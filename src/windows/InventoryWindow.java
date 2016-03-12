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
	public static GraphicsGrid grid = new GraphicsGrid(50, 105, 5, 5, thisMenu);
	//GraphicsGridEntry flag = new GraphicsGridEntry(Registry.imgRes.get("Flag"), 400, 100, "Test", grid);//test inventory
	//GraphicsGridEntry flag2 = new GraphicsGridEntry(Registry.imgRes.get("Flag2"), 455, 100, "Better Flag E!", grid);
	
	@Override
	public void draw() {
		grid.drawObject();
		//flag.drawObject();
		//flag2.drawObject();
	}
}
