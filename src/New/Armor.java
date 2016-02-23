/*
 * I am writing this to test the commit capabilities of GIT!
 */
package New;

import java.util.ArrayList;

public class Armor {
	ArrayList<Armor> allArmor = new ArrayList<Armor>();
	String name;
	int defense;
	int cost;
	
	public Armor(String name, int defense, int cost) {
		this.name = name;
		this.defense = defense;
		this.cost = cost;
		allArmor.add(this);
	}
}
