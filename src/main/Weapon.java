package main;

import java.util.ArrayList;

public class Weapon {
	ArrayList<Weapon> allWeapons = new ArrayList<Weapon>();
	String name;
	int damage;
	int cost;
	
	public Weapon(String name, int damage, int cost) {
		this.name = name;
		this.damage = damage;
		this.cost = cost;
		allWeapons.add(this);	
	}
}
