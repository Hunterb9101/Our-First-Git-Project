package main;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import graphics.*;
import main.Player.traits;
import windows.*;

//need for music and sound

public class Main extends ConstructorClass {
	public static enum menuItem{NONE,START,SHOP,ADVENTURE,INVENTORY};
	public static menuItem currMenu = menuItem.START;
	public static Player me = new Player(traits.NONE);
	private static boolean isFirstFrame = true;
	
	public Random rand = new Random();
	
	boolean itemBought = true;//will be deleted once shop is made
	
	int defaultWidth = 600;
	int defaultHeight = 600;

	GraphicsImage mainMap = new GraphicsImage(Registry.loadImage("res/MainMap.png"),25,50,550,550);
	DefaultMenu mainMenu;
	ShopWindow shopMenu;
	FightLoopWindow fightLoopMenu;
	InventoryWindow inventoryMenu;
	StartMenuWindow startMenuWindow;

	public void doInitialization(int width, int height) {	
	}

	// All drawing is done here //
	synchronized public void drawFrame(Graphics g, int width, int height) {
		Registry.g = g;
		if(isFirstFrame){
			isFirstFrame = false;
			Registry.initHelper(); //Initializes the Helper(), so Runtime is started.
			Registry.registerArmor();
			Registry.registerMonsters();
			Registry.registerWeapons();
			Registry.registerImageResources();	
			
			this.setSize(defaultWidth,defaultHeight);			
			
			mainMenu = new DefaultMenu();
			shopMenu = new ShopWindow();
			fightLoopMenu = new FightLoopWindow();
			inventoryMenu = new InventoryWindow();
			startMenuWindow = new StartMenuWindow();
		}
		
		Registry.g.setColor(Color.lightGray);
		GraphicsObject.setDimens(getSize().width, getSize().height);
		Registry.g.fillRect(0, 0, width, height);
		
		switch(currMenu){
		case NONE:
			//mainMap.drawObject();
			mainMenu.draw();
			break;
		case START:
			startMenuWindow.draw();
			break;
		case SHOP: 
			if(itemBought){
				for(int i = 0; i < 10; i++){
					InventoryWindow.grid.addEntry(Weapon.allWeapons.get(i));
				}
			}
			itemBought = false;
			shopMenu.draw();
			mainMenu.draw();
			break;
			
		case ADVENTURE: 
			fightLoopMenu.draw();
			mainMenu.draw();
			break;
		case INVENTORY: 
			inventoryMenu.draw();
			mainMenu.draw();
			break;
		}
		
		
		GraphicsObject.checkOnHover(
				(int)(MouseInfo.getPointerInfo().getLocation().x - this.getLocationOnScreen().getX()), 
				(int)(MouseInfo.getPointerInfo().getLocation().y - this.getLocationOnScreen().getY())
		);
	}

	public void mousePressed(MouseEvent evt) {
		super.mousePressed(evt);
		GraphicsObject.checkOnClick(evt.getX(), evt.getY());
	}
	
	public void keyPressed(KeyEvent evt) {}
	public void keyReleased(KeyEvent evt){}
}

/*
 * 	public static void town(String action) {
		if (action.equalsIgnoreCase("Town")) {
			System.out.println("What would you like to do?");
			action = scan.nextLine().toLowerCase();
			
			switch(action){
				case "sell": sell(); break;
				case "buy": buy(); break;
				case "sleep": break; // Restore life 
				case "bank": break; // Tells how much gold they have, maybe offer investments
				case "train": train(); // Increase skills for gold
				case "help": break;  // Print list of commands;
				case "equip": //Equips item out of inventory
			}

		}
	}
	public static void fight(Player a){
		Monster m = Monster.pickMonster(a);
		
		//Random PlayerDamage = new Random();
		//Random MonsterDamage = new Random();		
		
		// fight!!!!!
		while (m.health > 0 && a.hp > 0) {
			// Calculate attack of Monster and Player, and deduct HP from both
		}

		if (m.health <= 0) {
			// You win:
			// Give gold and XP
			
		} else if (a.hp <= 0) {
			// You lose the game
		}
		
	}
	private static void sell(){
		//sell stuff from inventory
	}
	private static void train() {
		// improves skills
	}

	private static void buy() {
		String type = scan.nextLine();
		if (type.equalsIgnoreCase("Weapons")) {
			// buy weapons
			// check if have enough gold
			// add to inventory
		} else if (type.equalsIgnoreCase("Armor")) {
			// buy armor
			// check if have enough gold
			// add to inventory
		}
	}
}
 */



