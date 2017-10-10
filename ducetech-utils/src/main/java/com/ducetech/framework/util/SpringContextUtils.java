package com.ducetech.framework.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * SpringContext工具类
 *
 * @ClassName: SpringContextUtils
 * @Date 17-10-10 下午4:03
 */
public class SpringContextUtils implements ApplicationContextAware {

	private static ApplicationContext context = null;

	private SpringContextUtils() {
		super();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}


	/**
	 * 根据名称获取bean
	 *
	 * @param beanName bean的名称
	 * @return java.lang.Object bean
	 * @throws
	 * @Title: getBean
	 * @Date: 17-10-10 下午4:04
	 */
	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

	/**
	 * 根据bean名称和bean的类型获取bean
	 *
	 * @param beanName bean名称
	 * @param clazz    返回的bean类型,若类型不匹配,将抛出异常
	 * @return T
	 * @throws
	 * @Title: getBean
	 * @Date: 17-10-10 下午4:05
	 */
	public static <T> T getBean(String beanName, Class<T> clazz) {
		return context.getBean(beanName, clazz);
	}

	/**
	 * 根据类型获取bean
	 *
	 * @param clazz bean的类型
	 * @return T
	 * @throws
	 * @Title: getBean
	 * @Date: 17-10-10 下午4:07
	 */
	public static <T> T getBean(Class<T> clazz) {
		T t = null;
		Map<String, T> map = context.getBeansOfType(clazz);
		for (Map.Entry<String, T> entry : map.entrySet()) {
			t = entry.getValue();
		}
		return t;
	}

	/**
	 * 判断是否包含指定bean名称的bean
	 *
	 * @param beanName bean名称
	 * @return boolean 包含:true 不包含:false
	 * @throws
	 * @Title: containsBean
	 * @Date: 17-10-10 下午4:08
	 */
	public static boolean containsBean(String beanName) {
		return context.containsBean(beanName);
	}

	/**
	 * 判断指定bean名称的bean是否单例
	 *
	 * @param beanName bean名称
	 * @return boolean 单例:true 多例：false
	 * @throws
	 * @Title: isSingleton
	 * @Date: 17-10-10 下午4:09
	 */
	public static boolean isSingleton(String beanName) {
		return context.isSingleton(beanName);
	}

	/**
	 * 根据指定bean名称获取bean的类型
	 *
	 * @param beanName bean名称
	 * @return java.lang.Class bean类型
	 * @throws
	 * @Title: getType
	 * @Date: 17-10-10 下午4:11
	 */
	public static Class getType(String beanName) {
		return context.getType(beanName);
	}
}
