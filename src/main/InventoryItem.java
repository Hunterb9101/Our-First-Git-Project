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

}
