package models.creatures;

import models.creatures.special.Bhorket;
import models.creatures.special.HomemGorgulho;

public enum CreatureName {

//	Especiais
	HOMEM_GORGULHO(new HomemGorgulho(8, 11)),
	BHORKET(new Bhorket(8, 11)),
	
//	Normais
	FALCAO_SANGUE_GIGANTE("Falcão-Sangue Gigante", 7, 12),
	RAIZES("Raízes", 6, 12),
	LAGARTO_KOMODO("Lagarto Komodo", 6, 8),
	ALTERADOR_DE_FORMA("Alterador de Forma", 10, 10),
	JAVALI_SELVAGEM("Javali Selvagem", 6, 5),
	ARCTOLYCE("Arctolyce", 9, 14), // FIXME Valor correto: ARCTOLYCE("Arctolyce", 9, 16), 
//	FIXME alterar a batalha para incluir magia
	
//	Errantes
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
