package windows;

import java.awt.Color;

import graphics.GraphicsImage;
import main.Registry;

public class StartWindowMenu extends WindowItem {
	GraphicsImage startMenu = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),200,0,200,50);

	@Override
	public void draw() {
		startMenu.drawObject();
		// TODO Auto-generated method stub
		
	}
}