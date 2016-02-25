package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GraphicsImage extends GraphicsObject{
	public Image src;
	
	public GraphicsImage(Image iSrc,int iX, int iY, int iWidth, int iHeight){
		super(iX,iY,iWidth,iHeight);
		src = iSrc;
	}
	
	public void drawObject(Graphics g){
		g.drawImage(src,(int)(x*xScalar),(int)(y*yScalar),(int)(width*xScalar),(int)(height*yScalar),null);
	}
	
	public void onClick(){}
	public void onHover(){}
}
