/**
 * This class contains all of methods for Door and is a subclass of Entity
 * 
 * @author Jordan Lever
 *
 */
public class Door extends Entity {
	/**
	 * This is the constructor for Door and initializes the values
	 * 
	 * @param name
	 *            the name of the door
	 */
	public Door(String name) {
		super(name, 50);

	}

	/**
	 * This is the overwritten doTask for instance checking to make sure the
	 * task is of the right class target
	 */
	@Override
	public void doTask(Entity e) {
		if (e instanceof Entity) {
			modifyHp(25);
		}

	}

}
