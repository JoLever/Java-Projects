/**
 * This is the enemy class that contains all of the methods
 * @author Jordan Lever
 *
 */
public class Enemy extends Character {
	/**
	 * This is the enemy's item
	 */
	private Item item;
	/**
	 * This constructor intitializes all of the values
	 * @param n	name of enemy	
	 * @param q	quip of enemy
	 * @param h health of enemy
	 * @param l level of enemy
	 * @param g gold of enemy
	 * @param i item of enemy
	 */
	public Enemy(String n, String q, int h, int l, int g, Item i) {
		super(n, q, h, l, g);
		item = i;
	}
	/**
	 * This method generates a random number to attack the enemy with
	 * based on level
	 * @param c the character to be attacked
	 */
	@Override
	void attack(Character c) {
		int random = (int) (Math.random() * (2));
		if (random >= 1) {
			String nameX = getName();
			String enemyX = c.getName();
			c.takeDamage(random);
			System.out.println(nameX + " attacks for " + random + " dmg to "
					+ enemyX);
			getQuip();

		} else {
			String nameX = getName();
			String enemyX = c.getName();
			System.out.println(nameX + " attack missed " + enemyX);
		}

	}
	/**
	 * This gets the enemy's item
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}
}
