import java.util.*;
/**
 * This class is the main where the arrays are created, their attacks cycled through until the user 
 * completes their mission.
 * @author Jordan Lever
 *
 */
public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);

		boolean finished = false;
		while (!finished) {
			System.out.println();
			Menu();
			int choice = MenuChoice(1, 3);
			switch (choice) {
			case 1:
				System.out.println("You and Your Team of Rebels Engage in Battle with the Sith Lord");
				System.out.println("Please Enter Your Jedi's Name");
				String name = scanner.nextLine();
				System.out.println("Please enter your Jedi's Saber Color");
				String color = scanner.nextLine();
				Entity[] rebel = new Entity[8];
				{
					rebel[0] = new Jedi(name,"I will bring balance to the force", color);
					rebel[1] = new Rebel("Rebel 1", " For the Alliance ");
					rebel[2] = new Rebel("Rebel 2", " For the Alliance ");
					rebel[3] = new Rebel("Rebel 3", " For the Alliance ");
					rebel[4] = new Rebel("Rebel 4", " For the Alliance ");
					rebel[5] = new Rebel("Rebel 5", " For the Alliance ");
					rebel[6] = new Astromech("R2D2    ", 20);
					rebel[7] = new Medical("GR8M8   ", 20);
				}

				Entity[] empire = new Entity[6];
				{
					empire[0] = new Stormtrooper("Stormtrooper 1",	"Aim for the Plot Armor");
					empire[1] = new Stormtrooper("Stormtrooper 2",
							"Reach For the Stars");
					empire[2] = new Stormtrooper("Stormtrooper 3",
							"For the empire");
					empire[3] = new Stormtrooper("Stormtrooper 4",
							"For the empire");
					empire[4] = new Stormtrooper("Stormtrooper 5",
							"For the empire");
					empire[5] = new SithLord("Darth Maul",
							"Embrace the Dark Side", "Red");

				}
				do {
					Menu2();
					int userChoice = MenuChoice(1, 3);
					if (userChoice == 1) {
						rebel[0].setTask("1");
						AttackMenu();
						int ac = MenuChoice(1, 6);
						printTeam(rebel, empire);
						 rebel[0].doTask(empire[ac - 1]);
						Cycle(rebel, empire);
						printTeam(rebel, empire);
						Cycle2(empire, rebel);
						printTeam(rebel, empire);

					}
					if (userChoice == 2) {
						rebel[0].setTask("2");
						AttackMenu();
						int ac = MenuChoice(1, 6);
						printTeam(rebel, empire);
						 rebel[0].doTask(empire[ac - 1]);
						Cycle(rebel, empire);
						printTeam(rebel, empire);
						Cycle2(empire, rebel);
						printTeam(rebel, empire);
					}
					if (userChoice == 3) {
						rebel[0].setTask("3");
						System.out.println();
						HealMenu();
						int healChoice = MenuChoice(0, 5);
						rebel[0].doTask(rebel[healChoice]);
						System.out.println();
						printTeam(rebel, empire);
						Cycle(rebel, empire);
						printTeam(rebel, empire);
						Cycle2(empire, rebel);
						printTeam(rebel, empire);
					}
				}

				while (empire[5].getHp() >= 0);

				break;

			case 2:
				System.out
						.println("You and Your Team of Rebels Engage in Battle with the SUPREME LEADER");
				System.out.println("Please Enter Your Jedi's Name");
				String name1 = scanner.nextLine();
				System.out.println("Please Enter Your Jedi's Saber Color");
				String color1 = scanner.nextLine();
				Entity[] rebel1 = new Entity[8];
				{
					rebel1[0] = new Jedi(name1,
							" I will bring balance to the force", color1);
					rebel1[1] = new Rebel("Rebel 1", " Stay on Target ");
					rebel1[2] = new Rebel("Rebel 2", " Stay on Target ");
					rebel1[3] = new Rebel("Rebel 3", " Stay on Target ");
					rebel1[4] = new Rebel("Rebel 4", " Stay on Target ");
					rebel1[5] = new Rebel("Rebel 5", " Stay on Target ");
					rebel1[6] = new Astromech("R2D2     ", 20);
					rebel1[7] = new Medical("GR8HL    ", 30);
				}
				Entity[] evil = new Entity[1];
				{
					evil[0] = new Jarjar("Darth Jar Jar", " Muahahahha");
				}
				do {
					Menu2();
					int userChoice = MenuChoice(1, 3);
					if (userChoice == 1) {
						rebel1[0].setTask("1");
						printTeam2(rebel1, evil);
						rebel1[0].doTask(evil[0]);
						Cycle3(rebel1, evil);
						printTeam2(rebel1, evil);
						Cycle4(evil, rebel1);
						printTeam2(rebel1, evil);
					}
					if (userChoice == 2) {
						rebel1[0].setTask("2");
						printTeam2(rebel1, evil);
						rebel1[0].doTask(evil[0]);
						Cycle3(rebel1, evil);
						printTeam2(rebel1, evil);
						Cycle4(evil, rebel1);
						printTeam2(rebel1, evil);
					}
					if (userChoice == 3) {
						rebel1[0].setTask("3");
						if(evil[0] instanceof Jarjar){
						((Jarjar) evil[0]).Aoe(rebel1);
						}
					
						System.out.println();
						HealMenu();
						int healChoice = scanner2.nextInt();
						if( rebel1[7].getHp() >0){
							rebel1[0].doTask(rebel1[healChoice]);
						printTeam2(rebel1, evil);
						Cycle3(rebel1, evil);
						printTeam2(rebel1, evil);
						Cycle4(evil, rebel1);
						printTeam2(rebel1, evil);
						}
						else{
							System.out.println("Your droid can no longer heal");
							printTeam2(rebel1, evil);
							Cycle3(rebel1, evil);
							printTeam2(rebel1, evil);
							Cycle4(evil, rebel1);
							printTeam2(rebel1, evil);
						}

					}

				} while (evil[0].getHp() >= 0);

				break;
			case 3:
				System.out.println("Exiting");
				finished = true;
				break;

			}

		}

	}
