package com.designPattern.strategy.pattern.example;

public class RunnerDuck extends Duck {

	@Override
	protected void duckIdentification() {
		this.flyBehaviour.fly();
		this.quackBehaviour.quack();
	}

}
