package models.dreamCreatures;

public enum EnumDreamCreature {

	FANTASMA_DA_NEVE("Fantasma da Neve", 14);
	
	private String name;
	private int power;
	
	private EnumDreamCreature(String name, int power) {
		this.name = name;
		this.power = power;
	}
	
	public DreamCreature getCreature() {
		return new DreamCreature(this.name, this.power);
	}
}
