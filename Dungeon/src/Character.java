import java.io.Serializable;
/**
 * This creates the hero class which will allow enemy and hero to extend from.
 * @author Jordan Lever
 *
 */
public abstract class Character {
	/**
	 * The string containing name
	 */
	private String name;
	/**
	 * The string containing quip
	 */
	private String quip;
	/**
	 * The int containing gold
	 */
	private int gold;
	/**
	 * The int containing level
	 */
	private int level;
	/**
	 * The int containing hp
	 */
	private int hp;
	/**
	 * The int containing max hp
	 */
	private int maxhp;
	/**
	 * This is the constructor that initializes values
	 * @param n The name of the character
	 * @param q	quip of the character
	 * @param h	hp of the character
	 * @param g	gold of the character
	 * @param l	level of the character
	 */
	public Character(String n, String q, int h, int g, int l) {
		name = n;
		quip = q;
		hp = h;
		gold = g;
		level = l;
		maxhp = 10;
	}
	/**
	 * The abstract method for attacking a character
	 * @param c
	 */
	abstract void attack(Character c);
	/**
	 * This method gets the name of the character
	 * @return the string containing name
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method gets the quip of the character
	 * @return the string containing quip
	 */
	public String getQuip() {
		System.out.println(quip);
		return quip;
	}
	/**
	 * This method gets the current hp of the character
	 * @return the int containing hp
	 */
	public int getHp() {
		return hp;
	}
	/**
	 * This method gets the gold of the character
	 * @return the int containing gold
	 */
	public int getGold() {
		return gold;
	}
	/**
	 * This method gets the level of the character
	 * @return the level of the character
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * This method increases the level and max hp of the character
	 */
	public void increaseLevel() {
		level = level + 1;
		if (level == 2) {
			maxhp *= 2;
			hp = maxhp;
		}
		if (level == 3) {
			maxhp *= 2;
			hp = maxhp;
		}

	}
	/**
	 * This method heals the character to full
	 * @param h the int to heal by
	 */
	public void heal(int h) {
		if (hp < maxhp) {
			hp = maxhp;
		}
	}
	/**
	 * This method updates the hp 
	 * @param h the damage taken
	 */
	public void takeDamage(int h) {
		hp = hp - h;
	}
	/**
	 * This method collects gold 
	 * @param g the gold being added
	 */
	public void collectGold(int g) {
		gold = gold + g;
	}
	/**
	 * This method displays hp and name of character
	 */
	public void display() {
		System.out.println(getName() + " has " + getHp() + "HP");

	}
}
