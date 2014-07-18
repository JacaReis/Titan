package models.itens;

import models.creatures.Creature;

public abstract class Item {

	protected String name;
	protected String description;
	
	public Item(String description, String name) {
		this.description = description;
		this.name = name;
	}
	
	public abstract void use(Creature... creatures);
	
	@Override
	public String toString() {
		return this.name;
	}

}
