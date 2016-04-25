import java.util.*;
import java.io.*;

/**
 * Class for controlling functions on the chess board.
 * 
 * @author William Forrest
 * @author Logan Rohde
 * @author Rene Fernandez
 *
 */
public class Board {

	Space[][] chessBoard = new Space[8][8];
	private String startPos;
    private String endPos;
    int startX, startY, endX, endY;
    private boolean isValMov;
    
    public Board(){
        
        for(int i=0;i<chessBoard.length;i++){
            for(int j=0;j<chessBoard.length;j++){
                chessBoard[i][j]= new Space(i,j);
            }
        }
    }
    
     public void movePiece(int startX, int startY, int endX, int endY, String color){
    	 boolean isValMov = false;
    	 Piece movingP;
        movingP = this.chessBoard[startY][startX].getPiece();
        if((movingP != null) && chessBoard[startY][startX].piece.validMove(chessBoard, startX, startY, endX, endY) &&
                chessBoard[startY][startX].piece.getColor().equals(color)){
        	this.chessBoard[startY][startX].removePiece(startY, startX);
        	this.chessBoard[endY][endX].setPiece(movingP);
        	movingP.setCurX(endX);
        	movingP.setCurY(endX);
        	isValMov = true;
        }
        else {
             System.out.println("Invalid Move. You lose your turn.");
             isValMov = false;
        }
     }

     public void printBoard(){
         System.out.println("\n --------------------------");
         
          for(int i=0;i<chessBoard.length;i++){
              System.out.print(8-i+"|");
            for(int j=0;j<chessBoard.length;j++){
                System.out.printf(chessBoard[i][j].getSymbol());
            }
            System.out.println("|");
        }
          
          System.out.println(" --------------------------");
          System.out.println("   a  b  c  d  e  f  g  h");
    }
    
