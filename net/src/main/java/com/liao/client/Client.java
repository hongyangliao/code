package com.liao.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author hongyangliao
 * @ClassName: Client
 * @Date 17-12-21 下午3:28
 */
public class Client {
    public void run() throws IOException {
        System.out.println("Client" + "--" + +Thread.currentThread().getId());
        Socket socket = new Socket("localhost", 8001);
        socket.getInetAddress();
        socket.setSoTimeout(5000);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("你好啊,我不好");
        writer.close();
    }
}
