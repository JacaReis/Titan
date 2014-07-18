package models.magics;

import models.creatures.Creature;

public class Ilusion extends Magic {

	public Ilusion() {
		super("Permite que qualquer coisa, inclusive voce mesmo, pareca-se com qualquer outra coisa, " +
			"porem sem exageros (por exemplo, voce nao pode fazer um formigueiro se parecer com uma montanha).");
	}
	
	@Override
	public void use(Creature... creatures) {
		// TODO Nothing
	}

}
