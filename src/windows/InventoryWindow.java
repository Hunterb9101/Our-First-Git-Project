package windows;

import java.awt.Graphics;

import graphics.GraphicsInventory;
import main.Registry;

public class InventoryWindow extends WindowItem {
	
	@Override
	public void draw(Graphics g) {
		GraphicsInventory flag = new GraphicsInventory(Registry.imgRes.get("Flag"), 400, 100, 50, 50, "Test");//test inventory
		GraphicsInventory flag2 = new GraphicsInventory(Registry.imgRes.get("Flag2"), 455, 100, 50, 50, "Better Flag E!");
		
		flag.drawObject(g);
		flag2.drawObject(g);
	}

}
