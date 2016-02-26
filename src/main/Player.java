package main;
public class Player {
	
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
	
	public enum traits{THIEF,WARRIOR,ARCHER};
	public traits job;
	public int critic = 1;

	public Player(traits job) {
		switch(job){
		case THIEF:		
			//Set weaknesses and strengths
		case WARRIOR:
			//Set weaknesses and strengths
		case ARCHER:
			//Set weaknesses and strengths
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
}
