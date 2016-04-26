/**
 * Class representing a Knight chess piece.
 * 
 * @author William Forrest
 *
 */
public class Knight extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	private int curX;
	private int curY;
	
	public Knight(){
		String type = "Knight";
		char symbol = 'N';
		String color;
		String curPos;
		//int curX; needs a converter method
		//int curY; needs a converter method
	}
	
	public Knight(String color, String curPos){
		this.type = "Knight";
		char symbol = getSymbol(color);
		this.color = color;
		this.curPos = curPos;
		//int curX; needs a converter method
		//int curY; needs a converter method
	}
	
	@Override
	public boolean validMove(Space[][] chessBoard, int staX, int staY, int tarX, int tarY) {
		// Knights move in L-shaped patterns where
		// if |delta_Y| = 1, then |delta_X| = 1, or
		// if |delta_Y| = 2, then |delta_X| = 2
		if(Math.abs(tarY - staY) == 1){
			if(!(Math.abs(tarX - staX) == 2)) return false;
		}
		else if(Math.abs(tarY - staY) == 2){
			if(!(Math.abs(tarX - staX) == 1)) return false;
		}
		else return false;
		
		// Determine color of piece to be moved
		String teamOcc = chessBoard[staY][staX].piece.getColor();
		
		// Is  the target occupied by player's own piece? Fail, if so.
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
		if(color.equals("white")) return 'N';
		return 'n';
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
	
	public boolean firstMove() {
            return false;
        }
	
}
