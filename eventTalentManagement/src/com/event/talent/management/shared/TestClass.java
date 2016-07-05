package com.event.talent.management.shared;

public class TestClass {

	public static <Z> void testGenericMethod(Z[] e) {

		for (Z ele : e) {
			if (ele instanceof Integer) {
				System.out.print(ele+" ");
			} else if (ele instanceof Float) {
				System.out.print(ele+" ");
			}
		}
	}
	public Number REST() {
		System.out.println("WWJKL");
		return null;
	}
	public static void main(String[] args) {
		Integer[] i = { 1, 2 };
		Float[] f = { 1.1f, 2.2f };

		testGenericMethod(i);
		System.out.println();
		testGenericMethod(f);
	}
}
