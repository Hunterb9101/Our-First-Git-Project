package main;

import java.awt.Image;

public abstract class InventoryItem {
	public String name;
	public Image src;
	public int cost;
	public InventoryItem(String iName, Image iSrc, int iCost){
		name = iName;
		src = iSrc;
		cost = iCost;
	}
	public abstract String parseText();
	public boolean isWeapon(){
		for(int i = 0; i < Weapon.allWeapons.size(); i++){
			if(name.equals(Weapon.allWeapons.get(i).name) && cost == Weapon.allWeapons.get(i).cost){
				return true;
			}
		}
		return false;
	}
	public boolean isArmor(){
		for(int i = 0; i < Armor.allArmor.size(); i++){
			if(name.equals(Armor.allArmor.get(i).name) && cost == Armor.allArmor.get(i).cost){
				return true;
			}
		}
		return false;
	}
	public Weapon getWeapon(){
		for(int i = 0; i < Weapon.allWeapons.size(); i++){
			if(this.name.equals(Weapon.allWeapons.get(i).name) && this.cost == Weapon.allWeapons.get(i).cost){
				return Weapon.allWeapons.get(i);
			}
		}
		return null;
	}
	public Armor getArmor(){
		for(int i = 0; i < Armor.allArmor.size(); i++){
			if(this.name.equals(Armor.allArmor.get(i).name) && this.cost == Armor.allArmor.get(i).cost){
				return Armor.allArmor.get(i);
			}
		}
		return null;
	}

}
