package com.liao.framework.web.filter;

import lombok.Data;
import org.apache.catalina.filters.RemoteIpFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * beans
 *
 * @author hongyangliao
 * @ClassName: WebConfiguration
 * @Date 17-11-13 下午2:34
 */
@Configuration
@ComponentScan("com.liao")
public class WebConfiguration {

	@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}

	@Bean
	public FilterRegistrationBean filterRegistratiionBean() {
		//创建过滤器注册器对象
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		//注册过滤器
		filterRegistrationBean.setFilter(new MyFilter());
		//添加filter mapping
		List<String> list = new ArrayList<String>();
		list.add("/*");
		filterRegistrationBean.setUrlPatterns(list);
		//设置filter name
		filterRegistrationBean.setName("MyFilter");
		//设置启动等级
		filterRegistrationBean.setOrder(1);
		//设置初始化参数
		Map<String, String> map = new HashMap<String, String>();
		map.put("param", "自定义参数");
		filterRegistrationBean.setInitParameters(map);
		return filterRegistrationBean;
	}

	@Data
	public class MyFilter implements Filter {

		private String param;

		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			String param = filterConfig.getInitParameter("param");
			if (StringUtils.isNotBlank(param)) {
				this.param = param;
			}
		}

		@Override
		public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
			System.out.println("这是springboot的一个自定义filter" + ", param:" + param);
			filterChain.doFilter(servletRequest, servletResponse);
		}

		@Override
		public void destroy() {

		}
	}
}
