package com.designPattern.decorator.pattern.example;

public class Page1 extends BaseDecoratorPage {

	public Page1() {}

	public Page1(ParentPage parentWindow) {
		super(parentWindow);
	}

	@Override
	protected void capturingArea() {
		System.out.print("Page 1 in ");
		this.parentWindow.capturingArea();
	}

	public void setParentWindow(ParentPage parentWindow) {
		super.setParentWindow(parentWindow);
		capturingArea();
	}
}
