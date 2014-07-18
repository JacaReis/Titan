package models.equipament;

import models.equipament.weapon.TelassaSword;

public enum EnumWeapon {

	TelassaSword(new TelassaSword()),
	;
	
	private Weapon weapon;
	
	private EnumWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Weapon getWeapon() {
		return this.weapon;
	}
}
