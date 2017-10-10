package com.ducetech.framework.test;


import com.ducetech.framework.util.DateUtils;

import java.util.Date;

/**
 * @author hongyangliao
 * @ClassName:
 * @Description:
 * @Date 17-9-29 下午1:59
 */
public class TestMain {

	public static void main(String[] args) {
		Integer intStr = DateUtils.formatDateToInt(new Date(),"yyyyMMdd");
		System.out.println(intStr);
	}
}
