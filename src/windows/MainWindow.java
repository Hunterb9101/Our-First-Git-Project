package windows;

import java.awt.Graphics;

import graphics.GraphicsImage;
import main.Registry;

public class MainWindow extends WindowItem {
	GraphicsImage mainMap = new GraphicsImage(Registry.loadImage("res/MainMap.png"),25,50,550,550);
	GraphicsImage mapIcon = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),390,380,32,32);
	GraphicsImage mapIcon2 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),280,350,32,32);
	GraphicsImage mapIcon3 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),160,460,32,32);
	GraphicsImage mapIcon4 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),100,210,32,32);
	GraphicsImage mapIcon5 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),270,180,32,32);
	GraphicsImage mapIcon6 = new GraphicsImage(Registry.loadImage("res/mapIcon.png"),470,120,32,32);
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		mainMap.drawObject();
		mapIcon.drawObject();
		mapIcon2.drawObject();
		mapIcon3.drawObject();
		mapIcon4.drawObject();
		mapIcon5.drawObject();
		mapIcon6.drawObject();
	}

}
