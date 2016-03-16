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
	public static enum menuItem{NONE,SHOP,ADVENTURE,INVENTORY,START,DEFAULT};
	public static menuItem currMenu = menuItem.NONE;
	public static Player me = new Player(traits.NONE);
	private static boolean isFirstFrame = true;
	
	public Random rand = new Random();
	
	boolean itemBought = true;//will be deleted once shop is made
	
	int defaultWidth = 600;
	int defaultHeight = 600;

	GraphicsImage mainMap = new GraphicsImage(Registry.loadImage("res/MainMap.png"),25,50,550,550, menuItem.NONE);
	StartMenuWindow startMenu;
	DefaultMenu mainMenu;
	ShopWindow shopMenu;
	FightLoopWindow fightLoopMenu;
	InventoryWindow inventoryMenu;

	public void doInitialization(int width, int height) {	
		Registry.initHelper(); //Initializes the Helper(), so Runtime is started.
		Registry.registerArmor();
		Registry.registerMonsters();
		Registry.registerWeapons();
		Registry.registerImageResources();	
		
		this.setSize(defaultWidth,defaultHeight);			
		
		startMenu = new StartMenuWindow();
		mainMenu = new DefaultMenu();
		shopMenu = new ShopWindow();
		fightLoopMenu = new FightLoopWindow();
		inventoryMenu = new InventoryWindow();
	}

	// All drawing is done here //
	synchronized public void drawFrame(Graphics g, int width, int height) {
		Registry.g = g;
		
		Registry.g.setColor(Color.lightGray);
		GraphicsObject.setDimens(getSize().width, getSize().height);
		Registry.g.fillRect(0, 0, width, height);
		
		switch(currMenu){
		case NONE:
			mainMap.drawObject();
			break;
		case START:
			startMenu.draw();
			break;
		case SHOP: 
			if(itemBought){
				for(int i = 0; i < 10; i++){
					InventoryWindow.grid.addEntry(Weapon.allWeapons.get(i));
				}
			}
			itemBought = false;
			shopMenu.draw();
			break;
			
		case ADVENTURE: 
			fightLoopMenu.draw();
			break;
		case INVENTORY: 
			inventoryMenu.draw();
			break;
		}
		
		mainMenu.draw();
		
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



