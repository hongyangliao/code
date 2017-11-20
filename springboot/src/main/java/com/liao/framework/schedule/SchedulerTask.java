package com.liao.framework.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时
 *
 * @author hongyangliao
 * @ClassName:
 * @Date 17-11-15 下午4:48
 */
@Component
public class SchedulerTask {
	private int count = 0;
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//@Scheduled(cron = "*/2 * * * * ?")
	public void process() {
		System.out.println("schedule:" + count++);
	}

	//@Scheduled(fixedDelay = 2000)
	public void reportTime() {
		System.out.println(df.format(new Date()));
	}
}
