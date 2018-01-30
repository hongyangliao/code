package com.liao;

import java.util.Properties;
import java.util.Set;

/**
 * @author hongyangliao
 * @ClassName:
 * @Date 17-12-15 上午11:19
 */
public class TestMain {
    public static void main(String[] args) {
//        Server server = new Server();
//        Client client = new Client(server);
//        client.sendMsg();
        Properties properties = System.getProperties();
        //properties.put("java.drivers","com.mysql.jdbc.driver");
        Set<Object> set = properties.keySet();
        for (Object key : set) {
            System.out.println(key + "==========" + properties.get(key));
        }
        //System.out.println(System.getProperty("java.drivers"));
    }
}
