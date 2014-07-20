package models.dreamCreatures;

import models.creatures.Creature;
import models.creatures.MagicHero;

public class MorcegoVampiro extends DreamCreature {

	public MorcegoVampiro(int power) {
		super("Morcego Vampiro", power);
	}

	@Override
	public void effect(Creature creature) {
		((MagicHero) creature).losePower(1);
	}
}
