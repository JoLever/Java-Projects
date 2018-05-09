import java.util.*;
import java.io.*;

/**
 * This class is the main for that allows the user to add new Jobs, update Jobs
 * mark Jobs complete, and display the Jobs.
 * 
 * @author Jordan Lever
 *
 */
public class Tasklist {
	public static void main(String[] args) {
		Heap<Job> h = new Heap<Job>();
		read(h);
		Scanner in = new Scanner(System.in);
		int i = 0;
		boolean finished = false;

		while (!finished) {
			System.out.println();

			Menu();
			int choice = MenuChoice(1, 6);
			switch (choice) {
			case 1:
				h.printHeap();
				break;
			case 2:
				if (h.getSize() == 0) {

				} else {
					System.out.println(h.getNodeAt(i));
				}
				break;
			case 3:
				System.out.println("Please enter task name");
				String name = in.nextLine();
				System.out.println("Please enter task date");
				String date = in.nextLine();
				Job x = new Job(name, date);
				h.addNode(x);
				break;
			case 4:
				if (h.getSize() == 0) {
					System.out.println("EMPTY");
				} else {

					i++;
					h.removeMin();
					if(h.isEmpty()){
						System.out.println("Empty");
					}
					else{
					System.out.println(h.getNodeAt(0));
					}
				}
				break;
			case 5:
				if(h.isEmpty()){
					System.out.println("Empty")
;				}
				else{
				System.out.println(h.getNodeAt(i));
				System.out.println("What is the new due date? MM/DD/YYYY HH:MM");
				String d1 = in.nextLine();
				Job j1 = (Job) h.getNodeAt(i);
				Job j2 = new Job(j1.getTask(), d1);
				
				h.removeMin();
				h.addNode(j2);
				System.out.println(j2);
				}
				break;
			case 6:

				System.out.println("Exiting");
				finished = true;
				break;

			}
		}
	}

	/**
	 * The menu options
	 */
	public static void Menu() {
		System.out.println();
		System.out.println("Tasklist Menu ");
		System.out.println("1. Display the list of tasks");
		System.out.println("2. Display current task.");
		System.out.println("3. Add a new task to the list");
		System.out.println("4. Mark Complete");
		System.out.println("5. Postpone next task");
		System.out.println("6. Quit");
	}

	/**
	 * This method checks the value of the input for the menu
	 * 
	 * @param low
	 *            The lowest possible input
	 * @param high
	 *            The highest possible input
	 * @return The value that is in the range
	 */
	public static int MenuChoice(int low, int high) {
		Scanner in = new Scanner(System.in);
		int value = 0;
		boolean done = false;
		while (!done) {
			if (in.hasNextInt()) {
				value = in.nextInt();
				if (value >= low && value <= high) {
					done = true;
				} else {
					System.out.println("Out of range!");
				}
			} else {
				String dummy = in.next();
				System.out.println("Invalid input! Enter a number.");
			}
		}
		return value;
	}

	/**
	 * This reads in the file and puts it into a heap
	 * 
	 * @param h
	 *            heap
	 */
	public static void read(Heap h) {

		try {
			Scanner reader = new Scanner(new File("task"));

			while (reader.hasNextLine()) {
				String[] jobs = reader.nextLine().split(",");
				Job x = new Job(jobs[0], jobs[1]);
				h.addNode(x);

			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
	}

}