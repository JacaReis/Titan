package models.dreamCreatures;

import models.creatures.Creature;
import models.creatures.MagicHero;

public class FantasmaDaNeve extends DreamCreature {

	public FantasmaDaNeve(int power) {
		super("Fantasma da Neve", power);
	}

	@Override
	public void effect(Creature creature) {
		((MagicHero) creature).receiveDamage(1);
	}
}
