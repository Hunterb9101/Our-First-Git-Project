package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import main.Registry;

public class HoverBox extends GraphicsObject{
	Image src;
	String text;
	
	int x;
	int y;
	
	Color bgColor = new Color(0,0,0,128);
	Color fgColor = new Color(255,255,255);
	Font f = new Font("SanSerif", Font.PLAIN, 18);
	
	public HoverBox(int iX, int iY, String iText){
		super(iX,iY,0,0);
		text = iText;
		x = iX;
		y = iY;
	}
	
	public void drawObject() {
		Registry.g.setFont(f);
		this.width = Registry.g.getFontMetrics(f).stringWidth(text);
		this.height = Registry.g.getFontMetrics(f).getHeight();
		
		Registry.g.setColor(fgColor);
		Registry.g.drawRect((int)(xScalar*x),(int)(yScalar*y)+6,(int)(width)+6, (int)(height));
		
		Registry.g.setColor(bgColor);
		Registry.g.fillRect((int)(xScalar*x),(int)(yScalar*y)+6,(int)(width)+6,(int)(height));
		
		Registry.g.setColor(fgColor);
		Registry.g.drawString(text,(int)(xScalar*x)+3, (int)(yScalar*(y+height)));
	}

	@Override
	public void onClick() {
		
	}

	@Override
	public void onHover() {
		
	}


}
