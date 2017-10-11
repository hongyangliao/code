package com.ducetech.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 序列化工具类
 *
 * @ClassName: SerializeUtils
 * @Date 17-10-10 下午4:58
 */
public final class SerializeUtils {
	private static final Logger logger = LoggerFactory.getLogger(CodecUtils.class);

	private SerializeUtils() {
	}

	/**
	 * 序列化
	 *
	 * @param object 需要序列化的对象
	 * @return byte[] 序列化后的byte[]
	 * @throws
	 * @Title: serialize
	 * @Date: 17-10-10 下午4:59
	 */
	public static final byte[] serialize(Object object) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			return baos.toByteArray();
		} catch (IOException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (Exception e) {
				logger.error("释放资源出错", e);
			}
			try {
				if (baos != null) {
					baos.close();
				}
			} catch (Exception e) {
				logger.error("释放资源出错", e);
			}
		}
	}

	/**
	 * 反序列化
	 *
	 * @param bytes 序列化过的数据
	 * @return java.lang.Object 反序列化得到的数据
	 * @throws
	 * @Title: deserialize
	 * @Date: 17-10-10 下午5:00
	 */
	public static final Object deserialize(byte[] bytes) {
		return deserialize(bytes, Object.class);
	}

	/**
	 * 反序列化
	 *
	 * @param bytes 序列化过的数据
	 * @param cls   反序列化过后对象的类型
	 * @return K 反序列化得到的数据
	 * @throws
	 * @Title: deserialize
	 * @Date: 17-10-10 下午5:01
	 */
	@SuppressWarnings("unchecked")
	public static final <K> K deserialize(byte[] bytes, Class<K> cls) {
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(bais);
			return (K) ois.readObject();
		} catch (IOException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (Exception e) {
				logger.error("释放资源出错", e);
			}
			try {
				if (bais != null) {
					bais.close();
				}
			} catch (Exception e) {
				logger.error("释放资源出错", e);
			}
		}
	}
}
