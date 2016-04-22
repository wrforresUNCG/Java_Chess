/**
 * Class representing a Pawn chess piece.
 * 
 * @author William Forrest
 * @author Logan Rohde
 */
public class Pawn extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	private int curX;
	private int curY;
	private boolean firstMove = true;
	
	public Pawn(){
		String type = "Pawn";
		char symbol = 'P';
		String color;
		String curPos;
		//int curX; needs a converter method
		//int curY; needs a converter method
	}
	
	public Pawn(String color, String curPos){
		String type = "Pawn";
		char symbol = getSymbol(color);
		this.color = color;
		this.curPos = curPos;
		//int curX; needs a converter method
		//int curY; needs a converter method
	}
	
	@Override
	public boolean validMove(Space[][] chessBoard, int staX, int staY, int tarX, int tarY) {
		// Determine color of piece to be moved
        	String teamOcc = chessBoard[staY][staX].piece.getColor();

        	// Calculate Valid Move Conditions
        	boolean valMov = false;
	 	//Allow the pawn to move two places if it is its first move
        	if (firstMove) {

            		if (teamOcc.equals("white") && (((tarY - staY) == -1) || (tarY - staY == -2))) {
                		if (tarX == staX) {
                    			valMov = valUp(chessBoard, staX, staY, tarX, tarY, teamOcc);
                		} else if (tarX == (staX - 1)) {
                    			valMov = valUpLft(chessBoard, staX, staY, tarX, tarY, teamOcc);
                		} else if (tarX == (staX + 1)) {
                    			valMov = valUpRt(chessBoard, staX, staY, tarX, tarY, teamOcc);
                		} else {
                    			return false;
                		}
            		} //A Black Pawn moves down 1, row index increasing
            		else if (teamOcc.equals("black") && (((tarY - staY) == 1) || (tarY - staY == 2))) {
                		if (tarX == staX) {
                    			valMov = valDwn(chessBoard, staX, staY, tarX, tarY, teamOcc);
                		} else if (tarX == (staX - 1)) {
                    			valMov = valDwnLft(chessBoard, staX, staY, tarX, tarY, teamOcc);
                		} else if (tarX == (staX + 1)) {
                    			valMov = valDwnRt(chessBoard, staX, staY, tarX, tarY, teamOcc);
                		} else {
                    			return false;
                		}
            		}
            		firstMove = false;
        	} else {
            		// A White Pawn moves up 1, row index decreasing
            		if (teamOcc.equals("white") && (tarY - staY) == -1) {
                		if (tarX == staX) {
                    			valMov = valUp(chessBoard, staX, staY, tarX, tarY, teamOcc);
                		} else if (tarX == (staX - 1)) {
                			valMov = valUpLft(chessBoard, staX, staY, tarX, tarY, teamOcc);
                		} else if (tarX == (staX + 1)) {
                    			valMov = valUpRt(chessBoard, staX, staY, tarX, tarY, teamOcc);
                		} else {
                    			return false;
                		}
            		} //A Black Pawn moves down 1, row index increasing
            		else if (teamOcc.equals("black") && (tarY - staY == 1)) {
                		if (tarX == staX) {
                    			valMov = valDwn(chessBoard, staX, staY, tarX, tarY, teamOcc);
        			} else if (tarX == (staX - 1)) {
                    			valMov = valDwnLft(chessBoard, staX, staY, tarX, tarY, teamOcc);
                		} else if (tarX == (staX + 1)) {
                    			valMov = valDwnRt(chessBoard, staX, staY, tarX, tarY, teamOcc);
                		} else {
                    			return false;
                		}
            		}
            		firstMove = false;
        	}
        	firstMove = false;

        	return valMov;
	}
	
	public boolean valUp(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, String teamOcc){
		// Is it occupied by player's own piece? If yes, fail.
		if(chessBoard[tarY][tarX].piece.getColor().equals(teamOcc)) return false;
		// Space is not occupied by own piece, move is valid.
		if(!chessBoard[tarY][tarX].piece.getColor().equals("none")) return false;
		// Space is unoccupied, move is valid.
		return true;
	}
	
	public boolean valUpLft(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, String teamOcc){
		// Is it occupied by player's own piece? If yes, fail.
		if(chessBoard[tarY][tarX].piece.getColor().equals(teamOcc)) return false;
		// Space is not occupied by own piece, move is valid.
		
		if(chessBoard[tarY][tarX].piece.getColor().equals("none")) return false;
		// Space is occupied by other color, capture can be made.
		return true;
	}
	
	public boolean valUpRt(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, String teamOcc){
		// Is it occupied by player's own piece? If yes, fail.
		if(chessBoard[staY - 1][staX + 1].piece.getColor().equals(teamOcc)) return false;
		// Space is not occupied by own piece, move is valid.
		if(chessBoard[tarY][tarX].piece.getColor().equals("none")) return false;
		// Space is occupied by other color, capture can be made.
		return true;
	}
	
	public boolean valDwn(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, String teamOcc){
		//Is it occupied by player's own piece? If yes, fail.
		if(chessBoard[staY + 1][staX].piece.getColor().equals(teamOcc)) return false;
		// Space is not occupied by own piece, move is valid.
		if(!chessBoard[tarY][tarX].piece.getColor().equals("none")) return false;
		// Space is unoccupied, move is valid.
		return true;
	}
	
	public boolean valDwnLft(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, String teamOcc){
		//Is it occupied by player's own piece? If yes, fail.
		if(chessBoard[staY + 1][staX - 1].piece.getColor().equals(teamOcc)) return false;
		// Space is not occupied by own piece, move is valid.
		if(chessBoard[tarY][tarX].piece.getColor().equals("none")) return false;
		// Space is occupied by other color, capture can be made.
		return true;
	}
	
	public boolean valDwnRt(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, String teamOcc){
		//Is it occupied by player's own piece? If yes, fail.
		if(chessBoard[staY + 1][staX + 1].piece.getColor().equals(teamOcc)) return false;
		// Space is not occupied by own piece, move is valid.
		if(chessBoard[tarY][tarX].piece.getColor().equals("none")) return false;
		// Space is occupied by other color, capture can be made.
		return true;
	}

	@Override
	public boolean validCap() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public char getSymbol(String color) {
		if(color.equals("white")) return 'P';
		return 'p';
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
