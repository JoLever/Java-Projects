import java.util.*;
import java.io.*;

/**
 * This class contains all of the methods and constructor for the Computer class
 * 
 * @author Jordan Lever
 *
 */
public class Computer implements Serializable {
	/**
	 * The hashmap to store patterns in
	 */
	private HashMap<Pattern, Integer> map;

	/**
	 * This is the constructor that initializes the hashmap
	 */
	public Computer() {
		map = new HashMap<Pattern, Integer>();
	}

	/**
	 * This method checks the hashmap for a pattern. It takes the most frequent
	 * variable and does the opposite variable to predict a move. If there is a
	 * tie or not enough variables a slection is randomly generated
	 * 
	 * @param p
	 *            the string to make a prediction off of
	 * @return the string containing the prediction
	 */
	public String makePrediction(String p) {
		int rCount = 0;
		int pCount = 0;
		int sCount = 0;

		Pattern pat = new Pattern(p);
		String choice = "";
		if (map.containsKey(pat) && !map.isEmpty()) {
			Pattern rUpdate = new Pattern(p.substring(0, p.length() - 1) + "r");
			Pattern sUpdate = new Pattern(p.substring(0, p.length() - 1) + "s");
			Pattern pUpdate = new Pattern(p.substring(0, p.length() - 1) + "p");
			if (map.containsKey(rUpdate)) {
				rCount = map.get(rUpdate);
			}
			if (map.containsKey(pUpdate)) {
				pCount = map.get(pUpdate);
			}
			if (map.containsKey(sUpdate)) {

				sCount = map.get(sUpdate);
			}

			if (rCount > pCount && rCount > sCount) {
				choice = "p";
			} else if (pCount > rCount && pCount > sCount) {
				choice = "s";

			} else if (sCount > rCount && sCount > pCount) {
				choice = "r";
			} else if (rCount == pCount && rCount > sCount) {
				int random = (int) (Math.random() * 3) + 1;
				if (random == 1) {
					choice = "r";
				} else if (random == 2) {
					choice = "p";
				} else if (random == 3) {
					choice = "s";
				}
			} else if (rCount == sCount && rCount > pCount) {
				int random = (int) (Math.random() * 3) + 1;
				if (random == 1) {
					choice = "r";
				} else if (random == 2) {
					choice = "p";
				} else if (random == 3) {
					choice = "s";
				}
			} else if (pCount == sCount && pCount > rCount) {
				int random = (int) (Math.random() * 3) + 1;
				if (random == 1) {
					choice = "r";
				} else if (random == 2) {
					choice = "p";
				} else if (random == 3) {
					choice = "s";
				}
			}

		} else {
			int random = (int) (Math.random() * 3) + 1;
			if (random == 1) {
				choice = "r";
			} else if (random == 2) {
				choice = "p";
			} else if (random == 3) {
				choice = "s";
			}

		}
		return choice;
	}

	/**
	 * This method stores patterns in the hashmap. If the pattern does not exist
	 * in the map it creates a key of 1. if there is already a pattern it
	 * increments.
	 * 
	 * @param p
	 *            the string to be stored
	 */
	public void storePattern(String p) {
		Pattern p1 = new Pattern(p);
		Integer frequency = map.get(p1);
		if (frequency == null) {
			map.put(p1, 1);

		} else {
			map.put(p1, frequency + 1);
		}
	}
}