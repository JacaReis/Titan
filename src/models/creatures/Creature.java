package models.creatures;

/**
 * Criatura basica do mundo de Titan
 * 
 * @author Jaca Reis
 *
 */
public abstract class Creature {

	protected String name;
	protected int initHability, hability;
	protected int initEnergy, energy;
	
	public Creature(String name, int hability, int energy) {
		this.name = name;
		
		this.initHability = hability;
		this.hability = this.initHability;
		
		this.initEnergy = energy;
		this.energy = this.initEnergy;
	}
	
	public String getName() {
		return name;
	}

	public int getInitHability() {
		return initHability;
	}
	
	public int getHability() {
		return hability;
	}
	
	public int getInitEnergy() {
		return initEnergy;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void setHability(int hability) {
		this.hability = hability;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void receiveDamage(int damage) {
		this.energy = Math.max(0, this.energy - damage);
	}

	public void receiveEnergy(int adicional) {
		this.energy = Math.min(this.initEnergy, (this.energy + adicional) );
	}
	
	public boolean isDead() {
		return this.energy == 0;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += "N: " + this.name + "\n";
		str += "H: " + this.hability + "\n";
		str += "E: " + this.energy + "\n";
		
		return str;
	}

	public void attack(Creature creature, int damage) {
		System.out.println("O " + this.name + " lhe aplicou " + damage + " de dano.");
		creature.receiveDamage(damage);
	}
	
}
