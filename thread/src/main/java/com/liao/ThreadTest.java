package com.liao;

/**
 * 线程测试
 *
 * @author hongyangliao
 * @ClassName: ThreadTest
 * @Date 18-2-28 上午11:27
 */
public class ThreadTest {
    class MyThread extends Thread {
        int count = 100;

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                method();
            }
        }

        public synchronized void method() {
            this.count++;
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("hello thread1");
//            }
//        };
//
//
//        Thread thread2 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("hello thread2");
//            }
//        };
//        thread1.start();
//        thread1.join();
//        thread2.start();
//
//        thread2.join();
//
//        System.out.println("hello main thread");


    }
}
