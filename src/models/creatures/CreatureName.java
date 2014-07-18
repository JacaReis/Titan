package models.creatures;

import models.creatures.special.Bhorket;
import models.creatures.special.HomemGorgulho;

public enum CreatureName {
	
	HOMEM_GORGULHO(new HomemGorgulho(8, 11)),
	BHORKET(new Bhorket(8, 11)),
	
	FALCAO_SANGUE_GIGANTE("Falcão-Sangue Gigante", 7, 12),
	
	EMPTY("",0,0),
	LOBO("Lobo", 7, 6),
	ALCE("Alce", 6, 12),
	URSO("Urso", 7, 14),
	GIGANTE_DA_FLORESTA("Gigante da Floresta", 9, 9),
	;
	
	private Creature creature;

	private CreatureName(Creature creature) {
		this.creature = creature;
	}
	
	private CreatureName(String name, int hability, int energy) {
		this.creature = new NormalCreature(name, hability, energy);
	}
	
	public Creature getCreature() {
		return creature;
	}
}
