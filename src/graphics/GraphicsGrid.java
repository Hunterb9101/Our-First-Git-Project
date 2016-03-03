package graphics;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import main.Registry;

public class GraphicsGrid extends GraphicsObject {
	public GraphicsGridEntry[] items = new GraphicsGridEntry[25];
	
	public int rows = 5;
	public int columns = 5;
	public static int xPadding = 3;
	public static int yPadding = 3;
	
	int x;
	int y;
	
	static int gridSizeX = 50;
	static int gridSizeY = 50;

	public GraphicsGrid(int iX, int iY, int rows, int columns) {
		super(iX, iY, rows*gridSizeX+(rows-1)*xPadding, columns*gridSizeY+(columns-1)*yPadding);
		x = iX;
		y = iY;
		this.rows = rows;
		this.columns = columns;
	}
	
	@Override
	public void drawObject() {
		//Registry.g.drawImage(src,(int)(x*xScalar),(int)(y*yScalar),(int)(width*xScalar),(int)(height*yScalar),null);
		
		for(int r = 0; r<rows; r++){
			for(int c = 0; c<columns; c++){
				Registry.g.setColor(Color.BLACK);
				
				
				try{
					new GraphicsImage(items[c*rows + r].i.src,x + r*gridSizeX + xPadding*r,y+c*gridSizeY + yPadding*c, gridSizeX, gridSizeY).drawObject();
				}catch(NullPointerException e){
					new GraphicsPrimitives(Color.BLACK,x + r*gridSizeX + xPadding*r,y+c*gridSizeY + yPadding*c, gridSizeX, gridSizeY).drawObject();
					Registry.g.drawString(String.valueOf(c*rows + r+1),x + r*gridSizeX + xPadding*r+16, y+c*gridSizeY + yPadding*c+50);
				}
				//System.out.println(r + ", " + c);
				//Basic Checking Mechanism (Displays Numbers and Rectangles)
				
			}
		}
		/*
		for (int i = 0; i < 18; i++) {// 18 is the current number of weapons and
		// armor we have, only a temporary fix, until we know how to clear the array list and remain functional
			if(i > items.size() - 1){
				break;//kicks out of the loop, avoids null pointer exception
			}
			else{//just in case we don't break out we will still put it in the else
				int[] points = findSpot(i);
				items.get(i).x = points[0];
				items.get(i).y = points[1];
				items.get(i).drawObject();
			}

		}
		*/
	}

	private int[] findSpot(int index) {// returns x start and y start
		// x start = ret[0], y start = ret[1]
		int rowsDown = (int) ((index + 1) / 5);// additional parenthesis to make
												// sure the whole thing is cast
												// as an int
		int collumsOver = 5 % (index + 1); // index + 1, because 4 is the last
											// one in the row, and avoids divide
											// by zero
		int retX = (collumsOver * 100) + 10 + x; // sets where it should start
		int retY = (rowsDown * 100) + 10 + y;
		int[] ret = { retX, retY };
		return ret;
	}

	@Override
	public void onClick() {
		// do nothing because it is the grid
		// so nothing should happen
	}

	@Override
	public void onHover() {
		// do nothing because it is the grid
	}

}
