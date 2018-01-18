package com.liao.thread;

/**
 * @author hongyangliao
 * @ClassName MyThread
 * @Date 17-12-21 下午4:27
 */
public class MyThread implements Runnable {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    private int count = 0;

    public void run() {
        threadLocal.set(count);
    }
}
