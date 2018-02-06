package com.liao.classloader;

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
}
