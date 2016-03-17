package windows;

import java.awt.Color;
import java.awt.Graphics;

import org.omg.Messaging.SyncScopeHelper;

import graphics.*;
import main.Main;
import main.Registry;
import main.Main.menuItem;

public class InventoryWindow extends WindowItem {
	private static menuItem thisMenu = menuItem.INVENTORY;
	public static GraphicsGrid grid = new GraphicsGrid(120, 105, 5, 5, 90, thisMenu);
	GraphicsGrid equiped = new GraphicsGrid(30, 145, 1, 6, 60, thisMenu);
	
	@Override
	public void draw() {
		equiped.drawObject();
		grid.drawObject();
		//flag.drawObject();
		//flag2.drawObject();
	}
}
