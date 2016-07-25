package com.designPattern.strategy.pattern.example;

public class MallardDuck extends Duck {
	public void duckIdentification() {
		this.flyBehaviour.fly();
		this.quackBehaviour.quack();
	}
}
