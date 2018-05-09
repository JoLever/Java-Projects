/**
 * This is the interface for HasForce that allows any class that implements it to
 * use UseForce
 * @author Jordan Lever
 *
 */
public interface HasForce {
/**
 * The method that is inherited by any class that implements HasForce
 * @param E the target of force damage
 */
		public void useForce(Entity E);
}
