package New;

public class Registry {
	public static void registerArmor(){
		new Armor("Leather", 7, 52);
		new Armor("chain mail", 9, 77);
		new Armor("steel plate", 15, 84);
		new Armor("iron", 11, 67);
		new Armor("Enchanted", 18, 134);
		new Armor("Mythical", 27, 213); 
		new Armor("Dragon", 23, 157);
	}
	
	public static void registerWeapons(){
		new Weapon("Iron sword", 6, 37);
		new Weapon("Wood sword", 3, 17);
		new Weapon("Steel Sword", 11, 78);
		new Weapon("Iron BattleAxe", 8, 48);
		new Weapon("Steel BattleAxe", 14, 83);
		new Weapon("Iron Dagger", 3, 24);
		new Weapon("Steel Dagger", 7, 42);
		new Weapon("Long bow", 4, 37);
		new Weapon("Compound bow", 6, 79);
		new Weapon("enchanted sword", 16, 121);
		new Weapon("Mythical sword", 18, 162);
	}
}
