package windows;

import java.awt.Color;

import graphics.GraphicsImage;
import main.Registry;

public class StartWindowMenu extends WindowItem {

	GraphicsImage title = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),100,0,400,100); // GraphicsImage(Image source, Int X, Int Y, Int Width, Int Height);

	GraphicsImage loadGame = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),200,175,200,50);

	GraphicsImage newGame = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),200,250,200,50);

	GraphicsImage credits = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),200,325,200,50);
	
	GraphicsImage exit = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),200,400,200,50);
	@Override
	public void draw() {
		title.drawObject();
		loadGame.drawObject();
		newGame.drawObject();
		credits.drawObject();
		exit.drawObject();
		// TODO Auto-generated method stub
		
	}
}