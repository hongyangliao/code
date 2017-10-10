package com.ducetech.framework.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 封装各种格式的编码解码工具类
 * 1.Commons-Codec的 hex/base64 编码
 * 2.自制的base62 编码
 * 3.Commons-Lang的xml/html escape
 * 4.JDK提供的URLEncoder
 *
 * @ClassName: EncodeUtils
 * @Date 17-10-9 上午10:47
 */
public class EncodeUtils {

	private static final String DEFAULT_URL_ENCODING = "UTF-8";
	private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final String CHARSET_UTF8 = "UTF-8";

	/**
	 * 将字节数组Hex编码
	 *
	 * @param input 字节数组
	 * @return java.lang.String
	 * @throws
	 * @Title: encodeHex
	 * @Date: 17-10-9 上午10:51
	 */
	public static String encodeHex(byte[] input) {
		return Hex.encodeHexString(input);
	}

	/**
	 * 将字字符串Hex解码
	 *
	 * @param input 字符串
	 * @return byte[]
	 * @throws
	 * @Title: decodeHex
	 * @Date: 17-10-9 下午1:08
	 */
	public static byte[] decodeHex(String input) {
		try {
			return Hex.decodeHex(input.toCharArray());
		} catch (Exception e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	/**
	 * 将字节数组Base64编码
	 * 酱紫
	 *
	 * @param input 字节数组
	 * @return java.lang.String
	 * @throws
	 * @Title: encodeBase64
	 * @Date: 17-10-9 下午1:09
	 */
	public static String encodeBase64(byte[] input) {
		return Base64.encodeBase64String(input);
	}


	/**
	 * 将字符串Base64编码
	 *
	 * @param input 字符串
	 * @return java.lang.String
	 * @throws
	 * @Title: encodeBase64
	 * @Date: 17-10-9 下午1:11
	 */
	public static String encodeBase64(String input) {
		try {
			return Base64.encodeBase64String(input.getBytes(CHARSET_UTF8));
		} catch (Exception e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	/**
	 * 将字节数组Base64编码, URL安全(将Base64中的URL非法字符'+'和'/'转为'-'和'_', 见RFC3548).
	 *
	 * @param input 字节数组
	 * @return java.lang.String
	 * @throws
	 * @Title: encodeUrlSafeBase64
	 * @Date: 17-10-9 下午1:14
	 */
	public static String encodeUrlSafeBase64(byte[] input) {
		return Base64.encodeBase64URLSafeString(input);
	}

	/**
	 * 将字符串Base64解码
	 *
	 * @param input 字符串
	 * @return byte[]
	 * @throws
	 * @Title: decodeBase64
	 * @Date: 17-10-9 下午1:15
	 */
	public static byte[] decodeBase64(String input) {
		return Base64.decodeBase64(input);
	}

	/**
	 * 将字节数组Base62编码
	 *
	 * @param input 字节数组
	 * @return java.lang.String
	 * @throws
	 * @Title: encodeBase62
	 * @Date: 17-10-9 下午1:16
	 */
	public static String encodeBase62(byte[] input) {
		char[] chars = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			chars[i] = BASE62[(input[i] & 0xFF)%BASE62.length];
		}
		return new String(chars);
	}

	/**
	 * Html转码
	 *
	 * @param html html字符串
	 * @return java.lang.String
	 * @throws
	 * @Title: escapeHtml
	 * @Date: 17-10-9 下午1:22
	 */
	public static String escapeHtml(String html) {
		return StringEscapeUtils.escapeHtml4(html);
	}

	/**
	 * Html解码
	 *
	 * @param htmlEscaped
	 * @return java.lang.String
	 * @throws
	 * @Title: unescapeHtml
	 * @Date: 17-10-9 下午1:23
	 */
	public static String unescapeHtml(String htmlEscaped) {
		return StringEscapeUtils.unescapeHtml4(htmlEscaped);
	}

	/**
	 * Xml转码
	 *
	 * @param xml xml字符串
	 * @return java.lang.String
	 * @throws
	 * @Title: escapeXml
	 * @Date: 17-10-9 下午1:23
	 */
	public static String escapeXml(String xml) {
		return StringEscapeUtils.escapeXml(xml);
	}


	/**
	 * Xml解码
	 *
	 * @param xmlEscaped
	 * @return java.lang.String
	 * @throws
	 * @Title: unescapeXml
	 * @Date: 17-10-9 下午1:24
	 */
	public static String unescapeXml(String xmlEscaped) {
		return StringEscapeUtils.unescapeXml(xmlEscaped);
	}

	/**
	 * URL 编码, Encode默认为UTF-8
	 *
	 * @param part
	 * @return java.lang.String
	 * @throws
	 * @Title: urlEncode
	 * @Date: 17-10-9 下午1:25
	 */
	public static String urlEncode(String part) {
		try {
			return URLEncoder.encode(part, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	/**
	 * URL 解码, Encode默认为UTF-8
	 *
	 * @param part
	 * @return java.lang.String
	 * @throws
	 * @Title: urlDecode
	 * @Date: 17-10-9 下午1:26
	 */
	public static String urlDecode(String part) {

		try {
			return URLDecoder.decode(part, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	public static void main(String[] args) {
		String text = "18696597327";
		System.out.println("Base64 encode for '" + text + "' is " + encodeBase64(text.getBytes()));
	}
}
