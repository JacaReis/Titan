package models.equipament;

import models.equipament.armour.LeatherArmour;

public enum EnumArmour {

	LeatherArmour(new LeatherArmour()),
	;
	
	private Armour armour;
	
	private EnumArmour(Armour armour) {
		this.armour = armour;
	}
	
	public Armour getArmour() {
		return armour;
	}
	
}
