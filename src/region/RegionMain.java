package region;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import graphics.ConstructorClass;
import main.Main;
import main.Main.menuItem;
import windows.WindowItem;

public class RegionMain extends ConstructorClass{
	protected menuItem thisMenu = menuItem.REGION;
	public static String graphicsPath = "regionResources/";
	
	/* Tiles */
	Tile grass = new Tile("grassTile.png","dirtSide.png");
	Tile farmland = new Tile("farmTile.png","dirtSide.png");
	Tile dirt = new Tile("dirtTile.png","dirtSide.png");
	
	Overlay house = new Overlay("houseOverlay.png");
	Overlay fence = new Overlay("fenceOverlay.png");
	
	static String[] CompressedMap = parseMap("maps/CompressedMap1");
	static String   HeightMap     = parseHeightMap("maps/CompressedMap1");
	static String   OverlayMap    = parseOverlayMap("maps/CompressedMap1");
	
	public static int rowLen; //Value assigned in parseMap
	
	// The original offsets of board
	public static final int origYOffset = 64;
	public static final int origXOffset = 0;
	
	public static int yOffset = origYOffset;
	public static int xOffset = origXOffset;
	
	public static boolean first = true;
		
	public static int[] selected = new int[]{0,0};
	public static int scrollSpeed = 4; //Speed at which keys move the screen around
	
	static String[] defaultMap = CompressedMap; //Change to create a new map
	static String defaultHMap = HeightMap; // Change to create a new map
	static String defaultOMap = OverlayMap; 
	
	static HashMap<String,Tile> mapKey = new HashMap<String,Tile>();	
	static HashMap<String,Overlay> overlayKey = new HashMap<String,Overlay>();
	static HashMap<String,Image> images = new HashMap<String,Image>();
	
	public void init(int width, int height) {	
		File folder = new File(graphicsPath);
		File[] allResources = folder.listFiles();
		for(int i = 0; i<allResources.length; i++){
			images.put(allResources[i].getName(), RegionUtils.loadImage(graphicsPath + allResources[i].getName()));
		}
		
		/* Key for the map */
		mapKey.put("0", grass);
			grass.borderColor = RegionUtils.darkGreen;
		mapKey.put("1", dirt);
			dirt.borderColor = RegionUtils.brown;
		mapKey.put("2", farmland);
			farmland.borderColor = RegionUtils.brown;
			
		/* Overlay Key */
		overlayKey.put("0", null);
		overlayKey.put("1", house);
		overlayKey.put("2", fence);
		this.setSize(640,640);
	}
	
	public static String[] parseMap(String filePath){
		File f = new File(filePath);
		List<String> rawData = RegionUtils.ReadFile(f);
		
		String raw = "";
		
		for(int i = 0; i<rawData.size(); i++){
			if(!rawData.get(i).equalsIgnoreCase("#")){
				raw+=rawData.get(i);
			}
			else{
				break;
			}
		}

		ArrayList<String> data = new ArrayList<String>();
		int tileShift = 0;
		rowLen = Integer.parseInt(raw.split("x")[0]);
		raw = raw.split("x")[1];
		while(raw.length() > 0){
			data.add(raw.substring(0,rowLen+tileShift));
			raw = raw.substring(rowLen + tileShift);
			tileShift = (tileShift==1) ? 0:1;
		}
		
		return (String[]) data.toArray(new String[0]);
	}
	
	public static String parseHeightMap(String filePath){
		File f = new File(filePath);
		List<String> rawData = RegionUtils.ReadFile(f);
		
		String hMap = "";
		int startIdx = rawData.indexOf("#");
		for(int i = startIdx+1; i<rawData.size(); i++){
				hMap+=rawData.get(i);
		}
		return hMap;
	}
	
	public static String parseOverlayMap(String filePath){
		File f = new File(filePath);
		List<String> rawData = RegionUtils.ReadFile(f);
		
		String oMap = "";
		for(int i = 0; i<rawData.size(); i++){
				oMap+=rawData.get(i);
		}
		oMap = oMap.split("#")[2];
		return oMap;
	}
	
	public static void parseMap(Graphics g, int width, int height){
		int[] xPoints = {-Tile.tileSize/2,0,Tile.tileSize/2,};
		int[] yPoints = {0,-Tile.tileSize/2,0,Tile.tileSize/2};
		
		int tileShift = 0; //With a diamond shaped pattern, 1 extra is needed per row, this keeps track.
		int cntr = 0; //Not for a 'for' loop for once!!!
				
		for(int y = 0; y<defaultMap.length; y++){
			for(int x=0; x<defaultMap[0].length() + tileShift; x++){
				/* Shift Every Other Tile Row */
				for(int i = 0; i<xPoints.length;i++){
					if((x==0)&& tileShift==1){ xPoints[i] += Tile.tileSize/2;}
					else{ xPoints[i] += Tile.tileSize;}
				}
				
				Tile thisTile = ((Tile)mapKey.get(defaultMap[y].substring(x,x+1)));
				thisTile.drawTile(g, Integer.parseInt(defaultHMap.substring(cntr,cntr+1)), new int[]{x,y}, thisTile, overlayKey.get(defaultOMap.substring(cntr,cntr+1)), "");
				cntr++;
			}
			
			int[] xDefaultPoints = {-Tile.tileSize/2,0,Tile.tileSize/2,0};
			xPoints = xDefaultPoints; //Resets X values to normal
			tileShift = (tileShift==1) ? 0:1; //Invert Tile shift
			
			yPoints = RegionUtils.addToArray(yPoints,Tile.tileSize/2);
		}
	}
	
	public static void fastDrawMap(Graphics g, int width, int height){
		for(int i = 0; i<TileReference.allTiles.size(); i++){
			TileReference thisTile = TileReference.allTiles.get(i);
			if(thisTile.selected){
				thisTile.parent.drawTile(g, thisTile.height, TileReference.allTiles.get(i).coords, TileReference.parentSelected, thisTile.overlay, "");
			}
			else{
				thisTile.parent.drawTile(g, thisTile.height, TileReference.allTiles.get(i).coords, thisTile.parent, thisTile.overlay, "");
			}
		}
	}
	
	public void draw(Graphics g, int width, int height) {
		if(first){
			parseMap(g,width,height);
			first = false;
		}
		
		g.setColor(new Color(0,198,255));
		g.fillRect(0, 0, width, height);
		fastDrawMap(g,width,height);
	}

	public void mousePressed(MouseEvent evt) {
		super.mousePressed(evt);	
	}
	
	public void keyReleased(KeyEvent evt){}
}
