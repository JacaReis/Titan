package models.itens;

import models.creatures.Creature;

public class HabilityPotion extends Item {

	public HabilityPotion() {
		super("Restaura todos os pontos de HABILIDADE.",
				"HabilityPotion");
	}
	
	@Override
	public void use(Creature... creatures) {
		creatures[0].setHability(creatures[0].getInitHability());
	}

}
