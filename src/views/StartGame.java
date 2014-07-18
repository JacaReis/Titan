package views;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import models.busnisses.BasicsFunctions;
import models.creatures.Creature;
import models.creatures.CreatureName;
import models.creatures.Hero;
import models.creatures.MagicHero;
import models.dreamCreatures.DreamCreature;
import models.dreamCreatures.EnumDreamCreature;
import models.equipament.Armour;
import models.equipament.EnumArmour;
import models.equipament.EnumWeapon;
import models.equipament.Weapon;
import models.equipament.armour.LeatherArmour;
import models.equipament.weapon.TelassaSword;
import models.itens.EnergyPotion;
import models.itens.EnumItem;
import models.itens.HabilityPotion;
import models.itens.Item;
import models.itens.LuckPotion;

public class StartGame {

	private static Scanner in = new Scanner(System.in);

	private static String[] errantes_1 = {
		"EMPTY", "LOBO", "ALCE", "URSO", "GIGANTE_DA_FLORESTA", "EMPTY"};
	
	private static int stage;
	
	public static void main(String[] args) {
		
		boolean exit = false;
		
		Hero hero = null;
		
//		hero = startHero();
		
		hero = loadGameSaved();
		
		if(hero==null) {
			System.out.print("Creature Name: ");
			String name = in.next();
			
			System.out.print("Creature Hability: ");
			int hability = in.nextInt();
			
			System.out.print("Creature Energy: ");
			int energy = in.nextInt();
			
			System.out.print("Creature Luck: ");
			int luck = in.nextInt();
			
			System.out.print("Creature Power: ");
			int power = in.nextInt();
			
			hero = new MagicHero(name, hability, energy, luck, power);
			hero.setArmour(new LeatherArmour());
			hero.setWeapon(new TelassaSword());
			hero.addItemInBag(new LuckPotion());
		}
		
		int stage = 0;
		
		while(!exit) {
			System.out.println("Update Status: 'u' ");
			System.out.println("Save: 's' ");
			System.out.println("Exit: 'e' ");
			System.out.println("Battle: 'b' ");
			System.out.println("Search Provioes: 'p'");
			System.out.println("Testar Sorte: 't'");
			System.out.println("Dream Battle: 'bs'");

			String choice = in.next();
			
			if(choice.equalsIgnoreCase("U")) {
			}
			else if(choice.equalsIgnoreCase("S")) {
				System.out.print("Stage number: ");
				
				stage = in.nextInt();
				
				saveGame(hero, stage);
				
			}
			else if(choice.equalsIgnoreCase("E")) {
				saveGame(hero, stage);
				
				exit = true;
			}
			else if(choice.equalsIgnoreCase("T")) {
				
				boolean hasLuck = BasicsFunctions.testLuck(hero);
				
				if(hasLuck) {
					System.out.println("Voce teve sorte!");
				}
				else {
					System.out.println("Voce foi azarado!");
				}
				
			}
			else if(choice.equalsIgnoreCase("P")) {
				
				System.out.print("Lance um dado para escolher uma criatura: ");
				in.next();
				
				int dice = BasicsFunctions.throwDice();
				boolean win = true;
				
				Creature creature = CreatureName.valueOf(errantes_1[dice]).getCreature();
				
				if(!creature.getName().equalsIgnoreCase("")) {
					System.out.println("Voce encontrou um"+creature.getName()+"!\n" +
							"Voce tem que derrota-la!");
					
					win = BasicsFunctions.battle(hero, creature);
				}
				
				if(win) {
					int quant = BasicsFunctions.lancarDoisDados();
					
					System.out.println("Voce encontrou "+quant+" provisoes");
					
					hero.incrementProvisoes(quant);
				}
				else {
					exit = true;
					
					System.out.println("Game Over");
				}
				
				
			}
			else if(choice.equalsIgnoreCase("B")) {
				System.out.print("Number of creatures: ");
				int quantCreatures = in.nextInt();
				Creature[] creatures = new Creature[quantCreatures];
				
				for(int i = 0; i < quantCreatures; i++) {
					System.out.print("Creature name: ");
					String nameCreature = in.next();
					
					creatures[i] = CreatureName.valueOf(nameCreature).getCreature();
				}
				
				boolean win = BasicsFunctions.battle(hero, creatures);
				
				if(!win) {
					exit = true;
					
					System.out.println("Game Over");
				}
				else {
					System.out.println(((MagicHero) hero).toString());
				}
			}
			else if(choice.equalsIgnoreCase("BS")) {
				
				int power = ((MagicHero) hero).getPower();
				
				System.out.print("Creature name: ");
				String nameCreature = in.next();
				
				DreamCreature creature = EnumDreamCreature.valueOf(nameCreature).getCreature();
				
				BasicsFunctions.dreamBattle((MagicHero) hero, creature);
				
				((MagicHero) hero).setPower(power);
				
			}
		}
		
	}
	
