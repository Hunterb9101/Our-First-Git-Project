package main;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;

public class Registry {
	public static HashMap<String, Image> imgRes = new HashMap<String,Image>();
	static Helper h;//Helper pulls out of Registry, so we have 1 Helper(), therefore
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
	
	public static void registerImageResources(){
		imgRes.put("FightLoopMenu", loadImage("res/Adventure.png"));
		imgRes.put("InventoryMenu", loadImage("res/Inventory.png"));
		imgRes.put("ShopMenu", loadImage("res/Shop.png"));
	}
	
	public static void registerArmor(){
		new Armor("Leather", 7, 52);
		new Armor("chain mail", 9, 77);
		new Armor("steel plate", 15, 84);
		new Armor("iron", 11, 67);
		new Armor("Enchanted", 18, 134);
		new Armor("Mythical", 27, 213); 
		new Armor("Dragon", 23, 157);
	}
	
	public static void registerWeapons(){
		new Weapon("Iron sword", 6, 37);
		new Weapon("Wood sword", 3, 17);
		new Weapon("Steel Sword", 11, 78);
		new Weapon("Iron BattleAxe", 8, 48);
		new Weapon("Steel BattleAxe", 14, 83);
		new Weapon("Iron Dagger", 3, 24);
		new Weapon("Steel Dagger", 7, 42);
		new Weapon("Long bow", 4, 37);
		new Weapon("Compound bow", 6, 79);
		new Weapon("enchanted sword", 16, 121);
		new Weapon("Mythical sword", 18, 162);
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
