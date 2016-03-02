package main;

import java.util.ArrayList;

import graphics.GraphicsGrid;
import graphics.GraphicsGridEntry;

public class Player {
	public ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
	public int lvl = 1; // Player's Current Level
	public int xp = 0; // The stuff that makes up the level, certain amount of XP increases level
	public int gold = 0; 
	
	public int hp = 0;
	private int maxHp = 0; // !SHOULD NOT BE EDITED! // 
	
	
	/* Skills */
	public int skillAttk = 0; //Melee Weapons Attack Bonus
	public int skillAccuracy = 0; //Ranged Weapons Attack Bonus
	public int skillHitPoints = 0; //Adds Hitpoints to User
	public double skillEvasionChance = 0; // Chance to Evade Enemy
	public int skillGoldHoarder = 0; //Gold gained bonus
	
	public enum traits{NONE,THIEF,WARRIOR,ARCHER};
	public traits job;
	public int critic = 1;

	public Player(traits job) {
		switch(job){
		case NONE:
			break;
		case THIEF:		
			//Set weaknesses and strengths
			break;
		case WARRIOR:
			//Set weaknesses and strengths
			break;
		case ARCHER:
			//Set weaknesses and strengths
			break;
		}
	}

	public int calculateMaxHP(){
		// Calculate the max hitpoints based off of armor, skills, etc. //
		return 0;
	}
	
	public void giveGold(int GoldGiven) {
		// Will be used to give gold to the player (Will take into mind the skill sets //
	}
	
	public int getAttackDamage(){
		// This formula will be used to calculate the amount of damage will be done to a target //
		return 0;
	}
	
	public void compileInventory(GraphicsGrid g){
		try{
			for(int i = 0; i<items.size(); i++){
				System.out.println("Added " + items.get(i).name);
				g.items[i] = new GraphicsGridEntry(items.get(i),g);
			}
			/*
			for(int i = 0; i<g.items.length-items.size()-1; i++){
				new GraphicsGridEntry(g);
			}
			*/
		}catch(NullPointerException e){
			System.out.println("EVEN MORE ERRORS!");
		}
	}
}
