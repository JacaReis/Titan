package models.busnisses;

import java.util.Scanner;

import models.creatures.Creature;
import models.creatures.Hero;
import models.creatures.MagicHero;
import models.dreamCreatures.DreamCreature;

public class BasicsFunctions {

	private static Scanner in = new Scanner(System.in);
	
	public static int throwDice() {
		
		int dice = 1 + (int)(Math.random()*6);
		
		// Sempre que lancar um dado apresentar seu valor
		
		return dice;
	}
	
	public static int lancarDoisDados() {
		int quant = 0;
		quant += throwDice();
		quant += throwDice();
		return quant;
	}
	
	public static boolean testLuck(Hero hero) {
		int dice_1 = throwDice();
		int dice_2 = throwDice();
		
		boolean hadLuck = (dice_1 + dice_2) <= hero.getLuck();
		
		System.out.println("Teste de sorte:");
		System.out.println("Sua sorte: " + hero.getLuck());
		System.out.println("Valor dos dados:" + (dice_1 + dice_2));
		
		hero.testLuck();
		System.out.println(hero.getLuck());
		
		return hadLuck;
	}
	
	public static boolean simpleBattle(Hero hero, Creature oponent) {
		
		boolean isFighting = true;
		
		while(isFighting) {
			
			{
//				Print HP dos combatentes
				System.out.println(oponent.getName());
				for(int i = 0; i < oponent.getEnergy(); i++) System.out.print("#");
				
				System.out.println();
				
				System.out.println(hero.getName());
				for(int i = 0; i < hero.getEnergy(); i++) System.out.print("#");

				System.out.println();
			}
			
			int dice_1_oponent = throwDice();
			int dice_2_oponent = throwDice();
			
			int oponent_attack_power = (oponent.getHability() + dice_1_oponent + dice_2_oponent);
			
			System.out.println("Poder de ataque do "+oponent.getName()+": " + oponent_attack_power);
			
			int dice_1_hero = throwDice();
			int dice_2_hero = throwDice();
			
			int hero_attack_power = (hero.getHability() + dice_1_hero + dice_2_hero);
			
			System.out.println("Seu poder de ataque: " + hero_attack_power);
			
			if(hero_attack_power > oponent_attack_power) {
				int damage = 2;
				
				System.out.println("Voce quer testar a sorte para aumentar o dano no oponente? (y/n)");
				
				if(in.next().charAt(0) == 'y') {
					damage = (testLuck(hero))? 3 : 1 ;
				}
				
				hero.attack(oponent, damage);
				
			}
			else if(hero_attack_power < oponent_attack_power) {
				int damage = 2;
				
				System.out.println("Voce quer testar a sorte para dimiuir o dano recebido? (y/n)");
				
				if(in.next().charAt(0) == 'y') {
					damage = (testLuck(hero))? 1 : 3 ;
				}
				
				oponent.attack(hero, damage);
				
			}
			else {
				// Empate, continua a luta
				oponent.receiveDamage(0);
			}
			
			isFighting = !(oponent.isDead() || hero.isDead());
		}
		
		return !(hero.isDead());
	}
	
	public static boolean battle(Hero hero, Creature... creatures) {
		
		// Let's go to fight!!!
		boolean heroWin = true;
		
		// For just one oponent
		if(creatures.length == 1) {
			heroWin = simpleBattle(hero, creatures[0]);
		}
		else {
			System.out.println("Only shit... o\\");
		}
		
		return heroWin;
	}
	
	public static Hero createHero(boolean isMagicHero) {
		
		Hero hero = null;
		
		System.out.println("Qual seu nome?");
		String name = in.nextLine();
		
		int hability, energy, luck, power;
		
		{
			// Lancar um dado para determinar sua hibilidade inicial
			int dice1 = throwDice();
			
			hability = (6 + dice1);
			
			System.out.println("Sua habilidade sera de :" + hability);
		}
		
		{
			// Lancar dois dados para determinar sua energia inicial
			int dice1 = throwDice();
			int dice2 = throwDice();
			
			energy = (12 + dice1 + dice2);
			
			System.out.println("Sua energia sera de :" + energy);
		}
		
		{
			// Lancar um dado para determinar sua energia inicial
			int dice1 = throwDice();
			
			luck = (6 + dice1);
			
			System.out.println("Sua sorte sera de :" + luck);
		}
		
		if(isMagicHero){
			// Lancar um dado para determinar o poder inicial
			int dice1 = throwDice();
			int dice2 = throwDice();
			
			power = (6 + dice1 + dice2);
			
			hero = new MagicHero(name, hability, energy, luck, power);

			System.out.println("Seu poder sera de :" + power);
		}
		else {
			hero = new Hero(name, hability, energy, luck);
		}
		
		return hero;
	}

	public static boolean dreamBattle(MagicHero hero, DreamCreature creature) {
		
		boolean isFighting = true;
		
		while(isFighting) {
			
			{
//				Print Powers
				System.out.print(creature.getName() + "\nPower: ");
				for(int i = 0; i < creature.getPower(); i++) System.out.print("#");
				
				System.out.println();
				
				System.out.print(hero.getName() + "\nPower: ");
				for(int i = 0; i < hero.getPower(); i++) System.out.print("#");

				System.out.println();
			}
			
			System.out.println("Lancar dados!");
			in.next();
			
			int dices = lancarDoisDados();
			System.out.println("O valor dos dados foi: " + dices);
			
			if(dices > 7) {
				creature.lostPower(2);
			}
			else {
				hero.lostPower(2);
			}
			
			isFighting = !(creature.noPower() || hero.noPower());
			
		}
		
		return hero.getPower()!=0;
	}
	
}
