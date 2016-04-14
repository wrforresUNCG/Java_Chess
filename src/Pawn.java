
public class Pawn extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	
	public Pawn(){
		String type = "Pawn";
		char symbol = 'P';
		String color;
		String curPos;
	}
	
	public Pawn(String color, String curPos){
		String type = "Pawn";
		char symbol = 'P';
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
