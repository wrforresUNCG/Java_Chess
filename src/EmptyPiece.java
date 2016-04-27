
public class EmptyPiece extends Piece{

	String type;
	char symbol;
	String color;
	String curPos;
	int curX;
	int curY;
	
	/**
	 * Constructor for creating a new empty piece with provided x and y coordinates
	 * 
	 * @param i
	 * @param j
	 */
	public EmptyPiece(int i, int j){
		this.type = "empty";
		this.color = "none";
		this.symbol = '_';
		this.curPos = "";
		this.curX = j;
		this.curY = i;
	}
	
	/**
	 * An Empty Piece has no valid moves
	 */
	@Override
	public boolean validMove(Space[][] chessBoard, int staX, int staY, int tarX, int tarY) {
		return false;
	}

	@Override
	public String getColor() {
		return this.color;
	}
	
	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public char getSymbol(String color) {
		return this.symbol;
	}

	@Override
	public String getCurPos() {
		return this.curPos;
	}

	@Override
	public int getCurX() {
		return this.curX;
	}

	@Override
	public int getCurY() {
		return this.curY;
	}
	
	@Override
	public void setCurX(int updCur){
		this.curX = updCur;
	}

	@Override
	public void setCurY(int updCur){
		this.curY = updCur;
	}
	
	@Override
    	public boolean firstMove() {
        	return false;
    	}
}
