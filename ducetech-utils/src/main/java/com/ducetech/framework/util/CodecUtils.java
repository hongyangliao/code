package com.ducetech.framework.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * 编码工具类
 *
 * @ClassName: CodecUtils
 * @Date 17-9-29 下午2:41
 */
public class CodecUtils {
	private static Logger logger = LoggerFactory.getLogger(CodecUtils.class);

	/**
	 * 将 URL 按 UTF-8 编码
	 *
	 * @param str 字符串
	 * @return java.lang.String UTF-8编码字符串
	 * @throws
	 * @Title: encodeURL
	 * @Date: 17-9-29 下午2:41
	 */
	public static String encodeURL(String str) {
		String target;
		try {
			target = URLEncoder.encode(str, "UTF-8");
		} catch (Exception e) {
			logger.error("编码出错！", e);
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 将 URL 按 UTF-8 解码
	 *
	 * @param str UTF-8编码字符串
	 * @return java.lang.String 解码字符串
	 * @throws
	 * @Title: decodeURL
	 * @Date: 17-9-29 下午2:47
	 */
	public static String decodeURL(String str) {
		String target;
		try {
			target = URLDecoder.decode(str, "UTF-8");
		} catch (Exception e) {
			logger.error("解码出错！", e);
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 将 URL 按 Base64 编码
	 *
	 * @param str 字符串
	 * @return java.lang.String Base64编码字符串
	 * @throws
	 * @Title: encodeBASE64
	 * @Date: 17-9-29 下午2:48
	 */
	public static String encodeBASE64(String str) {
		String target;
		try {
			target = Base64.encodeBase64URLSafeString(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.error("编码出错！", e);
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 将 URL 按 Base64 解码
	 *
	 * @param str Base64编码字符串
	 * @return java.lang.String 解码字符串
	 * @throws
	 * @Title: decodeBASE64
	 * @Date: 17-9-29 下午2:48
	 */
	public static String decodeBASE64(String str) {
		String target;
		try {
			target = new String(Base64.decodeBase64(str), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("解码出错！", e);
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 将字符串 MD5 加密
	 *
	 * @param str 字符串
	 * @return java.lang.String MD5加密字符串
	 * @throws
	 * @Title: encryptMD5
	 * @Date: 17-9-29 下午2:51
	 */
	public static String encryptMD5(String str) {
		return DigestUtils.md5Hex(str);
	}

	/**
	 * 将字符串 SHA 加密
	 *
	 * @param str 字符串
	 * @return java.lang.String SHA加密字符串
	 * @throws
	 * @Title: encryptMD5
	 * @Date: 17-9-29 下午2:51
	 */
	public static String encryptSHA(String str) {
		return DigestUtils.sha256Hex(str);
	}

	/**
	 * 根据给定位数创建随机数
	 *
	 * @param count 位数
	 * @return java.lang.String 随机数字符串
	 * @throws
	 * @Title: createRandom
	 * @Date: 17-9-29 下午2:55
	 */
	public static String createRandom(int count) {
		return RandomStringUtils.randomNumeric(count);
	}

	/**
	 * 获取32位UUID(全部大写)
	 *
	 * @param
	 * @return java.lang.String
	 * @throws
	 * @Title: createUUID
	 * @Date: 17-9-29 下午3:00
	 */
	public static String createUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
}
