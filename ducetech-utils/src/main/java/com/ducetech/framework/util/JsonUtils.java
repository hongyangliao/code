package com.ducetech.framework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Json工具类
 *
 * @ClassName: JsonUtils
 * @Date 17-10-9 下午5:55
 */
public class JsonUtils {

	private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

	private final static ObjectMapper objectMapper = new ObjectMapper();


	/**
	 * 将对象转换为json格式
	 *
	 * @param value 对象
	 * @return java.lang.String json格式字符串
	 * @throws
	 * @Title: writeValueAsString
	 * @Date: 17-10-9 下午5:56
	 */
	public static String writeValueAsString(Object value) {
		try {
			return objectMapper.writeValueAsString(value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 将json数组字符串转换为 key为 json字符串 value为 json字符串转换的对象 的map集合
	 *
	 * @param content
	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 * @throws
	 * @Title: readValue
	 * @Date: 17-10-9 下午5:57
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> readValue(String content) {
		try {
			return objectMapper.readValue(content, Map.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return Maps.newHashMap();
	}

	/**
	 * 将json数组字符串转换为对应对象的list集合
	 *
	 * @param content json数组字符串
	 * @return java.util.List
	 * @throws
	 * @Title: readListValue
	 * @Date: 17-10-10 上午9:43
	 */
	public static List readListValue(String content) {
		try {
			return objectMapper.readValue(content, List.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return Lists.newArrayList();
	}

	//实例
	public static void main(String[] args) {
	}
}