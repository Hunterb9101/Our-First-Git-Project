package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GraphicsImage extends GraphicsObject{
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
	
	public void onClick(){
		System.out.println("clicked");
	}
	public void onHover(){
		System.out.println("hovered");
	}
}
