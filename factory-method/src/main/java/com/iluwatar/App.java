package com.iluwatar;

/**
 * 
 * In Factory Method we have an interface (Smith) with a method for
 * creating objects (manufactureWeapon). The concrete subclasses (OrcSmith,
 * ElfSmith) then override the method to produce objects of their liking.
 * 
 */
public class App {

	public static void main(String[] args) {
		Smith blacksmith;
		Weapon weapon;

		blacksmith = new OrcSmith();
		weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
		System.out.println(weapon);
		weapon = blacksmith.manufactureWeapon(WeaponType.AXE);
		System.out.println(weapon);

		blacksmith = new ElfSmith();
		weapon = blacksmith.manufactureWeapon(WeaponType.SHORT_SWORD);
		System.out.println(weapon);
		weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
		System.out.println(weapon);
	}
}
