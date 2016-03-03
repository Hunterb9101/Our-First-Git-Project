package graphics;

import java.awt.Color;
import java.awt.Image;
import main.Armor;
import main.InventoryItem;
import main.Registry;
import main.Weapon;

public class GraphicsGridEntry extends GraphicsObject{
	public Image src;
	public String text;
	public InventoryItem i;
	
	private HoverBox descrip;
	public GraphicsGridEntry(Image iSrc,int iX, int iY, String iText, GraphicsGrid parent){
		//SHOULD NEVER BE CALLED EXCEPT BY GRAPHICS GRID
		super(iX, iY, parent.itemWidth, parent.itemHeight);
		src = iSrc;
		text = iText;
		descrip = new HoverBox(iX, iY, text);
	}
	
	public GraphicsGridEntry(int iX, int iY, Weapon w, GraphicsGrid parent){
		//SHOULD NEVER BE CALLED EXCEPT BY GRAPHICS GRID
		super(iX, iY, parent.itemWidth, parent.itemHeight);
		src = w.src;
		text = w.parseText();
		descrip = new HoverBox(iX, iY, text);
	}
	
	public GraphicsGridEntry(int iX, int iY, Armor a, GraphicsGrid parent){
		//SHOULD NEVER BE CALLED EXCEPT BY GRAPHICS GRID
		super(iX, iY, parent.itemWidth, parent.itemHeight);
		src = a.src;
		text = a.parseText();
		descrip = new HoverBox(iX, iY, text);
	}
	
	public void drawObject(){
		//SHOULD NEVER BE CALLED EXCEPT BY GRAPHICS GRID
		Registry.g.drawImage(src,(int)(x*xScalar),(int)(y*yScalar),(int)(width*xScalar),(int)(height*yScalar),null);
		Registry.g.setColor(Color.black);
		Registry.g.drawRect(x, y, width, height);//adds outline to the image
	}
	
	public void onClick(){
		//equip
	}
	public void onHover(){
		descrip.drawObject(); //Show Hover Box
	}


}