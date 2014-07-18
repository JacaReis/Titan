package models.itens;

import models.creatures.Creature;

public class Provisao extends Item {

	private int quantity;
	
	public Provisao() {
		super("Uma refeição simples");
		this.quantity = 0;
	}
	
	@Override
	public void use(Creature... creatures) {
		creatures[0].receiveEnergy(4);
		this.quantity--;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
}
