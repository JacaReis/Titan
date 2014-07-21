package models.equipament;

public abstract class Armour implements Cloneable {

	protected String name;
	
	public Armour(String name) {
		this.name = name;
	}
	
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
