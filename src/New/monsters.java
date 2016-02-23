package New;
import java.util.Random;

public class monsters {
	static int Zombie[] = { 1, 4, 2, 5 };// Xp given, Gold given, Damage, Health,1
	static int wolf[] = { 1, 3, 3, 6 };// Xp given, Gold given, Damage, Health,1
	
	static int Goblin[] = { 2, 6, 3, 7 };// Xp given, Gold given, Damage, Health,2
	static int Gremlin[] = {2, 5, 4, 5}; //2*
	
	static int skeleton[] = { 4, 9, 5, 8 };// Xp given, Gold given, Damage,Health,3
	static int Dwarf[] = {4, 7, 5, 10}; //3*
	static int Mermaid[] = {3, 5, 2, 7}; //3*
	
	static int Vampire[] = {4, 15, 9, 11}; //4*
	static int Trex[] = { 5, 13, 13, 7 };// Xp given, Gold given, Damage, Health,4*
	static int Ogre[] = { 5, 14, 7, 15 };// Xp given, Gold given, Damage, Health,4
	
	static int Troll[] = { 4, 15, 9, 12 };// Xp given, Gold given, Damage, Health,5
	static int Orc[] = {5, 15, 12, 9}; //5*
	
	static int Cyclops[] = { 7, 15, 9, 15 };// Xp given, Gold given, Damage, Health,6*
	static int Werwolf[] = {6, 15, 15, 14};//6*
	static int Minotaur[] = { 7, 19, 13, 12 };// Xp given, Gold given,Damage,Health,6
	
	static int Gryphon[] = {8, 23, 22, 14};//7*
	static int Giant[] = { 7, 24, 18, 18 };// Xp given, Gold given, Damage, Health,7
	
	static int Ghoast[] = { 9, 26, 22, 26 };// 8
	static int Goul[] = { 8, 20, 26, 22 };// Xp given, Gold given, Damage, Health,8*
	
	static int Hydra[] = {13, 29, 26, 28}; // 9
	static int Basalisk[] = {12, 24, 29, 25};//9*
	static int FallenAngel[] = {11, 23, 27, 27}; //9*
	
	static int Dragon[] = { 16, 32, 28, 31 };// Xp given, Gold given, Damage, Health,10*										
	static int Demon[] = {20, 33, 36, 24}; // 10
	static int MonsterHord[] = {18, 27, 35, 27}; //10*
	
	int xpGiven;
	int GoldGiven;
	int damage;
	int health;

