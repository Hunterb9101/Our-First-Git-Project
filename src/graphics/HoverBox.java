package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class HoverBox{
	Image src;
	String text;
	int x;
	int y;
	int width;
	int height;
	public HoverBox(int iX, int iY, int iWidth, int iHeight, String iText){
		text = iText;
		x = iX;
		y = iY;
		width = iWidth;
		height = iHeight;
	}
	public void drawObject(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(x, y, width, height);
		g.drawString(text, x + 5, y - 5);
	}

}
