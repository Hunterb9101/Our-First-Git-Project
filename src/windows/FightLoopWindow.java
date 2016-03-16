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
		int monsterHealth = m.health;
		int playerHealth = Main.me.calculateMaxHP();
		System.out.println(m.name);
		System.out.println(Main.me.getAttackDamage());
		System.out.println(m.damage);
		System.out.println(m.health);
		
		if(Main.me.canAttack()){
			monsterHealth= m.health-Main.me.getAttackDamage();
			System.out.println("Monster health is" + m.health);
		}
		if(m.canAttack()){
			playerHealth=Main.me.calculateMaxHP()-m.damage;
			System.out.println("your health" + Main.me.maxHp);
		}//if
		
		
		
		if(monsterHealth<= 0){
			System.out.println("Monster is dead you Win!");
			Main.me.giveGold(m.gold);
			Main.me.totalXp+=m.xp;
			System.out.println("You have " + Main.me.totalXp + " xp");
		}
		else if(playerHealth<=0){
			System.out.println("You died you lose!");
		}
	}

}
