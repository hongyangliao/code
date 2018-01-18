package com.liao;

import org.junit.Test;

/**
 * @author hongyangliao
 * @ClassName: ThreadLocalTest
 * @Date 17-12-22 下午2:37
 */
public class ThreadLocalTest {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

    static int flag = -1;

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                int count = 0;
                while (count < 100) {
                    count++;
                    flag = 0;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //threadLocal.set("thread");
                    System.out.println("thread --- " + flag);

//                    threadLocal.set("thread");
//                    System.out.println("thread --- " + threadLocal.get());
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                int count = 0;
                while (count < 100) {
                    count++;
                    flag = 2;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //threadLocal.set("thread");
                    System.out.println("thread2 --- " + flag);
                }
            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                int count = 0;
                while (count < 100) {
                    count++;
                    flag = 3;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //threadLocal.set("thread");
                    System.out.println("thread3 --- " + flag);
                }
            }
        };

        thread.start();
        thread2.start();
        thread3.start();
    }
}
