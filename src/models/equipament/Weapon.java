package models.equipament;

public abstract class Weapon {
	
	protected String name;
	
	public Weapon(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
