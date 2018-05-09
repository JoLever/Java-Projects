import java.io.*;

/**
 * This class contains the pattern constructor and all of it's methods it
 * overrides hashcode and equals
 * 
 * @author Jordan Lever
 *
 */
public class Pattern implements Serializable {
	/**
	 * This is the string containing the pattern
	 */
	private String pattern;

	/**
	 * This is the constructor that initializes the string
	 * 
	 * @param p
	 */
	public Pattern(String p) {
		pattern = p;
	}

	/**
	 * This method gets the pattern
	 * 
	 * @return the string containing the pattern
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * This overrides the hashcode
	 * 
	 * @return the int containg the hashcode
	 */
	@Override
	public int hashCode() {
		return pattern.hashCode();
	}

	/**
	 * This method overrides the equals method
	 * 
	 * @return the pattern if it is equal
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Pattern)) {
			return false;
		}
		Pattern s = (Pattern) o;
		return pattern.equals(s.getPattern());
	}
}
