/**
 * Provides an exception for any board state where a color does not
 * have a King.
 * 
 * @author William Forrest
 *
 */
public class NoKingException extends Exception{

	public static final long serialVersionUID = 42;
	
	@Override
	public String getMessage(){
		return "Color has no kings!";
	}
}
