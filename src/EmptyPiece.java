
public class EmptyPiece extends Piece{

	String type;
	char symbol;
	String color;
	String curPos;
	int curX;
	int curY;
	
	
	public EmptyPiece(int i, int j){
		this.type = "empty";
		String color = "none";
		char symbol = '_';
		String curPos;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getSymbol(String color) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCurPos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCurX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurY() {
		// TODO Auto-generated method stub
		return 0;
	}

}
