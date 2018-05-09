import java.io.*;
import java.util.Scanner;
import java.awt.Point;
import java.util.ArrayList;

/**
 * This is the testbench for dungeon game 
 * @author Jordan Lever
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean finished = false;
		ArrayList<Item> items = new ArrayList<Item>();
		Level l = new Level();
		EnemyGenerator e = new EnemyGenerator();
		ItemGenerator i = new ItemGenerator();
		int levelCount = 1; 
		//l.generateLevel(1);
		Hero h = null;
		
		while (!finished) {
			menu();
			int choice = menuChoice(1, 2);
			switch (choice) {
			case 1:
				System.out.println("Have you played before? 1.Yes/2.No ");
				int answer = menuChoice(1,2);
				if (answer == 1) {
					 h = readDat();
					l.generateLevel(h.getLevel());
				
					Point start = l.findStartLocation();
					h.setLocation(start);
					l.displayMap(h.getLocation());
					
				} else {
			
				System.out.println("What is your name traveler");
				String name = scanner.nextLine();
				System.out.println("What is your catch phrase");
				String quip = scanner.nextLine();
				l.generateLevel(1);
				Point start = l.findStartLocation();
				 h = new Hero(name,quip,start);
				
				Point p4 = h.getLocation();
				l.displayMap(p4);
				
				}
				boolean flag = true;
				do{
					
					travelMenu();
					int userChoice = menuChoice(1, 4);
					if (userChoice == 1) {
						
						
						if(h.goNorth(l)== 'z'){
							System.out.println("You cant go this way");
						}
						
						else {
						//h.goNorth(l);
						Point p = h.getLocation();
						l.displayMap(p);
						if(l.getRoom(p)== 'm'){
							h.display();
							Enemy en =	e.generateEnemy(h.getLevel());
							System.out.println(h.getName() + " has encountered a " + en.getName() );
							en.display();
							boolean battle = true;
							do{
								optionMenu();
								int userChoice2 = menuChoice(1,3);
								if(userChoice2 == 1){
									if(en.getHp() > 0 ){
										if(h.getHp() > 0){
										attackCycle(h,en);
										}
										else {
											System.out.println("You have died fighting");
											battle = false;
											 flag = false;
										}
										
									}
									
										else {

										fightFin(h,en);
										Item i1 = en.getItem();
										System.out.println(h.getName() + " has obtained a " + i1.getName());
										l.displayMap(p);
										boolean done = true;
										do{
											itemMenu();
											int userChoice3 = menuChoice(1,2);
											if(userChoice3 ==1 ){
												retrieveItem(h,i1);
												l.displayMap(p);
												battle = false;
												done = false;
												
												
											}
											else if(userChoice3 == 2 ){
												
												throwAway(h,i1);
												l.displayMap(p);
												battle = false;
												done = false;
												
											}
										
											else {
												
											}
				
											
										}while(done !=false);
										
										}
										
									}
								
								else if(userChoice2 == 2){
									if(h.getHp() >0){
									h.takeDamage(1);
									System.out.println(h.getName()+"takes 1 dmg");
									runAway(h,l);
									Point p1 = h.getLocation();
									l.displayMap(p1);
									
									battle = false;
									}
									else {
										System.out.println("You have died running away");
										battle =false;
										flag = false;
									}
									
								}
								else if(userChoice2 ==3){
									if(h.getItems().contains("Health Potion")){
									h.heal(5);
									System.out.println(h.getName() + " was healed for 5 ");
									}
									else{
										System.out.println("No health potions to heal!");
									}
									
								}
								else {
									
								}
								
							}while(battle  != false);
							
						}
						else if(l.getRoom(p)== 'i'){
							Item o = i.generateItem();
						
							boolean done = true;
							do{
								itemMenu();
								int userChoice3 = menuChoice(1,2);
								if(userChoice3 ==1 ){
		
									retrieveItem(h,o);	
									l.displayMap(p);
									done = false;
									
								}
								else if(userChoice3 == 2 ){
									
									throwAway(h,o);
									l.displayMap(p);
									done = false;
									
									} else {
									}
								} while (done != false);

							}
						else if(l.getRoom(p)== 'f'){
							levelCount++;
							h.increaseLevel();
							beatGame(h,levelCount);
							flag = false;

								}
						else if(l.getRoom(p)== 's'){
							if(h.getItems().size()>0){
							
								System.out.println(h.getItems().size()-1);
								System.out.println("which item would you like to sell?");
								int removed = menuChoice(0,5);
								Item itemR = h.getItems().get(removed);
								h.collectGold(itemR.getVal());
								 h.removeItem(removed);				
								 System.out.println(h.getName()+ " sold " + itemR.getName()+ " and now has " + h.getGold() + " total gold");
								
							}
							else{
								System.out.println("No items to sell");
							}
						}

							}
						}
					else if (userChoice == 2) {
						
						
						if(h.goSouth(l)== 'w'){
							System.out.println("You cant go this way");
						}
						
						else {
						//h.goSouth(l);
						Point p = h.getLocation();
						l.displayMap(p);
						if(l.getRoom(p)== 'm'){
							h.display();
							Enemy en =	e.generateEnemy(h.getLevel());
							System.out.println(h.getName() + " has encountered a " + en.getName() );
							en.display();
							boolean battle = true;
							do{
								optionMenu();
								int userChoice2 = menuChoice(1,3);
								if(userChoice2 == 1){
									if(en.getHp() > 0){
										attackCycle(h,en);
									}
									else {

										fightFin(h,en);
										Item i1 = en.getItem();
										System.out.println(h.getName() + " has obtained a " + i1.getName());
										l.displayMap(p);
										boolean done = true;
										
										do{
											itemMenu();
											int userChoice3 = menuChoice(1,2);
											if(userChoice3 ==1 ){
												
												retrieveItem(h,i1);
												l.displayMap(p);
												done = false;
												battle = false;
												
											}
											else if(userChoice3 == 2 ){
												
												throwAway(h,i1);
												l.displayMap(p);
												done = false;
												battle = false;
												
												
											}
											else {
											}
										}while(done !=false);
										}
										
									}
								
								else if(userChoice2 == 2){
									h.takeDamage(1);
									System.out.println(h.getName()+"takes 1 dmg");
									runAway(h,l);
									Point p1 = h.getLocation();
									l.displayMap(p1);
									
									battle = false;
								}
								else if(userChoice2 ==3){
									if(h.getItems().contains("Health Potion")){
									h.heal(5);
									System.out.println(h.getName() + " was healed to full ");
									}
									else{
										System.out.println("No health potions to heal!");
									}
									
								}
								else {
									
								}
								
							}while(battle  != false);
							
						}
						else if(l.getRoom(p)== 'i'){
							Item o = i.generateItem();
							
							
							boolean complete = true;
							do{
								itemMenu();
								int userChoice3 = menuChoice(1,2);
								if(userChoice3 ==1 ){
		
									retrieveItem(h,o);
									l.displayMap(p);
									complete = false;
									
								}
								else if(userChoice3 == 2 ){
									
									throwAway(h,o);
									l.displayMap(p);
									complete = false;
									
									} else {
									}
								} while (complete != false);

							}
						else if(l.getRoom(p)== 'f'){
							levelCount++;
							h.increaseLevel();
							beatGame(h,levelCount);
							flag = false;

								}
						else if(l.getRoom(p)== 's'){
							if(h.getItems().size()>0){
							
								System.out.println(h.getItems().size()-1);
								System.out.println("which item would you like to sell?");
								int removed = menuChoice(0,5);
								Item itemR = h.getItems().get(removed);
								h.collectGold(itemR.getVal());
								 h.removeItem(removed);				
		System.out.println(h.getName()+ " sold " + itemR.getName()+ " and now has " + h.getGold() + " total gold");
								l.displayMap(p);
							}
							else{
								System.out.println("No items to sell");
							}
						}

							}
						}
					else if (userChoice == 3) {
						
						
						if(h.goWest(l)== 'x'){
							System.out.println("You cant go this way");
						}
						
						else {
						//h.goWest(l);
						Point p = h.getLocation();
						l.displayMap(p);
						if(l.getRoom(p)== 'm'){
							h.display();
							Enemy en =	e.generateEnemy(levelCount);
							System.out.println(h.getName() + " has encountered a " + en.getName() );
							en.display();
							boolean battle = true;
							do{
								optionMenu();
								int userChoice2 = menuChoice(1,3);
								if(userChoice2 == 1){
									if(en.getHp() > 0){
										attackCycle(h,en);
									}
									else {
										
										fightFin(h,en);
										Item i1 = en.getItem();
										System.out.println(h.getName() + " has obtained a " + i1.getName());
										l.displayMap(p);
										boolean done = true;
										
										do{
											itemMenu();
											int userChoice3 = menuChoice(1,2);
											if(userChoice3 ==1 ){
												retrieveItem(h,i1);
												l.displayMap(p);
												done = false;
												battle = false;
												
											}
											else if(userChoice3 == 2 ){
												
												throwAway(h,i1);
												l.displayMap(p);
												done = false;
												battle = false;
												
												
											}
											else {
											}
										}while(done !=false);
										}
										
									}
								
								else if(userChoice2 == 2){
									h.takeDamage(1);
									System.out.println(h.getName()+"takes 1 dmg");
									runAway(h,l);
									Point p1 = h.getLocation();
									l.displayMap(p1);
									
									battle = false;
								}
								else if(userChoice2 ==3){
									if(h.getItems().contains("Health Potion")){
									h.heal(5);
									System.out.println(h.getName() + " was healed to full ");
									}
									else{
										System.out.println("No health potions to heal!");
									}
									
								}
								else {
									
								}
								
							}while(battle  != false);
							
						}
						else if(l.getRoom(p)== 'i'){
							Item o = i.generateItem();
							
							
							boolean complete = true;
							do{
								itemMenu();
								int userChoice3 = menuChoice(1,2);
								if(userChoice3 ==1 ){
		
									retrieveItem(h,o);	
									l.displayMap(p);
									complete = false;
									
								}
								else if(userChoice3 == 2 ){
									
									throwAway(h,o);
									l.displayMap(p);
									complete = false;
									
									} 
								} while (complete != false);

							}
						else if(l.getRoom(p)== 'f'){
							levelCount++;
							h.increaseLevel();
							beatGame(h,levelCount);
							flag = false;

								}
						else if(l.getRoom(p)== 's'){
							if(h.getItems().size()>0){
							
								System.out.println(h.getItems().size()-1);
								System.out.println("which item would you like to sell?");
								int removed = menuChoice(0,5);
								Item itemR = h.getItems().get(removed);
								h.collectGold(itemR.getVal());
								 h.removeItem(removed);				
		System.out.println(h.getName()+ " sold " + itemR.getName()+ " and now has " + h.getGold() + " total gold");
								l.displayMap(p);
							}
							else{
								System.out.println("No items to sell");
							}
						}
						

							}
						}
					else if (userChoice == 4) {
						
						
						if(h.goEast(l)== 'y'){
							System.out.println("You cant go this way");
						}
						
						else {
							
						//h.goEast(l);
						Point p = h.getLocation();
						l.displayMap(p);
						if(l.getRoom(p)== 'm'){
							h.display();
							Enemy en =	e.generateEnemy(levelCount);
							System.out.println(h.getName() + " has encountered a " + en.getName() );
							en.display();
							boolean battle = true;
							do{
								optionMenu();
								int userChoice2 = menuChoice(1,3);
								if(userChoice2 == 1){
									if(en.getHp() > 0){
										attackCycle(h,en);
									}
									else {

										fightFin(h,en);
										Item i1 = en.getItem();
										System.out.println(h.getName() + " has obtained a " + i1.getName());
										l.displayMap(p);
										boolean done = true;
										
										do{
											itemMenu();
											int userChoice3 = menuChoice(1,2);
											if(userChoice3 ==1 ){
												retrieveItem(h,i1);
												l.displayMap(p);
												done = false;
												battle = false;
												
											}
											else if(userChoice3 == 2 ){
												
												throwAway(h,i1);
												l.displayMap(p);
												done = false;
												battle = false;
												
												
											}
											else {
											}
										}while(done !=false);
										}
										
									}
								
								else if(userChoice2 == 2){
									h.takeDamage(1);
									System.out.println(h.getName()+ " takes 1 dmg");
									runAway(h,l);
									Point p1 = h.getLocation();
									l.displayMap(p1);
									
									battle = false;
								}
								else if(userChoice2 ==3){
									if(h.getItems().contains("Health Potion")){
									h.heal(5);
									System.out.println(h.getName() + " was healed to full ");
									}
									else{
										System.out.println("No health potions to heal!");
									}
									
								}
								else {
									
								}
								
							}while(battle  != false);
							
						}
						else if(l.getRoom(p)== 'i'){
							Item o = i.generateItem();
							
							
							boolean complete = true;
							do{
								itemMenu();
								int userChoice3 = menuChoice(1,2);
								if(userChoice3 ==1 ){
		
									retrieveItem(h,o);	
									complete = false;
									
								}
								else if(userChoice3 == 2 ){
									
									throwAway(h,o);
									complete = false;
									
									} else {
									}
								} while (complete != false);

							}
						else if(l.getRoom(p)== 'f'){
							levelCount++;
							h.increaseLevel();
							beatGame(h,levelCount);
							flag = false;

								}
						else if(l.getRoom(p)== 's'){
							if(h.getItems().size()>0){
							
								System.out.println(h.getItems().size()-1);
								System.out.println("which item would you like to sell?");
								int removed = menuChoice(0,5);
								Item itemR = h.getItems().get(removed);
								h.collectGold(itemR.getVal());
								 h.removeItem(removed);				
								 System.out.println(h.getName()+ " sold " + itemR.getName()+ " and now has " + h.getGold() + " total gold");
								 l.displayMap(p);
							}
							else{
								System.out.println("No items to sell");
							
							}
						}
						
							}
					}
				
				
					} while (flag != false);

				
		
		
				break;

			case 2:
				System.out.println("Exiting");
				finished = true;
				break;
			}

		}

	}
	/**
	 * This is the first menu
	 */
	public static void menu() {
		System.out.println("Welcome to the Dungeon");
		System.out.println("1. Play Game");
		System.out.println("2. Exit ");
	}
	/**
	 * This gives the travel choices
	 */
	public static void travelMenu() {
		System.out.println("Choose the direction to go");
		System.out.println("1. North");
		System.out.println("2. South");
		System.out.println("3. West");
		System.out.println("4. East");
	}
	/**
	 * The menu for choices in a monster room
	 */
	public static void optionMenu() {
		System.out.println("What do you want to do?");
		System.out.println("1. Attack!");
		System.out.println("2. Run Away");
		System.out.println("3. Use Potion");
	}
	/**
	 * The menu for choices regarding items
	 */
	public static void itemMenu() {
		System.out.println("What do you want to do with your item");
		System.out.println("1. Keep");
		System.out.println("2. Sell");
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
	 * This method generates a random number to go to a random room within the bounds
	 * @param h hero to move
	 * @param l level to move within
	 */
	public static void runAway(Hero h, Level l){
		int random =  (int) (Math.random()*(4)+1) ;
		Point p = h.getLocation();
		
		if(random == 1 && p.getX() - 1 >= 0 && p.getX() - 1 < 4){
			h.goNorth(l);
		}
		else if(random ==2 && p.getX() + 1 >= 0 && p.getX() + 1 < 4 ){
			h.goSouth(l);
		}
		else if(random ==3 && p.getY() + 1 >= 0 && p.getY() + 1 < 4){
			h.goWest(l);
		}
		else if(random == 4 && p.getY() - 1 >= 0 && p.getY() - 1 < 4){
			h.goEast(l);
		}
	}
	/**
	 * This method reads the .Dat file and makes a hero object
	 */
	public static Hero readDat(){
		Hero h = null;
		  File f = new File("hero.dat");
		  if (f.exists()) {
		   try {
		    ObjectInputStream in = new ObjectInputStream( new FileInputStream(f));
		    h = (Hero) in.readObject();
		    Point p = new Point(0,4);
		    h.setLocation(p);
		    in.close();
		   } catch (IOException e) {
		    System.out.println("Error processing file.");
		   } catch (ClassNotFoundException e) {
		    System.out.println("Could not find class.");
		   }
		  }
		  return h;
	}
	/**
	 * This method allows the user to pick up an item and display it
	 * @param h hero picking up item
	 * @param i1 item to be picked up
	 */
	public static void retrieveItem(Hero h,Item i1){
		h.pickUpItem(i1);
		System.out.println(h.getName() + " now has a " + i1.getName());
	
	}
	/**
	 * This method sells an item
	 * @param h hero selling item
	 * @param i1 item to be sold
	 */
	public static void throwAway(Hero h, Item i1){
		h.removeItem(i1);
		h.collectGold(i1.getVal());
		System.out.println(h.getName()+ " sold " + i1.getName()+ " and now has " + h.getGold() + " total gold");
	}
	/**
	 * This method ends the level and writes the hero to a .dat file
	 * @param h the hero to be written
	 * @param levelCount the counter keeping track of levels
	 */
	public static void beatGame(Hero h, int levelCount){
		System.out.println("You beat the dungeon");
		File f = new File("hero.dat");
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(h);
			out.close();
			}catch( IOException y ) {
			System.out.println("Error processing file.");
			}
			
				
	}
	/**
	 * This method displays the gold gain at the end of a fight
	 * @param h the hero gaining gold
	 * @param en the enemy giving god upon death
	 */
	public static void fightFin(Hero h, Enemy en){
		System.out.println(en.getName() + " is dead");
		h.getQuip();
		h.collectGold(en.getGold());
		System.out.println(h.getName()+ " has received "+ en.getGold() + " gold!");
		System.out.println(h.getName()	+ " has " + h.getGold()+ " total gold");
	}
	/**
	 * This method allows the user to attack and enemy to attack and then
	 * displays their hp
	 * @param h the hero attacking
	 * @param en the enemy attacking
	 */
	public static void attackCycle(Hero h,Enemy en){
		h.attack(en);
		en.attack(h);
		h.display();
		en.display();
	}
}
