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
                //boolean check = chkChk(turn color
                //if in check let the user know, and then have to get out of check
                System.out.println("It is the white's turn, enter your move: ");
                move = userInput.nextLine();
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
                else{
                    //convert move to readable array coordinates, then move the piece
                    b.convert(move);
                }
                //after move
                //check Board
                    //get occurrence
                //pawn promotion
                
                if(b.validMove()){
                    turnColor = black;
                }
                else{
                    System.out.println("That is not a valid move, please reenter a valid move:");
                }
            }
            
            else if(turnColor.equals("black")){
                System.out.println("It is black's turn, enter your move: ");
                move = userInput.nextLine();
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
                else{
                    //convert move to readable array coordinates, then move the piece
                    b.convert(move);
                }
                
                if(b.validMove()){
                    turnColor = white;
                }
                else{
                    System.out.println("That is not a valid move, please reenter a valid move:");
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
        System.out.println("Note: attempting to move a space with no piece will forfeit the turn");
        System.out.println("Type 'quit' at anytime to quit the match.");
        
        
    }
    
    public  static void pawnPromo(Board b,String color){
        for (int i = 0; i < 8; i++) {
                char x;
                char xLow;
                x = b.getSpace(0, i).piece.getSymbol(color);
                xLow = Character.toLowerCase(x);
                if (xLow == 'n') {
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
                        String myPos;
                        myPos = b.getSpace(0, i).piece.getCurPos();
                        b.getSpace(0, i).setPiece(new Rook(color, myPos));
                    } else if (selection.toLowerCase().compareTo("knight") == 0) {
                        System.out.println("you  choose a knight");
                        String myPos;
                        myPos = b.getSpace(0, i).piece.getCurPos();
                        b.getSpace(0, i).setPiece(new Knight(color, myPos));
                    } else if (selection.toLowerCase().compareTo("bishop") == 0) {
                        System.out.println("you  choose a Bishop");
                        String myPos;
                        myPos = b.getSpace(0, i).piece.getCurPos();
                        b.getSpace(0, i).setPiece(new Bishop(color, myPos));
                    } else if (selection.toLowerCase().compareTo("queen") == 0) {
                        System.out.println("you  choose a Queen");
                        String myPos;
                        myPos = b.getSpace(0, i).piece.getCurPos();
                        b.getSpace(0, i).setPiece(new Queen(color, myPos));
                    } else {
                        System.out.println("TryAgain");
                    }

                }

            }
    }//end of pawn promo method
}
