package graphics;

import java.awt.Color;
import java.awt.Image;

import main.InventoryItem;
import main.Armor;
import main.Main;
import main.Registry;
import main.Weapon;

public class GraphicsGridEntry extends GraphicsObject {
	public Image src;
	public String text;
	public InventoryItem i;
	private Armor armor = null;
	private Weapon weapon = null;
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
		if(i.isWeapon()){
			weapon = i.getWeapon();
		}
		else if(i.isArmor()){
			armor = i.getArmor();
		}
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
		Registry.g.drawRect(x, y, width, height);// adds outline to the image
	}

	public void onClick() {
		// equip
		if (parent.parentMenu.equals(Main.currMenu)){//checks that we are in correct menu before doing on click
			System.out.println("Equiping " + i.name);
			if (weapon != null) {
				Main.me.equipedWeapon = weapon;
			}
			if (armor != null) {
				Main.me.equipedArmor = armor;
			}
		}
	}

	public void onHover() {
		if (parent.parentMenu.equals(Main.currMenu)) {//checks we are in correct menu before showing the hoverbox
			descrip.drawObject(); // Show Hover Box
		}
	}

}