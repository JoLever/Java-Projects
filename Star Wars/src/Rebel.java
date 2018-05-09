/**
 * This class contains the constructor and methods for Rebel
 * It also implements Healable and is a subclass of Person
 * @author Jordan Lever
 *
 */
public class Rebel extends Person implements Healable{
/**
 * This is the constructor that initializes the values
 * @param name 	The name of Rebel
 * @param quip	The catch phrase of Rebel
 */
	public Rebel(String name, String quip){
		super(name,50,"Blaster",quip);
	}
/**
 * The over written attack method generates a number from 1-10
 * if the attack is successful it hits the target and says catch phrase
 */
	@Override
	public void attack(Entity e) {
		int random =  (int)( Math.random()*(10) );

		if( random >= 1){
			String enemyX = e.getName();
			String nameX = getName();
			String wepX = getWeapon();
		e.modifyHp(random);
		System.out.println(nameX + " attacks for " + random + " dmg to " + enemyX + " with " + wepX);
		sayCatchPhrase();
		
		}
		else {
			String enemyX = e.getName();
			String nameX = getName();
			String wepX = getWeapon();
		System.out.println( nameX + " attacks for 0 dmg to " + enemyX + " with " + wepX);
		}

		}
		
	
/**
 * The doTask allows the rebel to use attack if
 * the target is of instance person
 */
	@Override
	public void doTask(Entity e) {
		if (e instanceof Person){
			attack(e);
		}
		else {
			
		}
		
	}
/**
 * The overwritten heal allows the Rebel to be healed
 */
	@Override
	public void heal(int hp) {
		
	}
	
}
