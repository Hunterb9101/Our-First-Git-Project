package windows;

import java.awt.Graphics;

import main.Main;
import main.Monster;
import main.Registry;

public class FightLoopWindow extends WindowItem {
	
	@Override
	public void draw() {
		Monster m = Monster.pickMonster(Main.me);
		System.out.println(m.name);
		System.out.println(Main.me.getAttackDamage());
		System.out.println(m.damage);
		System.out.println(m.health);
		
	}

}
