import java.io.Serializable;
/**
 * This class makes the methods for item
 * @author Jordan Lever
 *
 */
public class Item {
	/**
	 * The int containing goldVal
	 */
	private int goldVal;
	/**
	 * The string containing item name
	 */
	private String name;
	/**
	 * This method initializes the values
	 * @param n the name of the item
	 * @param g	the goldval of the item
	 */
	public Item(String n, int g) {
		goldVal = g;
		name = n;
	}
	/**
	 * This method returns the name of the item
	 * @return the string containing name
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method gets the value of the item
	 * @return the int containing goldVal
	 */
	public int getVal() {
		return goldVal;
	}
}
