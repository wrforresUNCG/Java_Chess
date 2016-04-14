/**
 * Abstract class to serve as basis for all Pieces.
 * Holds a concept of a type, color, and current position.
 * Specifies that there are abstract methods for determining
 *     valid moves and valid captures.
 * @author Will Forrest
 *
 */
public abstract class Piece {
	
	public abstract boolean validMove();
	
	public abstract boolean validCap();
}
