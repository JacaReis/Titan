package models.itens;

import models.creatures.Creature;
import models.creatures.Hero;

public class LuckPotion extends Item {

	public LuckPotion() {
		super("Restaura todos os pontos de SORTE e soma 1 ponto ao seu valor inicial.",
				"LuckPotion");
	}
	
	@Override
	public void use(Creature... creatures) {
		if(creatures[0] instanceof Hero) {
			Hero hero = (Hero) creatures[0];
			
			hero.upLuckPoint();
			
			hero.setLuck(hero.getInitLuck());
		}
	}

}
