
public class Queen extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	
	public Queen(){
		String type = "Queen";
		char symbol = 'Q';
		String color;
		String curPos;
	}
	
	public Queen(String color, String curPos){
		String type = "Queen";
		char symbol = 'Q';
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
		if(color.equals("white")) return 'Q';
		return 'q';
	}
	
	@Override
	public String getColor(){
		return this.color;
	}

}
