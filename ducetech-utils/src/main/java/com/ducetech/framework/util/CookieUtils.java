package com.ducetech.framework.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Cookie工具类
 *
 * @ClassName: CookieUtils
 * @Date 17-9-29 下午3:19
 */
public class CookieUtils {
	//public static final int PERSISTENTTIME = 3 * 30 * 24 * 3600;// 目前是三个月
	public static final String USER_NAME = "DT_LOGIN_USER";

	/**
	 * 从cookie里面获取用户id
	 *
	 * @param request
	 * @return java.lang.String 用户id
	 * @throws
	 * @Title: getLoginUserId
	 * @Date: 17-9-29 下午3:25
	 */
	public static String getLoginUserId(final HttpServletRequest request) {
		return getCookieValue(request, USER_NAME);
	}

	/**
	 * 从cookie里面删除用户id
	 *
	 * @param response
	 * @return void
	 * @throws
	 * @Title: deleteUserFromCookie
	 * @Date: 17-9-29 下午3:27
	 */
	public static void deleteUserFromCookie(HttpServletResponse response) {
		removeCookie(response, USER_NAME);
	}

	/**
	 * 根据key获取Cookie的值
	 *
	 * @param request
	 * @param key     键
	 * @return java.lang.String
	 * @throws
	 * @Title: getCookieValue
	 * @Date: 17-9-29 下午3:28
	 */
	public static String getCookieValue(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (key.equals(c.getName())) {
					return c.getValue();
				}
			}
		}
		return null;
	}

	/**
	 * 生成cookie
	 *
	 * @param response
	 * @param key      键
	 * @param value    值
	 * @return void
	 * @throws
	 * @Title: setCookie
	 * @Date: 17-9-29 下午3:30
	 */
	public static void setCookie(HttpServletResponse response, String key, String value) {
		if (null == value) {
			value = "";
		}
		try {
			value = URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {

		}
		if (StringUtils.isEmpty(key)) {
			key = USER_NAME;
		}
		Cookie cookie = new Cookie(key, value);
		//cookie.setDomain(null);
		cookie.setPath("/");
		cookie.setMaxAge(-1);// -1 means the cookie is not stored
		cookie.setSecure(false);

		// 表示是否Cookie只能通过加密的连接（即SSL）发送
		//cookie.setSecure(secure);
		// 设置Cookie适用的路径
		//cookie.setPath(path);
		// 设置Cookie适用的域
		//cookie.setDomain(domain);
		// 设置Cookie有效时间
		//cookie.setMaxAge(time);

		response.addCookie(cookie);
	}

	/**
	 * 根据key删除cookie
	 *
	 * @param response
	 * @param key      键
	 * @return void
	 * @throws
	 * @Title: removeCookie
	 * @Date: 17-9-29 下午3:33
	 */
	public static void removeCookie(HttpServletResponse response, String key) {
		Cookie cookie = new Cookie(key, "");
		//cookie.setDomain(null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		cookie.setSecure(false);
		response.addCookie(cookie);
	}
}
