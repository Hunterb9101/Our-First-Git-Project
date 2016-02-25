package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GraphicsImage extends GraphicsObject{
	public String defName = "Shop";
	public Image src;
	
	public boolean freeMotion = true; //Determines whether the object is scalable
	
	public GraphicsImage(Image iSrc,int iX, int iY, int iWidth, int iHeight){
		super(iX,iY,iWidth,iHeight);
		src = iSrc;
	}
	
	public void drawObject(Graphics g, int currWidth, int currHeight){
		double dX = (x*xScalar);
		double dY = (y*yScalar);
		double dW = (width*xScalar);
		double dH = (height*yScalar);
		g.drawImage(src,(int)dX,(int)dY,(int)dW,(int)dH,null);
	}
	
	public void baseOnClick(){
		System.out.println(defName + "clicked on");
	}
	public void baseOnHover(){
		System.out.println(defName + "hovered on.");
	}
}
