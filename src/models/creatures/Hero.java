package models.creatures;

import models.itens.Item;

import java.util.ArrayList;
import java.util.List;

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
	protected int provisoes;

	protected List<Item> bag;
	
	protected Weapon weapon;
	protected Armour armour;
	
	public Hero(String name, int hability, int energy, int luck) {
		super(name, hability, energy);
		
		this.initLuck = luck;
		this.luck = this.initLuck;
		
		this.provisoes = 0;
		this.bag = new ArrayList<Item>();
	}
	
	public int getInitLuck() {
		return initLuck;
	}
	
	public int getLuck() {
		return luck;
	}

	public Armour getArmour() {
		return armour;
	}
	
	public List<Item> getBag() {
		return bag;
	}
	
	public int getProvisoes() {
		return provisoes;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void upLuckPoint() {
		this.initLuck++;
	}
	
	public void setLuck(int luck) {
		this.luck = luck;
	}

	public void setProvisoes(int provisoes) {
		this.provisoes = provisoes;
	}
	
	public void setArmour(Armour armour) {
		this.armour = armour;
	}
	
	public void setBag(List<Item> bag) {
		this.bag = bag;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void testLuck() {
		this.luck = Math.max(0, this.luck-1);
	}

	public void addItemInBag(Item newItem) {
		this.bag.add(newItem);
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str += "L: " + this.luck + "\n";

		return str;
	}

	public void incrementProvisoes(int quant) {
		this.provisoes += quant;
	}
	
	@Override
	public void attack(Creature creature, int damage) {
		System.out.println("Voce aplicou " + damage + " de dano.");
		creature.receiveDamage(damage);
	}
}
