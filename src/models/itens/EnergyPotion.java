package models.itens;

import models.creatures.Creature;

public class EnergyPotion extends Item {

	public EnergyPotion() {
		super("Restaura todos os pontos de ENERGIA.",
				"EnergyPotion");
	}
	
	@Override
	public void use(Creature... creatures) {
		creatures[0].setEnergy(creatures[0].getInitEnergy());
	}

}
