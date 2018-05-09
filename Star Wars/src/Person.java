/**
 * The abstract class Person allows the subclasses to inherit its methods
 * 
 * @author Jordan Lever
 *
 */
public abstract class Person extends Entity {
	/**
	 * The string for weapon name
	 */
	private String weapon;
	/**
	 * The string for catch phrase
	 */
	private String quip;

	/**
	 * The constructor initializes the values
	 * 
	 * @param name1
	 *            The name of the Person
	 * @param hp1
	 *            The hit points of the Person
	 * @param weapon1
	 *            The weapon of the Person
	 * @param quip1
	 *            The catch phrase of the Person
	 */
	public Person(String name1, int hp1, String weapon1, String quip1) {
		super(name1, hp1);
		weapon = weapon1;
		quip = quip1;

	}

	/**
	 * This method prints out the quip
	 */
	public void sayCatchPhrase() {
		System.out.println(" " + quip + " ");
	}

	/**
	 * This is the abstract method to be used in all subclasses
	 * 
	 * @param E
	 *            the entity to attack
	 */
	public abstract void attack(Entity E);

	/**
	 * This method gets the weapon of the Person
	 * 
	 * @return the string containing the weapon
	 */
	public String getWeapon() {
		return weapon;
	}

}
