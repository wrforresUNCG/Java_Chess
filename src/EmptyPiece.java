
public class EmptyPiece extends Piece{

	String type;
	char symbol;
	String color;
	String curPos;
	int curX;
	int curY;
	
	
	public EmptyPiece(int i, int j){
		this.type = "empty";
		this.color = "none";
		this.symbol = '_';
		this.curPos = "";
		this.curX = j;
		this.curY = i;
	}
	
	
	@Override
	public boolean validMove(Space[][] chessBoard, int staX, int staY, int tarX, int tarY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validCap() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public char getSymbol(String color) {
		return this.symbol;
	}

	@Override
	public String getCurPos() {
		// TODO Auto-generated method stub
		return this.curPos;
	}

	@Override
	public int getCurX() {
		// TODO Auto-generated method stub
		return this.curX;
	}

	@Override
	public int getCurY() {
		// TODO Auto-generated method stub
		return this.curY;
	}

}
