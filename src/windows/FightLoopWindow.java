package windows;

import java.awt.Graphics;
import main.Main;
import main.Monster;
import main.Player;
import main.Registry;

public class FightLoopWindow extends WindowItem {
	private static menuItem thisMenu = menuItem.ADVENTURE;
	public int money;
	
	public void draw() {
		Monster m = Monster.pickMonster(Main.me);
		System.out.println(m.name);
		System.out.println(Main.me.getAttackDamage());
		System.out.println(m.damage);
		System.out.println(m.health);
		
		if(Main.me.canAttack()){
			m.health= m.health-Main.me.getAttackDamage();
			System.out.println(m.health);
		}
		if(m.canAttack()){
			Main.me.maxHp=Main.me.calculateMaxHP()-m.damage;
			System.out.println(Main.me.maxHp);
		}//if
		
		
		
		if(m.health<= 0){
			System.out.println("Monster is dead you Win!");
			Main.me.giveGold(m.gold);
		}
		else if(Main.me.maxHp<=0){
			System.out.println("You died you lose!");
		}
	}

}