/**
 * This is the main menu
 */
	public static void Menu() {
		System.out.println("Welcome to Star Wars Interactive Scene");
		System.out.println("1. Fight the Sith Lord ");
		System.out.println("2. Fight the Supreme Leader");
		System.out.println("3. Exit");
	}
/**
 * This is a menu for the user choices
 */
	public static void Menu2() {
		System.out.println("What would you like to do");
		System.out.println("1. Attack with Lightsaber ");
		System.out.println("2. Use the Force");
		System.out.println("3. Have the droids heal a party member");
	}
/**
 * This is a menu for the attack choices
 */
	public static void AttackMenu() {
		System.out.println("Who would you like to attack");
		System.out.println("1. Stormtrooper 1 ");
		System.out.println("2. Stormtrooper 2 ");
		System.out.println("3. Stormtrooper 3 ");
		System.out.println("4. Stormtrooper 4 ");
		System.out.println("5. Stormtrooper 5 ");
		System.out.println("6. Darth Maul ");
	}
/**
 * This is a menu for the heal choices
 */
	public static void HealMenu() {
		System.out.println("Who would you like to heal");
		System.out.println("1. Rebel 1 ");
		System.out.println("2. Rebel 2 ");
		System.out.println("3. Rebel 3 ");
		System.out.println("4. Rebel 4 ");
		System.out.println("5. Rebel 5 ");
		System.out.println("0. Yourself ");
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
 * This method prints out the names of the Entities in the array and displays their hp 
 * @param array		The array containing the information to print
 */
	public static void printing(Entity[] array) {
		for (int i = 0; i < array.length; i++) {
			String x = array[i].getName();
			int y = array[i].getHp();
			if (y <= 0) {
				
			} else {
				System.out.println(x + "      " + y);
			}
		}
	}
	/**
	 * This method cycles the attacks for the rebels to run through the empire
	 * @param array  The array of the attacking team
	 * @param array1	the array containing the team being attacked
	 */
	public static void Cycle(Entity[] array, Entity[] array1) {
		for (int i = 1; i < array.length - 2; i++) {
			if (array[i].getHp() <= 0) {
				

			} else {
				int random = (int) (Math.random() * (array.length - 2));
				array[i].doTask(array1[random]);
			}
		}
	}
	/**
	 * This method cycles the attacks for the empire to run through the rebels 
	 * @param array  The array of the attacking team
	 * @param array1	the array containing the team being attacked
	 */
	public static void Cycle2(Entity[] array, Entity[] array1) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].getHp() <= 0) {
				
				
			} else {
				int random = (int) (Math.random() * (array.length));
				array[i].doTask(array1[random]);
			}
		}
	}
/**
 * This method cycles the attacks for the rebels to run through the boss 
 * @param array  The array of the attacking team
 * @param array1	the array containing the team being attacked
 */
	public static void Cycle3(Entity[] array, Entity[] array1) {
		for (int i = 1; i < array.length; i++) {
			if (array[i].getHp() <= 0) {

			} else {
				array[i].doTask(array1[0]);
			}
		}
	}
/**
 * This method cycles the attacks for The boss to run through the rebel team 
 * to choose a target.
 * @param array  The array of the attacking team
 * @param array1	the array containing the team being attacked
 */
	public static void Cycle4(Entity[] array, Entity[] array1) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].getHp() <= 0) {
				System.out.println("You defeated THE SUPREME LEADER ");
				System.out.println();

			} else {
				int random = (int) (Math.random() * (array1.length));
				array[i].doTask(array1[random]);
			}
		}
	}
	/**
	 * This is a helper method for printing out the hit points of both teams
	 * @param rebel  the array for rebel team
	 * @param empire 	  the array for empire team
	 */
	public static void printTeam(Entity[] rebel, Entity[] empire) {
		System.out.println();
		System.out.println("Rebel Team");
		System.out.println("----------");
		printing(rebel);
		System.out.println();
		System.out.println("Empire");
		System.out.println("------");
		printing(empire);
		System.out.println();
	}
/**
 * This is a helper method for printing out the hit points of both teams
 * @param rebel1  the array for rebel team
 * @param evil 	  the array for empire team
 */
	public static void printTeam2(Entity[] rebel1, Entity[] evil) {
		System.out.println();
		System.out.println("Rebel Team");
		System.out.println("----------");
		printing(rebel1);
		System.out.println();
		System.out.println("THE DARK LORD");
		System.out.println("-------------");
		printing(evil);
		System.out.println();
	}
}
