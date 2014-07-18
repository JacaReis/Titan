package models.dreamCreatures;

public class DreamCreature {

	private String name;
	private int power;
	
	public DreamCreature(String name, int power) {
		this.name = name;
		this.power = power;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPower() {
		return power;
	}
	
	public void lostPower(int quant) {
		this.power = Math.max(0, this.power-quant);
	}
	
	public boolean noPower() {
		return this.power==0;
	}
}