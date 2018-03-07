package com.liao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池测试类
 *
 * @author hongyangliao
 * @ClassName: ExecutorsTest
 * @Date 18-2-26 上午9:40
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute();

    }
}
