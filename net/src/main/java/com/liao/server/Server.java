package com.liao.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hongyangliao
 * @ClassName: Server
 * @Date 17-12-21 下午3:16
 */
public class Server implements Runnable {
    private static ServerSocket ss;

    static {
        try {
            ss = new ServerSocket(8001);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            System.out.println("Server" + "--" + + Thread.currentThread().getId());
            Socket socket = null;
            try {
                socket = ss.accept();
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = reader.readLine();
                System.out.println(Thread.currentThread() + "---" + line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
