
public class Bishop extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	
	public Bishop(){
		String type = "Bishop";
		char symbol = 'B';
		String color;
		String curPos;
	}
	
	public Bishop(String color, String curPos){
		String type = "Bishop";
		char symbol = 'B';
		this.color = color;
		this.curPos = curPos;
	}
	@Override
	public boolean validMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validCap() {
		// TODO Auto-generated method stub
		return false;
	}

}
