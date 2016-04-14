
public class Knight extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	
	public Knight(){
		String type = "Knight";
		char symbol = 'N';
		String color;
		String curPos;
	}
	
	public Knight(String color, String curPos){
		String type = "Knight";
		char symbol = 'N';
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

	@Override
	public char getSymbol(String color) {
		if(color.equals("white")) return 'N';
		return 'n';
	}

	@Override
	public String getColor() {
		return this.color;
	}
}
