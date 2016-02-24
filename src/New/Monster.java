package New;

import java.util.ArrayList;
import java.util.Random;

public class Monster {
	static ArrayList<Monster> AllMonsters = new ArrayList<Monster>(10);
	String name;
	int xp;
	int gold;
	int damage;
	int health;
	int lvl;

	public Monster(String name, int xp, int gold, int damage, int health, int lvlAvailable) {
		this.name = name;
		this.xp = xp;
		this.gold = gold;
		this.damage = damage;
		this.health = health;
		lvl = lvlAvailable;
		AllMonsters.add(this);

	}

	public static Monster pickMonster(Player a) {
		Random rand = new Random();
		Monster m = AllMonsters.get(rand.nextInt(AllMonsters.size()));
		while (m.lvl > a.lvl) {
			// while required level is greater then player level, pick new
			// monster
			// this is so we pick a monster within the meetable monsters for
			// this player
			m = AllMonsters.get(rand.nextInt(AllMonsters.size()));
			// this picks a random monster within AllMonsters
		}
		return m;
	}
}
