package game;

import java.util.ArrayList;
import java.util.Scanner;

import penguin.*;

public class GameApp {

	public static void main(String args[]) {
		ArrayList<Penguin> yourParty = new ArrayList<Penguin>();
		
		yourParty.add(new FighterPenguin ("Aetherhopper", 60, 8, "I won't lose!"));
		yourParty.add(new ElementalPenguin ("King Diluc", 80, 5, PenguinType.FIRE, "Repent!"));
		yourParty.add(new ElementalPenguin ("Penganyu", 60, 7, PenguinType.SNOW, "Give me your gems!"));
		yourParty.add(new ElementalPenguin ("Monadelie", 40, 9, PenguinType.WATER, "The council will decide your fate!"));
		
		ArrayList<Penguin> enemies = new ArrayList<Penguin>();
		
		//enemies.add(new FighterPenguin ("Zhongli", 999, 999, "...No."));
		enemies.add(new Penguin("Penmon", 50, "Don't bully me!"));
		enemies.add(new FighterPenguin ("Pengunner", 60, 5, "One shot, one kill."));
		enemies.add(new ElementalPenguin ("Penklee", 40, 10, PenguinType.FIRE, ":D???"));
		enemies.add(new ElementalPenguin ("Penqiqi", 70, 8, PenguinType.SNOW, "zzz...?"));
		enemies.add(new ElementalPenguin ("Emperor Childe", 100, 12, PenguinType.WATER, "This ends here!"));
		
		System.out.println("Welcome Penguin Impact PvP Simulator!");
		System.out.println("You'll fight five enemies.");
		System.out.println("Are you ready? Here we go?");
		
		Penguin currentPlayer = yourParty.get(0);
		Penguin currentEnemy = enemies.get(0);
		
		Scanner sc = new Scanner(System.in);
		
		//begin fight, player always goes first
		//current player and current enemy says catchphrase
		System.out.println(currentPlayer.getSpeech());
		System.out.println(currentEnemy.getSpeech());
		
		boolean gameEnd = false;
		
		while(!gameEnd) {
			System.out.println("==== Your Turn! ====");
			boolean playerTurnDone = false;
			
			//this loops until the player does a valid action
			while(!playerTurnDone) {
				
				//display the current player and current enemy
				
				System.out.println(currentPlayer);
				System.out.println(currentEnemy);
				System.out.println("-----");
				System.out.println("1) Attack");
				System.out.println("2) Switch");
				
				int parsedPlayerChoice = 0;
				
				try {
					String playerChoice = sc.nextLine();
					parsedPlayerChoice = Integer.parseInt(playerChoice);
				}catch (Exception e) {
					
				}
				
				switch(parsedPlayerChoice) {
				//option 1: attack, deal damage
				case 1:
					attack(currentPlayer, currentEnemy);
					playerTurnDone = true;
					break;
					
				//option 2: switch	
				case 2:
					Penguin switchTo = switchCharacter(yourParty, currentPlayer, sc);
					
					if(switchTo != null) {
						currentPlayer = switchTo;
						playerTurnDone = true;
					}
					break;
				default:
					System.out.println("Not a valid input! Please try again.");
				}
				//if player chooses something invalid, then this loop doesn't break
			}
			
			//after taking player actions, check if enemy is dead
			if(currentEnemy.getHp() <= 0) {
				System.out.println(currentEnemy.getName() + " is defeated!");
				
				//if enemy is dead, send out the next one
				
				Penguin nextEnemy = null;
				
				for(Penguin p : enemies) {
					if(p.getHp() != 0) {
						nextEnemy = p;
						break;
					}
				}
				
				currentEnemy = nextEnemy;
				
				//if there is nothing to send, quit the game and congratulate player
				if(currentEnemy == null) {
					System.out.println("You defeated all enemies! Congratulations!");
					gameEnd = true;
				}else {
					//if there is indeed something to send, announce their entry and make them speak
					System.out.println(nextEnemy.getName() + " enters the battle!");
					System.out.println(nextEnemy.getSpeech());
				}
			}
			
			//if there is still an enemy, it will attack
			if(currentEnemy != null) {
				System.out.println("==== Their Turn ====");
				attack(currentEnemy, currentPlayer);
				
				//after enemy attack, check if player is dead
				if(currentPlayer.getHp() <= 0) {
					System.out.println(currentPlayer.getName() + " is defeated!");
					
					//if player is dead, check if everyone is dead
					Penguin livingPartyMember = null;
					
					//check if there is a living party member
					for(Penguin p : yourParty) {
						if(p.getHp() != 0) {
							livingPartyMember = p;
							break;
						}
					}
					
					//if there are no more characters to send out, quit the game and give a game over message
					if(livingPartyMember == null) {
						System.out.println("Your party has been defeated! Game over...");
						gameEnd = true;
						break;
					}
				
					//choose a new hero!
					boolean newHeroChosen = false;
					while(!newHeroChosen) {
						
						Penguin switchTo = switchCharacter(yourParty, currentPlayer, sc);
						
						if(switchTo != null) {
							currentPlayer = switchTo;
							newHeroChosen = true;
						}
						
					}
				}
			}
			//loop back to beginning at display
		}
	}
	
