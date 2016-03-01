package windows;

import java.awt.Color;
import java.awt.Graphics;

import org.omg.Messaging.SyncScopeHelper;

import graphics.*;
import main.Main;
import main.Registry;

public class InventoryWindow extends WindowItem {
	GraphicsImage inventory = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),200,0,200,50){
		@Override 
		public void onClick(){
			System.out.println("This is the inventory!");
			Main.currMenu = menuItem.NONE;
		}
		
		@Override
		public void onHover(){
			System.out.println("Hovering over the Inventory!");
		}
	};
	GraphicsGrid grid = new GraphicsGrid(50, 70, 500, 500);
	GraphicsInventory flag = new GraphicsInventory(Registry.imgRes.get("Flag"), 400, 100, 90, 90, "Test");//test inventory
	GraphicsInventory flag2 = new GraphicsInventory(Registry.imgRes.get("Flag2"), 455, 100, 90, 90, "Better Flag E!");
	GraphicsPrimitives bg = new GraphicsPrimitives(Color.BLACK,0,0,600,55);
	GraphicsPrimitives bgLine1 = new GraphicsPrimitives(new Color(124,29,29),0,52,600,2);
	GraphicsPrimitives bgLine2 = new GraphicsPrimitives(new Color(124,29,29),0, 55, 600, 2);
	
	@Override
	public void draw() {
		grid.items.add(flag);
		grid.items.add(flag2);
		grid.drawObject();				
		flag.drawObject();
		flag2.drawObject();
	}
}
