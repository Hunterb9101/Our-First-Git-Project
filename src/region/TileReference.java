package region;

import java.util.ArrayList;
import java.util.Arrays;

public class TileReference {
	public static ArrayList<TileReference> allTiles = new ArrayList<TileReference>();
	
	public Tile parent;
	public static Tile parentSelected = new Tile("selectedTile.png","dirtSide.png");
	
	public int[] coords;
	public int height;
	
	int[] xPoints;
	int[] yPoints;
	public Overlay overlay;
	
	public boolean selected = false;
	
	public TileReference(Tile parent, Overlay overlay, int height, int[] coords){
		this.parent = parent;
		this.overlay = overlay;
		this.height = height;
		this.coords = coords;
		xPoints = Tile.coords2Points(coords[0],coords[1],"x");
		yPoints = RegionUtils.addToArray(Tile.coords2Points(coords[0],coords[1],"y"), -height*Tile.pxHeight);
		
		boolean add = true;
		for(int i = 0; i<TileReference.allTiles.size(); i++){
			if(Arrays.equals(this.coords, TileReference.allTiles.get(i).coords)){
				add=false;
			}
		}
		
		if(add){
			allTiles.add(this);
		}
	}
	
	
}
