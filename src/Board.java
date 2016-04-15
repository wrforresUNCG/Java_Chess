import java.util.*;
import java.io.*;

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
        spaceSym = this.chessBoard[startX][startY].symbol;
        this.chessBoard[startX][startY].symbol="|_|";
        this.chessBoard[endX][endY].symbol=spaceSym;    
     }

     public void printBoard(){
         System.out.println(" --------------------------");
         
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
        Scanner in = new Scanner(pos);
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
                startX = 8 - i;
                startY = 0;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("b" + i) == 0){
                startX = 8 - i;
                startY = 1;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("c" + i) == 0){
                startX = 8 - i;
                startY = 2;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("d" + i) == 0){
                startX = 8 - i;
                startY = 3;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("e" + i) == 0){
                startX = i - 1;
                startY = 4;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("f" + i) == 0){
                startX = 8 - i;
                startY = 5;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("g" + i) == 0){
                startX = 8 - i;
                startY = 6;
            }
        }
        for(int i = 1; i < 9; i++){
            if(startPos.compareTo("h" + i) == 0){
                startX = 8 - i;
                startY = 7;
            }
        }
        
        
        //convert end position to array values
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("a" + i) == 0){
                endX = 8 - i;
                endY = 0;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("b" + i) == 0){
                endX = 8 - i;
                endY = 1;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("c" + i) == 0){
                endX = 8 - i;
                endY = 2;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("d" + i) == 0){
                endX = 8 - i;
                endY = 3;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("e" + i) == 0){
                endX = 8 - i;
                endY = 4;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("f" + i) == 0){
                endX = 8 - i;
                endY = 5;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("g" + i) == 0){
                endX = 8 - i;
                endY = 6;
            }
        }
        for(int i = 1; i < 9; i++){
            if(endPos.compareTo("h" + i) == 0){
                endX = 8 - i;
                endY = 7;
            }
        }
        
         
        
       movePiece(startX, startY, endX, endY);
    }
    
    public Space getSpace(int i, int j){
            return chessBoard[i][j];
        }
    
    public Board setBoardStart(){
    	chessBoard[0][0].setPiece(new Rook("black", "a8"));
    	chessBoard[0][1].setPiece(new Knight("black", "b8"));
    	chessBoard[0][2].setPiece(new Bishop("black", "c8"));
    	chessBoard[0][3].setPiece(new Queen("black", "d8"));
    	chessBoard[0][4].setPiece(new King("black", "e8"));
    	chessBoard[0][5].setPiece(new Bishop("black", "f8"));
    	chessBoard[0][6].setPiece(new Knight("black", "g8"));
    	chessBoard[0][7].setPiece(new Rook("black", "h8"));
    	
    	for(int i = 0; i<8; i++){
    		chessBoard[1][i].setPiece(new Pawn("black", 'a'+i + "7"));
    	}
    	
    	for(int i = 0; i<8; i++){
    		chessBoard[6][i].setPiece(new Pawn("white", 'a'+i + "2"));
    	}
    	
    	chessBoard[7][0].setPiece(new Rook("white", "a8"));
    	chessBoard[7][1].setPiece(new Knight("white", "b8"));
    	chessBoard[7][2].setPiece(new Bishop("white", "c8"));
    	chessBoard[7][3].setPiece(new Queen("white", "e8"));
    	chessBoard[7][4].setPiece(new King("white", "d8"));
    	chessBoard[7][5].setPiece(new Bishop("white", "f8"));
    	chessBoard[7][6].setPiece(new Knight("white", "g8"));
    	chessBoard[7][7].setPiece(new Rook("white", "h8"));
    	
    	return null;
    }
}
