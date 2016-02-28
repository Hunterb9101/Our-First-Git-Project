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
			Main.currMenu = Main.menuItem.SHOP;
		}
		
		@Override public void onHover(){}
	};
	
	GraphicsImage adventure = new GraphicsImage(Registry.imgRes.get("FightLoopMenu"),200,0,200,50){
		@Override
		public void onClick(){
			Main.currMenu = Main.menuItem.ADVENTURE;
		}
	};
	
	GraphicsImage inventory = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),400,0,200,50){
		@Override
		public void onClick(){
			Main.currMenu = Main.menuItem.INVENTORY;
		}
	};
	
	GraphicsPrimitives bg = new GraphicsPrimitives(Color.BLACK,0,0,600,55);
	GraphicsPrimitives bgLine1 = new GraphicsPrimitives(new Color(124,29,29),0,52,600,2);
	GraphicsPrimitives bgLine2 = new GraphicsPrimitives(new Color(124,29,29),0, 55, 600, 2);
	
	@Override
	public void draw(Graphics g) {
		bg.drawObject(g);
		bgLine1.drawObject(g);
		bgLine2.drawObject(g);
		shop.drawObject(g);
		inventory.drawObject(g);
		adventure.drawObject(g);	
	}

}
