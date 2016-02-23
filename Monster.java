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
}
