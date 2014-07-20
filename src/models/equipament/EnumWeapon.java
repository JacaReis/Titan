package models.equipament;

import models.equipament.weapon.TelessaSword;

public enum EnumWeapon {

	TelessaSword(new TelessaSword()),
	;
	
	private Weapon weapon;
	
	private EnumWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Weapon getWeapon() {
		return this.weapon;
	}
}
