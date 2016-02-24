package New;

import java.util.ArrayList;
import java.util.Random;

public class Monster {
	ArrayList<Monster> AllMonsters = new ArrayList<Monster>(10);
	String name;
	int xp;
	int gold;
	int damage;
	int health;
	int lvl;

	public Monster(String name, int xp, int gold, int damage, int health, int lvlAvailable) {
		if (!name.equalsIgnoreCase("Read Only")) {
			this.name = name;
			this.xp = xp;
			this.gold = gold;
			this.damage = damage;
			this.health = health;
			lvl = lvlAvailable;
			AllMonsters.add(this);
		}
	}
	public Monster pickMonster(Player a){
		Random rand = new Random();
		Monster m = new Monster("Read Only", 0, 0, 0, 0, -1);
		while(m.lvl > a.lvl){
			//while required level is greater then player level, pick new monster
			//this is so we pick a monster within the meetable monsters for this player
			m = m.AllMonsters.get(rand.nextInt(m.AllMonsters.size()));
			//this picks a random monster within AllMonsters
		}
		return m;
	}
}
