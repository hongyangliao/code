package com.liao;

import org.junit.Test;

/**
 * 测试类
 */
public class TestMain {
	@Test
	public void show() {
		Dog dog = new Dog();
		AnimalProxy animalProxy = new AnimalProxy();
		Animal animal = (Animal) animalProxy.createProxyInstance(dog);
		animal.run();
	}
}
