package com.designPattern.decorator.pattern.example;

public class Page3 extends BaseDecoratorPage {

	public Page3() {
	}

	public Page3(ParentPage parentWindow) {
		super(parentWindow);
	}

	@Override
	protected void capturingArea() {
		System.out.print("Page 3 in ");
		this.parentWindow.capturingArea();
	}

	public void setParentWindow(ParentPage parentWindow) {
		super.setParentWindow(parentWindow);
		capturingArea();
	}

}
