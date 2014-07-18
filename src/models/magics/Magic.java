package models.magics;

import models.creatures.Creature;

public abstract class Magic {

	protected String description;
	
	public Magic(String description) {
		this.description = description;
	}
	
	public abstract void use(Creature... creatures);
}
