package com.liao;

/**
 * 猫
 */
public class Cat implements Animal{
	@Override
	public void run() {
		System.out.println("小猫在跑");
	}

	@Override
	public void bark() {
		System.out.println("小猫在叫");
	}
}
