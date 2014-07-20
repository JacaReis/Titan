package views;

import java.util.Scanner;
import java.util.Vector;

import controllers.GameActions;
import controllers.ProgramActions;

import models.creatures.Hero;
import models.creatures.MagicHero;
import models.dreamCreatures.DreamCreature;
import models.dreamCreatures.EnumDreamCreature;
import models.itens.Item;

public class StartGame {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		Vector<String> actions = new Vector<String>();
		actions.add("save");
		actions.add("exit");
		actions.add("walk");
		actions.add("battle");
		actions.add("dream_battle");
		actions.add("use_item");
		actions.add("test_luck");
		actions.add("use_magic");
		actions.add("update");
		actions.add("search");
		actions.add("dices");
		actions.add("status");
		actions.add("stage");
		
		ProgramActions program = new ProgramActions();
		GameActions game = new GameActions();
		
		Hero hero = null;
		
		System.out.println("O que deseja fazer:");
		System.out.println("Começar um jogo novo: 'new'");
		System.out.println("Carregar um jogo salvo: 'load'");
		
		String action = in.next();
		
		if(action.equalsIgnoreCase("NEW")) {
			hero = game.createHero(true);
			game.choicePotion(hero);
		}
		else if(action.equalsIgnoreCase("LOAD")) {
			hero = program.loadGame();
		}
		
		System.out.println();
		
		boolean finishProgram = (hero==null);
		
		while(!finishProgram) {
			
			System.out.println(actions);
			System.out.print("O que deseja fazer: ");
			action = in.next();
			
//			Program Actions
			if(action.equalsIgnoreCase("SAVE")) {
				program.saveGame(hero.getName(), hero);
			}
			else if(action.equalsIgnoreCase("EXIT")) {
				program.extitGame(hero.getName(), hero);
				finishProgram = true;
			}
//			Game Actions
			else if(action.equalsIgnoreCase("WALK")) {
				System.out.print("Proximo estagio: ");
				int stage = in.nextInt();
				hero.setStage(stage);
			}
			else if(action.equalsIgnoreCase("BATTLE")) {
//				FIXME Tentar incluir magia na batalha
				game.battle(hero);
				
				if(hero.isDead()) {
					System.out.println("\nGame Over!!!\n");
					
					program.extitGame(hero.getName(), hero);
					
					finishProgram = true;
				}
				
			}
			else if(action.equalsIgnoreCase("DREAM_BATTLE")) {
				int power = ((MagicHero) hero).getPower();
				
				System.out.print("Qual o nome da criatura: ");
				String name = in.next();
				
				DreamCreature creature = EnumDreamCreature.valueOf(name).getCreature();
				boolean win = game.dreamBattle((MagicHero) hero, creature);

				((MagicHero) hero).setPower(power);
				
				if(!win) {
					creature.effect(hero);
				}
				
			}
			else if(action.equalsIgnoreCase("USE_ITEM")) {
				System.out.println("Escolha um item: ");
				
				for(Item item : hero.getBag().keySet()) {
					int quant = hero.getBag().get(item);
//					FIXME Tratar para apresentar todos os itens, mas so permitir utilizar os que ainda tiverem
					if(quant > 0) System.out.println(item.getName() + " ["+quant+"]");
				}
				
				String name = in.next();
				
				Item item = null;
				
				for(Item iten : hero.getBag().keySet()) {
					if(iten.getName().equalsIgnoreCase(name)) {
						item = iten;
					}
				}
				
				hero.useItem(item, hero);
				
			}
			else if(action.equalsIgnoreCase("TEST_LUCK")) {

				boolean hasLuck = game.testLuck(hero);
				
				if(hasLuck) {
					System.out.println("Voce teve sorte!");
				}
				else {
					System.out.println("Voce foi azarado!");
				}
			}
			else if(action.equalsIgnoreCase("USE_MAGIC")) {
				if(hero instanceof MagicHero) {
					MagicHero magichero = (MagicHero) hero;
					
					if(magichero.getPower() > 0) {
						for(int i = 1; i <= magichero.getMagics().size(); i++) {
							System.out.println(i+ " - " + magichero.getMagics().get(i-1));
						}
						
						System.out.print("Escolha uma magia para utilizar: ");
						int n = in.nextInt() - 1;
						
						magichero.useMagic(n);
					}
					else {
						System.out.println("Voce nao tem poder suficiente para lancar uma magia.");
					}
				}
				else {
					System.out.println("O heroi nao pode usar magia. :(");
				}
			}
			else if(action.equalsIgnoreCase("UPDATE")) {
				System.out.println("Indique os valores em ordem: ");
				String[] values = in.next().split(",");
				
				hero.receiveHability(Integer.parseInt(values[0]));
				hero.receiveEnergy(Integer.parseInt(values[1]));
				hero.receiveLuck(Integer.parseInt(values[2]));
				((MagicHero) hero).receivePower(Integer.parseInt(values[3]));
				
				if(hero.isDead()) {
					System.out.println("Game Over!");
					
					program.extitGame(hero.getName(), hero);
					
					finishProgram = true;
				}
				
			}
			else if(action.equalsIgnoreCase("SEARCH")) {
				game.searchProvisions(hero);
			}
			else if(action.equalsIgnoreCase("DICES")) {
				System.out.print("Quantos dados deseja lancar: ");
				int quant = in.nextInt();
				
				game.throwDices(quant);
				
			}
			else if(action.equalsIgnoreCase("STATUS")) {
				int h = hero.getHability();
				int iH = hero.getInitHability();
				int e = hero.getEnergy();
				int iE = hero.getInitEnergy();
				int l = hero.getLuck();
				int iL = hero.getInitLuck();
				int p = ((MagicHero)hero).getPower();
				
				System.out.println(hero.getName() + 
						" = [ H: " + h + "/" + iH +
						", E: " + e + "/" + iE +
						", L: " + l + "/" + iL +
						", P:" + p + " ]");
			}
			else if(action.equalsIgnoreCase("STAGE")) {
				System.out.println("Stage: " + hero.getStage());
			}
			
			System.out.println();
			
		}

		System.out.println("End Program");
	}
		
}
