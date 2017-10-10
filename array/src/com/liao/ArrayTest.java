package com.liao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 数组测试类
 */
public class ArrayTest {
	public static void main(String[] args) {
		Integer[] arrays = {1,2,3,4};
		expandCapacity(arrays,5);
		//Arrays.asList()方法返回的值不是java.util.ArrayList而是Arrays的一个内部类
		//List<Integer> list = Arrays.asList(arrays);
		//list.add(1);
		//LinkedList
		Stack
	}

	/**
	 * @title 对数组进行扩容
	 * @param arrays 原数组
	 * @param len 新长度
	 * @param <T>
	 * @return
	 */
	private static <T> T[] expandCapacity(T[] arrays,int len) {
		int newLen = arrays.length > len ? arrays.length : len;
		return Arrays.copyOf(arrays,len);
	}
}
