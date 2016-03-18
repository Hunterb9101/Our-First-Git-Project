package main;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;

public class Registry {
	public static HashMap<String,Image> imgRes = new HashMap<String,Image>();
	public static Graphics g;
	public static Helper h;//Helper pulls out of Registry, so we have 1 Helper(), therefore
	//runtime not reset constantly, and it is public so we can pull it from other classes
	public static void initHelper(){
		h = new Helper();
	}
	
	public static Image loadImage(String path){
		Image img = null;
		try {
		    img = ImageIO.read(new File(path));
		} catch (IOException e){}		
		return img;
	}
	
	public static void registerArmor(){
		makeArmorSet("Leather", 7, 52);
		makeArmorSet("chain mail", 9, 77);
		makeArmorSet("steel plate", 15, 84);
		makeArmorSet("iron", 11, 67);
		makeArmorSet("Enchanted", 18, 134);
		makeArmorSet("Mythical", 27, 213); 
		makeArmorSet("Dragon", 23, 157);
	}
	
	private static void makeArmorSet(String name, int defence, int cost){
		//defence based on helmet value, so that we can easily multiply, and keep whole numbers
		//same for cost, based on helmet value for the same reasons
		new Armor(name + " helmet", defence, cost, Armor.armorPiece.HEAD);//makes helmet
		new Armor(name + " chestplate", (defence * 3), cost * 3, Armor.armorPiece.CHEST);//makes chestplate
		new Armor(name + " gloves", (int) (defence / 2), (int) (cost/2), Armor.armorPiece.GLOVES);//makes the gloves
		new Armor(name + " leggings", (defence * 2), (cost * 2), Armor.armorPiece.PANTS);//makes pants
		new Armor(name + " boots", defence, cost, Armor.armorPiece.BOOTS);//makes boots
		//multiplier values based off of Minecraft ratios of armor
		
	}
	public static void registerImageResources(){
		imgRes.put("ShopMenu", loadImage("res/Shop.png"));
		imgRes.put("FightLoopMenu", loadImage("res/Adventure.png"));
		imgRes.put("InventoryMenu", loadImage("res/Inventory.png"));
		imgRes.put("Flag", loadImage("res/Flag.png"));//test image
		imgRes.put("Flag2", loadImage("res/Flag2.png"));
		imgRes.put("Grid", loadImage("res/Grid.png"));
	}
	public static void registerWeapons(){
		new Weapon("Iron sword", 6, 37, 5);
		new Weapon("Wood sword", 3, 17, 7);
		new Weapon("Steel Sword", 11, 78, 6);
		new Weapon("Iron BattleAxe", 8, 48, 3);
		new Weapon("Steel BattleAxe", 14, 83, 4);
		new Weapon("Iron Dagger", 3, 24, 7);
		new Weapon("Steel Dagger", 7, 42, 8);
		new Weapon("Long bow", 4, 37, 1);
		new Weapon("Compound bow", 6, 79, 1);
		new Weapon("enchanted sword", 16, 121, 7);
		new Weapon("Mythical sword", 18, 162, 6);
	}

	//Monster(String name, int xp, int gold, int damage, int health, int lvlAvailable)
	public static void registerMonsters(){
		new Monster("Zombie", 1, 4, 2, 5, 1);
		new Monster("Wolf", 1, 3, 3, 6, 1);
		
		new Monster("Goblin", 2, 6, 3, 7, 2);
		new Monster("Goblin", 2, 5, 4, 5, 2);
		
		new Monster("Skeleton", 4, 9, 5, 8, 3);
		new Monster("Dwarf", 2, 5, 4, 5, 3);
		new Monster("Mermaid", 3, 5, 2, 7, 3);
		
		new Monster("Vampire", 4, 15, 9, 11, 4);
		new Monster("T-Rex", 4, 15, 9, 11, 4);
		new Monster("Ogre", 4, 15, 9, 11, 4);
		
		new Monster("Troll", 4, 15, 9, 12, 5);
		new Monster("Orc", 5, 15, 12, 9, 5);
		
		new Monster("Cyclops", 7, 15, 9, 15, 6);
		new Monster("Werewolf", 6, 15, 15, 14, 6);
		new Monster("Minotaur", 7, 19, 13, 12, 6);

		new Monster("Gryphon", 8, 23, 22, 14, 7);
		new Monster("Giant", 7, 24, 18, 18, 7);
		
		new Monster("Ghoast", 9, 26, 22, 26, 8);
		new Monster("Goul", 8, 20, 26, 22, 8);
		
		new Monster("Hydra", 13, 29, 26, 28, 9);
		new Monster("Basalisk", 12, 24, 29, 25, 9);
		new Monster("Fallen Angel", 11, 23, 27, 27, 9);
		
		new Monster("Dragon", 16, 32, 28, 31, 10);
		new Monster("Basalisk", 20, 33, 36, 24, 10);
		new Monster("Monster Hoard", 18, 27, 35, 27, 10);
	}
}
