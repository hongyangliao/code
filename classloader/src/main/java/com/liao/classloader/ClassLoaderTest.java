package com.liao.classloader;

import com.sun.deploy.util.StringUtils;
import com.sun.webkit.network.URLs;
import jdk.nashorn.internal.runtime.linker.Bootstrap;
import org.junit.Test;
import sun.misc.Launcher;

import java.net.URL;

/**
 * ClassLoader测试
 *
 * @author hongyangliao
 * @ClassName: ClassLoaderTest
 * @Date 18-2-5 下午1:45
 */
public class ClassLoaderTest {
//    static {
//        System.out.println("我加载了");
//    }

    public static void main(String[] args) {
        System.out.println(ClassLoaderTest1.class.getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader());
    }

    @Test
    public void show() {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(System.class.getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent());
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent().getParent());
    }

    @Test
    public void bootStrapClassLoaderTest() {
//        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
//        for (URL url : urLs) {
//            System.out.println(url.getPath());
//        }
//        String bootPaths = System.getProperty("sun.boot.class.path");
//        System.out.println(bootPaths);
//        String[] bootPathArray = StringUtils.splitString(bootPaths, ":");
//        for (String bootPath : bootPathArray) {
//            System.out.println(bootPath);
//        }
        System.out.println(ClassLoaderTest1.class.getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader());
    }

    public class ClassLoaderTest1 {
        public ClassLoaderTest1() {
        }
    }
}
