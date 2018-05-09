/**
 * This class contains all of the methods and constructor for Medical class.
 * It is a subclass of Droid
 * @author Jordan Lever
 *
 */
public class Medical extends Droid{
/**
 * This is the constructor for Medical that initiazlies the values
 * @param name1 the name of the medical droid
 * @param hp 	the health points of the droid
 */
	public Medical(String name1, int hp){
		super(name1 , hp, 1);
	}
/**
 * The doTask checks to see if the healing target
 * is of instance rebel or jedi.
 */
	@Override
	public void doTask(Entity e) {
		if(getHp() >0 ){
			if (getNumTasks() !=0){
				if( e instanceof Healable){
					System.out.println(e.getName() + "was healed for 20 ");
				 ((Healable) e).heal(-20);
				}
				else{
					System.out.println("Dead");
				}
			}
			
		}
		
	}
/**
 * This is the heal method that restores 20 hp to the target.
 * @param e the target of the healing
 */
	private void heal(Entity e) {
		
		String x = getName();
		String y = e.getName();	
		e.modifyHp(-20);		
		System.out.println(x  + " heals " + y + " for  20 hp" );
		
	}

}
