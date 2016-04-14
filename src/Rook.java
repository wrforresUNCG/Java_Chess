
public class Rook extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	
	public Rook(){
		String type = "Rook";
		char symbol = 'R';
		String color;
		String curPos;
	}
	
	public Rook(String color, String curPos){
		String type = "Rook";
		char symbol = 'R';
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
