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
    
    public Board(){
        
        for(int i=0;i<chessBoard.length;i++){
            for(int j=0;j<chessBoard.length;j++){
                chessBoard[i][j]= new Space(i,j);
            }
        }
        
    }
    
     public void movePiece(int startX, int startY, int endX, int endY){
        String spaceSym;
        spaceSym = this.chessBoard[startY][startX].symbol;
        System.out.println("we're going to be moving the piece " + spaceSym + " from " + startX + startY + " to " + endX + endY);
        System.out.println(spaceSym + "'s starting X is " + startX);
        System.out.println(spaceSym + "'s starting Y is " + startY);
        
        System.out.println("That move should work: " + chessBoard[startY][startX].piece.validMove(chessBoard, startX, startY, endX, endY));
        // ADDED && CHESSBOARD[STA...
        // WAS FUNCTIONAL BEFORE ADD
        if(!(spaceSym.equals("|_|")) && chessBoard[startY][startX].piece.validMove(chessBoard, startX, startY, endX, endY)){
        	this.chessBoard[startY][startX].symbol="|_|";
        	this.chessBoard[endY][endX].symbol=spaceSym;
        	System.out.println("So we made those moves?");
        }
        else System.out.println("Wouldn't you have rather moved a piece?");
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
    
    public void convert(String pos){
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
         
//        System.out.println(startX + " " + startY);

        if(valIn == true){
        	/////////////
        	System.out.println("||||| startPos = " + startPos);
        	System.out.println("||||| endPos = " + endPos);
            System.out.println("||||| startX = " + startX);
            System.out.println("||||| startY = " + startY);
            System.out.println("||||| endX = " + endX);
            System.out.println("||||| endY = " + endY);
            System.out.println("||||| NOW TO MOVE");
            /////////////
            movePiece(startX, startY, endX, endY);
        }

    }
    
    public Space getSpace(int i, int j){
            return chessBoard[i][j];
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
}
