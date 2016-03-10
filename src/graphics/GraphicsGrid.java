package graphics;

import java.awt.Color;
import java.awt.Image;
import main.Armor;
import main.InventoryItem;
import main.Main;
import main.Registry;
import main.Weapon;

public class GraphicsGrid extends GraphicsObject {
	public GraphicsGridEntry[] items = new GraphicsGridEntry[25];
	public int rows = 5;
	public int columns = 5;
	public static int xPadding = 3;
	public static int yPadding = 3;

	int x;
	int y;

	static int itemWidth = 90;
	static int itemHeight = 90;
	public Main.menuItem parentMenu;

	public GraphicsGrid(int iX, int iY, int rows, int columns, Main.menuItem parentMenu) {
		// x start, y start, number of rows in grid, number of columns in grid,
		// what menu it is in for hover purposes
		super(iX, iY, (rows * itemWidth) + ((rows - 1) * xPadding),
				(columns * itemHeight) + ((columns - 1) * yPadding));
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
					Registry.g.fillRect(x + r * itemWidth + xPadding * r, y + c * itemHeight + yPadding * c, itemWidth,
							itemHeight);// makes black squares where there is no
										// items
				}
			}
		}
	}

	public void addEntry(Armor a) {
		System.out.println("Item added " + a.name);
		boolean needsEntry = true;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				try {
					// do nothing because stuff exists here
					items[c * rows + r].freeMotion = items[c * rows + r].freeMotion;
				} catch (NullPointerException e) {
					if (needsEntry) {
						GraphicsGridEntry entry = new GraphicsGridEntry(x + r * itemWidth + xPadding * r,
								y + c * itemHeight + yPadding * c, a, this);
						// makes a grid entry with the correct size
						items[c * rows + r] = entry;
						// adds it to the array, and moves index up 1 so we
						// don't add another entry to the same spot :(
						needsEntry = false;
					}
				}
			}
		}
	}
	public void addEntry(InventoryItem i) {
		System.out.println("Item added " + i.name);
		boolean needsEntry = true;
		for (int c = 0; c < columns; c++) {
			for (int r = 0; r < rows; r++) {
				try {
					// do nothing because stuff exists here
					items[c * rows + r].freeMotion = items[c * rows + r].freeMotion;// triggers
																					// catch

				} catch (NullPointerException e) {
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
	public void addEntry(Weapon w) {
		System.out.println("Item added " + w.name);
		boolean needsEntry = true;
		for (int c = 0; c < columns; c++) {
			for (int r = 0; r < rows; r++) {
				try {
					// do nothing because stuff exists here
					items[c * rows + r].freeMotion = items[c * rows + r].freeMotion;// triggers
																					// catch

				} catch (NullPointerException e) {
					if (needsEntry) {
						GraphicsGridEntry entry = new GraphicsGridEntry(x + r * itemWidth + xPadding * r,
								y + c * itemHeight + yPadding * c, w, this);
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

	public void addEntry(Image src, String text) {
		boolean needsEntry = true;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				try {
					// do nothing
					items[c * rows + r].freeMotion = items[c * rows + r].freeMotion;// triggers
																					// the
																					// catch
				} catch (NullPointerException e) {
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