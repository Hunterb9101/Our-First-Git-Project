package graphics;

import java.awt.Color;
import java.awt.Image;

import main.InventoryItem;
import main.Main;
import main.Registry;

public class GraphicsGrid extends GraphicsObject {
	public GraphicsGridEntry[] items = new GraphicsGridEntry[25];
	public int rows;
	public int columns;
	public static int xPadding = 3;
	public static int yPadding = 3;

	public static enum onClickBehavior {
		NONE, EQUIP, UNEQUIP, BUY, SELL
	};

	public onClickBehavior behavior = onClickBehavior.NONE;
	int x;
	int y;

	int itemWidth = 90;
	int itemHeight = 90;
	public Main.menuItem parentMenu;

	public GraphicsGrid(int iX, int iY, int rows, int columns, int itemSize, onClickBehavior behavior,
			Main.menuItem parentMenu) {
		// x start, y start, number of rows in grid, number of columns in grid,
		// what menu it is in for hover purposes
		super(iX, iY, (rows * itemSize) + ((rows - 1) * xPadding), (columns * itemSize) + ((columns - 1) * yPadding),
				parentMenu);
		this.behavior = behavior;
		itemWidth = itemSize;
		itemHeight = itemSize;
		this.parentMenu = parentMenu;
		x = iX;
		y = iY;
		this.rows = rows;
		this.columns = columns;
	}

	@Override
	public void drawObject() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				try {
					items[c * rows + r].drawObject();// draws the items
				} catch (NullPointerException e) {
					Registry.g.setColor(Color.BLACK);
					Registry.g.fillRect((int) ((x + r * itemWidth + xPadding * r) * xScalar),
							(int) ((y + c * itemHeight + yPadding * c) * yScalar), (int) (itemWidth * xScalar),
							(int) (itemHeight * yScalar));// makes black squares
															// where there is no
															// items
				}
			}
		}
	}
	public void showChildren(){
		for(int i = 0; i < items.length; i++){
			if(items[i] != null){
				items[i].parentMenu = parentMenu;
			}
		}
	}
	public void hideChildren(){
		for(int i = 0; i < items.length; i++){
			if(items[i] != null){
				items[i].parentMenu = Main.menuItem.DELETE;
			}
		}
	}
	public void removeEntry(InventoryItem i) {
		for (int j = 0; j < items.length; j++) {
			try {
				if (items[j].i == i) {
					System.out.println(i.name + " successfully removed");
					items[j].parentMenu = Main.menuItem.DELETE;
					items[j] = null;
				}
			} catch (NullPointerException e) {
				// do nothing because no item is here
			}
		}
	}

	public void addEntry(InventoryItem i) {
		System.out.println("Item added " + i.name);
		boolean needsEntry = true;
		for (int c = 0; c < columns; c++) {
			for (int r = 0; r < rows; r++) {
				// do nothing because stuff exists here
				if (items[c * rows + r] == null) {
					if (needsEntry) {
						GraphicsGridEntry entry = new GraphicsGridEntry(x + r * itemWidth + xPadding * r,
								y + c * itemHeight + yPadding * c, i, this);
						// makes a grid entry with the correct size
						items[c * rows + r] = entry;
						// adds it to the array, and moves index up 1 so we
						// don't add another entry to the same spot :(
						needsEntry = false;
					}
				}
				// Basic Checking Mechanism (Displays Numbers and Rectangles)
			}
		}
	}

	public void addEntry(InventoryItem i, int index) {
		// adds the Inventory Item at a specific index
		System.out.println("Item added " + i.name);
		boolean needsEntry = true;
		for (int c = 0; c < columns; c++) {
			for (int r = 0; r < rows; r++) {
				if (needsEntry && (c * rows + r) == index) {
					GraphicsGridEntry entry = new GraphicsGridEntry(x + r * itemWidth + xPadding * r,
							y + c * itemHeight + yPadding * c, i, this);
					// makes a grid entry with the correct size
					if(items[index] != null){
						removeEntry(items[index].i);//removes old entry if there was one
					}
					items[index] = entry;
					// adds it to the array, and moves index up 1 so we
					// don't add another entry to the same spot :(
					needsEntry = false;
				}
				// Basic Checking Mechanism (Displays Numbers and Rectangles)
			}
		}
	}

	public void addEntry(Image src, String text) {
		boolean needsEntry = true;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				if (items[c * rows + r] == null) {
					if (needsEntry) {
						GraphicsGridEntry entry = new GraphicsGridEntry(src, x + r * itemWidth + xPadding * r,
								y + c * itemHeight + yPadding * c, text, this);
						// makes a grid entry at the right spot
						items[c * rows + r] = entry;
						needsEntry = false;
					}
				}
				// Basic Checking Mechanism (Displays Numbers and Rectangles)
			}
		}
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