package models.busnisses;

import java.util.ArrayList;
import java.util.List;

import models.creatures.Creature;
import models.creatures.EnumCreature;

/**
 * Fabrica de criaturas.<br>
 * As criaturas podem ser feitas do "zero" ou podem vir das ecolhas nos dados de criaturas errantes,
 *  definidas especificamente em cada jogo.
 * 
 * @author Jaca Reis
 *
 */
public class FactoryCreature {
	
	private List<EnumCreature> creatures;
	
	public FactoryCreature() {
		this.creatures = new ArrayList<EnumCreature>();
	}
	
	public void setCreatures(EnumCreature[] creatures) {
		for(EnumCreature creature : creatures) {
			this.creatures.add(creature);
		}
	}
	
	public void setCreatures(List<EnumCreature> creatures) {
		this.creatures = creatures;
	}
	
	public Creature getCreature(int dice) {
		return this.creatures.get(dice).getCreature();
	}
	
}
