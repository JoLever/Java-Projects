import java.util.*;
import java.io.*;
/**
 * This is the main class where we play teh rock paper scissors game with the computer predicting 
 * based on previous patterns.
 * @author Jordan Lever
 *
 */
public class Main {

	public static void main(String[] args) {
		int playerS = 0;
		int computerS = 0;
		int tieS = 0;
		Pattern p = new Pattern("");
		Computer c = new Computer();

		boolean finished = false;
		while (!finished) {
			System.out.println();
			menu();
			int choice = menuChoice(1, 2);

			switch (choice) {
			case 1:
				boolean complete = false;
				do {
					menuRPS();
					int select = menuChoice(1, 4);

					if (select == 1) {
						String user = "r";
						p = new Pattern(p.getPattern() + "r");
						String s = p.getPattern();
						System.out.println(s);
						if (s.length() == 3) {

							String x = c.makePrediction(s);
							c.storePattern(s);
							s = p.getPattern().substring(1,
									p.getPattern().length() - 1);
							p = new Pattern(s);

							if (user.equals(x)) {

								System.out.println("It's a Tie!");
								tieS++;
								play(x, playerS, computerS, tieS);
							} else {
								if (s.equals("r") && x.equals("p")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("r") && x.equals("s")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("p")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("r")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("r")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("s")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}

							}
						} else {
							String x = c.makePrediction(s);
							if (user.equals(x)) {
								System.out.print("It's a Tie!");
								tieS++;
								play(x, playerS, computerS, tieS);
							} else {
								if (s.equals("r") && x.equals("p")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("r") && x.equals("s")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("p")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("r")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("r")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("s")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}

							}

						}
					}
					if (select == 2) {
						String user = "s";
						p = new Pattern(p.getPattern() + "s");
						String s = p.getPattern();
						System.out.println(s);
						if (s.length() == 3) {

							String x = c.makePrediction(s);
							c.storePattern(s);
							s = p.getPattern().substring(1,
									p.getPattern().length() - 1);
							p = new Pattern(s);
							System.out.println(s);
							System.out.println(x);
							if (user.equals(x)) {

								System.out.println("It's a Tie!");
								tieS++;
								play(x, playerS, computerS, tieS);
							} else {
								if (s.equals("r") && x.equals("p")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("r") && x.equals("s")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("p")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("r")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("r")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("s")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}

							}
						} else {
							String x = c.makePrediction(s);
							if (user.equals(x)) {
								System.out.print("It's a Tie!");
								tieS++;
								play(x, playerS, computerS, tieS);
							} else {
								if (s.equals("r") && x.equals("p")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("r") && x.equals("s")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("p")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("r")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("r")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("s")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}

							}

						}
					}
					if (select == 3) {
						String user = "p";
						p = new Pattern(p.getPattern() + "p");
						String s = p.getPattern();
						System.out.println(s);
						if (s.length() == 3) {

							String x = c.makePrediction(s);
							c.storePattern(s);
							s = p.getPattern().substring(1,
									p.getPattern().length() - 1);
							p = new Pattern(s);
							System.out.println(x);
							if (user.equals(x)) {

								System.out.println("It's a Tie!");
								tieS++;
								play(x, playerS, computerS, tieS);
							} else {
								if (s.equals("r") && x.equals("p")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("r") && x.equals("s")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("p")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("r")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("r")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("s")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}

							}
						} else {
							String x = c.makePrediction(s);
							if (user.equals(x)) {
								System.out.print("It's a Tie!");
								tieS++;
								play(x, playerS, computerS, tieS);
							} else {
								if (s.equals("r") && x.equals("p")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("r") && x.equals("s")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("p")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("r")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("r")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("s")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}

							}

						}
					}
					if (select == 4) {

						System.out.println("Exiting..");
						quit(c);
						complete = true;
						finished = true;
					}
				} while (!complete);

				break;

			case 2:
				c = readDat();

				complete = false;
				do {
					menuRPS();
					int select = menuChoice(1, 4);

					if (select == 1) {
						String user = "r";
						p = new Pattern(p.getPattern() + "r");
						String s = p.getPattern();
						System.out.println(s);
						if (s.length() == 4) {

							String x = c.makePrediction(s);
							c.storePattern(s);
							s = p.getPattern().substring(1,
									p.getPattern().length() - 1);
							p = new Pattern(s);

							if (user.equals(x)) {

								System.out.println("It's a Tie!");
								tieS++;
								play(x, playerS, computerS, tieS);
							} else {
								if (s.equals("r") && x.equals("p")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("r") && x.equals("s")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("p")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("r")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("r")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("s")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}

							}
						} else {
							String x = c.makePrediction(s);
							if (user.equals(x)) {
								System.out.print("It's a Tie!");
								tieS++;
								play(x, playerS, computerS, tieS);
							} else {
								if (s.equals("r") && x.equals("p")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("r") && x.equals("s")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("p")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("r")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("r")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("s")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}

							}

						}
					}
					if (select == 2) {
						String user = "s";
						p = new Pattern(p.getPattern() + "s");
						String s = p.getPattern();
						System.out.println(s);
						if (s.length() == 4) {

							String x = c.makePrediction(s);
							c.storePattern(s);
							s = p.getPattern().substring(1,
									p.getPattern().length() - 1);
							p = new Pattern(s);
							System.out.println(s);
							System.out.println(x);
							if (user.equals(x)) {

								System.out.println("It's a Tie!");
								tieS++;
								play(x, playerS, computerS, tieS);
							} else {
								if (s.equals("r") && x.equals("p")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("r") && x.equals("s")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("p")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("r")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("r")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("s")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}

							}
						} else {
							String x = c.makePrediction(s);
							if (user.equals(x)) {
								System.out.print("It's a Tie!");
								tieS++;
								play(x, playerS, computerS, tieS);
							} else {
								if (s.equals("r") && x.equals("p")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("r") && x.equals("s")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("p")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("r")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("r")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("s")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}

							}

						}
					}
					if (select == 3) {
						String user = "p";
						p = new Pattern(p.getPattern() + "p");
						String s = p.getPattern();
						System.out.println(s);
						if (s.length() == 4) {

							String x = c.makePrediction(s);
							c.storePattern(s);
							s = p.getPattern().substring(1,
									p.getPattern().length() - 1);
							p = new Pattern(s);
							System.out.println(x);
							if (user.equals(x)) {

								System.out.println("It's a Tie!");
								tieS++;
								play(x, playerS, computerS, tieS);
							} else {
								if (s.equals("r") && x.equals("p")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("r") && x.equals("s")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("p")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("r")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("r")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("s")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}

							}
						} else {
							String x = c.makePrediction(s);
							if (user.equals(x)) {
								System.out.print("It's a Tie!");
								tieS++;
								play(x, playerS, computerS, tieS);
							} else {
								if (s.equals("r") && x.equals("p")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("r") && x.equals("s")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("p")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("s") && x.equals("r")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("r")) {
									System.out.println("You Win");
									playerS++;
									play(x, playerS, computerS, tieS);
								}
								if (s.equals("p") && x.equals("s")) {
									System.out.println("Computer Wins");
									computerS++;
									play(x, playerS, computerS, tieS);
								}

							}

						}
					}
					if (select == 4) {

						System.out.println("Exiting..");
						quit(c);
						complete = true;
						finished = true;
					}
				} while (!complete);

				break;

			}
		}

	}
	/**
	 * This method prints out the first menu
	 */
	public static void menu() {

		System.out.println("1. Play The most fun game!1111");
		System.out.println("2. Play on Hard mode");

	}
	/**
	 * This prints out the choices to play
	 */
	public static void menuRPS() {
		System.out.println("1. Throw Rock");
		System.out.println("2. Run with scissors");
		System.out.println("3. Paper cut");
		System.out.println("4. Exit");
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
	public static int menuChoice(int low, int high) {
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
	 * This method prints out the scores 
	 * @param x what the computer chose
	 * @param p	the player score counter
	 * @param c the computer score counter
	 * @param t	the tie score counter
	 */
	public static void play(String x, int p, int c, int t) {
		System.out.println("Computer Played " + x);
		System.out.println("Player Score: " + p + " Comp Score: " + c
				+ " Ties: " + t);
	}
	/**
	 * This method writes to the .dat file when the user decides to quit
	 * @param c the computer object to write to teh .dat
	 */
	public static void quit(Computer c) {

		File f = new File("hashMap.dat");
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(f));
			out.writeObject(c);
			out.close();
		} catch (IOException y) {
			System.out.println("Error processing file.");
		}
	}
	/**
	 * This method reads the .dat file and makes  a computer object based on the contents.
	 * It throws exceptions if there is no file or iuf the class could not be located.
	 * @return the computer object containing the information inside the .dat
	 */
	public static Computer readDat() {
		Computer h = null;
		File f = new File("hashMap.dat");
		if (f.exists()) {
			try {
				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream(f));
				h = (Computer) in.readObject();
				in.close();
			} catch (IOException e) {
				System.out.println("Error processing file.");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not find class.");
			}
		}
		return h;
	}
}
