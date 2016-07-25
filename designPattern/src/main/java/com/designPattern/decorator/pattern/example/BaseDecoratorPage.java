package com.designPattern.decorator.pattern.example;

public abstract class BaseDecoratorPage extends ParentPage {
	ParentPage parentWindow;
	PageType currentPage;
	boolean active = Boolean.FALSE;

	public void display(){
		this.parentWindow.capturingArea();
	}
	
	public BaseDecoratorPage() {
	}

	public BaseDecoratorPage(ParentPage parentWindow) {
		this.parentWindow = parentWindow;
	}

	public void setParentWindow(ParentPage parentWindow) {
		this.parentWindow = parentWindow;
	}

	public PageType getCurrentType() {
		return this.currentPage;
	}

	public void setCurrentType(PageType type) {
		this.currentPage = type;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
