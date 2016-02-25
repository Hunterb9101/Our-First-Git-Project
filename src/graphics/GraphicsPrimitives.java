package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GraphicsPrimitives extends GraphicsObject{	
	Color c = Color.BLACK;
	
	public GraphicsPrimitives(Color iC,int iX, int iY, int iWidth, int iHeight){
		super(iX,iY,iWidth,iHeight);
		c = iC;
	}
	
	public void drawObject(Graphics g){
		g.setColor(c);
		g.fillRect((int)(x*xScalar),(int)(y*yScalar),(int)(width*xScalar),(int)(height*yScalar));
	}
	
	public void onClick(){}
	public void onHover(){}
}
