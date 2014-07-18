package models.magics;

import models.creatures.Creature;

public class Levitation extends Magic {

	public Levitation() {
		super("Permite que voce flutue ate uns quatro de altura. " +
			"Como voce tambem flutua suavemente para o chao com este feitico, " +
			"ele podera ajuda-lo a descer um penhasco, por exemplo.");
	}
	
	@Override
	public void use(Creature... creatures) {
		// TODO Nothing

	}

}
