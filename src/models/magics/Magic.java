package models.magics;

import models.creatures.Creature;

public abstract class Magic {

	protected String name;
	protected String description;
	
	public Magic(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public abstract void use(Creature... creatures);

	@Override
	public String toString() {
		return this.name;
	}
}
