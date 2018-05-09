import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ItemGenerator {
	/**
	 * This is the array list of items
	 */
	private ArrayList<Item> itemList;
	/**
	 * This is the constructor that reads in from the file and adds
	 * to the itemList.  It checks for file not found error
	 */
	public ItemGenerator() {
		itemList = new ArrayList<Item>(8);
		String name, value;
		try {
			Scanner read = new Scanner(new File("ItemList.txt"));
			do {

				read.useDelimiter(",");
				name = read.next();
				value = read.nextLine().substring(1);
				Item i = new Item(name, Integer.parseInt(value));
				itemList.add(i);
				

			} while (read.hasNext());
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("FNF");
		}
	}
	/**
	 * This method generates a random item from the list of items
	 * @return the random item
	 */
	public Item generateItem() {
		int random = (int) (Math.random() * (8));
		Item x = itemList.get(random);
		x.getName();

		return x;

	}
}
