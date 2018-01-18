package com.liao;

/**
 * @author hongyangliao
 * @ClassName:
 * @Date 17-12-15 上午11:19
 */
public class TestMain {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);
        client.sendMsg();
    }
}
