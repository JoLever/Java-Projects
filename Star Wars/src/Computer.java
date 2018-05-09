/**
 * This class contains all of the method for Computer and is a subclass of Entity
 * @author Jordan Lever
 *
 */
public class Computer extends Entity {
/**
 * This is the constructor that initializes the values 
 * @param name1  The name of the computer
 */
	public Computer(String name1) {
		super(name1, 10);
		
	}
/**
 * This is the instance check to make sure only the right instances are targetted 
 */
	@Override
	public void doTask(Entity e) {
		if (e instanceof Entity){
			modifyHp(10);
		}
		
	}

}
