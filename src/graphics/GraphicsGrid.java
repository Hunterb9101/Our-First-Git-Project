package graphics;

import java.awt.Image;
import java.util.ArrayList;

import main.Registry;

public class GraphicsGrid extends GraphicsObject {
	private Image src = Registry.imgRes.get("Grid");
	public ArrayList<GraphicsInventory> items = new ArrayList<GraphicsInventory>(5);
	int x;
	int y;

	public GraphicsGrid(int iX, int iY, int iWidth, int iHeight) {
		super(iX, iY, iWidth, iHeight);
		x = iX;
		y = iY;
	}

	@Override
	public void drawObject() {
		Registry.g.drawImage(src,(int)(x*xScalar),(int)(y*yScalar),(int)(width*xScalar),(int)(height*yScalar),null);
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
