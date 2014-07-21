package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.creatures.Creature;
import models.creatures.EnumCreature;
import models.creatures.Hero;
import models.creatures.MagicHero;
import models.dreamCreatures.DreamCreature;
import models.equipament.armour.LeatherArmour;
import models.equipament.weapon.TelessaSword;
import models.itens.EnergyPotion;
import models.itens.HabilityPotion;
import models.itens.Item;
import models.itens.LuckPotion;

public class GameActions {

	private Scanner in = new Scanner(System.in);
	
	private static String[] errantes_1 = {
		"EMPTY", "LOBO", "ALCE", "URSO", "GIGANTE_DA_FLORESTA", "EMPTY"};
	
	public static int throwDice() {
		
		int dice = 1 + (int)(Math.random()*6);
		
		// Sempre que lancar um dado apresentar seu valor
		
		return dice;
	}
	
	public int throwDices(int n) {
		
		System.out.println("Os valores foram: ");
		int sum = 0;
		
		for(int i = 1; i <= n; i++) {
			int dice = throwDice();
			System.out.print(dice+", ");
			sum += dice;
		}
		
		System.out.println("\ntotal: " + sum);
		
		return sum;
	}
	
	public boolean testLuck(Hero hero) {
		int dices = throwDices(2);
		
		boolean hadLuck = dices <= hero.getLuck();
		
		System.out.println("Teste de sorte:");
		System.out.println("Sua sorte: " + hero.getLuck());
		System.out.println("Valor dos dados:" + dices);
		
		hero.testLuck();
		
		return hadLuck;
	}
	
	public void combat(Hero hero, Creature oponent) {
		
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
			// Empate, ambos evitaram os ataques
		}
	}
	
	public boolean battle(Hero hero) {
		System.out.print("Quantas criaturas esta combatendo: ");
		int quant = in.nextInt();

		List<Creature> creatures = new ArrayList<Creature>();
		
		for(int i = 0; i < quant; i++) {
			System.out.print("Qual o nome da criatura: ");
			String name = in.next();
			creatures.add(EnumCreature.valueOf(name).getCreature());
		}
		
		// Let's go to fight!!!
		battle(hero, creatures);
		
		return !hero.isDead();
	}
	
	public boolean battle(Hero hero, List<Creature> oponents) {
		
		boolean isFighting = true;
		
		while(isFighting) {
			{
//				Print HP dos combatentes
				for(Creature oponent : oponents) {
					System.out.println(oponent.getName());
					for(int i = 0; i < oponent.getEnergy(); i++) System.out.print("#");
					System.out.println();
				}
				
				System.out.println(hero.getName());
				for(int i = 0; i < hero.getEnergy(); i++) System.out.print("#");

				System.out.println();
			}
			
			for(int i = 0; i < oponents.size(); i++) {
				combat(hero, oponents.get(i));
				
				if(oponents.get(i).isDead()) {
					oponents.remove(i);
					i--;
				}
			}
			
			isFighting = !oponents.isEmpty() && !hero.isDead();
		}
		
		return !hero.isDead();
	}
	
	public Hero createHero(boolean isMagicHero) {
		
		Hero hero = null;
		
		System.out.println("Qual seu nome?");
		String name = in.nextLine();
		
		int hability, energy, luck, power;
		
		{
			// Lancar um dado para determinar sua hibilidade inicial
			int dice1 = throwDice();
			
			hability = (6 + dice1);
			
			System.out.println("Sua habilidade sera de: " + hability);
		}
		
		{
			// Lancar dois dados para determinar sua energia inicial
			int dices = throwDices(2);
			
			energy = (12 + dices);
			
			System.out.println("Sua energia sera de: " + energy);
		}
		
		{
			// Lancar um dado para determinar sua energia inicial
			int dice1 = throwDice();
			
			luck = (6 + dice1);
			
			System.out.println("Sua sorte sera de: " + luck);
		}
		
		if(isMagicHero){
			// Lancar um dado para determinar o poder inicial
			int dices = throwDices(2);
			
			power = (6 + dices);
			
			hero = new MagicHero(name, hability, energy, luck, power);

			System.out.println("Seu poder sera de: " + power);
		}
		else {
			hero = new Hero(name, hability, energy, luck);
		}
		
		return hero;
	}

	public boolean dreamBattle(MagicHero hero, DreamCreature creature) {
		
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
			
			System.out.print("Lancar dados (y): ");
			in.next();
			
			int dices = throwDice() + throwDice();
			System.out.println("O valor dos dados foi: " + dices);
			
			if(2 <= dices && dices <= 7) {
				System.out.println("O " + creature.getName() + " tirou 2 pontos do seu poder.");
				hero.losePower(2);
			}
			else {
				System.out.println("Você tirou 2 pontos de poder do " + creature.getName() + ".");
				creature.lostPower(2);
			}
			
			isFighting = !(creature.noPower() || hero.noPower());
			
			System.out.println();
		}
		
		return hero.getPower()!=0;
	}

	public void searchProvisions(Hero hero) {
		int dice = throwDice();
		
		Creature creature = EnumCreature.valueOf(errantes_1[dice-1]).getCreature();
		
//		Se nao selecionou uma "criatura vazia", deve lutar
		if(!creature.getName().equalsIgnoreCase("")) {
			System.out.println(
					"Enquanto voce procurava por provisoes " +
					"voce encontrou um "+creature.getName()+"!\n" +
					"Voce tem que derrota-lo!");
			
			List<Creature> creatures = new ArrayList<Creature>();
			creatures.add(creature);
			
			battle(hero, creatures);
		}
		
		if(!hero.isDead()) {
			int quant = throwDice() + throwDice();
			
			System.out.println("Voce encontrou "+quant+" provisoes");
			
			hero.incrementProvisoes(quant);
		}
		
	}
	
	public void choicePotion(Hero hero) {
		System.out.println("\n" +
				"Escolha uma Pocao:\n" +
				"1 - Pocao de Habilidade\n" +
				"2 - Pocao de Energia\n" +
				"3 - Pocao de Sorte\n");
		
		int choice = in.nextInt();
		hero.addItemInBag(selectPotion(choice));
		
//		FIXME Generalizar para a construcao de qualquer heroi com suas armas especificas
		hero.setWeapon(new TelessaSword());
		hero.setArmour(new LeatherArmour());
	}
	
	private Item selectPotion(int choice) {
		Item potion = null;
		
		switch (choice) {
		case 1:
			potion = new HabilityPotion();
			break;
		case 2:
			potion = new EnergyPotion();
			break;
		case 3:
			potion = new LuckPotion();
			break;
		}
		
		return potion;
	}

}
