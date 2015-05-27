package com.iluwatar;

/**
 * 
 * Concrete subclass for creating new objects.
 * 
 */
public class ElfSmith implements Smith {

	public Weapon manufactureWeapon(WeaponType weaponType) {
		return new ElfWeapon(weaponType);
	}

}
