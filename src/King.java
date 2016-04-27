/**
 * Class representing a King chess piece.
 * 
 * @author William Forrest
 *
 */
public class King extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	private int curX;
	private int curY;
	private boolean firstMove;
	
	/**
	 * Default constructor for a King.
	 */
	public King(){
		String type = "King";
		char symbol = 'K';
		String color;
		String curPos;
		this.firstMove = true;
	}
	
	/**
	 * Constructor for a King with a provided color and position.
	 * @param color
	 * @param curPos
	 */
	public King(String color, String curPos){
		this.type = "King";
		char symbol = getSymbol(color);
		this.color = color;
		this.curPos = curPos;
		this.firstMove = true;
	}
	
	/**
	 * Determines if a move is valid using the King's movement rules.
	 */
	@Override
	public boolean validMove(Space[][] chessBoard, int staX, int staY, int tarX, int tarY) {
		// A King moves vertically, horizontally, or diagonally by 1 space.
		if(!(Math.abs(tarY - staY) == 1 || Math.abs(tarY - staY) == 0)) return false;
		if(!(Math.abs(tarX - staX) == 1 || Math.abs(tarX - staX) == 0)) return false;
		
		// Determine color of a piece to be moved
		String teamOcc = chessBoard[staY][staX].piece.getColor();
		
		// Is the target occupied by player's own piece? Fail, if so.
		if(chessBoard[tarY][tarX].piece.getColor().equals(teamOcc)) return false;
		
		firstMove = false;
		return true;
	}

	@Override
	public String getType(){
		return this.type;
	}

	@Override
	public char getSymbol(String color) {
		if(color.equals("white")) return 'K';
		return 'k';
	}

	@Override
	public String getColor() {
		return this.color;
	}
	
	@Override
	public String getCurPos(){
		return this.curPos;
	}
	
	@Override
	public int getCurX(){
		return this.curX;
	}
	
	@Override
	public int getCurY(){
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
        public boolean firstMove(){
            return firstMove;
        }

}
