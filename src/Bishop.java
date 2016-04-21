/**
 * Class representing a Bishop chess piece.
 * 
 * @author William Forrest
 *
 */
public class Bishop extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	private int curX;
	private int curY;
	
	public Bishop(){
		String type = "Bishop";
		char symbol = 'B';
		String color;
		String curPos;
		//int curX; needs a converter method
		//int curY; needs a converter method
	}
	
	public Bishop(String color, String curPos){
		String type = "Bishop";
		char symbol = getSymbol(color);
		this.color = color;
		this.curPos = curPos;
		//int curX; needs a converter method
		//int curY; needs a converter method
	}
	
	@Override
	public boolean validMove(Space[][] chessBoard, int staX, int staY, int tarX, int tarY) {		
		// A bishop moves diagonally by N spaces
		int difY = Math.abs(tarY) - Math.abs(staY);
		int difX = Math.abs(tarX) - Math.abs(staX);
		if(difX != difY) return false;
		
		int diff = difX;
		
		// Determine color of piece to be moved
		String teamOcc = chessBoard[staY][staX].piece.getColor();
		
		// Calculate Valid Move Conditions
		boolean valMov = false;
		
		// Up Left
		if(tarX < staX && tarY < staY){
			valMov = valUpLft(chessBoard, staX, staY, tarX, tarY, diff, teamOcc);
		}
		// Down Left
		else if(tarX > staX && tarY < staY){
			valMov = valDwnLft(chessBoard, staX, staY, tarX, tarY, diff, teamOcc);
		}
		// Down Right
		else if(tarX > staY && tarY > staY){
			valMov = valDwnRt(chessBoard, staX, staY, tarX, tarY, diff, teamOcc);
		}
		// Up Right
		else if(tarX < staX && tarY > staY){
			valMov = valUpRt(chessBoard, staX, staY, tarX, tarY, diff, teamOcc);
		}
		
		return valMov;
	}
	
	/**
	 * Determine if a Bishop can make a move or capture diagonally up to the left.
	 * 
	 * @param chessBoard
	 * @param staX
	 * @param staY
	 * @param tarX
	 * @param tarY
	 * @param diff
	 * @param teamOcc
	 * @return
	 */
	public boolean valUpLft(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		for(int i = 1; i < diff; i++){
				if(chessBoard[staY - i][staX - i].getSymbol() != "|_|") return false;
		}
		
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[staY - diff][staX - diff].piece.getColor().equals(teamOcc)) return false;

		return true;
	}
	
	/**
	 * Determine if a Bishop can make a move or capture diagonally up to the right.
	 * 
	 * @param chessBoard
	 * @param staX
	 * @param staY
	 * @param tarX
	 * @param tarY
	 * @param diff
	 * @param teamOcc
	 * @return
	 */
	public boolean valUpRt(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		for(int i = 1; i < diff; i++){
			if(chessBoard[staY - i][staX + i].getSymbol() != "|_|") return false;
		}
	
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[staY - diff][staX + diff].piece.getColor().equals(teamOcc)) return false;

		return true;
	}
	
	/**
	 * Determine if a Bishop can make a move or capture diagonally down to the left.
	 * 
	 * @param chessBoard
	 * @param staX
	 * @param staY
	 * @param tarX
	 * @param tarY
	 * @param diff
	 * @param teamOcc
	 * @return
	 */
	public boolean valDwnLft(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		for(int i = 1; i < diff; i++){
			if(chessBoard[staY + i][staX - i].getSymbol() != "|_|") return false;
		}
	
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[staY + diff][staX - diff].piece.getColor().equals(teamOcc)) return false;

		return true;
	}
	
	/**
	 * Determine if a Bishop can make a move or capture diagonally down to the right.
	 * 
	 * @param chessBoard
	 * @param staX
	 * @param staY
	 * @param tarX
	 * @param tarY
	 * @param diff
	 * @param teamOcc
	 * @return
	 */
	public boolean valDwnRt(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		for(int i = 1; i < diff; i++){
			if(chessBoard[staY - i][staX + i].getSymbol() != "|_|") return false;
		}
	
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[staY - diff][staX + diff].piece.getColor().equals(teamOcc)) return false;

		return true;
	}

	@Override
	public boolean validCap() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public char getSymbol(String color) {
		if(color.equals("white")) return 'B';
		return 'b';
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
		//need to implement a call to the converter
		return -1;
	}
	
	@Override
	public int getCurY(){
		//need to implement a call to the converter
		return -1;
	}
	
}
