package models.magics;

import models.creatures.Creature;

public class Localizar extends Magic {

	public Localizar() {
		super("Localizar", "Permite que voce detecte a presenca de algo - " +
			"um tesouro, uma passagem secreta, ou ato um inimigo escondido. " +
			"O feitico e de curto alcance.");
	}
	
	@Override
	public void use(Creature... creatures) {
		// Nao fazer nada por enquanto
	}

}
