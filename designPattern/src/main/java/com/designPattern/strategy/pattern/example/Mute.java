package com.designPattern.strategy.pattern.example;

public class Mute implements QuackBehaviour {

	public void quack() {
		System.out.println("I am a mute duck");
	}

}
