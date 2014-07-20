package models.creatures;

import java.util.ArrayList;
import java.util.List;

import models.magics.Fire;
import models.magics.Fraqueza;
import models.magics.Ilusion;
import models.magics.Levitation;
import models.magics.Localizar;
import models.magics.Magic;
import models.magics.Protection;

/**
 * Heroi que possui a habilidade de utilizar magia
 * 
 * @author Jaca Reis
 *
 */
public class MagicHero extends Hero {
	
	protected List<Magic> magics;
	protected int power;
	
	public MagicHero(String name, int hability, int energy, int luck, int power) {
		super(name, hability, energy, luck);
		
		this.power = power;
		
		this.magics = new ArrayList<Magic>();
		this.magics.add(new Protection());
		this.magics.add(new Ilusion());
		this.magics.add(new Fraqueza());
		this.magics.add(new Levitation());
		this.magics.add(new Localizar());
		this.magics.add(new Fire());
	}
	
	public List<Magic> getMagics() {
		return this.magics;
	}
	
	public int getPower() {
		return power;
	}
	
	public void setPower(int magic_power) {
		this.power = magic_power;
	}

	public void losePower(int quant) {
		this.power = Math.max(0, this.power-quant);
	}
	
	public void useMagic(int magic, Creature... creatures) {
		this.magics.get(magic).use(creatures);
		this.power--;
	}
	
	public void receivePower(int adicional) {
		this.power = Math.max(0, (this.power + adicional));
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
