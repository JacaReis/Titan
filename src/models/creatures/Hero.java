package models.creatures;

import models.itens.Item;
import models.itens.Provision;

import java.util.HashMap;
import java.util.Map;

import models.equipament.Armour;
import models.equipament.Weapon;

/**
 * Um heroi eh uma criatura du mundo de titan.<br>
 * Este por pertencer a qualquer raca (geralemente a de humanos).
 * 
 * @author Jaca Reis
 *
 */
public class Hero extends Creature {
	
	protected int initLuck, luck;
	protected int stage;
	
	protected Map<Item, Integer> bag;
	
	protected Weapon weapon;
	protected Armour armour;
	
	public Hero(String name, int hability, int energy, int luck) {
		super(name, hability, energy);
		
		this.initLuck = luck;
		this.luck = this.initLuck;
		
		this.stage = 0;
		this.bag = new HashMap<Item, Integer>();
		this.bag.put(new Provision(), 0);
	}
	
	/* GETTERS */
	
	public int getInitLuck() {
		return initLuck;
	}
	
	public int getLuck() {
		return luck;
	}

	public Weapon getWeapon() {
		return weapon;
	}
	
	public Armour getArmour() {
		return armour;
	}
	
	public Map<Item, Integer> getBag() {
		return bag;
	}
	
//	public int getProvisoes() {
//		return provision;
//	}
	
	public int getStage() {
		return stage;
	}
	
	/* SETTERS */
	
	public void setLuck(int luck) {
		this.luck = luck;
	}

//	public void setProvisoes(int provision) {
//		this.provision = provision;
//	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void setArmour(Armour armour) {
		this.armour = armour;
	}
	
	public void setStage(int stage) {
		this.stage = stage;
	}
	
	/* OTHERS */
	
	public void upLuckPoint() {
		this.initLuck++;
	}
	
	public void testLuck() {
		this.luck = Math.max(0, this.luck-1);
	}

	public void addItemInBag(Item newItem) {
		addItemInBag(newItem, 1);
	}

	public void addItemInBag(Item newItem, int n) {
		boolean puted = false;
		
		for(Item item : this.bag.keySet()) {
			if(item.equals(newItem)) {
				int quant = this.bag.get(item) + n;
				this.bag.put(item, quant);
				puted = true;
			}
		}
		if(!puted) {
			this.bag.put(newItem, n);
		}
	}
	
	public void incrementProvisoes(int quant) {
		int provions = this.bag.get(0);
		this.bag.put(new Provision(), provions+quant);
	}
	
	/* Overrides */
	
	@Override
	public void attack(Creature creature, int damage) {
		System.out.println("Voce aplicou " + damage + " de dano.");
		creature.receiveDamage(damage);
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str += "L: " + this.luck + "\n";

		return str;
	}
}
