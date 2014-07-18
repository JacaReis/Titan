package models.equipament;

public abstract class Armour {

	protected String name;
	
	public Armour(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
