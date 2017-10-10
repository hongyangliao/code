package com.ducetech.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 线程工具类
 *
 * @ClassName: ThreadUtils
 * @Date 17-10-10 下午1:29
 */
public class ThreadUtils {

	private final static Logger logger = LoggerFactory.getLogger(ThreadUtils.class);

	/**
	 * 线程sleep一秒
	 *
	 * @param
	 * @return void
	 * @throws
	 * @Title: sleepOneSecond
	 * @Date: 17-10-10 下午1:30
	 */
	public static void sleepOneSecond() {
		sleepSeconds(1);
	}


	/**
	 * 线程sleep seconds秒
	 *
	 * @param seconds sleep的秒数
	 * @return void
	 * @throws
	 * @Title: sleepSeconds
	 * @Date: 17-10-10 下午1:30
	 */
	public static void sleepSeconds(int seconds) {
		try {
			logger.debug("Thread {} sleep {} seconds...", Thread.currentThread().getName(), seconds);
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
