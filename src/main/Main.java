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

import graphics.*;
import main.Player.traits;
import windows.*;

//need for music and sound

public class Main extends ConstructorClass {
	public static enum menuItem{NONE,START, DEFAULT, SHOP,ADVENTURE,INVENTORY, DELETE};
	public static menuItem currMenu = menuItem.START;
	public static Player me = new Player(traits.NONE);
	private static boolean isFirstFrame = true;
	
	public Random rand = new Random();
	
	boolean itemBought = true;//will be deleted once shop is made
	
	int defaultWidth = 600;
	int defaultHeight = 600;

	MainWindow mainWindow;
	DefaultMenu mainMenu;
	ShopWindow shopMenu;
	FightLoopWindow fightLoopMenu;
	InventoryWindow inventoryMenu;
	StartMenuWindow startMenuWindow;

	public void doInitialization(int width, int height) {	
		System.out.println("Doing initialization");
		Registry.initHelper(); //Initializes the Helper(), so Runtime is started.
		Registry.registerArmor();
		Registry.registerMonsters();
		Registry.registerWeapons();
		Registry.registerImageResources();	
		
		this.setSize(defaultWidth,defaultHeight);			
		
		mainMenu = new DefaultMenu();
		mainWindow = new MainWindow();
		shopMenu = new ShopWindow();
		fightLoopMenu = new FightLoopWindow();
		inventoryMenu = new InventoryWindow();
		startMenuWindow = new StartMenuWindow();
	}

	// All drawing is done here //
	synchronized public void drawFrame(Graphics g, int width, int height) {
		Registry.g = g;
		
		Registry.g.setColor(Color.lightGray);
		GraphicsObject.setDimens(getSize().width, getSize().height);
		Registry.g.fillRect(0, 0, width, height);
		
		switch(currMenu){
		case NONE:
			mainWindow.draw();
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
				InventoryWindow.grid.removeEntry(Weapon.allWeapons.get(2));
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



