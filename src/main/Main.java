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
import region.RegionMain;
import region.Tile;
import region.TileReference;
import windows.*;

//need for music and sound

public class Main extends ConstructorClass {
	public static enum menuItem{NONE, MAIN, START, SHOP, REGION, INVENTORY,DELETE};
	public static menuItem currMenu = menuItem.START;
	public static Player me = new Player(traits.NONE);
	private static boolean isFirstFrame = true;
	
	public Random rand = new Random();
	
	int defaultWidth = 600;
	int defaultHeight = 600;

	MainWindow mainWindow;
	DefaultMenu mainMenu;
	ShopWindow shopMenu;
	FightLoopWindow fightLoopMenu;
	InventoryWindow inventoryMenu;
	StartMenuWindow startMenuWindow;
	RegionMain regionWindow;
	
	GraphicsImage mapImage;
	
	public void init(int width, int height) {	
		System.out.println("Doing initialization");
		Registry.initHelper(); //Initializes the Helper(), so Runtime is started.
		Registry.registerRegions();
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
		regionWindow = new RegionMain();
		mapImage = new GraphicsImage(Registry.imgRes.get("mainMapMonochromatic"),0,0,600,600,menuItem.NONE);
		regionWindow.init(width,height);
		
		for(int i = 0; i < 10; i++){
			InventoryWindow.grid.addEntry(Weapon.allWeapons.get(i));
		}
		InventoryWindow.grid.removeEntry(Weapon.allWeapons.get(2));
	}

	// All drawing is done here //
	synchronized public void draw(Graphics g, int width, int height) {
		Registry.g = g;	
		Registry.g.setColor(Color.lightGray);
		GraphicsObject.setDimens(getSize().width, getSize().height);
		Registry.g.fillRect(0, 0, width, height);
		
		switch(currMenu){	
		case MAIN: // Campaign Window
			mainWindow.draw();
			mainMenu.draw();
			break;
			
		case START: // Start Menu
			mapImage.drawObject();
			Registry.g.setColor(new Color(234,208,0,192));
			Registry.g.fillRect(0, 0, width, height);
			startMenuWindow.draw();
			break;
			
		case SHOP: // Shop Menu
			shopMenu.draw();
			mainMenu.draw();
			break;
		
		case REGION:
			regionWindow.draw(g,width,height);
			break;
			
		case INVENTORY: 
			inventoryMenu.draw();
			mainMenu.draw();
			break;
			
		default:
			break;
		}
		
		// Checks Stretchable Object Hovering
		GraphicsObject.checkOnHover(
				(int)(MouseInfo.getPointerInfo().getLocation().x - this.getLocationOnScreen().getX()), 
				(int)(MouseInfo.getPointerInfo().getLocation().y - this.getLocationOnScreen().getY())
		);
	}

	public void mousePressed(MouseEvent evt) {
		super.mousePressed(evt);
		GraphicsObject.checkOnClick(evt.getX(), evt.getY()); // Checks if Stretchable Graphic is Clicked
		
		
		
		// This part is for objects in windows that aren't Graphics Objects
		if(currMenu == menuItem.REGION){
			// Deselect Last Tile //
			try{
				TileReference.allTiles.get(Tile.getIdxNum(RegionMain.selected[0], RegionMain.selected[1], RegionMain.rowLen)).selected = false;
			}catch(NullPointerException e){}catch(IndexOutOfBoundsException e){}
			
			// Select Clicked Tile //
			try{
				RegionMain.selected = Tile.selectTile(evt.getX(), evt.getY());
				TileReference.allTiles.get(Tile.getIdxNum(RegionMain.selected[0], RegionMain.selected[1], RegionMain.rowLen)).selected = true;
			}catch(NullPointerException e){}
		}
		
	}
	
	public void keyPressed(KeyEvent evt) {
		
		//The different buttons in an interface.
		switch(currMenu){
			case REGION:
				switch(evt.getKeyChar()){
					case 'w': RegionMain.yOffset += RegionMain.scrollSpeed; break;
					case 'a': RegionMain.xOffset += RegionMain.scrollSpeed; break;
					case 's': RegionMain.yOffset -= RegionMain.scrollSpeed; break;
					case 'd': RegionMain.xOffset -= RegionMain.scrollSpeed; break;
				}
			break;
			
			default:
				break;
		}
	}
	public void keyReleased(KeyEvent evt){}
}



