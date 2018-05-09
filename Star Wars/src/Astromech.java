/**
 * This class contains all of the methods for Computer and is a subclass of Droid
 * @author Jordan Lever
 *
 */
public class Astromech extends Droid{
/**
 * This is the constructor that initializes the values;
 * @param name1 The name of the Astromech
 * @param hp	The health of the Astromech
 */
	public Astromech(String name1, int hp) {
		super(name1, hp, 1);
		
	}
/**
 * This overwritten dotask makes sure that the Astromech can only hack doors
 * and computers
 */
	@Override
	public void doTask(Entity e) {
		if (e instanceof Computer){
			hack(e);
		}
		else if (e instanceof Door) {
			hack(e);
		}
		else {
			
		}
	}

/**
 * The hack method deals 10 dmg
 * @param e the target of the hack
 */
	public void hack(Entity e){
		e.modifyHp(10);
	}
}
