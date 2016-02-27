package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import main.Armor;
import main.Registry;
import main.Weapon;

public class GraphicsInventory extends GraphicsObject{
	public Image src;
	public String text;
	private HoverBox descrip;
	private Graphics graphics;
	private boolean draw;
	public GraphicsInventory(Image iSrc,int iX, int iY, int iWidth, int iHeight, String iText){
		super(iX,iY,iWidth,iHeight);
		src = iSrc;
		text = iText;
		descrip = new HoverBox(iX, iY - iHeight + 5, iHeight, text);
	}
	public GraphicsInventory(Image iSrc,int iX, int iY, int iWidth, int iHeight, Weapon w){
		super(iX,iY,iWidth,iHeight);
		src = iSrc;
		text = w.parseText();
		descrip = new HoverBox(iX, iY - iHeight + 5, iHeight, text);
	}
	public GraphicsInventory(Image iSrc,int iX, int iY, int iWidth, int iHeight, Armor a){
		super(iX,iY,iWidth,iHeight);
		src = iSrc;
		text = a.parseText();
		descrip = new HoverBox(iX, iY - iHeight + 5, iHeight, text);
	}
	public void drawObject(Graphics g){
		graphics = g;
		graphics.drawImage(src,(int)(x*xScalar),(int)(y*yScalar),(int)(width*xScalar),(int)(height*yScalar),null);
		System.out.println(draw);
		System.out.println("Drawing by hand");
		if(draw){
			
		}		
		//draw = false;
	}	
	public void onClick(){
		//equip
	}
	public void onHover(){
		//show box
		draw = true;
		System.out.println("Hovering over an inventory " + draw);
		descrip.drawObject(graphics);
		//
	}


}
