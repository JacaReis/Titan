package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.creatures.Hero;
import models.creatures.MagicHero;
import models.equipament.Armour;
import models.equipament.EnumArmour;
import models.equipament.EnumWeapon;
import models.equipament.Weapon;
import models.itens.EnumItem;

public class ProgramActions {

	private List<String> actions;
	
	private Scanner in = new Scanner(System.in);
	
	public ProgramActions() {
		this.actions = new ArrayList<String>();
		
		this.actions.add("NEW");
		this.actions.add("LOAD");
		this.actions.add("SAVE");
		this.actions.add("EXIT");
	}
	
//	FIXME inserir JAVADOC
//	FIXME Verificar a necessidade do metodo
	public Hero newGame() {
		return null;
	}
	
//	FIXME inserir JAVADOC
	public Hero loadGame() {
		System.out.print("Diga o nome do arquivo: ");
		String name = in.next();
		
		return loadGame(name);
	}
	
//	FIXME inserir JAVADOC
	public Hero loadGame(String fileName) {
		
		MagicHero hero = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("saves/"+fileName+".titan"));
			
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
				int power = Integer.parseInt(line);
				
				hero = new MagicHero(heroName, initHability, initEnergy, initLuck, power);
				hero.setHability(hability);
				hero.setEnergy(energy);
				hero.setLuck(luck);
				hero.setPower(power);
				
				line = br.readLine().split(":")[1];
				Weapon weapon = EnumWeapon.valueOf(line).getWeapon();
				hero.setWeapon(weapon);
				
				line = br.readLine().split(":")[1];
				Armour armour = EnumArmour.valueOf(line).getArmour();
				hero.setArmour(armour);
				
//				FIXME Verificar o carregamento dos itens da mochila
				line = br.readLine().split(":")[1];
				String[] bag = line.substring(1, line.length()-1).split(",");
				
				for(String itemValue : bag) {
					String item = itemValue.split("=")[0].trim();
					int quant = Integer.parseInt(itemValue.split("=")[1]);
					
					hero.addItemInBag(EnumItem.valueOf(item).getItem(), quant);
				}
				
				line = br.readLine().split(":")[1];
				int stage = Integer.parseInt(line);
				hero.setStage(stage);
				
			}
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return hero;
	}
	
//	FIXME inserir JAVADOC
	public void saveGame(String fileName, Hero hero) {
		try {
			FileWriter fw = new FileWriter("saves/"+fileName+".titan");
			
			// Salvando os dados
			fw.write("Name:" + hero.getName() + "\n");
			
			fw.write("Init Hability:" + hero.getInitHability() + "\n");
			fw.write("Hability:" + hero.getHability() + "\n");
			
			fw.write("Init Energy:" + hero.getInitEnergy() + "\n");
			fw.write("Energy:" + hero.getEnergy() + "\n");
			
			fw.write("Init Luck:" + hero.getInitLuck() + "\n");
			fw.write("Luck:" + hero.getLuck() + "\n");
			
			// FIXME Melhorar o metodo de 'save' para ser unico para varios tipos de herois
			if(hero instanceof MagicHero) {
				MagicHero magicHero = (MagicHero) hero;
				fw.write("Power:" + magicHero.getPower() + "\n");
			}
			
			fw.write("Weapon:" + hero.getWeapon().toString() + "\n");
			fw.write("Armour:" + hero.getArmour().toString() + "\n");
			
			fw.write("Bag:" + hero.getBag().toString() + "\n");
			
			fw.write("Stage:" + hero.getStage());
			
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo para encerrar o programa (encerra o jogo salvando os dados)
	 * 
	 * @param hero Dados do personagem para salvar
	 */
	public void extitGame(String fileName, Hero hero) {
		saveGame(fileName, hero);
	}

}
