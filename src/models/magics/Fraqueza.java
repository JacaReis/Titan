package models.magics;

import models.creatures.Creature;

public class Fraqueza extends Magic {

	public Fraqueza() {
		super("Reduz a ENERGIA do oponente em 4 pontos.");
	}
	
	@Override
	public void use(Creature... creatures) {
		Creature creature = creatures[0];
		
		int energy = creature.getEnergy();
		creature.setEnergy(energy - 4);
	}

}
