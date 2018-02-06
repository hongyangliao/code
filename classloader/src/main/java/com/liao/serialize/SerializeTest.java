package com.liao.serialize;

import java.io.*;

/**
 * 序列化测试类
 *
 * @author hongyangliao
 * @ClassName: SerializeTest
 * @Date 18-2-6 上午10:11
 */
public class SerializeTest implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("/apps/test");
        file.createNewFile();
        Test test = new SerializeTest().new Test("小明", "12345");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(test);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Test serialTest = (Test) ois.readObject();
        System.out.println(serialTest);
    }

    public class Test implements Serializable {
        private static final long serialVersionUID = 1L;

        private String username;

        private String password;

//        public Test() {
//        }

        public Test(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
