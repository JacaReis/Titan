package models.itens;

import models.creatures.Creature;

public class Provision extends Item {

	public Provision() {
		super("Uma refeição simples", "Provision");
	}
	
	@Override
	public void use(Creature... creatures) {
		creatures[0].receiveEnergy(4);
	}
	
}
