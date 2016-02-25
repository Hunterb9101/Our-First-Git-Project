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

import graphics.ConstructorClass;
import graphics.GraphicsImage;
import graphics.GraphicsLine;
import graphics.GraphicsObject;
import graphics.GraphicsPrimitives;

//need for music and sound

public class Main extends ConstructorClass {
	public static enum menuItem{NONE,SHOP,ADVENTURE,INVENTORY};
	public static menuItem currMenu = menuItem.NONE;
	
	GraphicsObject shop;
	
	Helper h = new Helper();
	public static boolean isFirstFrame = true;
	public Random rand = new Random();
	// ********Global Variables
	int defaultWidth = 600;
	int defaultHeight = 600;

	public void doInitialization(int width, int height) {
		Registry.initHelper();//initalizes the Helper(), so Runtime is started.
		Registry.registerArmor();
		Registry.registerMonsters();
		Registry.registerWeapons();
		
	} // doInitialization

	// All drawing is done here //
	synchronized public void drawFrame(Graphics g, int width, int height) {
		int mouseX = (int) (MouseInfo.getPointerInfo().getLocation().x - this.getLocationOnScreen().getX());
		int mouseY = (int) (MouseInfo.getPointerInfo().getLocation().y - this.getLocationOnScreen().getY());
		
		
		if(isFirstFrame){
			isFirstFrame = false;
			this.setSize(defaultWidth,defaultHeight);
		}
		
		GraphicsObject.setDimens(getSize().width, getSize().height);
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, width, height);
		
		GraphicsObject.checkOnHover(mouseX, mouseY);
		
		// MENU BUTTONS //
		GraphicsImage shop = new GraphicsImage(getImage(getCodeBase(), "res/Shop.png"),0,0,200,50){
			@Override 
			public void onClick(){
				System.out.println("This is the Shop!");
			}
			
			@Override
			public void onHover(){
				System.out.println("Hovering over the Shop!");
				//h.nap(1000);
			}
		};
		
		GraphicsImage adventure = new GraphicsImage(getImage(getCodeBase(), "res/Adventure.png"),200,0,200,50);
		GraphicsImage inventory = new GraphicsImage(getImage(getCodeBase(), "res/Inventory.png"),400,0,200,50);
		
		GraphicsPrimitives bg = new GraphicsPrimitives(Color.BLACK,0,0,600,55);
		GraphicsPrimitives bgLine1 = new GraphicsPrimitives(new Color(124,29,29),0,52,600,2);
		GraphicsPrimitives bgLine2 = new GraphicsPrimitives(new Color(124,29,29),0, 55, 600, 2);
		
		switch(currMenu){
		case NONE:
			bg.drawObject(g);
			bgLine1.drawObject(g);
			bgLine2.drawObject(g);
			
			shop.drawObject(g);
			inventory.drawObject(g);
			adventure.drawObject(g);
			break;
		case SHOP: break;
		case ADVENTURE: break;
		case INVENTORY: break;
		} 
	}

	public void mousePressed(MouseEvent evt) {
		super.mousePressed(evt);
		GraphicsObject.checkOnClick(evt.getX(), evt.getY());
	}

	public void keyPressed(KeyEvent evt) {
	}

	public void keyReleased(KeyEvent evt){
	}

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



