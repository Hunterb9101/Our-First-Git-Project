package windows;

import java.awt.Color;
import java.awt.Graphics;

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
	
	GraphicsInventory flag = new GraphicsInventory(Registry.imgRes.get("Flag"), 400, 100, 50, 50, "Test");//test inventory
	
	GraphicsPrimitives bg = new GraphicsPrimitives(Color.BLACK,0,0,600,55);
	GraphicsPrimitives bgLine1 = new GraphicsPrimitives(new Color(124,29,29),0,52,600,2);
	GraphicsPrimitives bgLine2 = new GraphicsPrimitives(new Color(124,29,29),0, 55, 600, 2);
	
	@Override
	public void draw() {
		GraphicsInventory flag = new GraphicsInventory(Registry.imgRes.get("Flag"), 400, 100, 50, 50, "Test");//test inventory
		GraphicsInventory flag2 = new GraphicsInventory(Registry.imgRes.get("Flag2"), 455, 100, 50, 50, "Better Flag E!");
		
		flag.drawObject();
		flag2.drawObject();
	}
}
