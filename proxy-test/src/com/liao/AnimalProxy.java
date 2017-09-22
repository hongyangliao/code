package com.liao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动物代理类
 */
public class AnimalProxy implements InvocationHandler {
	private Object targetObj;

	/**
	 * 创建代理对象
	 *
	 * @param targetObj 被代理对象
	 * @return 代理对象
	 */
	public Object createProxyInstance(Object targetObj) {
		this.targetObj = targetObj;
		return Proxy.newProxyInstance(targetObj.getClass().getClassLoader(), targetObj.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		start();
		Object result = method.invoke(targetObj,args);
		end();
		return result;
	}

	/**
	 * 开始驯兽
	 */
	private void start() {
		System.out.println("驯兽员说可以开始了");
	}

	/**
	 * 结束驯兽
	 */
	private void end() {
		System.out.println("驯兽员说可以结束了");
	}


}
