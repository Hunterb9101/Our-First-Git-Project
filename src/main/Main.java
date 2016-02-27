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
import windows.*;

//need for music and sound

public class Main extends ConstructorClass {
	public static enum menuItem{NONE,SHOP,ADVENTURE,INVENTORY};
	public static menuItem currMenu = menuItem.NONE;
	
	public static boolean isFirstFrame = true;
	public Random rand = new Random();
	
	// ********Global Variables
	int defaultWidth = 600;
	int defaultHeight = 600;

	public void doInitialization(int width, int height) {
		Registry.initHelper();//initalizes the Helper(), so Runtime is started.
		Registry.registerImageResources();
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
		
		switch(currMenu){
			case NONE:
				new DefaultMenu().draw(g);
			case SHOP:
				new ShopWindow().draw(g);
			case ADVENTURE:
				new FightLoopWindow().draw(g);
			case INVENTORY:
				new InventoryWindow().draw(g);
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



