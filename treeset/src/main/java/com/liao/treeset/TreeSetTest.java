package com.liao.treeset;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet测试类
 *
 * @author hongyangliao
 * @ClassName: TreeSetTest
 * @Date 18-2-1 下午3:08
 */
public class TreeSetTest {

    @Test
    public void show() throws IOException {
        File file = new File("/app/file.xml");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.write();

        //String
//        Set<Str> set = new TreeSet<Str>(Str.strComparator);
//
//        Str str1 = new Str(1);
//        Str str2 = new Str(2);
//        Str str3 = new Str(3);
//        Str str4 = new Str(4);
//        Str str51 = new Str(5);
//        Str str52 = new Str(5);
//
//        set.add(str51);
//        set.add(str2);
//        set.add(str3);
//        set.add(str1);
//        set.add(str4);
//        set.add(str52);
//
//        System.out.println(set);

        Set<String> set = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }

    // implements Comparable<Str>
//    static class Str {
//        private int num;
//
//        public static final Comparator<Str> strComparator = new StrComparator();
//
//        private static class StrComparator implements Comparator<Str> {
//            public int compare(Str o1, Str o2) {
//                return o1.num - o2.num;
//            }
//        }
//
//        public Str(int num) {
//            this.num = num;
//        }
//
////        public int compareTo(Str o) {
////            return this.num - o.num;
////        }
//
//        public int getNum() {
//            return num;
//        }
//
//        public void setNum(int num) {
//            this.num = num;
//        }
//
//        @Override
//        public String toString() {
//            return "Str{" +
//                    "num=" + num +
//                    '}';
//        }
//    }
}
