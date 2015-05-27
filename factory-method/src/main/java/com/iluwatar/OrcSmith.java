package com.iluwatar;

/**
 * 
 * Concrete subclass for creating new objects.
 * 
 */
public class OrcSmith implements Smith {

	public Weapon manufactureWeapon(WeaponType weaponType) {
		return new OrcWeapon(weaponType);
	}

}
