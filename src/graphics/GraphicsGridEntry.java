package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
		super(iX,iY,parent.gridSizeX,parent.gridSizeY);
		src = iSrc;
		text = iText;
		descrip = new HoverBox(iX, iY, text);
	}
	
	public GraphicsGridEntry(Image iSrc,int iX, int iY, Weapon w, GraphicsGrid parent){
		super(iX,iY,parent.gridSizeX,parent.gridSizeY);
		src = iSrc;
		text = w.parseText();
		descrip = new HoverBox(iX, iY, text);
	}
	
	public GraphicsGridEntry(Image iSrc,int iX, int iY, Armor a, GraphicsGrid parent){
		super(iX,iY,parent.gridSizeX,parent.gridSizeY);
		src = iSrc;
		text = a.parseText();
		descrip = new HoverBox(iX, iY, text);
	}
	
	public GraphicsGridEntry(InventoryItem i, GraphicsGrid parent){
		super(0,0,parent.gridSizeX,parent.gridSizeY);
		this.i = i;
	}
	
	public GraphicsGridEntry(GraphicsGrid parent){
		super(0,0,parent.gridSizeX,parent.gridSizeY);
		this.i = null;
	}
	
	public void drawObject(){
		Registry.g.drawImage(src,(int)(x*xScalar),(int)(y*yScalar),(int)(width*xScalar),(int)(height*yScalar),null);
	}
	
	public void onClick(){
		//equip
	}
	public void onHover(){
		descrip.drawObject(); //Show Hover Box
	}


}
