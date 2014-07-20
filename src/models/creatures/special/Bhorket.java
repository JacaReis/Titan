package models.creatures.special;

import models.creatures.Creature;

public class Bhorket extends Creature {

	private int consecutive_attack;
	
	public Bhorket(int hability, int energy) {
		super("Bhorket", hability, energy);
		
		this.consecutive_attack = 0;
	}
	
	@Override
	public void receiveDamage(int damage) {
		this.consecutive_attack = 0;
		super.receiveDamage(damage);
	}
	
	@Override
	public void attack(Creature creature, int damage) {
		
		if(this.consecutive_attack == 2) {
			System.out.println("O " + this.name + " conseguiu lhe derrubar!");
			System.out.println("Você perde mais um de dano extra.");
			damage += 1;
			this.consecutive_attack = 0;
		}
		
		super.attack(creature, damage);
	}

}
