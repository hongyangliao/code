package com.ducetech.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 访问IP地址工具类
 *
 * @ClassName: IPAddrFetcherUtils
 * @Date 17-10-9 下午5:35
 */
public class IPAddrFetcherUtils {

	private static Logger logger = LoggerFactory.getLogger(IPAddrFetcherUtils.class);

	/**
	 * 获取客户端IP地址，支持代理服务器
	 *
	 * @param request request对象
	 * @return java.lang.String IP地址
	 * @throws
	 * @Title: getRemoteIpAddress
	 * @Date: 17-10-9 下午5:36
	 */
	public static String getRemoteIpAddress(HttpServletRequest request) {
		String ip = "";
		//匹配大小写，保证无论Nginx如何配置代理参数，系统都能正常获取代理IP
		Enumeration<?> enumeration = request.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String paraName = (String) enumeration.nextElement();
			if ("x-forward-for".equalsIgnoreCase(paraName) || "x-forwarded-for".equalsIgnoreCase(paraName)) {
				ip = request.getHeader(paraName);
				break;
			}
		}
		String localIP = "127.0.0.1";
		if ((ip == null) || (ip.length() == 0) || (ip.equalsIgnoreCase(localIP)) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || (ip.equalsIgnoreCase(localIP)) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || (ip.equalsIgnoreCase(localIP)) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 获取本机的一个IP地址
	 *
	 * @param
	 * @return java.lang.String
	 * @throws
	 * @Title: getGuessUniqueIP
	 * @Date: 17-10-9 下午5:47
	 */
	public static String getGuessUniqueIP() {
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface ni = interfaces.nextElement();
				Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();

				while (inetAddresses.hasMoreElements()) {
					InetAddress address = inetAddresses.nextElement();
					if (address instanceof Inet4Address) {
						if (!"127.0.0.1".equals(address.getHostAddress())) {
							return address.getHostAddress();
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("Get IP Error", e);
		}
		return null;
	}

	/**
	 * 获取本机的IP地址信息
	 *
	 * @param
	 * @return java.lang.String
	 * @throws
	 * @Title: getIPInfo
	 * @Date: 17-10-9 下午5:50
	 */
	public static String getIPInfo() {
		StringBuilder sb = new StringBuilder();

		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

			while (interfaces.hasMoreElements()) {
				NetworkInterface ni = interfaces.nextElement();

				sb.append("Interface " + ni.getName() + ":\r\n");

				Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();

				while (inetAddresses.hasMoreElements()) {
					InetAddress address = inetAddresses.nextElement();

					sb.append("Address");

					if (address instanceof Inet4Address) {
						sb.append("(v4)");
					} else {
						sb.append("(v6)");
					}
					sb.append(":address=" + address.getHostAddress() + " name=" + address.getHostName() + "\r\n");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sb.toString();
	}

	//实例
	public static void main(String[] args) {
		System.out.println(IPAddrFetcherUtils.getIPInfo());
	}
}
