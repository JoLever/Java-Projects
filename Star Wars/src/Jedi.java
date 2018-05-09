/**
 * This class contains the methods and constructor for the Jedi class.
 * It implements hasForce and Healable and is a subclass of Person.
 * @author Jordan Lever
 *
 */
public  class Jedi extends Person implements HasForce,Healable {
/**
 * This string contains the light saber color	
 */
private String saberColor;
/**
 * This is the constructor that initializes the values
 * @param name1 	The name of the Jedi
 * @param quip1		The Catch Phrase of the Jedi
 * @param sc1		The saber color of the Jedi
 */
public Jedi(String name1, String quip1, String sc1){
	
	super(name1,100," Lightsaber",quip1);
	saberColor = sc1;
}
/**
 * This method gets the saber color
 * @return the string containing the color of the lightsaber
 */
public  String getSaber(){
	return saberColor;
}
/** 
 * This is the overwritten method for attack.
 * It generates a number from 0 -20 and attacks the Entity and then says
 * catch phrase if it is  a successful attack
 */
@Override
public void attack(Entity E) {
	int random =  (int) (Math.random()*(20)) ;
	if( random >= 5){
		String nameX = getName();
		String wepX = getWeapon();
		String enemyX = E.getName();
		String scX = getSaber();
	E.modifyHp(random);
	System.out.println(nameX + " attacks for " + random + " dmg to " + enemyX + " with " + scX + ""+ wepX);
	sayCatchPhrase();
	
	}
	else {
		String nameX = getName();
		String enemyX = E.getName();
		System.out.println( nameX  + " attack missed " + enemyX);
	}
}
/**
 * The overwritten doTask checks to make sure the target of the attack or
 * useForce is a subclass of Person
 */
@Override
public void doTask(Entity e) {
	
	if (getTask() == "1"){
		attack(e);
		
	}
	else if (getTask() == "2"){
		useForce(e);
	}
	else if( getTask() == "3"){
		if(e instanceof Medical){
			((Medical) e).doTask(e);
		}
		else {
			
		}
		
	}
	else {
		
	}
	
	
}
/**
 * The overwritten heal method
 */
@Override
public void heal(int hp) {
modifyHp(hp);
	
}
/**
 * The overwritten use force allows the jedi to do 20 dmg to a target
 * and then say catch phrase
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
