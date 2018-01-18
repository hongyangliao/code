package com.liao;

/**
 * @author hongyangliao
 * @ClassName: Client
 * @Date 17-12-15 上午10:19
 */
public class Client implements Callback {
    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    public void sendMsg() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                server.getClientMsg(Client.this,"这是发送的信息" );
            }
        }).start();
    }

    @Override
    public void proccess(String status) {
        System.out.println(status);
    }
}
