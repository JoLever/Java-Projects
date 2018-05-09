/**
 * This class contains the methods and constructor for Stormtrooper object and
 * is a subclass of Person
 * 
 * @author Jordan lever
 *
 */
public class Stormtrooper extends Person {
	/**
	 * This is the constructor where values are initialized
	 * 
	 * @param name1
	 *            The name of the Stormtrooper
	 * @param quip1
	 *            The catch phrase of the Stormtrooper
	 */
	public Stormtrooper(String name1, String quip1) {
		super(name1, 50, "Blaster", quip1);

	}

	/**
	 * This is the attack method from person to be overwritten. It generates a
	 * random number from 0-10, then modifies the hp of the target if it is
	 * greater than 1
	 */
	@Override
	public void attack(Entity e) {
		int random = (int) (Math.random() * (10));
		if (random >= 1) {
			String nameX = getName();
			String wepX = getWeapon();
			String enemyX = e.getName();
			e.modifyHp(random);
			System.out.println(nameX + " attacks for " + random + " dmg to "
					+ enemyX + " with " + wepX);
			sayCatchPhrase();

		} else {
			String enemyX = e.getName();
			String nameX = getName();
			System.out.println(nameX + " attack missed! " + enemyX);
		}
	}

	/**
	 * This is the overwritten doTask that instance checks to make sure that
	 * attack only hits person
	 */
	@Override
	public void doTask(Entity e) {
		if (e instanceof Person) {
			attack(e);
		} else {

		}

	}

}
