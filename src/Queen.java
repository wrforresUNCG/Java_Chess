/**
 * Class representing a Queen chess piece.
 * 
 * @author William Forrest
 *
 */
public class Queen extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	private int curX;
	private int curY;
	
	/**
	 * Default constructor for a Queen.
	 */
	public Queen(){
		String type = "Queen";
		char symbol = 'Q';
		String color;
		String curPos;
	}
	
	/**
	 * Constructor for a Queen with provided color and position.
	 * 
	 * @param color
	 * @param curPos
	 */
	public Queen(String color, String curPos){
		this.type = "Queen";
		char symbol = getSymbol(color);
		this.color = color;
		this.curPos = curPos;
	}
	
	/**
	 * Determines if a move is valid using the Queen's movement rules.
	 */
	@Override
	public boolean validMove(Space[][] chessBoard, int staX, int staY, int tarX, int tarY) {
		// A Queen moves vertically, horizontally, or diagonally by N spaces
		int difY = Math.abs(tarY - staY);
		int difX = Math.abs(tarX - staX);
		
		// Determine color of a piece to be moved
		String teamOcc = chessBoard[staY][staX].piece.getColor();
		
		// Calculate Valid Move Conditions
		boolean valMov = false;
		int diff;
		
		// Up
		if(tarY < staY && tarX == staX){
			diff = difY;
			valMov = valUp(chessBoard, staX, staY, tarX, tarY, diff, teamOcc);
		}
		// Up Left
		else if(tarY < staY && tarX < staX){
			diff = difX;
			valMov = valUpLft(chessBoard, staX, staY, tarX, tarY, diff, teamOcc);
		}
		// Left
		else if(tarY == staY && tarX < staX){
			diff = difX;
			valMov = valLft(chessBoard, staX, staY, tarX, tarY, diff, teamOcc);
		}
		// Down Left
		else if(tarY > staY && tarX < staX){
			diff = difX;
			valMov = valDwnLft(chessBoard, staX, staY, tarX, tarY, diff, teamOcc);
		}
		// Down
		else if(tarY > staY && tarX == staX){
			diff = difY;
			valMov = valDwn(chessBoard, staX, staY, tarX, tarY, diff, teamOcc);
		}
		// Down Right
		else if(tarY > staY && tarX > staX){
			diff = difX;
			valMov = valDwnRt(chessBoard, staX, staY, tarX, tarY, diff, teamOcc);
		}
		// Right
		else if(tarY == staY && tarX > staX){
			diff = difX;
			valMov = valRt(chessBoard, staX, staY, tarX, tarY, diff, teamOcc);
		}
		// Up Right
		else if(tarY < staY && tarX > staX){
			diff = difX;
			valMov = valUpRt(chessBoard, staX, staY, tarX, tarY, diff, teamOcc);
		}
		
		return valMov;
	}
	
	public boolean valUp(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		//tarY < staY && tarX == staX
		for(int i = 1; i < diff; i++){
			if(!(chessBoard[staY - i][staX].piece.getColor().equals("none"))) return false;
		}
		
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[tarY][tarX].piece.getColor().equals(teamOcc)) return false;
		
		return true;
	}
	
	public boolean valUpLft(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		//tarY < staY && tarX < staX
		for(int i = 1; i < diff; i++){
			if(!(chessBoard[staY - i][staX - i].piece.getColor().equals("none"))) return false;
		}
		
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[tarY][tarX].piece.getColor().equals(teamOcc)) return false;
		
		return true;
	}
	
	public boolean valLft(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		//tarY == staY && tarX < staX
		for(int i = 1; i < diff; i++){
			if(!(chessBoard[staY][staX - i].piece.getColor().equals("none"))) return false;
		}
		
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[tarY][tarX].piece.getColor().equals(teamOcc)) return false;
		
		return true;
	}
	
	public boolean valDwnLft(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		//tarY > staY && tarX < staX
		for(int i = 1; i < diff; i++){
			if(!(chessBoard[staY + i][staX - i].piece.getColor().equals("none"))) return false;
		}
		
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[tarY][tarX].piece.getColor().equals(teamOcc)) return false;
		
		return true;
	}
	
	public boolean valDwn(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		//tarY > staY && tarX == staX
		for(int i = 1; i< diff; i++){
			if(!(chessBoard[staY + 1][staX].piece.getColor().equals("none"))) return false;
		}
		
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[tarY][tarX].piece.getColor().equals(teamOcc)) return false;
		
		return true;
	}
	
	public boolean valDwnRt(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		//tarY > staY && tarX > staX
		for(int i = 1; i < diff; i++){
			if(!(chessBoard[staY + i][staX + i].piece.getColor().equals("none"))) return false;
		}
		
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[tarY][tarX].piece.getColor().equals(teamOcc)) return false;
		
		return true;
	}
	
	public boolean valRt(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		//tarY == staY && tarX > staX
		for(int i = 1; i < diff; i++){
			if(!(chessBoard[staY][staX + i].piece.getColor().equals("none"))) return false;
		}
		
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[tarY][tarX].piece.getColor().equals(teamOcc)) return false;
		
		return true;
	}
	
	public boolean valUpRt(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		//tarY < staY && tarX > staX
		for(int i = 1; i < diff; i++){
			if(!(chessBoard[staY - i][staX + i].piece.getColor().equals("none"))) return false;
		}
		
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[tarY][tarX].piece.getColor().equals(teamOcc)) return false;
		
		return true;
	}
	
	@Override
	public String getType(){
		return this.type;
	}

	@Override
	public char getSymbol(String color) {
		if(color.equals("white")) return 'Q';
		return 'q';
	}
	
	@Override
	public String getColor(){
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
    	public boolean firstMove() {
        	return false;
    	}
}
