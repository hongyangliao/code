package com.liao;

import org.junit.Test;

/**
 * 测试类
 */
public class TestMain implements Cloneable{
	@Test
	public void show() {
		Dog dog = new Dog();
		AnimalProxy animalProxy = new AnimalProxy();
		Animal animal = (Animal) animalProxy.createProxyInstance(dog);
		animal.run();

		//dog.hashCode();
	}


}
