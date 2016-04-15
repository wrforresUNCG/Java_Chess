
public class Pawn extends Piece{

	private String type;
	private char symbol;
	private String color;
	private String curPos;
	private int curX;
	private int curY;
	
	public Pawn(){
		String type = "Pawn";
		char symbol = 'P';
		String color;
		String curPos;
		//int curX; needs a converter method
		//int curY; needs a converter method
	}
	
	public Pawn(String color, String curPos){
		String type = "Pawn";
		char symbol = 'P';
		this.color = color;
		this.curPos = curPos;
		//int curX; needs a converter method
		//int curY; needs a converter method
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
		if(color.equals("white")) return 'P';
		return 'p';
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
		//need to implement a call to the converter
		return -1;
	}
	
	@Override
	public int getCurY(){
		//need to implement a call to the converter
		return -1;
	}
	
}
