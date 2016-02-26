package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GraphicsInventory extends GraphicsObject{
	public Image src;
	public String text;
	private HoverBox descrip;
	private Graphics graphics;
	public GraphicsInventory(Image iSrc,int iX, int iY, int iWidth, int iHeight, String iText){
		super(iX,iY,iWidth,iHeight);
		src = iSrc;
		text = iText;
		descrip = new HoverBox(iX, iY + iHeight + 5, iWidth, iHeight, iText);
	}	
	public void drawObject(Graphics g){
		graphics = g;
		g.drawImage(src,(int)(x*xScalar),(int)(y*yScalar),(int)(width*xScalar),(int)(height*yScalar),null);
	}	
	public void onClick(){
		//equip
	}
	public void onHover(){
		//show box
		descrip.drawObject(graphics);
	}
}
