package windows;

import java.awt.Graphics;

import graphics.GraphicsImage;
import main.Main;
import main.Registry;

public class MainWindow extends WindowItem {
	private static menuItem thisMenu = menuItem.NONE;
	GraphicsImage mainMap = new GraphicsImage(Registry.loadImage("res/MainMap.png"),25,50,550,550, thisMenu);
	GraphicsImage mapIcon = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),390,380,30,30, thisMenu);
	GraphicsImage mapIcon2 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),270,340,30,30, thisMenu);
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		mainMap.drawObject();
		mapIcon.drawObject();
		mapIcon2.drawObject();
	}

}
