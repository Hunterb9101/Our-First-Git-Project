package region;

import java.util.ArrayList;

import windows.MainWindow;
import windows.ShopWindow;

public abstract class RegionAbstract extends MainWindow{
	public static ArrayList<RegionAbstract> allRegions = new ArrayList<RegionAbstract>(); // A list of all regions
	
	public String zoneName = "DEFACTO";
	public int zoneNum = -1; // Zone number for MainWindow
	
	public int lastClearedZone = 0; // Last cleared level in this region	
	private ShopWindow areaShop = new ShopWindow(); //Allows for a unique shop in each of the Regions
	
	public boolean hasSnowfall = false; // A feature to be added for making the Mountain area a little more real
	
	public RegionAbstract(String zoneName, int zoneNum){
		this.zoneName = zoneName;
		for(int i = 0; i<allRegions.size(); i++){
			if(allRegions.get(i).zoneNum == zoneNum){
				throw new RegionAlreadyExistsException();
			}
		}
		allRegions.add(this);
		this.zoneNum = zoneNum;
	}
	
	public abstract void drawRegion();
	
	public void setShop(ShopWindow s){
		areaShop = s;
	}
}
