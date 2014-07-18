package models.busnisses;

import java.util.ArrayList;
import java.util.List;

import models.creatures.Creature;
import models.creatures.CreatureName;

/**
 * Fabrica de criaturas.<br>
 * As criaturas podem ser feitas do "zero" ou podem vir das ecolhas nos dados de criaturas errantes,
 *  definidas especificamente em cada jogo.
 * 
 * @author Jaca Reis
 *
 */
public class FactoryCreature {
	
	private List<CreatureName> creatures;
	
	public FactoryCreature() {
		this.creatures = new ArrayList<CreatureName>();
	}
	
	public void setCreatures(CreatureName[] creatures) {
		for(CreatureName creature : creatures) {
			this.creatures.add(creature);
		}
	}
	
	public void setCreatures(List<CreatureName> creatures) {
		this.creatures = creatures;
	}
	
	public Creature getCreature(int dice) {
		return this.creatures.get(dice).getCreature();
	}
	
}
