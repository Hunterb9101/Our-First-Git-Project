package New;
import java.util.ArrayList;
import java.util.Random;

public class monsters {
	
	Monster Zombie = new Monster("Zombie", 1, 4, 2, 5, 1);
	Monster Wolf = new Monster("Wolf", 1, 3, 3, 6, 1);
	
	Monster Goblin = new Monster("Goblin", 2, 6, 3, 7, 2);
	Monster Gremlin = new Monster("Goblin", 2, 5, 4, 5, 2);
	
	Monster Skeleton = new Monster("Skeleton", 4, 9, 5, 8, 3);
	Monster Dwarf = new Monster("Dwarf", 2, 5, 4, 5, 3);
	Monster Mermaid = new Monster("Mermaid", 3, 5, 2, 7, 3);
	
	Monster Vampire = new Monster("Vampire", 4, 15, 9, 11, 4);
	Monster TRex = new Monster("T-Rex", 4, 15, 9, 11, 4);
	Monster Ogre = new Monster("Ogre", 4, 15, 9, 11, 4);
	
	Monster Troll = new Monster("Troll", 4, 15, 9, 12, 5);
	Monster Orc = new Monster("Orc", 5, 15, 12, 9, 5);
	
	Monster Cyclops = new Monster("Cyclops", 7, 15, 9, 15, 6);
	Monster Werewolf = new Monster("Werewolf", 6, 15, 15, 14, 6);
	Monster Minotaur = new Monster("Minotaur", 7, 19, 13, 12, 6);

	Monster Gryphon = new Monster("Gryphon", 8, 23, 22, 14, 7);
	Monster Giant = new Monster("Giant", 7, 24, 18, 18, 7);
	
	Monster Ghoast = new Monster("Ghoast", 9, 26, 22, 26, 8);
	Monster Goul = new Monster("Goul", 8, 20, 26, 22, 8);
	
	Monster Hydra = new Monster("Hydra", 13, 29, 26, 28, 9);
	Monster Basalisk = new Monster("Basalisk", 12, 24, 29, 25, 9);
	Monster FallenAngle = new Monster("Fallen Angel", 11, 23, 27, 27, 9);
	
	Monster Dragon = new Monster("Dragon", 16, 32, 28, 31, 10);
	Monster Demon = new Monster("Basalisk", 20, 33, 36, 24, 10);
	Monster MonsterHoard = new Monster("Monster Hoard", 18, 27, 35, 27, 10);

	public Monster pickMonster(Player a){
		Random rand = new Random();
		Monster m = new Monster("Read Only", 0, 0, 0, 0, -1);
		while(m.lvl > a.playerLV){
			//while required level is greater then player level, pick new monster
			//this is so we pick a monster within the meetable monsters for this player
			m = m.AllMonsters.get(rand.nextInt(m.AllMonsters.size()));
			//this picks a random monster within AllMonsters
		}
		return m;
	}
}

