package com.designPattern.decorator.pattern.example;


public class Initializer {

	public static void main(String[] args) {
		ParentPage holdingWindow = new LandingBasePage();
		BaseDecoratorPage page1 = new Page1();
		page1.setCurrentType(PageType.One);
		BaseDecoratorPage page2 = new Page2();
		page2.setCurrentType(PageType.Two);
		BaseDecoratorPage page3 = new Page3();
		page3.setCurrentType(PageType.Three);

		for (int i = 0; i < args.length; i++) {
			if (args[i] != null) {
				if (holdingWindow.getNext().equalsIgnoreCase(args[i])) {
					if (!page1.isActive()
							&& (page1.getCurrentType() != null && page1
									.getCurrentType() == PageType.One)) {
						page1.setActive(Boolean.TRUE);
						page1.setParentWindow(holdingWindow);
						holdingWindow = page1;
					} else if (!page2.isActive()
							&& (page2.getCurrentType() != null && page2
									.getCurrentType() == PageType.Two)) {
						page1.setCurrentType(null);
						page1.setActive(Boolean.FALSE);
						page2.setActive(Boolean.TRUE);
						page2.setParentWindow(holdingWindow);
						holdingWindow = page2;
					} else if (!page3.isActive()
							&& (page3.getCurrentType() != null && page3
									.getCurrentType() == PageType.Three)) {
						page2.setCurrentType(null);
						page2.setActive(Boolean.FALSE);
						page3.setActive(Boolean.TRUE);
						page3.setParentWindow(holdingWindow);
						holdingWindow = page3;
					}
				} else if (holdingWindow.getBack().equalsIgnoreCase(args[i])) {
					System.out.println("<-->");
					if (page2.isActive()
							&& (page2.getCurrentType() != null && page2
									.getCurrentType() == PageType.Two)) {
						page2.display();
						page2.setCurrentType(null);
						page2.setActive(Boolean.FALSE);
						page1.setActive(Boolean.TRUE);
						page1.setCurrentType(PageType.One);
						holdingWindow = page1;
					} else if (page3.isActive()
							&& (page3.getCurrentType() != null && page3
									.getCurrentType() == PageType.Three)) {
						page3.display();
						page3.setCurrentType(null);
						page3.setActive(Boolean.FALSE);
						page2.setActive(Boolean.TRUE);
						page2.setCurrentType(PageType.Two);
						holdingWindow = page2;
					}
				}
			}
		}
	}
}
