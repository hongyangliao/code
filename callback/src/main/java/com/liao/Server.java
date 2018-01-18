package com.liao;

/**
 * @author hongyangliao
 * @ClassName: Server
 * @Date 17-12-15 上午10:37
 */
public class Server {
    public void getClientMsg(Client client, String msg) {
        System.out.println("我收到客户端的一条消息");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg);
        client.proccess("我收到服务端的一条消息");
    }
}
