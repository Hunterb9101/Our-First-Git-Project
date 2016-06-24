package windows;

import java.awt.Graphics;

import graphics.GraphicsImage;
import main.Main;
import main.Registry;

public class MainWindow extends WindowItem {
	protected menuItem thisMenu = menuItem.MAIN;
	public int currZoneSelected = -1;
	
	GraphicsImage mainMap = new GraphicsImage(Registry.loadImage("res/resMaps/MainMap.png"),25,50,550,550, thisMenu);
	
	GraphicsImage mapIcon = new GraphicsImage(Registry.loadImage("res/resMaps/MapIcon.png"),390,380,32,32, thisMenu){
		@Override
		public void onClick(){
			Main.currMenu = menuItem.REGION;
		}
	};
	GraphicsImage mapIcon2 = new GraphicsImage(Registry.loadImage("res/resMaps/DisabledMapIcon.png"),280,350,32,32, thisMenu){
		@Override
		public void onClick(){
			Main.currMenu = menuItem.REGION;
		}
	};
	
	GraphicsImage mapIcon3 = new GraphicsImage(Registry.loadImage("res/resMaps/DisabledMapIcon.png"),160,460,32,32, thisMenu);
	GraphicsImage mapIcon4 = new GraphicsImage(Registry.loadImage("res/resMaps/DisabledMapIcon.png"),100,210,32,32, thisMenu);
	GraphicsImage mapIcon5 = new GraphicsImage(Registry.loadImage("res/resMaps/DisabledMapIcon.png"),270,180,32,32, thisMenu);
	GraphicsImage mapIcon6 = new GraphicsImage(Registry.loadImage("res/resMaps/DisabledmapIcon.png"),470,120,32,32, thisMenu);
	
	@Override
	public void draw() {
		mainMap.drawObject();
		mapIcon.drawObject();
		mapIcon2.drawObject();
		mapIcon3.drawObject();
		mapIcon4.drawObject();
		mapIcon5.drawObject();
		mapIcon6.drawObject();
	}

}
