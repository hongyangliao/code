package com.ducetech.framework.util;

import org.apache.commons.lang3.Validate;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * 支持SHA-1/MD5消息摘要的工具类.
 * 返回ByteSource，可进一步被编码为Hex, Base64或UrlSafeBase64
 *
 * @ClassName: DigestUtils
 * @Date 17-10-9 上午9:54
 */
public class DigestUtils {

	private static final String SHA1 = "SHA-1";
	private static final String MD5 = "MD5";

	private static SecureRandom random = new SecureRandom();

	/**
	 * 对输入字节数组进行sha1散列,不加盐,一次迭代
	 *
	 * @param input
	 * @return byte[]
	 * @throws
	 * @Title: sha1
	 * @Date: 17-10-9 上午10:07
	 */
	public static byte[] sha1(byte[] input) {
		return digest(input, SHA1, null, 1);
	}

	/**
	 * 对输入字节数组进行sha1散列,加盐,一次迭代
	 *
	 * @param input
	 * @param salt  盐
	 * @return byte[]
	 * @throws
	 * @Title: sha1
	 * @Date: 17-10-9 上午10:09
	 */
	public static byte[] sha1(byte[] input, byte[] salt) {
		return digest(input, SHA1, salt, 1);
	}

	/**
	 * 对输入字节数组进行sha1散列,加盐
	 *
	 * @param input
	 * @param salt       盐
	 * @param iterations 迭代次数
	 * @return byte[]
	 * @throws
	 * @Title: sha1
	 * @Date: 17-10-9 上午10:10
	 */
	public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
		return digest(input, SHA1, salt, iterations);
	}

	/**
	 * 对输入字节数组进行MD5散列,加盐
	 *
	 * @param input
	 * @param salt
	 * @return byte[]
	 * @throws
	 * @Title: md5
	 * @Date: 17-10-9 上午10:21
	 */
	public static byte[] md5(byte[] input, byte[] salt) {
		return digest(input, MD5, salt, 1);
	}

	/**
	 * 对输入字节数组进行MD5散列,不加盐
	 *
	 * @param input
	 * @return byte[]
	 * @throws
	 * @Title: md5
	 * @Date: 17-10-9 上午10:22
	 */
	public static byte[] md5(byte[] input) {
		return digest(input, MD5, null, 1);
	}

	/**
	 * 对输入字符串进行MD5散列,不加盐
	 *
	 * @param input
	 * @return java.lang.String
	 * @throws
	 * @Title: md5
	 * @Date: 17-10-9 上午10:23
	 */
	public static String md5(String input) {
		return EncodeUtils.encodeHex(DigestUtils.md5(input.getBytes()));
	}

	/**
	 * 对输入字符串进行MD5散列,加 DuceTech 盐，进行两次迭代
	 *
	 * @param password
	 * @return java.lang.String
	 * @throws
	 * @Title: md5Hash
	 * @Date: 17-10-9 上午10:27
	 */
	public static String md5Hash(String password) {
		return new Md5Hash(password, "DuceTech", 2).toString();
	}

	/**
	 * 对输入字符串进行MD5散列,加盐，进行两次迭代
	 *
	 * @param password 字符串
	 * @param salt     盐
	 * @return java.lang.String
	 * @throws
	 * @Title: md5Hash
	 * @Date: 17-10-9 上午10:29
	 */
	public static String md5Hash(String password, String salt) {
		return new Md5Hash(password, salt, 2).toString();
	}

	/**
	 * 对字节数组进行散列, 支持md5与sha1算法
	 *
	 * @param input      字节数组
	 * @param algorithm  算法 SHA-1 MD5
	 * @param salt       盐
	 * @param iterations 迭代次数
	 * @return byte[]
	 * @throws
	 * @Title: digest
	 * @Date: 17-10-9 上午10:30
	 */
	private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);

			if (salt != null) {
				digest.update(salt);
			}

			byte[] result = digest.digest(input);

			for (int i = 1; i < iterations; i++) {
				digest.reset();
				result = digest.digest(result);
			}
			return result;
		} catch (GeneralSecurityException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	/**
	 * 生成随机的Byte[]作为salt
	 *
	 * @param numBytes 字节数组长度
	 * @return byte[]
	 * @throws
	 * @Title: generateSalt
	 * @Date: 17-10-9 上午10:36
	 */
	public static byte[] generateSalt(int numBytes) {
		Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);

		byte[] bytes = new byte[numBytes];
		random.nextBytes(bytes);
		return bytes;
	}

	/**
	 * 对输入流进行md5散列
	 *
	 * @param input 输入流
	 * @return byte[]
	 * @throws
	 * @Title: md5
	 * @Date: 17-10-9 上午10:41
	 */
	public static byte[] md5(InputStream input) throws IOException {
		return digest(input, MD5);
	}

	/**
	 * 对输入流进行sha1散列
	 *
	 * @param input 输入流
	 * @return byte[]
	 * @throws
	 * @Title: sha1
	 * @Date: 17-10-9 上午10:43
	 */
	public static byte[] sha1(InputStream input) throws IOException {
		return digest(input, SHA1);
	}

	/**
	 * 对输入流进行散列, 支持md5与sha1算法
	 *
	 * @param input     输入流
	 * @param algorithm 算法 SHA-1 or MD5
	 * @return byte[]
	 * @throws
	 * @Title: digest
	 * @Date: 17-10-9 上午10:44
	 */
	private static byte[] digest(InputStream input, String algorithm) throws IOException {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			int bufferLength = 8*1024;
			byte[] buffer = new byte[bufferLength];
			int read = input.read(buffer, 0, bufferLength);

			while (read > -1) {
				messageDigest.update(buffer, 0, read);
				read = input.read(buffer, 0, bufferLength);
			}

			return messageDigest.digest();
		} catch (GeneralSecurityException e) {
			throw ExceptionUtils.unchecked(e);
		}
	}
}
