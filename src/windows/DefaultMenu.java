package windows;

import java.awt.Color;
import java.awt.Graphics;

import graphics.GraphicsImage;
import graphics.GraphicsGridEntry;
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
		
		@Override public void onHover(){}
	};
	
	GraphicsImage inventory = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),400,0,200,50){
		@Override
		public void onClick(){
			Main.currMenu = Main.menuItem.INVENTORY;
		}
		
		@Override public void onHover(){}
	};
	
	
	
	GraphicsPrimitives bg = new GraphicsPrimitives(Color.BLACK,0,0,600,55);
	GraphicsPrimitives bgLine1 = new GraphicsPrimitives(new Color(124,29,29),0,52,600,2);
	GraphicsPrimitives bgLine2 = new GraphicsPrimitives(new Color(124,29,29),0, 55, 600, 2);
	
	@Override
	public void draw() {
		bg.drawObject();
		bgLine1.drawObject();
		bgLine2.drawObject();
		shop.drawObject();
		inventory.drawObject();
		adventure.drawObject();	
	}

}
