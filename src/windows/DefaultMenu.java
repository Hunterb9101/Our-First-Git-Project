package windows;

import java.awt.Color;
import java.awt.Graphics;

import graphics.GraphicsImage;
import graphics.GraphicsPrimitives;
import main.Main;
import main.Registry;

public class DefaultMenu extends WindowItem {
	private static menuItem thisMenu = menuItem.NONE;
	GraphicsImage shop = new GraphicsImage(Registry.imgRes.get("ShopMenu"), 0, 0, 200, 50, thisMenu) {
		@Override
		public void onClick() {
			Main.currMenu = Main.menuItem.SHOP;
		}

		@Override
		public void onHover() {
		}
	};

	GraphicsImage inventory = new GraphicsImage(Registry.imgRes.get("InventoryMenu"), 400, 0, 200, 50, thisMenu) {
		@Override
		public void onClick() {
			Main.currMenu = Main.menuItem.INVENTORY;
		}

		@Override
		public void onHover() {
		}
	};

	GraphicsPrimitives bg = new GraphicsPrimitives(Color.BLACK, 0, 0, 600, 55, thisMenu);
	GraphicsPrimitives bgLine1 = new GraphicsPrimitives(new Color(124, 29, 29), 0, 52, 600, 2, thisMenu);
	GraphicsPrimitives bgLine2 = new GraphicsPrimitives(new Color(124, 29, 29), 0, 55, 600, 2, thisMenu);

	@Override
	public void draw() {
		bg.drawObject();
		bgLine1.drawObject();
		bgLine2.drawObject();
		shop.drawObject();
		inventory.drawObject();
	}

}
