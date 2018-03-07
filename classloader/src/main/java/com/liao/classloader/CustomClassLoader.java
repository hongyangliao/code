package com.liao.classloader;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义类加载器
 *
 * @author hongyangliao
 * @ClassName: CustomClassLoader
 * @Date 18-2-6 上午10:03
 */
public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
    ConcurrentHashMap
}
