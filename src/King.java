
public class King extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	
	public King(){
		String type = "King";
		char symbol = 'K';
		String color;
		String curPos;
	}
	
	public King(String color, String curPos){
		String type = "King";
		char symbol = 'K';
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
