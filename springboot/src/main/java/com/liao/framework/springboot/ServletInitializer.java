package com.liao.framework.springboot;

import com.liao.SpringbootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 注册启动类
 *
 * @author hongyangliao
 * @ClassName:
 * @Date 17-11-20 下午5:36
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringbootApplication.class);
	}
}
