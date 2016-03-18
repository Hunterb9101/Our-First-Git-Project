package windows;

import java.awt.Graphics;

import graphics.GraphicsImage;
import main.Registry;
import region.RegionAbstract;

public class MainWindow extends WindowItem {
	private menuItem thisMenu = menuItem.MAIN;
	public int currZoneSelected = 0;
	GraphicsImage mainMap = new GraphicsImage(Registry.loadImage("res/MainMap.png"),25,50,550,550, thisMenu);
	
	GraphicsImage mapIcon = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),390,380,32,32, thisMenu){
		@Override
		public void onClick(){
			currZoneSelected = 1;
		}
	};
	GraphicsImage mapIcon2 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),280,350,32,32, thisMenu){
		@Override
		public void onClick(){
			currZoneSelected = 2;
		}
	};
	
	GraphicsImage mapIcon3 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),160,460,32,32, thisMenu);
	GraphicsImage mapIcon4 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),100,210,32,32, thisMenu);
	GraphicsImage mapIcon5 = new GraphicsImage(Registry.loadImage("res/MapIcon.png"),270,180,32,32, thisMenu);
	GraphicsImage mapIcon6 = new GraphicsImage(Registry.loadImage("res/mapIcon.png"),470,120,32,32, thisMenu);
	
	GraphicsImage zone1Bg = new GraphicsImage(Registry.loadImage("res/MtnBG.png"),0,0,600,600,thisMenu);
	
	@Override
	public void draw() {
		switch(currZoneSelected){
		case 1:
			zone1Bg.drawObject();
			break;
		case 2:
			break;
		default:
			mainMap.drawObject();
			mapIcon.drawObject();
			mapIcon2.drawObject();
			mapIcon3.drawObject();
			mapIcon4.drawObject();
			mapIcon5.drawObject();
			mapIcon6.drawObject();
		}
	}

}
