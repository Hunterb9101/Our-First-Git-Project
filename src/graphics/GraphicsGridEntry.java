package graphics;

import java.awt.Color;
import java.awt.Image;

import main.InventoryItem;
import main.Armor;
import main.Main;
import main.Registry;
import main.Weapon;
import windows.InventoryWindow;

public class GraphicsGridEntry extends GraphicsObject {
	public Image src;
	public String text;
	public InventoryItem i;
	private HoverBox descrip;
	private GraphicsGrid parent;

	public GraphicsGridEntry(Image iSrc, int iX, int iY, String iText, GraphicsGrid parent) {
		// SHOULD NEVER BE CALLED EXCEPT BY GRAPHICS GRID
		super(iX, iY, parent.itemWidth, parent.itemHeight, parent.parentMenu);
		this.parent = parent;
		src = iSrc;
		text = iText;
		descrip = new HoverBox(iX, iY, text, parent.parentMenu);
	}
	public GraphicsGridEntry(int iX, int iY, InventoryItem i, GraphicsGrid parent) {
		// SHOULD NEVER BE CALLED EXCEPT BY GRAPHICS GRID
		super(iX, iY, parent.itemWidth, parent.itemHeight, parent.parentMenu);
		this.parent = parent;
		this.i = i;
		src = i.src;
		text = i.parseText();
		descrip = new HoverBox(iX, iY, text, parent.parentMenu);
	}

	public void drawObject() {
		// SHOULD NEVER BE CALLED EXCEPT BY GRAPHICS GRID
		Registry.g.drawImage(src, (int) (x * xScalar), (int) (y * yScalar), (int) (width * xScalar),
				(int) (height * yScalar), null);
		Registry.g.setColor(Color.black);
		Registry.g.drawRect((int) (x * xScalar), (int) (y * yScalar), (int) (width * xScalar),
				(int) (height * yScalar));// adds outline to the image
	}

	public void onClick() {
		switch(parent.behavior){
		case BUY:
			break;
		case EQUIP:
			int index = 5;
			if (parent.parentMenu.equals(Main.currMenu)){//checks that we are in correct menu before doing on click
				if(i.isWeapon()){
					Main.me.equipedWeapon = i.getWeapon();
					InventoryWindow.equiped.addEntry(i, index);
				}
				else if(i.isArmor()){
					switch(i.getArmor().armorLocation){
					case BOOTS:
						Main.me.equipedBoots = i.getArmor();
						index = 4;
						break;
					case CHEST:
						Main.me.equipedChestplate = i.getArmor();
						index = 1;
						break;
					case GLOVES:
						Main.me.equipedGloves = i.getArmor();
						index = 2;
						break;
					case HEAD:
						Main.me.equipedHelmet = i.getArmor();
						index = 0;
						break;
					case PANTS:
						Main.me.equipedLeggings = i.getArmor();
						index = 3;
						break;
					default:
						break;					
					}
					InventoryWindow.equiped.addEntry(i.getArmor(), index);
				}
			}
			break;
		case NONE:
			break;
		case SELL:
			break;
		case UNEQUIP:
			parent.removeEntry(i);
			break;
		default:
			break;
		
		}
		// equip
		
	}

	public void onHover() {
		if (parent.parentMenu.equals(Main.currMenu)) {//checks we are in correct menu before showing the hoverbox
			descrip.drawObject(); // Show Hover Box
		}
	}

}