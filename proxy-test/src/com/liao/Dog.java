package com.liao;

/**
 * 狗
 */
public class Dog implements Animal {
	@Override
	public void run() {
		System.out.println("小狗在跑");
	}

	@Override
	public void bark() {
		System.out.println("小狗在叫");
	}
}
