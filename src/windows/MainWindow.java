package windows;

import java.awt.Graphics;

import graphics.GraphicsImage;
import main.Registry;

public class MainWindow extends WindowItem {
	private static  menuItem thisMenu = menuItem.NONE;
	GraphicsImage mainMap = new GraphicsImage(Registry.loadImage("res/MainMap.png"),25,50,550,550, thisMenu);
	GraphicsImage mapIcon = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),390,380,32,32, thisMenu);
	GraphicsImage mapIcon2 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),280,350,32,32, thisMenu);
	GraphicsImage mapIcon3 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),160,460,32,32, thisMenu);
	GraphicsImage mapIcon4 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),100,210,32,32, thisMenu);
	GraphicsImage mapIcon5 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),270,180,32,32, thisMenu);
	GraphicsImage mapIcon6 = new GraphicsImage(Registry.loadImage("res/mapIcon.png"),470,120,32,32, thisMenu);
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
