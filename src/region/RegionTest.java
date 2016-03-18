package region;

import graphics.GraphicsImage;
import main.Registry;

public class RegionTest extends RegionAbstract{
	GraphicsImage zone1Bg = new GraphicsImage(Registry.loadImage("res/MtnBG.png"),0,0,600,600,thisMenu);
	
	public RegionTest(){
		super("Region Test",0);
	}

	@Override
	public void drawRegion() {
		System.out.println("Drawing Region 1");
		zone1Bg.drawObject();
	}
}
