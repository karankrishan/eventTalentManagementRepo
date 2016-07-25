package com.designPattern.strategy.pattern.example;

/**
 * @author KARAN KRISHAN 
 * 			Design principle 1: Program to an interface not to an
 *         implementation. 2: Identify the varying aspects of the application
 *         and separate them what remains the same.
 */
public abstract class Duck {
	FlyBehaviour flyBehaviour;
	QuackBehaviour quackBehaviour;

	public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
		this.flyBehaviour = flyBehaviour;
	}

	public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
		this.quackBehaviour = quackBehaviour;
	}

	protected abstract void duckIdentification();

	public static void main(String[] args) {
		FlyBehaviour behaviour = new FlyWithWings();
		QuackBehaviour quackBehaviour = new Squeak();
		Duck duck = new MallardDuck();
		duck.setFlyBehaviour(behaviour);
		duck.setQuackBehaviour(quackBehaviour);
		duck.duckIdentification();
		System.out.println("<<---->>");
		quackBehaviour = new Mute();
		behaviour = new NoWings();
		duck = new RunnerDuck();
		duck.setFlyBehaviour(behaviour);
		duck.setQuackBehaviour(quackBehaviour);
		duck.duckIdentification();
	}
}
