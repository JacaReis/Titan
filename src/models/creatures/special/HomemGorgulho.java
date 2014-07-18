package models.creatures.special;

import models.busnisses.BasicsFunctions;
import models.creatures.Creature;

public class HomemGorgulho extends Creature {

	public HomemGorgulho(int hability, int energy) {
		super("HOMEM-GORGULHO", hability, energy);
	}

	public void receiveDamage(int damage) {
		
		int dice = BasicsFunctions.throwDice();
		
		if(dice <= 3 && damage > 0) {
			System.out.println("Homem Gorgulho conseguiu evitar todo o golpe!");
			damage -= 1;
		}
		
		super.receiveDamage(damage);
	}
	
}
