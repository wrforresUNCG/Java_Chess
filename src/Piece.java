/**
 * Abstract class to serve as basis for all Pieces.
 * Holds a concept of a type, color, and current position.
 * Specifies that there are abstract methods for determining
 *     valid moves and valid captures.
 * 
 * @author Will Forrest
 *
 */
public abstract class Piece {
	
	public abstract boolean validMove(Space[][] chessBoard, int staX, int staY, int tarX, int tarY);
	
	public abstract boolean validCap();
	
	public abstract String getColor();
	
	public abstract char getSymbol(String color);
	
	public abstract String getCurPos();
	
	public abstract int getCurX();
	
	public abstract int getCurY();
	
	public abstract void setCurX(int updCur);
	
	public abstract void setCurY(int updCur);
	
}
