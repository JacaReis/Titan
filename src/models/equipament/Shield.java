package models.equipament;

public abstract class Shield {

	protected String name;
	
	public Shield(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
