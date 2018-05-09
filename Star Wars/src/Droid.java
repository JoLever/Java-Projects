/**
 * This class is a subclass of Entity and contains the methods for 
 * droid as well as the constructor.
 * @author Jordan Lever
 *
 */
public abstract class Droid extends Entity {
/**
 * The integer containing the number of tasks
 */
	int numTasks;
/**
 * This is the constructor that initaizlies the values
 * @param name1 	The name of the droid
 * @param hp1		The health of the droid
 * @param numTasks1	 the number of task of the droid
 */
	public Droid(String name1, int hp1, int numTasks1) {
		super(name1, hp1);
		numTasks = numTasks1;

	}
/**
 * This method gets the number of tasks
 * @return the integer containing the number of tasks
 */
	public int getNumTasks() {
		return numTasks;
	}
/**
 * This method is for using Tasks
 */
	public void useTask() {

	}
}
