package windows;

import java.awt.Color;
import java.awt.Graphics;

import graphics.GraphicsImage;
import graphics.GraphicsInventory;
import graphics.GraphicsPrimitives;
import main.Main;
import main.Registry;

public class DefaultMenu extends WindowItem {
	GraphicsImage shop = new GraphicsImage(Registry.imgRes.get("ShopMenu"),0,0,200,50){
		@Override 
		public void onClick(){
			System.out.println("This is the Shop!");
		}
		
		@Override
		public void onHover(){
			System.out.println("Hovering over the Shop!");
		}
	};
	GraphicsImage adventure = new GraphicsImage(Registry.imgRes.get("FightLoopMenu"),200,0,200,50);
	GraphicsImage inventory = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),400,0,200,50){
		@Override 
		public void onClick(){
			System.out.println("This is the inventory!");
			Main.currMenu = menuItem.INVENTORY;
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
	public void draw(Graphics g) {
		bg.drawObject(g);
		bgLine1.drawObject(g);
		bgLine2.drawObject(g);
		flag.drawObject(g);
		shop.drawObject(g);
		inventory.drawObject(g);
		adventure.drawObject(g);	
	}

}