    public void convert(String pos, String color){
    	startX = -1;
    	startY = -1;
    	
        Scanner in = new Scanner(pos.toLowerCase());
        in.useDelimiter(":");
        String temp;
        int count = 0;
        
        parse:
        while(in.hasNext()){
            if(count == 0){
                startPos = in.next();
                count++;
            }
            else if(count == 1){
                endPos = in.next();
                count++;
            }

        }
        
        //Convert start position to array values
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("a" + i) == 0){
                startY = 8 - i;
                startX = 0;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("b" + i) == 0){
                startY = 8 - i;
                startX = 1;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("c" + i) == 0){
                startY = 8 - i;
                startX = 2;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("d" + i) == 0){
                startY = 8 - i;
                startX = 3;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("e" + i) == 0){
                startY = 8 - i;
                startX = 4;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("f" + i) == 0){
                startY = 8 - i;
                startX = 5;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("g" + i) == 0){
                startY = 8 - i;
                startX = 6;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("h" + i) == 0){
                startY = 8 - i;
                startX = 7;
            }
        }
        
        
        //convert end position to array values
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("a" + i) == 0){
                endY = 8 - i;
                endX = 0;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("b" + i) == 0){
                endY = 8 - i;
                endX = 1;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("c" + i) == 0){
                endY = 8 - i;
                endX = 2;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("d" + i) == 0){
                endY = 8 - i;
                endX = 3;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("e" + i) == 0){
                endY = 8 - i;
                endX = 4;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("f" + i) == 0){
                endY = 8 - i;
                endX = 5;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("g" + i) == 0){
                endY = 8 - i;
                endX = 6;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("h" + i) == 0){
                endY = 8 - i;
                endX = 7;
            }
        }
        
        
        boolean valIn = true;
        if(startX < 0 || startX > 7) valIn = false;
        if(startY < 0 || startY > 7) valIn = false;
        if(startX > 0 && startX < 8 && startY > 0 && startY < 8){
        	if(chessBoard[startY][startX].getSymbol().equals("|_|")) valIn = false;
        }

        //THIS BLOCK IS FOR TESTING PURPOSES
        //REMOVE IN FINAL .JAR
        if(valIn == true){
        	/////////////
        	System.out.println("***** startPos = " + startPos);
        	System.out.println("||||| endPos = " + endPos);
            System.out.println("||||| startX = " + startX);
            System.out.println("||||| startY = " + startY);
            System.out.println("||||| endX = " + endX);
            System.out.println("||||| endY = " + endY);
            System.out.println("***** NOW TO MOVE");
            /////////////
            movePiece(startX, startY, endX, endY, color);
        }

    }
    
    public Space getSpace(int i, int j){
            return chessBoard[i][j];
        }
    
    
    public Boolean kinChk(int curX, int curY){
    	// If the King is in check from any movement of an opponent's piece, return true
    	
		// Determine color of a pieces that would put King in check
    	System.out.println("Starting king Check : curXcurY " + curX + curY);
		String teamOcc = chessBoard[curY][curX].piece.getColor();
		String danger = "";
		if(teamOcc.equals("white")) danger = "black";
		else if(teamOcc.equals("black")) danger = "white";

		// Up
		System.out.println("Beginning up");
    	if(kinChkUp(curX, curY, danger)) return true;
    	// Up Left
    	System.out.println("beginning up left");
    	if(kinChkUpLft(curX, curY, danger)) return true;
    	// Left
    	System.out.println("Beginning left");
    	if(kinChkLft(curX, curY, danger)) return true;
    	// Down Left;
    	System.out.println("Beginning down left");
    	if(kinChkDwnLft(curX, curY, danger)) return true;
    	// Down
    	System.out.println("Beginning down");
    	if(kinChkDwn(curX, curY, danger)) return true;
    	// Down Right
    	System.out.println("Beginning down right");
    	if(kinChkDwnRt(curX, curY, danger)) return true;
    	// Right
    	System.out.println("Beginning right");
    	if(kinChkRt(curX, curY, danger)) return true;
    	// Up Right
    	System.out.println("Beginning up right");
    	if(kinChkUpRt(curX, curY, danger)) return true;
    	// Knight Checks
    	System.out.println("Beginning knight checks");
    	if(kinKniChk(curX, curY, danger)) return true;
    	// Nothing puts the King in check
    	return false;
    }
    
	/**
	 * Checks to see if the King is placed in check by a piece above it on the board.
	 * For a piece immediately above the King, opposing Kings, Queens, and Rooks are dangerous.
	 * Past that, only unblocked, opposing Queens and Rooks are dangerous.
	 * 
	 * @param curX
	 * @param curY
	 * @param danger
	 * @return
	 */
	public boolean kinChkUp(int curX, int curY, String danger){
		
		int i = curY;
		
		// King, Queen, and Rook are dangerous
		if(i > 0){
			if(!(chessBoard[i - 1][curX].piece.getColor().equals("none"))){
				String occCol = chessBoard[i - 1][curX].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[i - 1][curX].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'k' || occSym == 'q' || occSym == 'r')) return true;
				else return false;
			}
		}
		
		i--;
		
		// Queen and Rook are dangerous
		while(i > 0){
			if(!(chessBoard[i - 1][curX].piece.getColor().equals("none"))){
				String occCol = chessBoard[i -1][curX].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[i - 1][curX].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'q' || occSym == 'r')) return true;
				else return false;
			}
			i--;
		}

		return false;
	}
	
	/**
	 * Checks to see if the King is placed in check by a piece to its upper-left diagonal on the board.
	 * For a piece immediately to the upper-left of the King, opposing Bishops, Kings, Queens,
	 *    and Pawns(only Black) are dangerous.
	 * Past that, only unblocked, opposing Bishops and Queens are dangerous.
	 * 
	 * @param curX
	 * @param curY
	 * @param danger
	 * @return
	 */
	public boolean kinChkUpLft(int curX, int curY, String danger){

		int i = curY;
		int j = curX;
		
		// Bishop, King, Queen, and Pawn are dangerous
		if(i > 0 && j > 0){
			if(!(chessBoard[i - 1][j - 1].piece.getColor().equals("none"))){
				String occCol = chessBoard[i - 1][j - 1].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[i - 1][j - 1].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'b' || occSym == 'k' || occSym == 'q' || occSym == 'p')) return true;
				else return false;
			}
		}
		
		i--;
		j--;
		
		// Bishop and Queen are dangerous
		while(i > 0 && j > 0){
			if(!(chessBoard[i - 1][j - 1].piece.getColor().equals("none"))){
				String occCol = chessBoard[i - 1][j - 1].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[i - 1][j - 1].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'b' || occSym == 'q')) return true;
				else return false;
			}
			i--;
			j--;
		}
		
		return false;
	}
	
	/**
	 * Checks to see if the King is placed in check by a piece to its left on the board.
	 * For a piece immediately to the left of the King, opposing Kings, Queens, and Rooks are dangerous.
	 * Past that, only unblocked, opposing Queens and Rooks are dangerous.
	 * 
	 * @param curX
	 * @param curY
	 * @param danger
	 * @return
	 */
	public boolean kinChkLft(int curX, int curY, String danger){

		int j = curX;
		
		// King, Queen, and Rook are dangerous
		if(j > 0){
			if(!(chessBoard[curY][j - 1].piece.getColor().equals("none"))){
				String occCol = chessBoard[curY][j - 1].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[curY][j - 1].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'k' || occSym == 'q' || occSym == 'r')) return true;
				else return false;
			}
		}
		
		j--;
		
		// Queen and Rook are dangerous
		while(j > 0){
			if(!(chessBoard[curY][j - 1].piece.getColor().equals("none"))){
				String occCol = chessBoard[curY][j - 1].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[curY][j - 1].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'q' || occSym == 'r')) return true;
				else return false;
			}
			j--;
		}
		
		return false;
	}
	
	/**
	 * Checks to see if the King is placed in check by a piece to its lower-left diagonal on the board.
	 * For a piece immediately to the lower-left of the King, opposing Bishops, Kings, Queens,
	 *    and Pawns(only White) are dangerous
	 * Past that, only unblocked, opposing Bishops and Queens are dangerous.
	 * 
	 * @param curX
	 * @param curY
	 * @param danger
	 * @return
	 */
	public boolean kinChkDwnLft(int curX, int curY, String danger){

		int i = curY;
		int j = curX;
		
		// Bishop, King, Queen, and Pawn are dangerous
		if(i < 7 && j > 0){
			if(!(chessBoard[i + 1][j - 1].piece.getColor().equals("none"))){
				String occCol = chessBoard[i + 1][j - 1].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[i + 1][j - 1].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'b' || occSym == 'k' || occSym == 'q' || occSym == 'p')) return true;
				else return false;
			}
		}
		
		i++;
		j--;
		
		// Bishop and Queen are dangerous
		while(i < 7 && j > 0){
			if(!(chessBoard[i + 1][j - 1].piece.getColor().equals("none"))){
				String occCol = chessBoard[i + 1][j - 1].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[i + 1][j - 1].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'b' || occSym == 'q')) return true;
				else return false;
			}
			i++;
			j--;
		}
		
		return false;
	}
	
	/**
	 * Checks to see if the King is placed in check below it on the board.
	 * For a piece immediately below the King, opposing Kings, Queens, and Rooks are dangerous.
	 * Past that, only unblocked, opposing Queens and Rooks are dangerous.
	 * 
	 * @param curX
	 * @param curY
	 * @param danger
	 * @return
	 */
	public boolean kinChkDwn(int curX, int curY, String danger){

		int i = curY;
		
		// King, Queen, and Rook are dangerous
		if(i < 7){
			if(!(chessBoard[i + 1][curX].piece.getColor().equals("none"))){
				String occCol = chessBoard[i + 1][curX].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[i + 1][curX].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'k' || occSym == 'q' || occSym == 'r')) return true;
				else return false;
			}
		}
		
		i++;
		
		// Queen and Rook are dangerous
		while(i < 7){
			if(!(chessBoard[i + 1][curX].piece.getColor().equals("none"))){
				String occCol = chessBoard[i + 1][curX].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[i + 1][curX].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'q' || occSym == 'r')) return true;
				else return false;
			}
			i++;
		}
		
		return false;
	}
	
	/**
	 * Checks to see if the King is placed in check by a piece to its lower-right diagonal on the board.
	 * For a piece immediately to the lower-right of the King, opposing Bishops, Kings, Queens,
	 *    and Pawns(only White) are dangerous.
	 * Past that, only unblocked, opposing Bishops and Queens are dangerous.
	 * 
	 * @param curX
	 * @param curY
	 * @param danger
	 * @return
	 */
	public boolean kinChkDwnRt(int curX, int curY, String danger){

		int i = curY;
		int j = curX;
		
		// Bishop, King, Queen, and Pawn are dangerous
		if(i < 7 && j < 7){
			if(!(chessBoard[i + 1][j + 1].piece.getColor().equals("none"))){
				String occCol = chessBoard[i + 1][j + 1].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[i + 1][j + 1].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'b' || occSym == 'k' || occSym == 'q' || occSym == 'p')) return false;
				else return true;
			}
		}
		
		i++;
		j++;
		
		// Bishop and Queen are dangerous
		while(i < 7 && j < 7){
			if(!(chessBoard[i + 1][j + 1].piece.getColor().equals("none"))){
				String occCol = chessBoard[i + 1][j + 1].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[i + 1][j + 1].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'b'|| occSym == 'q')) return false;
				else return true;
			}
			i++;
			j++;
		}
		
		return false;
	}
	
	/**
	 * Checks to see if the King is placed in check by a piece to its right on the board.
	 * For a piece immediately to the right of the King, opposing Kings, Queens, and Rooks are dangerous.
	 * Past that, only unblocked, opposing Queens and Rooks are dangerous.
	 * 
	 * @param curX
	 * @param curY
	 * @param danger
	 * @return
	 */
	public boolean kinChkRt(int curX, int curY, String danger){

		int j = curX;
		
		// King, Queen, and Rook are dangerous
		if(j < 7){
			if(!(chessBoard[curY][j + 1].piece.getColor().equals("none"))){
				String occCol = chessBoard[curY][j + 1].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[curY][j + 1].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'k' || occSym == 'q' || occSym == 'r')) return true;
				else return false;
			}
		}
		
		j++;
		
		// Queen and Rook are dangerous
		while(j < 7){
			if(!(chessBoard[curY][j + 1].piece.getColor().equals("none"))){
				String occCol = chessBoard[curY][j + 1].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[curY][j + 1].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'q' || occSym == 'r')) return true;
				else return false;
			}
			j++;
		}
	
		return false;
		
	}
	
	/**
	 * Checks to see if the King is placed in check by a piece to its upper-right diagonal on the board.
	 * For a piece immediately to the upper-right of the King, opposing Bishops, Kings, Queens,
	 *    and Pawns(only Black) are dangerous.
	 * Past that, only unblocked, opposing Bishops and Queens are dangerous.
	 * 
	 * @param curX
	 * @param curY
	 * @param danger
	 * @return
	 */
	public boolean kinChkUpRt(int curX, int curY, String danger){

		int i = curY;
		int j = curX;
		
		// Bishop, King, Queen, and Pawn are dangerous
		if(i > 0 && j < 7){
			if(!(chessBoard[i - 1][j + 1].piece.getColor().equals("none"))){
				String occCol = chessBoard[i - 1][j + 1].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[i - 1][j + 1].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'b' || occSym == 'k' || occSym == 'q'|| occSym == 'p')) return true;
				else return false;
			}
		}
		
		i--;
		j++;
		
		// Bishop and Queen are dangerous
		while(i > 0 && j < 7){
			if(!(chessBoard[i - 1][j + 1].piece.getColor().equals("none"))){
				String occCol = chessBoard[i - 1][j + 1].piece.getColor();
				char occSym = Character.toLowerCase(chessBoard[i - 1][j + 1].piece.getSymbol(occCol));
				if(occCol == danger && (occSym == 'b' || occSym == 'q')) return true;
				else return false;
			}
			i--;
			j++;
		}
		
		return false;
	}
	
	/**
	 * Check to see if the King is placed in check by a Knight.
	 * @param curX
	 * @param curY
	 * @param danger
	 * @return
	 */
	// Knight Checks
	public boolean kinKniChk(int curX, int curY, String danger){
		
		// Up Left
		try{
			System.out.println("Blah" + chessBoard[curY - 2][curX - 1].piece.getSymbol(chessBoard[curY - 2][curX -1].piece.getColor()));
			if(Character.toLowerCase(chessBoard[curY - 2][curX - 1].piece.getSymbol(danger)) == 'n') return true;
		}
		catch(ArrayIndexOutOfBoundsException aioobe){
		}
		
		// Up Right
		try{
			if(Character.toLowerCase(chessBoard[curY - 2][curX + 1].piece.getSymbol(danger)) == 'n') return true;
		}
		catch(ArrayIndexOutOfBoundsException aioobe){
		}
		
		// Left Up
		try{
			if(Character.toLowerCase(chessBoard[curY - 1][curX - 2].piece.getSymbol(danger)) == 'n') return true;
		}
		catch(ArrayIndexOutOfBoundsException aioobe){
		}
		
		// Right Up
		try{
			if(Character.toLowerCase(chessBoard[curY - 1][curX + 2].piece.getSymbol(danger)) == 'n') return true;
		}
		catch(ArrayIndexOutOfBoundsException aioobe){
		}
		
		// Left Down
		try{
			if(Character.toLowerCase(chessBoard[curY + 1][curX - 2].piece.getSymbol(danger)) == 'n') return true;
		}
		catch(ArrayIndexOutOfBoundsException aioobe){
		}
		
		// Right Down
		try{
			if(Character.toLowerCase(chessBoard[curY + 1][curX + 2].piece.getSymbol(danger)) == 'n') return true;
		}
		catch(ArrayIndexOutOfBoundsException aioobe){
		}
		
		// Down Left
		try{
			if(Character.toLowerCase(chessBoard[curY + 2][curX - 1].piece.getSymbol(danger)) == 'n') return true;
		}
		catch(ArrayIndexOutOfBoundsException aioobe){
		}
		
		// Down Right
		try{
			if(Character.toLowerCase(chessBoard[curY + 2][curX + 1].piece.getSymbol(danger)) == 'n') return true;
		}
		catch(ArrayIndexOutOfBoundsException aioobe){
		}
		
		// No Knight puts King in check
		return false;
	}
    
    
       public boolean castleKingSide(String color) {
        if (color.equals("white")) {
            //Check if the king will be in check when moved
            if (this.chessBoard[7][4].piece.getSymbol(color) == 'K') {
                if (!(this.chessBoard[7][4].piece.firstMove())) {
                    return false;
                }
            }
            if (this.chessBoard[7][7].piece.getSymbol(color) == 'R') {
                if (!(this.chessBoard[7][7].piece.firstMove())) {
                    return false;
                }
            }
            if ((this.chessBoard[7][6].piece.getColor().equals("none"))
                    && (this.chessBoard[7][5].piece.getColor().equals("none"))) {
                Piece movingP = this.chessBoard[7][4].getPiece();
                this.chessBoard[7][4].removePiece(7, 4);
                this.chessBoard[7][6].setPiece(movingP);
                movingP = this.chessBoard[7][7].getPiece();
                this.chessBoard[7][7].removePiece(7, 7);
                this.chessBoard[7][5].setPiece(movingP);
                return true;
            }

        } 
        
        else if (color.equals("black")) {
            //Check if the king will be in check when moved
            if (this.chessBoard[0][4].piece.getSymbol(color) == 'k') {
                if (!(this.chessBoard[0][4].piece.firstMove())) {
                    return false;
                }
            }
            if (this.chessBoard[0][7].piece.getSymbol(color) == 'r') {
                if (!(this.chessBoard[0][7].piece.firstMove())) {
                    return false;
                }
            }
            if ((this.chessBoard[0][6].piece.getColor().equals("none"))
                    && (this.chessBoard[0][5].piece.getColor().equals("none"))) {
                Piece movingP = this.chessBoard[0][4].getPiece();
                this.chessBoard[0][4].removePiece(0, 4);
                this.chessBoard[0][6].setPiece(movingP);
                movingP = this.chessBoard[0][7].getPiece();
                this.chessBoard[0][7].removePiece(0, 7);
                this.chessBoard[0][5].setPiece(movingP);
                return true;
            }
        }

        isValMov = false;
        return false;

    }
    
    public boolean castleQueenSide(String color) {
        if (color.equals("white")) {
            //Check if the king will be in check when moved
            if (this.chessBoard[7][4].piece.getSymbol(color) == 'K') {
                if (!(this.chessBoard[7][4].piece.firstMove())) {
                    return false;
                }
            }
            if (this.chessBoard[7][0].piece.getSymbol(color) == 'R') {
                if (!(this.chessBoard[7][0].piece.firstMove())) {
                    return false;
                }
            }
            if ((this.chessBoard[7][1].piece.getColor().equals("none"))
                    && (this.chessBoard[7][2].piece.getColor().equals("none"))
                    && (this.chessBoard[7][3].piece.getColor().equals("none"))) {
                Piece movingP = this.chessBoard[7][4].getPiece();
                this.chessBoard[7][4].removePiece(7, 4);
                this.chessBoard[7][2].setPiece(movingP);
                movingP = this.chessBoard[7][0].getPiece();
                this.chessBoard[7][0].removePiece(7, 0);
                this.chessBoard[7][3].setPiece(movingP);
                return true;
            }
        } else if (color.equals("black")) {
            //Check if the king will be in check when moved
            if (this.chessBoard[0][4].piece.getSymbol(color) == 'k') {
                if (!(this.chessBoard[0][4].piece.firstMove())) {
                    return false;
                }
            }
            if (this.chessBoard[0][0].piece.getSymbol(color) == 'r') {
                if (!(this.chessBoard[0][0].piece.firstMove())) {
                    return false;
                }
            }
            if ((this.chessBoard[0][1].piece.getColor().equals("none"))
                    && (this.chessBoard[0][2].piece.getColor().equals("none"))
                    && (this.chessBoard[0][3].piece.getColor().equals("none"))) {
                Piece movingP = this.chessBoard[0][4].getPiece();
                this.chessBoard[0][4].removePiece(0, 4);
                this.chessBoard[0][2].setPiece(movingP);
                movingP = this.chessBoard[0][0].getPiece();
                this.chessBoard[0][0].removePiece(0, 0);
                this.chessBoard[0][3].setPiece(movingP);
                return true;
            }
        }

        isValMov = false;
        return false;
    }
    
    
    /**
     * Sets the proper pieces into place to display a starting board
     */
    public void setBoardStart(){
    	// Black-Side Back Row
    	chessBoard[0][0].setPiece(new Rook("black", "a8"));
    	chessBoard[0][1].setPiece(new Knight("black", "b8"));
    	chessBoard[0][2].setPiece(new Bishop("black", "c8"));
    	chessBoard[0][3].setPiece(new Queen("black", "d8"));
    	chessBoard[0][4].setPiece(new King("black", "e8"));
    	chessBoard[0][5].setPiece(new Bishop("black", "f8"));
    	chessBoard[0][6].setPiece(new Knight("black", "g8"));
    	chessBoard[0][7].setPiece(new Rook("black", "h8"));
    	// Black-Side Front Row
    	for(int i = 0; i<8; i++){
    		chessBoard[1][i].setPiece(new Pawn("black", 'a'+i + "7"));
    	}
    	// White-Side Front Row
    	for(int i = 0; i<8; i++){
    		chessBoard[6][i].setPiece(new Pawn("white", 'a'+i + "2"));
    	}
    	// White-Side Back Row
    	chessBoard[7][0].setPiece(new Rook("white", "a8"));
    	chessBoard[7][1].setPiece(new Knight("white", "b8"));
    	chessBoard[7][2].setPiece(new Bishop("white", "c8"));
    	chessBoard[7][3].setPiece(new Queen("white", "e8"));
    	chessBoard[7][4].setPiece(new King("white", "d8"));
    	chessBoard[7][5].setPiece(new Bishop("white", "f8"));
    	chessBoard[7][6].setPiece(new Knight("white", "g8"));
    	chessBoard[7][7].setPiece(new Rook("white", "h8"));
    }
    
    /**
     * tester board
     * @return
     */
    public void setBoardStart2(){
    	chessBoard[0][0].setPiece(new Rook("black", "a8"));
    	chessBoard[0][1].setPiece(new Queen("black", "b8"));
    	chessBoard[0][2].setPiece(new Knight("black", "c8"));
    	chessBoard[0][3].setPiece(new Pawn("black", "d8"));
    	
    	chessBoard[3][3].setPiece(new King("white", "d4"));
    }
    
    public boolean validMove() {
        return isValMov;
    }
}
