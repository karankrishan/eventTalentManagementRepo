package com.designPattern.strategy.pattern.example2;

public abstract class Character {
	WeaponBehaviour weaponBehaviour;

	abstract void personality();

	public void setWeaponBehaviour(WeaponBehaviour weaponBehaviour) {
		this.weaponBehaviour = weaponBehaviour;
	}

	public static void main(String[] args) {
		WeaponBehaviour behaviour = new SwordBehaviour();
		Character character = new King();
		character.setWeaponBehaviour(behaviour);
		character.personality();
	}
}
