package models.creatures.special;

import java.util.Scanner;

import models.creatures.Creature;
import models.creatures.Hero;

public class EscorpioesGigantes extends Creature {

	private int attacks;
	private Creature atacada;
	
	public EscorpioesGigantes(int hability, int energy) {
		super("Escorpiões Gigantes", hability, energy);
		
		this.attacks = 0;
	}
	
	@Override
	public void attack(Creature creature, int damage) {
		this.atacada = creature;
		
		super.attack(creature, damage);
		
		this.attacks++;
		
	}
	
	@Override
	public boolean isDead() {
		boolean isDead = super.isDead();
		
		String message = "Você sofreu " + attacks + " ataque(s).\n" +
				"Deve tratar ferimento recebido para não ser envenenado.";
		
		if(this.attacks > 0) System.out.println(message);
		
		for(int i = 1; i <= this.attacks; i++) {
			System.out.println("Ferimento " + i + ": Como deseja trata-lo");
			System.out.println("1 - cortar a área infectada com sua lâmina, " +
					"o que lhe custará 2 pontos de ENERGIA");
			System.out.println("2 - procurar uma raiz do antídoto Alaba, " +
					"o que lhe reduzirá 1 ponto de SORTE");
			
			int choice = new Scanner(System.in).nextInt();
			
			if(choice==1) {
				System.out.println("Você perdeu 2 pontos de ENERGIA.");
				this.atacada.receiveDamage(2);
			}
			else if(choice==2) {
				System.out.println("Você perdeu 1 ponto de SORTE.");
				int l = ((Hero) atacada).getLuck();
				((Hero) atacada).setLuck(l-1);
			}
			else {
				System.out.println("Escolha errada!");
				i--;
			}
		}
		
		return isDead;
	}

}
