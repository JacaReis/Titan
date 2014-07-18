package models.magics;

import models.creatures.Creature;

public class Fire extends Magic {

	public Fire() {
		super("Voce e capaz de produzir chamas na ponta dos dedos que podem ser lancadas " +
			"numa pequena area (como o peito do inimigo!), para criar uma barreira de fogo, " +	
			"ou apenas para voce se aquecer!");
	}
	
	@Override
	public void use(Creature... creatures) {
		// TODO Nothing
	}
}
