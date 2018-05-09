import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * This class creates the enemeis for use in other classes
 * @author Jordan Lever
 *
 */
public class EnemyGenerator {
	/**
	 * This is the array list of enemies
	 */
private ArrayList<Enemy> enemyList;
/**
 * This method reads in and adds to the enemyList 
 * @throws FileNotFoundException
 */
public EnemyGenerator() throws FileNotFoundException{
	enemyList = new ArrayList<Enemy>(7);
	Scanner read = new Scanner(new File("EnemyList.txt"));
	do{
	
		String line = read.nextLine();
		String [] tokens = line.split(",");
		String name = tokens[0];
		String quip = tokens[1];
		int hp = Integer.parseInt(tokens[2]);
		Enemy e = new Enemy(name,quip,hp,0,1,null);
		enemyList.add(e);
		
		
	}
	while(read.hasNextLine());
	//System.out.println(enemyList);
	
}
	/**
	 * This method creates a enemy at random with stats based on level
	 * @param level the level of the enemy
	 * @return the enemy that was generated
	 * @throws FileNotFoundException
	 */
	public Enemy generateEnemy(int level) throws FileNotFoundException {
		int random =  (int)( Math.random()*(7) );
		Enemy e = enemyList.get(random);
		String name =  e.getName();
		String quip = e.getQuip();
		int hp = e.getHp() * level;
		int gold = hp - 2 ;
		ItemGenerator i = new ItemGenerator();
		Item  item = i.generateItem();
	
		 e = new Enemy(name,quip,hp,level,gold,item);
		 
		return e;
		
	}
}

