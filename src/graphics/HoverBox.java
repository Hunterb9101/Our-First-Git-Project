package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

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
	
	public void drawObject(Graphics g) {
		g.setFont(f);
		this.width = g.getFontMetrics(f).stringWidth(text);
		this.height = g.getFontMetrics(f).getHeight();
		
		g.setColor(fgColor);
		g.drawRect((int)(xScalar*x),(int)(yScalar*y)+6,(int)(width)+6, (int)(height));
		
		g.setColor(bgColor);
		g.fillRect((int)(xScalar*x),(int)(yScalar*y)+6,(int)(width)+6,(int)(height));
		
		g.setColor(fgColor);
		g.drawString(text,(int)(xScalar*x)+3, (int)(yScalar*(y+height)));
	}

	@Override public void onClick() {}
	@Override public void onHover() {}

}
