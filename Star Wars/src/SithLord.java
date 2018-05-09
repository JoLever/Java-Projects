/**
 * This class contains the constructor and methods for the Sithlord class
 * It implements Has force and is a subclass of Person
 * @author Jordan Lever
 *
 */
public class SithLord extends  Person implements HasForce{
	
/**
 * This is the saber color
 */
	
private String saberColor;

/**
 * This is the constructor to initialize values
 * @param name1 the name of the sith lord
 * @param quip1 The catch phrase of the sith lord
 * @param Sc1 the color of the lightsaber
 */
	public SithLord(String name1, String quip1, String Sc1) {
		super(name1, 100, " Lightsaber", quip1);
		saberColor = Sc1;
	}
/**
 * This is overwritten attack method that generates a number form 0 to 20
 * if the attack is successful it prints the catch phrase
 */
	@Override
	public void attack(Entity E) {
		int random =  (int) (Math.random()*(20)) ;
		if( random >= 1){
			String nameX = getName();
			String wepX = getWeapon();
			String enemyX = E.getName();
			String colorX = getSaber();
		E.modifyHp(random);
		System.out.println(nameX + " attacks for " + random + " dmg to " + enemyX + " with " + colorX + " "+ wepX);
		sayCatchPhrase();
		
		}
		else {
			String nameX = getName();
			String enemyX = E.getName();
		System.out.println( nameX + " attacks for 0 dmg to " + enemyX);
		}
	}
/**
 * The over written doTask generates a number to decide which attack to user
 * then it checks to make sure that the target is an instance of person
 */
	@Override
	public void doTask(Entity e) {
		
		int choice = (int)(Math.random()*(2 +1));
	if (choice == 1){
		if( e instanceof Person){
		attack(e);
		}
		else {
			
		}
	}
	else if (choice ==2){
		if ( e instanceof Person){
		useForce(e);
		}
		else{
			
		}
	}
		
	}
	/**
	 * This method gets the saber color
	 * @return the string containing saber color
	 */
	public  String getSaber(){
		return saberColor;
	}
/**
 * The overwritten UseForce allows the sith lord to do 20 dmg to a target and then say
 * catch phrase
 */
	@Override
	public void useForce(Entity E) {
		int dmg = 20;
		E.modifyHp(dmg);
			String nameX = getName();
			String enemyX = E.getName();
		System.out.println(nameX + " attacks  with the force for " + dmg + " dmg to " + enemyX);
		sayCatchPhrase();
		
		
	}
}
