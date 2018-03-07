package com.liao;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * 字符集测试
 *
 * @author hongyangliao
 * @ClassName: CharacterCodeTest
 * @Date 18-2-8 上午10:40
 */
public class CharacterCodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        char a = '\u20BD';
        int i = 2;
        String str = "\u20BD";
        String str1 = new String("123");
        String str2 = new String("123".getBytes(), "GBK");
        System.out.println(Charset.defaultCharset().name());
        System.out.println(str.getBytes().length);
        //System.out.println(Integer.SIZE);
        //System.out.println(System.getProperty("file.encoding"));
    }
}
