package main;

import java.util.ArrayList;
import main.Armor;
import windows.FightLoopWindow;
import main.Weapon;

public class Player {
	public ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
	
	public int zoneLvl = 1;
	public int lvl = 1; // Player's Current Level
	public int totalXp = 0; // The stuff that makes up the level, certain amount
							// of
	// XP increases level
	public int gold = 0;

	public int hp = 10;
	public int maxHp = 0; // !SHOULD NOT BE EDITED! //
	public int attack = 0;

	public Armor equipedHelmet;
	public Armor equipedChestplate;
	public Armor equipedGloves;
	public Armor equipedLeggings;
	public Armor equipedBoots;
	public Weapon equipedWeapon;
	/* Skills */
	public int skillAttk = 0; // Melee Weapons Attack Bonus
	public int skillAccuracy = 0; // Ranged Weapons Attack Bonus
	public int skillHitPoints = 0; // Adds Hitpoints to User
	public double skillEvasionChance = 0; // Chance to Evade Enemy
	public int skillGoldHoarder = 0; // Gold gained bonus
	public int skillSpeed = 1;

	public enum traits {
		NONE, THIEF, WARRIOR, ARCHER
	};

	public traits job;
	public int critic = 1;
	private Helper playerHelper;

	public Player(traits job) {
		playerHelper = new Helper();
		switch (job) {
		case NONE:
			break;
		case THIEF:
			// Set weaknesses and strengths
			break;
		case WARRIOR:
			// Set weaknesses and strengths
			break;
		case ARCHER:
			// Set weaknesses and strengths
			break;
		}
	}

	public boolean canAttack() {
		if (playerHelper.getElapsedTime() > 10 / skillSpeed) {
			return true;
		}
		return false;
	}

	public void attacked() {
		playerHelper.start();
	}

	public int calculateMaxHP() {
		maxHp = (hp * lvl);
		//checks that some armor is equiped
		//then adds it to the max HP
		if (equipedHelmet != null) {
			maxHp += equipedHelmet.defense;
		}
		if (equipedChestplate != null) {
			maxHp += equipedChestplate.defense;
		}
		if (equipedGloves != null) {
			maxHp += equipedGloves.defense;
		}
		if (equipedLeggings != null) {
			maxHp += equipedLeggings.defense;
		}
		if (equipedBoots != null) {
			maxHp += equipedBoots.defense;
		}
		// Calculate the max hitpoints based off of armor, skills, etc. //
		return maxHp;
	}

	public void giveGold(int GoldGiven) {
		// Will be used to give gold to the player (Will take into mind the
		// skill sets //
		gold += GoldGiven;
	}

	public int getAttackDamage() {
		attack = lvl * 5;
		if (equipedWeapon == null) {

		} else {
			attack += equipedWeapon.damage;
		}
		// This formula will be used to calculate the amount of damage will be
		// done to a target //
		return attack;
	}
}