	public static Hero startHero() {
		Hero hero = BasicsFunctions.createHero(true);
		
		System.out.println("\n" +
				"Escolha uma Pocao:\n" +
				"1 - Pocao de Habilidade\n" +
				"2 - Pocao de Energia\n" +
				"3 - Pocao de Sorte\n");
		
		int choice = in.nextInt();
		hero.addItemInBag(selectPotion(choice));
		hero.setWeapon(new TelassaSword());
		hero.setArmour(new LeatherArmour());
		
		return hero;
	}
	
	public static Item selectPotion(int choice) {
		Item potion = null;
		
		switch (choice) {
		case 1:
			potion = new HabilityPotion();
		case 2:
			potion = new EnergyPotion();
		case 3:
			potion = new LuckPotion();
		}
		
		return potion;
	}
	
	public static void saveGame(Hero hero, int stage) {
		try {
			
			FileWriter fw = new FileWriter("saves/"+hero.getName()+".titan");
			
			// Salvando os dados
			fw.write("Name:" + hero.getName() + "\n");
			
			fw.write("Init Hability:" + hero.getInitHability() + "\n");
			fw.write("Hability:" + hero.getHability() + "\n");
			
			fw.write("Init Energy:" + hero.getInitEnergy() + "\n");
			fw.write("Energy:" + hero.getEnergy() + "\n");
			
			fw.write("Init Luck:" + hero.getInitLuck() + "\n");
			fw.write("Luck:" + hero.getLuck() + "\n");
			
			if(hero instanceof MagicHero) {
				MagicHero magicHero = (MagicHero) hero;
				fw.write("Init Power:" + magicHero.getInitPower() + "\n");
				fw.write("Power:" + magicHero.getPower() + "\n");
			}
			
			fw.write("Provisoes:" + hero.getProvisoes() + "\n");
			
			fw.write("Weapon:" + hero.getWeapon().toString() + "\n");
			fw.write("Armour:" + hero.getArmour().toString() + "\n");
			
			fw.write("Bag:{" + hero.getBag().toString() + "}" + "\n");
			
			fw.write("Stage:" + stage);
			
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Hero loadGameSaved() {
		System.out.print("Diga o nome do arquivo: ");
		String name = in.next();
		
		return loadGameSaved(name);
	}
	
	public static Hero loadGameSaved(String name) {
		
		MagicHero hero = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("saves/"+name+".titan"));
			
			String line = "";
			
			while(br.ready()) {
				line = br.readLine().split(":")[1];
				String heroName = line;
				
				line = br.readLine().split(":")[1];
				int initHability = Integer.parseInt(line);
				
				line = br.readLine().split(":")[1];
				int hability = Integer.parseInt(line);
				
				line = br.readLine().split(":")[1];
				int initEnergy = Integer.parseInt(line);
				
				line = br.readLine().split(":")[1];
				int energy = Integer.parseInt(line);
				
				line = br.readLine().split(":")[1];
				int initLuck = Integer.parseInt(line);
				
				line = br.readLine().split(":")[1];
				int luck = Integer.parseInt(line);
				
				line = br.readLine().split(":")[1];
				int initPower = Integer.parseInt(line);
				
				line = br.readLine().split(":")[1];
				int power = Integer.parseInt(line);
				
				line = br.readLine().split(":")[1];
				int provisoes = Integer.parseInt(line);
				
				hero = new MagicHero(heroName, initHability, initEnergy, initLuck, initPower);
				hero.setHability(hability);
				hero.setEnergy(energy);
				hero.setLuck(luck);
				hero.setPower(power);
				hero.setProvisoes(provisoes);
				
				line = br.readLine().split(":")[1];
				Weapon weapon = EnumWeapon.valueOf(line).getWeapon();
				hero.setWeapon(weapon);
				
				line = br.readLine().split(":")[1];
				Armour armour = EnumArmour.valueOf(line).getArmour();
				hero.setArmour(armour);
				
				line = br.readLine().split(":")[1];
				String[] bag = line.substring(2, line.length()-2).split(",");
				
				for(String item : bag) {
					hero.addItemInBag(EnumItem.valueOf(item).getItem());
				}
				
				line = br.readLine().split(":")[1];
				stage = Integer.parseInt(line);
				
			}
			
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generabr.readLine();ted catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
		return hero;
	}
}
