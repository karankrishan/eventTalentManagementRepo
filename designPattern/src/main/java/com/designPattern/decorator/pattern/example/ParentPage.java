package com.designPattern.decorator.pattern.example;

public abstract class ParentPage {
	protected String next = "Next";
	protected String back = "Back";

	protected abstract void capturingArea();

	public String getNext() {
		return next;
	}

	public String getBack() {
		return back;
	}
}
