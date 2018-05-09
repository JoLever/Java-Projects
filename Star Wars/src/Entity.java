/**
 * This is the super class for person and abstract as we never make an entity It
 * contains all of the methods for Entity and the constructor.
 * 
 * @author Jordan Lever
 *
 */
public abstract class Entity {
	/**
	 * The string containing the name
	 */
	private String name;
	/**
	 * The integer containing the hp
	 */
	private int hp;
	/**
	 * The boolean for active
	 */
	private boolean active;
	/**
	 * The string containing the task
	 */
	private String task;

	/**
	 * This is the constructor that initializes the values
	 * 
	 * @param name1
	 *            The name of the entity
	 * @param hp1
	 *            The health points of the entity
	 */
	public Entity(String name1, int hp1) {
		name = name1;
		hp = hp1;
		active = true;
		task = "";
	}

	public abstract void doTask(Entity e);

	/**
	 * This method returns the integer containing health points
	 * 
	 * @return the integer containing hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * This method gets the active boolean
	 * 
	 * @return the boolaen containing active
	 */
	public boolean getActive() {
		return active;
	}

	/**
	 * This method gets the name
	 * 
	 * @return the string containing the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method gets the Task
	 * 
	 * @return the string containing the task
	 */
	public String getTask() {
		return task;
	}

	/**
	 * This method sets the active boolean to false
	 */
	public void setActive(boolean active) {
		active = false;

	}

	/**
	 * This method modifies the heath points when damage is taken
	 * 
	 * @param h
	 *            the damage taken
	 */
	public void modifyHp(int h) {
		hp = hp - h;
	}

	/**
	 * This method sets the task to the inputed string
	 * 
	 * @param t
	 *            the inputed string
	 */
	public void setTask(String t) {
		task = t;

	}

}
