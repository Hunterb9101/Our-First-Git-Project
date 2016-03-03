/*
 * I am writing this to test the commit capabilities of GIT!
 * Another Test...
 */
package main;

import java.awt.Image;
import java.util.ArrayList;

public class Armor extends InventoryItem{
	public static ArrayList<Armor> allArmor = new ArrayList<Armor>();
	String name;
	int defense;
	int cost;
	static Image src = Registry.imgRes.get("Flag");
	public Armor(String name, int defense, int cost) {
		super(name,src,cost);
		this.name = name;
		this.defense = defense;
		this.cost = cost;
		allArmor.add(this);
	}
	public static Armor getArmor(String name){
		Armor a = allArmor.get(2);
		for(int i = 0; i < allArmor.size(); i++){
			if(allArmor.get(i).name.equalsIgnoreCase(name)){
				a = allArmor.get(i);
			}
		}
		return a;
	}
	public String parseText(){
		String retString = name + " blocks " + defense + " damage";
		return retString;
	}
}
