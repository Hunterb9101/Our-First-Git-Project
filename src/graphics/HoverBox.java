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
	public HoverBox(int iX, int iY, int iHeight, String iText){
		text = iText;
		x = iX;
		y = iY;
		width = iText.length() * 20;
		height = iHeight;
	}
	public void drawObject(Graphics g) {
		System.out.println("Hover box drawing");
		g.setColor(Color.blue);
		g.drawRect(x, y, width, height);
		g.drawString(text, x + 5, y + 28);
	}

}
