package models.magics;

import models.creatures.Creature;

public abstract class Magic implements Cloneable {

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
	
	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
		}
		
		return null;
	}
}