	public monsters(int playerLevel) {
		int x;
		x = 0;
		if (playerLevel == 1) {
			Random randGen = new Random();
			x = randGen.nextInt(3);
			
			if (x == 1) {
				System.out.println("You encountered a wolf");
				xpGiven = wolf[0];
				GoldGiven = wolf[1];
				damage = wolf[2];
				health = wolf[3];
			} else {
				System.out.println("You encountered a zombie");
				xpGiven = Zombie[0];
				GoldGiven = Zombie[1];
				damage = Zombie[2];
				health = Zombie[3];
			}
		}

		else if (playerLevel == 2) {
			Random randGen = new Random();
			x = randGen.nextInt(3);
			
			if (x == 1) {
				System.out.println("You encountered a Gremlin");
				xpGiven = Gremlin[0];
				GoldGiven = Gremlin[1];
				damage = Gremlin[2];
				health = Gremlin[3];
			} 
			else{
				System.out.println("You encountered a goblin");
			xpGiven = Goblin[0];
			GoldGiven = Goblin[1];
			damage = Goblin[2];
			health = Goblin[3];
			}
		} else if (playerLevel == 3) {
			Random randGen = new Random();
			x = randGen.nextInt(4);
			
			if (x == 1) {
				System.out.println("You encountered a Dwarf");
				xpGiven = Dwarf[0];
				GoldGiven = Dwarf[1];
				damage = Dwarf[2];
				health = Dwarf[3];
			}
			
			
			else if (x == 2) {
				System.out.println("You encountered a Mermaid");
				xpGiven = Mermaid[0];
				GoldGiven = Mermaid[1];
				damage = Mermaid[2];
				health = Mermaid[3];
			} 
			else {
			System.out.println("You encountered a skeleton");
			xpGiven = skeleton[0];
			GoldGiven = skeleton[1];
			damage = skeleton[2];
			health = skeleton[3];
		} 
		
		}
			else if (playerLevel == 4) {
				Random randGen = new Random();
				x = randGen.nextInt(4);
				
				if (x == 1) {
					System.out.println("You encountered a Vampire");
					xpGiven = Vampire[0];
					GoldGiven = Vampire[1];
					damage = Vampire[2];
					health = Vampire[3];
				}
				
				
				else if (x == 2) {
					System.out.println("You encountered a Trex");
					xpGiven = Trex[0];
					GoldGiven = Trex[1];
					damage = Trex[2];
					health = Trex[3];
				} 
				else {
			System.out.println("You encountered an Ogre");
			xpGiven = Ogre[0];
			GoldGiven = Ogre[1];
			damage = Ogre[2];
			health = Ogre[3];
				}
		} else if (playerLevel == 5) {
			Random randGen = new Random();
			x = randGen.nextInt(3);
			
			if (x == 1) {
				System.out.println("You encountered a Orc");
				xpGiven = Orc[0];
				GoldGiven = Orc[1];
				damage = Orc[2];
				health = Orc[3];
			} 
			else{
			System.out.println("You encountered a Troll");
			xpGiven = Troll[0];
			GoldGiven = Troll[1];
			damage = Troll[2];
			health = Troll[3];
			}
		} else if (playerLevel == 6) {
			Random randGen = new Random();
			x = randGen.nextInt(4);
			
			if (x == 1) {
				System.out.println("You encountered a Cyclops");
				xpGiven = Cyclops[0];
				GoldGiven = Cyclops[1];
				damage = Cyclops[2];
				health = Cyclops[3];
			}
			
			
			else if (x == 2) {
				System.out.println("You encountered a Werwolf");
				xpGiven = Werwolf[0];
				GoldGiven = Werwolf[1];
				damage = Werwolf[2];
				health = Werwolf[3];
			} 
			else {
			System.out.println("You encountered a Minotaur");
			xpGiven = Minotaur[0];
			GoldGiven = Minotaur[1];
			damage = Minotaur[2];
			health = Minotaur[3];
			}
		} else if (playerLevel == 7) {
			Random randGen = new Random();
			x = randGen.nextInt(3);
			
			if (x == 1) {
				System.out.println("You encountered a Gryphon");
				xpGiven = Gryphon[0];
				GoldGiven = Gryphon[1];
				damage = Gryphon[2];
				health = Gryphon[3];
			} 
			else{
			System.out.println("You encountered a Giant");
			xpGiven = Giant[0];
			GoldGiven = Giant[1];
			damage = Giant[2];
			health = Giant[3];
		}
		}
		else if (playerLevel == 8) {
			Random randGen = new Random();
			x = randGen.nextInt(3);
			
			if (x == 1) {
				System.out.println("You encountered a Goul");
				xpGiven = Goul[0];
				GoldGiven = Goul[1];
				damage = Goul[2];
				health = Goul[3];
			}
			else{
				System.out.println("You encountered a Ghoast");
			xpGiven = Ghoast[0];
			GoldGiven = Ghoast[1];
			damage = Ghoast[2];
			health = Ghoast[3];
			}
			}
		else if (playerLevel == 9) {
			Random randGen = new Random();
			x = randGen.nextInt(4);
			
			if (x == 1) {
				System.out.println("You encountered a Basalisk");
				xpGiven = Basalisk[0];
				GoldGiven = Basalisk[1];
				damage = Basalisk[2];
				health = Basalisk[3];
			}
			
			
			else if (x == 2) {
				System.out.println("You encountered a Fallen Angel");
				xpGiven = FallenAngel[0];
				GoldGiven = FallenAngel[1];
				damage = FallenAngel[2];
				health = FallenAngel[3];
			} 
			else {
			System.out.println("You encountered a Hydra");
			xpGiven = Hydra[0];
			GoldGiven = Hydra[1];
			damage = Hydra[2];
			health = Hydra[3];
		}
		}
		else if (playerLevel == 10) {
			Random randGen = new Random();
			x = randGen.nextInt(4);
			
			if (x == 1) {
				System.out.println("You encountered a Dragon");
				xpGiven = Dragon[0];
				GoldGiven = Dragon[1];
				damage = Dragon[2];
				health = Dragon[3];
			}
			
			
			else if (x == 2) {
				System.out.println("You encountered a Monster Hord");
				xpGiven = MonsterHord[0];
				GoldGiven = MonsterHord[1];
				damage = MonsterHord[2];
				health = MonsterHord[3];
			} 
			else {
			System.out.println("You encountered a Demon!");
			xpGiven = Demon[0];
			GoldGiven = Demon[1];
			damage = Demon[2];
			health = Demon[3];
		}
		}
	}
}
