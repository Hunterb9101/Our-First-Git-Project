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
	public static enum menuItem{NONE,STARTMENU,SHOP,ADVENTURE,INVENTORY};
	public static menuItem currMenu = menuItem.STARTMENU;
	public static Player me = new Player(traits.NONE);
	private static boolean isFirstFrame = true;
	
	public Random rand = new Random();
	
	int defaultWidth = 600;
	int defaultHeight = 600;

	GraphicsImage mainMap = new GraphicsImage(Registry.loadImage("res/MainMap.png"),25,50,550,550);
	DefaultMenu mainMenu;
	ShopWindow shopMenu;
	FightLoopWindow fightLoopMenu;
	InventoryWindow inventoryMenu;
	StartMenuWindow startMenu;
	GraphicsGrid gridTest;
	
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
			
			gridTest = new GraphicsGrid(60,60,5,5);
			me.items.add(Weapon.allWeapons.get(0));
			me.items.add(Armor.allArmor.get(1));
			me.items.add(Weapon.allWeapons.get(2));
			me.items.add(Weapon.allWeapons.get(3));
			me.items.add(Weapon.allWeapons.get(4));
			me.items.add(Weapon.allWeapons.get(5));
			me.items.add(Weapon.allWeapons.get(6));
			me.items.add(Weapon.allWeapons.get(7));
			
			me.compileInventory(gridTest);
			
			mainMenu = new DefaultMenu();
			shopMenu = new ShopWindow();
			fightLoopMenu = new FightLoopWindow();
			inventoryMenu = new InventoryWindow();
			startMenu = new StartMenuWindow();
		}
		
		Registry.g.setColor(Color.lightGray);
		GraphicsObject.setDimens(getSize().width, getSize().height);
		Registry.g.fillRect(0, 0, width, height);
		
		switch(currMenu){
		case NONE:
			mainMenu.draw();
			gridTest.drawObject();
			//mainMap.drawObject();
			break;
			
		case STARTMENU:
			startMenu.draw();
			break;
			
		case SHOP: 
			mainMenu.draw();
			shopMenu.draw();
			break;
			
		case ADVENTURE: 
			mainMenu.draw();
			fightLoopMenu.draw();
			break;
		case INVENTORY: 
			mainMenu.draw();
			inventoryMenu.draw();
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



