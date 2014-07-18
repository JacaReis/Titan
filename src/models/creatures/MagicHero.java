package models.creatures;

import java.util.List;

import models.magics.Magic;

/**
 * Heroi que possui a habilidade de utilizar magia
 * 
 * @author Jaca Reis
 *
 */
public class MagicHero extends Hero {
	
	protected List<Magic> magics;
	protected int initPower, power;
	
	public MagicHero(String name, int hability, int energy, int luck, int power) {
		super(name, hability, energy, luck);
		
		this.initPower = power;
		this.power = this.initPower;
	}
	
	public List<Magic> getMagics() {
		return this.magics;
	}
	
	public int getInitPower() {
		return initPower;
	}
	
	public int getPower() {
		return power;
	}
	
	public void getMagics(List<Magic> magics) {
		this.magics = magics;
	}

	public void setPower(int magic_power) {
		this.power = magic_power;
	}

	public void lostPower(int quant) {
		this.power = Math.max(0, this.power-quant);
	}
	
	public void useMagic(int magic, Creature... creatures) {
		this.magics.get(magic).use(creatures);
		this.power--;
	}
	
	@Override
	public String toString() {
		String str = super.toString();		
		str += "P: " + this.power;
		
		return str;
	}

	public boolean noPower() {
		return this.power==0;
	}
	
}
