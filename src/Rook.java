/**
 * Class representing a Rook chess piece.
 * 
 * @author William Forrest
 *
 */
public class Rook extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	private int curX;
	private int curY;
	private boolean firstMove;
	
	public Rook(){
		//String type = "Rook";
		this.type = "Rook";
		char symbol = 'R';
		String color;
		String curPos;
		this.firstMove = true;
		//int curX; needs a converter method
		//int curY; needs a converter method
	}
	
	public Rook(String color, String curPos){
		//String type = "Rook";
		this.type = "Rook";
		char symbol = getSymbol(color);
		this.color = color;
		this.curPos = curPos;
		this.firstMove = true;
		//int curX; needs a converter method
		//int curY; needs a converter method
	}
	
	@Override
	public boolean validMove(Space[][] chessBoard, int staX, int staY, int tarX, int tarY) {
		// A rook moves vertically or horizontally by N spaces
		int difY = Math.abs(tarY - staY);
		int difX = Math.abs(tarX - staX);
		
		// Determine color of a piece to be moved
		String teamOcc = chessBoard[staY][staX].piece.getColor();
		
		// Calculate Valid Move Conditions
		boolean valMov = false;
		
		// Up
		if(tarY < staY && tarX == staX){
			valMov = valUp(chessBoard, staX, staY, tarX, tarY, difY, teamOcc);
		}
		// Left
		else if(tarY == staY && tarX < staX){
			valMov = valLft(chessBoard, staX, staY, tarX, tarY, difX, teamOcc);
		}
		// Down
		else if(tarY > staY && tarX == staX){
			valMov = valDwn(chessBoard, staX, staY, tarX, tarY, difY, teamOcc);
		}
		// Right
		else if(tarY == staY && tarX > staX){
			valMov = valRt(chessBoard, staX, staY, tarX, tarY, difX, teamOcc);
		}
		if(valMov){
                    firstMove = false;
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
	
	public boolean valLft(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		//tarY == staY && tarX < staX
		for(int i = 1; i < diff; i++){
			if(!(chessBoard[staY][staX - i].piece.getColor().equals("none"))) return false;
		}
		
		// Made it to the target, is it occupied by player's own piece?
		if(chessBoard[tarY][tarX].piece.getColor().equals(teamOcc)) return false;
		
		return true;
	}
	
	public boolean valDwn(Space[][] chessBoard, int staX, int staY, int tarX, int tarY, int diff, String teamOcc){
		//tarY > staY && tarX == staX
		for(int i = 1; i < diff; i++){
			if(!(chessBoard[staY + 1][staX].piece.getColor().equals("none"))) return false;
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
	
	@Override
	public boolean validCap() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getType(){
		return this.type;
	}

	@Override
	public char getSymbol(String color) {
		if(color.equals("white")) return 'R';
		return 'r';
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
        public boolean firstMove() {
            return firstMove;
        }
}
