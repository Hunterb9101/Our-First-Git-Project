package main;

import java.awt.Image;
import java.util.ArrayList;

public class Weapon extends InventoryItem{
	public static ArrayList<Weapon> allWeapons = new ArrayList<Weapon>();
	public String name;
	public int damage;
	int cost;
	int attackSpeed;
	public static Image src = Registry.loadImage("res/Flag2.png");
	public Weapon(String name, int damage, int cost, int attackSpeed) {
		super(name,src,cost);
		this.attackSpeed = attackSpeed;
		this.name = name;
		this.damage = damage;
		this.cost = cost;
		allWeapons.add(this);	
	}
	public static Weapon getWeapon(String name){
		Weapon w = allWeapons.get(2);
		for(int i = 0; i < allWeapons.size(); i++){
			if(allWeapons.get(i).name.equalsIgnoreCase(name)){
				w = allWeapons.get(i);
			}
		}
		return w;
	}
	public String parseText(){
		String retString = name + " does " + damage + " damage";
		return retString;
	}
}
