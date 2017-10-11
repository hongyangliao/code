package com.ducetech.framework.util;

import org.codehaus.xfire.client.Client;

import java.net.URL;

/**
 * WebService工具类
 *
 * @ClassName: WebServiceUtils
 * @Date 17-10-10 下午5:18
 */
public final class WebServiceUtils {
	private WebServiceUtils() {
	}

	/**
	 * 调用webService
	 *
	 * @param url    调用的url
	 * @param method 调用的方法
	 * @param params 调用的参数
	 * @return java.lang.Object
	 * @throws
	 * @Title: invoke
	 * @Date: 17-10-10 下午5:19
	 */
	public static final Object invoke(String url, String method, Object... params) {
		try {
			Client client = new Client(new URL(url + "?wsdl"));
			return client.invoke(method, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
