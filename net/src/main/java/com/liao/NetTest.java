package com.liao;

import com.liao.client.Client;
import com.liao.server.Server;

import java.io.IOException;

/**
 * @author hongyangliao
 * @ClassName: NetTest
 * @Date 17-12-21 下午3:14
 */
public class NetTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = new Server();
        Thread thread = new Thread(server);
        thread.start();

        Thread.sleep(5000);

        System.out.println("main" + "--" + Thread.currentThread().getId());

        Client client = new Client();
        client.run();
    }
}
