package com.ducetech.framework.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

/**
 * 随机数工具类
 *
 * @ClassName: RandomUtils
 * @Date 17-10-10 下午1:22
 */
public final class RandomUtils {

	private RandomUtils() {
	}

	/**
	 * 生成随机数
	 *
	 * @param count 随机数的位数
	 * @return java.lang.String 生成的随机数
	 * @throws
	 * @Title: getRandom
	 * @Date: 17-10-10 下午1:24
	 */
	public static String getRandom(int count) {
		return RandomStringUtils.randomNumeric(count);
	}

	/**
	 * 生成UUID,没有"-"
	 *
	 * @param
	 * @return java.lang.String 生成的没有"-"的UUID
	 * @throws
	 * @Title: UID
	 * @Date: 17-10-10 下午1:27
	 */
	public static String UID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	//实例
	public static void main(String[] args) {
		System.out.println(getRandom(10));
		System.out.println(UID());
	}
}
