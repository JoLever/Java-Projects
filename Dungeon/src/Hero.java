import java.awt.Point;
import java.util.*;
import java.io.Serializable;
/**
 * This Class contains the methods for hero
 * @author Jordan Lever
 *
 */
public class Hero extends Character implements Serializable {
	/**
	*This is the Array list of items
	**/
	private ArrayList<Item> items;
	/**
	 * The point containing location
	 */
	private Point location;
	/**
	 * This is the constructor that initialzies the values
	 * @param n	name of hero
	 * @param q	quip of hero
	 * @param start	location of hero
	 */
	public Hero(String n, String q, Point start) {
		super(n, q, 10, 0, 1);
		location = start;
		items = new ArrayList<Item>();
		
	}
	/**
	 * This is the overridden attack method that generates a random number
	 * to a attack a character
	 */
	@Override
	void attack(Character c) {
		int random = (int) (Math.random() * (4)) + getLevel();
		
		if (random >= 1) {
			String nameX = getName();
			String enemyX = c.getName();
			c.takeDamage(random);
			System.out.println(nameX + " attacks for " + random + " dmg to "+ enemyX);
			

		} else {
			String nameX = getName();
			String enemyX = c.getName();
			System.out.println(nameX + " attack missed " + enemyX);
		}
		}
	

	
	/**
	 * This method returns the array lsit
	 * @return the arraylist of items
	 */
	public ArrayList<Item> getItems() {
		
		return items;
	}
	/**
	 * This method adds an item to the itemList and checks if there is space for it
	 * @param i the item to be added
	 * @return true if you can add it
	 */
	public boolean pickUpItem(Item i){
		  if(i instanceof Item && items.size()<=5){
		   items.add(i);
		   return true;
		  }
		  else{
		   System.out.println("You cant carry that much good sir");
		   return false;
		  }
		 }
	/**
	 * This method removes an item by name
	 * @param i the item to be removed
	 */
	public void removeItem(Item i) {
		items.remove(i);
	}
	/**
	 * This method removes an item by index
	 * @param index the item location to be removed
	 */
	public void removeItem(int index) {
		items.remove(index);
	}
	/**
	 * This method returns a point at current location
	 * @return the point at current location
	 */
	public Point getLocation() {
		return location;
	}
	/**
	 * This method set the location to a new point
	 * @param p the new location
	 */
	public void setLocation(Point p) {
		p = location;
	}
	/**
	 * This method checks to make sure the move is within the bounds
	 * then it sets the location and gets the char at that location
	 * @param l the level within the move
	 * @return the char at that room or junk char
	 */
	public char goNorth(Level l) {

		Point p = new Point((int) (location.getX()), (int) location.getY());
		if (p.getX() - 1 >= 0 && p.getX() - 1 < 4) {

			location.setLocation(p.getX() - 1, p.getY());
			char r = l.getRoom(location);
			return r;
		} else {
			return 'z';
		}
	}
	/**
	 * This method moves the hero south if its within bounds.  it sets the location adn
	 * gets the character at that room
	 * @param l the levle within the move
	 * @return the char at that room or junk char
	 */
	public char goSouth(Level l) {

		Point p = new Point((int) (location.getX()), (int) location.getY());
		if (p.getX() + 1 >= 0 && p.getX() - 1 < 4) {

			location.setLocation(p.getX() + 1, p.getY());
			char r = l.getRoom(location);
			return r;
		} else {
			return 'w';
		}
	}
	/**
	 * This method moves the character East if it's within the bounds of the map
	 * It then sets location to y +1 and then gets the char at that point
	 * @param l the level within the move
	 * @return the char at that room or junk char
	 */
	public char goEast(Level l) {
		Point p = new Point((int) (location.getX()), (int) location.getY());
		if (p.getY() + 1 >= 0 && p.getY() + 1 < 4) {

			location.setLocation(p.getX(), p.getY() + 1);
			char r = l.getRoom(location);
			return r;
		} else {
			return 'y';
		}
	}
	/**
	 * This method moves the hero west and checks if it;s within the bounds
	 * IT then sets the location and gets the char at that room
	 * @param l the level within the move
	 * @return the char at that room or return junk char
	 */
	public char goWest(Level l) {
		Point p = new Point((int) (location.getX()), (int) location.getY());
		if (p.getY() - 1 >= 0 && p.getY() - 1 < 4) {

			location.setLocation(p.getX(), p.getY() - 1);
			char r = l.getRoom(location);
			return r;
		} else {
			return 'x';
		}
	}
}
