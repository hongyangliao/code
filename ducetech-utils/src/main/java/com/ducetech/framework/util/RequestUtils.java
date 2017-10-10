package com.ducetech.framework.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * request工具类
 *
 * @ClassName: RequestUtils
 * @Date 17-10-10 下午3:53
 */
public class RequestUtils {

	/**
	 * 移除request指定参数,并返回请求参数
	 *
	 * @param request   request对象
	 * @param paramName 参数名称
	 * @return java.lang.String 请求参数(name=liao&sex=0)
	 * @throws
	 * @Title: removeParam
	 * @Date: 17-10-10 下午3:54
	 */
	public String removeParam(HttpServletRequest request, String paramName) {
		String queryString = "";
		Enumeration keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			if (key.equals(paramName)) {
				continue;
			}
			if (queryString.equals("")) {
				queryString = key + "=" + request.getParameter(key);
			} else {
				queryString += "&" + key + "=" + request.getParameter(key);
			}
		}
		return queryString;
	}

	/**
	 * 获取请求basePath
	 *
	 * @param request request对象
	 * @return java.lang.String basePath
	 * @throws
	 * @Title: getBasePath
	 * @Date: 17-10-10 下午3:57
	 */
	public static String getBasePath(HttpServletRequest request) {
		StringBuffer basePath = new StringBuffer();
		String scheme = request.getScheme();
		String domain = request.getServerName();
		int port = request.getServerPort();
		basePath.append(scheme);
		basePath.append("://");
		basePath.append(domain);
		if ("http".equalsIgnoreCase(scheme) && 80 != port) {
			basePath.append(":").append(String.valueOf(port));
		} else if ("https".equalsIgnoreCase(scheme) && port != 443) {
			basePath.append(":").append(String.valueOf(port));
		}
		return basePath.toString();
	}

	/**
	 * 请求中参数转Map<String, String>
	 * for支付宝异步回调,平时建议直接使用request.getParameterMap(),返回Map<String, String[]>
	 *
	 * @param request request对象
	 * @return java.util.Map<java.lang.String,java.lang.String>
	 * @throws
	 * @Title: getParameterMap
	 * @Date: 17-10-10 下午3:59
	 */
	public static Map<String, String> getParameterMap(HttpServletRequest request) {
		Map<String, String> result = new HashMap<>();
		Enumeration parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			result.put(parameterName, request.getParameter(parameterName));
		}
		return result;
	}

}
