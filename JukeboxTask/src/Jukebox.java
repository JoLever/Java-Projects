import java.util.*;
import java.io.*;

/**
 * This is the testbench that runs the program for Song with options
 * to add a song, update rating, print out songs, and play next song.
 * 
 * @author Jordan Lever
 *
 */
public class Jukebox {
	public static void main(String[] args) {
		Heap<Song> h = new Heap<Song>();
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
					System.out.println("EMPTY");
				} else {
					System.out.println(h.getNodeAt(i));
				}
				break;
			case 3:
				System.out.println("Please enter song name");
				String name = in.nextLine();
				System.out.println("Please enter artist name");
				String artist = in.nextLine();
				System.out.println("Please enter album name");
				String album = in.nextLine();
				System.out.println("Please enter rating");
				String rating = in.nextLine();
				Song x = new Song(name, artist, album, rating);
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
				if (h.isEmpty()) {
					System.out.println("Empty");
				} else {
					System.out.println(h.getNodeAt(i));
					System.out.println("What is the new rating? ");
					String r1 = in.nextLine();
					Song s1 = (Song) h.getNodeAt(i);
					Song s2 = new Song(s1.getTitle(), s1.getArtist(), s1.getAlbum(), r1);

					h.removeMin();
					h.addNode(s2);
					System.out.println(s2);
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
		System.out.println("JukeBox Menu ");
		System.out.println("1. Display the list of songs");
		System.out.println("2. Display current song.");
		System.out.println("3. Add a new song to the list");
		System.out.println("4. Play next song");
		System.out.println("5. Re-rate current song");
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
	 * THis method reads in from the file and place into heap h
	 * 
	 * @param h
	 *            the heap being added to
	 */
	public static void read(Heap h) {

		try {
			Scanner reader = new Scanner(new File("Songs"));

			while (reader.hasNextLine()) {
				String[] song = reader.nextLine().split(",");
				Song x = new Song(song[0], song[1], song[2], song[3]);
				h.addNode(x);

			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
	}

}