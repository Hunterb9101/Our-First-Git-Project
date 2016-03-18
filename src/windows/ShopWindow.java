package windows;

import graphics.GraphicsGrid;
import graphics.GraphicsImage;
import main.Armor;
import main.Main;
import main.Registry;
import main.Weapon;

public class ShopWindow extends WindowItem {
	private static menuItem thisMenu = menuItem.SHOP;
	public GraphicsGrid weaponsGrid = new GraphicsGrid(70, 120, 5, 5, 90, GraphicsGrid.onClickBehavior.BUY, thisMenu);
	public GraphicsGrid armorGrid = new GraphicsGrid(70, 120, 5, 5, 90, GraphicsGrid.onClickBehavior.BUY, thisMenu);
	boolean displayWeapons = false;
	GraphicsImage weaponTab = new GraphicsImage(Registry.imgRes.get("ShopMenu"), 50, 60, 200, 50, thisMenu) {

		@Override
		public void onClick() {
			weaponsGrid.showChildren();
			displayWeapons = true;
			armorGrid.hideChildren();
		}

		@Override
		public void onHover() {
		}
	};
	GraphicsImage armorTab = new GraphicsImage(Registry.imgRes.get("ShopMenu"), 350, 60, 200, 50, thisMenu) {
		@Override
		public void onClick() {
			armorGrid.showChildren();
			displayWeapons = false;
			weaponsGrid.hideChildren();
		}

		@Override
		public void onHover() {
		}
	};
	boolean firstFrame = true;

	@Override
	public void draw() {
		if (firstFrame) {
			for (int i = 0; i < Weapon.allWeapons.size(); i++) {
				weaponsGrid.addEntry(Weapon.allWeapons.get(i));
			}
			for (int i = 0; i < Armor.allArmor.size(); i++) {
				armorGrid.addEntry(Armor.allArmor.get(i));
			}
			firstFrame = false;
		}
		armorTab.drawObject();
		weaponTab.drawObject();
		if (displayWeapons) {
			weaponsGrid.drawObject();
		} else {
			armorGrid.drawObject();
		}
	}

}