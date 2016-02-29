/*
 * I am writing this to test the commit capabilities of GIT!
 * Another Test...
 */
package main;

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
	public String parseText(){
		String retString = name + " blocks " + defense + " damage";
		return retString;
	}
}
