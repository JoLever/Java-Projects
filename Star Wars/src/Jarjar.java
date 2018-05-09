/**
 * This class contains all of the methods and constructor for Jarjar class.
 * It implements has force and is a subclass of person
 * @author Jordan Lever
 *
 */
public class Jarjar extends Person implements HasForce{
/**
 * This is the constructor that initializes the values
 * @param name1 The name of the Jarjar
 * @param quip 	The catch phrase of the Jarjar
 */
	public Jarjar(String name1, String quip) {
		super(name1, 250, "Fists of Fury " , quip);
		
	}
/**
 * The overwritten attack method allows for me to set the damage
 * to be from 5 - 20, and then say catch phrase after an attack.
 */
	@Override
	public void attack(Entity E) {
		int random =  (int) (Math.random()*(25) + 5) ;
		if( random >= 1){
			String nameX = getName();
			String wepX = getWeapon();
			String enemyX = E.getName();
		E.modifyHp(random);
		System.out.println(nameX + " attacks for " + random + " dmg to " + enemyX + " with " + wepX);
		sayCatchPhrase();
		
		}
		
	}
	/**
	 * This method allows for Jarjar to do a combo attack, striking 3 times
	 * @param E the target of the attack
	 */
	public void combo(Entity E) {
		int random =  (int) (Math.random()*(10) + 5) ;
		if( random >= 1){
			String nameX = getName();
			String wepX = getWeapon();
			String enemyX = E.getName();
		E.modifyHp(random);
		System.out.println(nameX + " attacks for " + random + " dmg to " + enemyX + " with" + wepX);
		sayCatchPhrase();
		
		}
		 int random2 = (int) (Math.random()*(12) + 5) ;
		 if( random2 >= 1){
				String nameX = getName();
				String wepX = getWeapon();
				String enemyX = E.getName();
			E.modifyHp(random);
			System.out.println(nameX + " attacks for " + random + " dmg to " + enemyX + " with " + wepX);
			sayCatchPhrase();
	}
		 int random3 = (int) (Math.random()*(15) + 5) ;
		 if( random3 >= 1){
				String nameX = getName();
				String wepX = getWeapon();
				String enemyX = E.getName();
			E.modifyHp(random);
			System.out.println(nameX + " attacks for " + random + " dmg to " + enemyX + " with " + wepX);
			sayCatchPhrase();
	}
		 
	}
	/**
	 * The overwritten do task generates a number that corresponds to which attack
	 * Jarjar will use
	 */
	@Override
	public void doTask(Entity e) {
		
		int choice = (int)(Math.random()*(3) +1);
		if (choice == 1){
			attack(e);
		}
		else if( choice ==2){
			useForce(e);
		}
		else if (choice ==3) {
			combo(e);
		}
		else {
			
		}
	}
/**
 * The overwritten UseForce allows Jarjar to do 25 damage to the target and 
 * then say catch phrase.
 */
	@Override
	public void useForce(Entity E) {
		int dmg = 25;
		E.modifyHp(dmg);
		String enemyX = E.getName();
		String nameX = getName();
		System.out.println(nameX + " attacks  with the force for " + dmg + " dmg to " + enemyX);
		sayCatchPhrase();

	}
	/**
	 * This method allows for JarJAR to do an AoE attack hitting all memebers of the rebel team
	 * @param array the array containing the rebel team to be damaged
	 */
	public void Aoe(Entity [] array){
		String nameX = getName();
		String enemyX = array[0].getName();
		String enemy1 = array[1].getName();
		String enemy2 = array[2].getName();
		String enemy3 = array[3].getName();
		String enemy4 = array[4].getName();
		String enemy5 = array[5].getName();
		String enemy6 = array[6].getName();
		String enemy7 = array[7].getName();
		array[0].modifyHp(10);
		System.out.println(nameX + " deals 10 dmg to "+ enemyX);
		array[1].modifyHp(10);	
		System.out.println(nameX + " deals 10 dmg to "+ enemy1);
		array[2].modifyHp(10);
		System.out.println(nameX + " deals 10 dmg to "+ enemy2);
		array[3].modifyHp(10);
		System.out.println(nameX + " deals 10 dmg to "+ enemy3);
		array[4].modifyHp(10);
		System.out.println(nameX + " deals 10 dmg to "+ enemy4);
		array[5].modifyHp(10);
		System.out.println(nameX + " deals 10 dmg to "+ enemy5);
		array[6].modifyHp(10);
		System.out.println(nameX + " deals 10 dmg to "+ enemy6);
		array[7].modifyHp(10);
		System.out.println(nameX + " deals 10 dmg to "+ enemy7);
		sayCatchPhrase();
	}

}
