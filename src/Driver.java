import java.util.*;
import java.io.*;

/**
 * Driver class for the Java_Chess project.
 * Driver facilitates playing a console-based game of chess.
 * 
 * @author William Forrest
 * @author Logan Rohde
 * @author Rene Fernandez
 * @version 1.0
 */

public class Driver {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String white = "white"; //white pieces are capital case
        String black = "black"; //black pieces are lowercase
        String turnColor;
        boolean win = false;
        String move;
        
        Board b = new Board();
        intro();
        b.setBoardStart();
        b.printBoard();
        Scanner userInput = new Scanner(System.in);
        turnColor = white;
        
        play:
        while(win == false){
            
            if(turnColor.equals("white")){
                //call check; return boolean
            	int i = 0, j = 0, kinX = -1, kinY = -1;
            	boolean chkForKin = false;
            	while(chkForKin == false){
            		while(j < 8 && chkForKin == false){
            			if(b.chessBoard[i][j].piece.getSymbol(b.chessBoard[i][j].piece.getColor()) == 'K'){
            				b.chessBoard[i][j].piece.setCurX(j);
            				b.chessBoard[i][j].piece.setCurY(i);
            				kinX = b.chessBoard[i][j].piece.getCurX();
            				kinY = b.chessBoard[i][j].piece.getCurY();
            				chkForKin = true;
            			}
            			j++;
            		}
            		//if(i == 7) chkForKin = false; //if you have check through [i][j]==[7][7] there is no white King
            		i++;
            		j = 0;
            	}
            	boolean inCheck = false;
            	System.out.println("King Pos + [" + kinY + "][" + kinX + "]");
            	if(kinX > -1 && kinY > -1) inCheck = b.kinChk(kinX, kinY);
            	//if in check let the user know, and then have to get out of check
                if(inCheck == true) System.out.println("White is in check");
                
            	System.out.println("It is the white's turn, enter your move: ");
                move = userInput.nextLine().toLowerCase();
                if(move.compareTo("quit") == 0){
                    break play;
                }
                if(move.equals("0-0-0")){
                    if(b.castleQueenSide(turnColor) == false){
                        System.out.println("You cannot castle on your Queen side");
                    }
                }
                else if(move.equals("0-0")){
                    if(b.castleKingSide(turnColor) == false){
                        System.out.println("You cannot castle on your King side");
                    }
                }
                else if(move.equals("reset")){
                    System.out.println("The game has been reset.");
                    b = new Board();
                    b.setBoardStart();
                }
                else{
                    //convert move to readable array coordinates, then move the piece
                    b.convert(move, turnColor);
                    
                    if(b.validMove()){
                        pawnPromo(b, turnColor);
                        turnColor = black;
                    }
                    else{
                        System.out.println("That is not a valid move, please reenter a valid move:");
                    }
                }
                
                
                //after move
                //check Board
                    //get occurrence
                //pawn promotion
            }
            
            else if(turnColor.equals("black")){
                System.out.println("It is black's turn, enter your move: ");
                move = userInput.nextLine().toLowerCase();
                if(move.compareTo("quit") == 0){
                    break play;
                }
                if(move.equals("0-0-0")){
                    if(b.castleQueenSide(turnColor) == false){
                        System.out.println("You cannot castle on your Queen side");
                    }
                }
                else if(move.equals("0-0")){
                    if(b.castleKingSide(turnColor) == false){
                        System.out.println("You cannot castle on your King side");
                    }
                }
                else if(move.equals("reset")){
                    turnColor = white;
                    System.out.println("The game has been reset.");
                    intro();
                    b = new Board();
                    b.setBoardStart();
                }
                else{
                    //convert move to readable array coordinates, then move the piece
                    b.convert(move, turnColor);
                    
                    if(b.validMove()){
                        pawnPromo(b, turnColor);
                        turnColor = white;
                    }
                    else{
                        System.out.println("That is not a valid move, please reenter a valid move:");
                    }
                }
                
                
            }
            
            //display board
            b.printBoard();
        }
        
        
        System.exit(0);
    }
    
    public static void intro(){
        System.out.println("A new game of chess has been started.");
        System.out.println("The white pieces are all capital letters.");
        System.out.println("The black pieces are all lowercase letters");
        System.out.println("The white players goes first.");
        System.out.println("Enter each move in the form of <start coordinate>:<end coordinate>");
        System.out.println("Enter '0-0' for a king side castle and '0-0-0' for a queen side castle");
        System.out.println("Type 'quit' at anytime to quit the match.");
        
        
    }
    
    public  static void pawnPromo(Board b,String color){
        
        for (int i = 0; i < 8; i++) {
            char x;
            char xLow;
            String myPos;
            String pawnColor;
            if (color.compareTo("white") == 0) {
                System.out.println("hit here white");
                x = b.getSpace(0, i).piece.getSymbol(color);
                myPos = b.getSpace(0, i).piece.getCurPos();
                pawnColor = b.getSpace(0, i).piece.getColor();
                
            } else {
                System.out.println("hit here black");
                x = b.getSpace(7, i).piece.getSymbol(color);
                myPos = b.getSpace(7, i).piece.getCurPos();
                pawnColor = b.getSpace(7, i).piece.getColor();
            }

            xLow = Character.toLowerCase(x);
            System.out.println("char = " + xLow);
            
            if (xLow == 'p'&& color.compareTo(pawnColor)==0) {
                System.out.println("Congratulations! Please choose a promotion for your pawn"
                        + "\n Rook"
                        + "\n Kinght"
                        + "\n Bishop"
                        + "\n Queen");
                Scanner pawnPromoInput = new Scanner(System.in);
                String selection;
                selection = pawnPromoInput.nextLine();
                if (selection.toLowerCase().compareTo("rook") == 0) {
                    System.out.println("you chose a rook");
                    //String myPos;
                    //myPos = b.getSpace(0, i).piece.getCurPos();                  
                    if (color.compareTo("white") == 0) {
                        b.getSpace(0, i).setPiece(new Rook(color, myPos));
                    } else {
                        b.getSpace(7, i).setPiece(new Rook(color, myPos));
                    }
                } else if (selection.toLowerCase().compareTo("knight") == 0) {
                    System.out.println("you  choose a knight");
                    //String myPos;
                    //myPos = b.getSpace(0, i).piece.getCurPos();
                    if (color.compareTo("white") == 0) {
                        b.getSpace(0, i).setPiece(new Knight(color, myPos));
                    } else {
                        b.getSpace(7, i).setPiece(new Knight(color, myPos));
                    }
                } else if (selection.toLowerCase().compareTo("bishop") == 0) {
                    System.out.println("you  choose a Bishop");
                    //String myPos;
                    //myPos = b.getSpace(0, i).piece.getCurPos();
                    if (color.compareTo("white") == 0) {
                        b.getSpace(0, i).setPiece(new Bishop(color, myPos));
                    } else {
                        b.getSpace(7, i).setPiece(new Bishop(color, myPos));
                    }
                } else if (selection.toLowerCase().compareTo("queen") == 0) {
                    System.out.println("you  choose a Queen");
                    //String myPos;
                    //myPos = b.getSpace(0, i).piece.getCurPos();
                    if (color.compareTo("white") == 0) {
                        b.getSpace(0, i).setPiece(new Queen(color, myPos));
                    } else {
                        b.getSpace(7, i).setPiece(new Queen(color, myPos));
                    }
                } else {
                    System.out.println("TryAgain");
                    pawnPromo(b, color);
                }

            }

        }
        //end while
    }//end of pawn promo method
}
