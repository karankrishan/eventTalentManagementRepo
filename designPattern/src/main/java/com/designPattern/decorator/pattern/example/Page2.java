package com.designPattern.decorator.pattern.example;

public class Page2 extends BaseDecoratorPage {

	public Page2() {
	}

	public Page2(ParentPage parentWindow) {
		super(parentWindow);
	}

	@Override
	protected void capturingArea() {
		System.out.print("Page 2 in ");
		this.parentWindow.capturingArea();
	}

	public void setParentWindow(ParentPage parentWindow) {
		super.setParentWindow(parentWindow);
		capturingArea();
	}
}
