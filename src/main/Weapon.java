package main;

import java.awt.Image;
import java.util.ArrayList;

public class Weapon extends InventoryItem{
	public static ArrayList<Weapon> allWeapons = new ArrayList<Weapon>();
	String name;
	int damage;
	int cost;
	static Image src = Registry.loadImage("res/Flag2.png");
	public Weapon(String name, int damage, int cost) {
		super(name,src,cost);
		
		this.name = name;
		this.damage = damage;
		this.cost = cost;
		allWeapons.add(this);	
	}
	public String parseText(){
		String retString = name + " does " + damage + " damage";
		return retString;
	}
}