	public static String getEffectiveMessage(int effectiveness) {
		
		if(effectiveness == 1) {
			return "It's super effective!";
		}
		
		if(effectiveness == -1) {
			return "It's not very effective...";
		}
		
		return null;
	}
	
	public static void attack(Penguin attacker, Penguin defender) {
		if(attacker instanceof FighterPenguin) {
			FighterPenguin fp = (FighterPenguin) attacker;
			int damage = fp.attack(defender);
			System.out.println(attacker.getName() + " deals " + damage + " damage to " + defender.getName() + "!");
			
			//if there is elemental advantage/disadvantage, it prints here
			if(attacker instanceof ElementalPenguin) {
				ElementalPenguin elAttacker = (ElementalPenguin) attacker;
				
				int adv = elAttacker.getElementalAdvantage(defender);
				
				String effectiveMessage = getEffectiveMessage(adv);
				
				if(effectiveMessage != null) System.out.println(effectiveMessage);
				
			}
			
		}else {
			//if it can't attack, it will speak its catchphrase
			System.out.println(attacker.getSpeech());
		}
	}
	
	//will only return a new character if the switch is valid. otherwise it's null
	public static Penguin switchCharacter(ArrayList<Penguin> yourParty, Penguin currentPlayer, Scanner sc) {
		System.out.println("Who to switch to?");
		int party = 1;
		for(Penguin p: yourParty) {
			System.out.println(party + ") " + p);
			party++;
		}
		
		int parsedSwitchChoice = 0;
		
		try {
			String playerChoice = sc.nextLine();
			parsedSwitchChoice = Integer.parseInt(playerChoice);
		}catch (Exception e) {
			System.out.println("Not a valid input!");
			return null;
		}
		
		if(parsedSwitchChoice - 1 < 0 || parsedSwitchChoice - 1 >= yourParty.size()) {
			System.out.println("Not in range!");
			return null;
		}
		
		Penguin switchedChar = yourParty.get(parsedSwitchChoice - 1);
		
		//you cannot pick dead characters
		if(switchedChar.getHp() <= 0) {
			System.out.println("That penguin is unconscious!");
			return null;
		}
		
		//if same character is chosen, don't break loop and returns to options
		if(switchedChar.equals(currentPlayer)) {
			System.out.println("No need to switch, it's the same penguin!");
			return null;
		}
		
		//otherwise, switch current player and have new char say catchphrase
		System.out.println(currentPlayer.getName() + " is switched out for " + switchedChar.getName() + "!");
		System.out.println(switchedChar.getSpeech());
		
		return switchedChar;
	}
	
}
