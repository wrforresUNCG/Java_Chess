import java.util.*;
import java.io.*;

/**
 * Driver class for the Java_Chess project.
 * Driver facilitates playing a console-based game of chess.
 * 
 * @author William Forrest
 * @author Logan Rohde
 * @author Rene Fernandez
 * @version 2.0
 */

public class Driver {
    
	/**
	 * Handles running games of chess.
	 * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String white = "white"; //white pieces are upper case
        String black = "black"; //black pieces are lower case
        String turnColor;
        boolean win = false;
        String move;
        boolean val;
        
        Board b = new Board();
        intro();
        b.setBoardStart();
        b.printBoard();
        Scanner userInput = new Scanner(System.in);
        turnColor = white;
        
        play:
        while(win == false){
            
        	gameturn:
            if(turnColor.equals("white")){

            	boolean inCheck = false;
            	// Check to see if King has been placed in check.
            	try{
            		inCheck = knInCk(b, turnColor);
            	}catch(NoKingException nke){	// No King was found, opponent has won.
            		win = true;
            		if(turnColor.equals("white")) System.out.println("Black has won!");
            		else System.out.println("White has won!");
            		break gameturn;
            	}
            	
            	// If in check let the user know.
                if(inCheck == true) System.out.println("White is in check");
                
            	System.out.println("It is the white's turn, enter your move: ");
                move = userInput.nextLine().toLowerCase();
                val = (move.contains(":") || move.contains("-"));
                // Quit Command
                if(move.compareTo("quit") == 0){
                    break play;
                }
                // Queen Side Castle Command
                if(move.equals("0-0-0")){
                    if(b.castleQueenSide(turnColor) == false){
                        System.out.println("You cannot castle on your Queen side");
                    }
                }
                // King Side Castle Command
                else if(move.equals("0-0")){
                    if(b.castleKingSide(turnColor) == false){
                        System.out.println("You cannot castle on your King side");
                    }
                }
                // Reset Command
                else if(move.equals("reset")){
                    System.out.println("The game has been reset.");
                    b = new Board();
                    b.setBoardStart();
                }
                // Concede Command
                else if(move.equals("concede")){
                	if(turnColor.equals("white")) System.out.println("Black has won!");
                	win = true;
                	break gameturn;
                }
                // Move Coordinates
                else{
                    //convert move to readable array coordinates, then move the piece
                    if(val){
                        b.convert(move, turnColor);
                    }
                }
                 if(b.validMove() && val){
                        pawnPromo(b, turnColor);
                        turnColor = black; // Change turn once a move has been made
                    }
                else{
                        System.out.println("That is not a valid move, please reenter a valid move:");
                }
                
            }
            
        	
            else if(turnColor.equals("black")){
            	
            	boolean inCheck = false;
            	
            	// Check to see if King has been placed in check.
            	try{
            		inCheck = knInCk(b, turnColor);
            	}catch(NoKingException nke){
            		win = true;
            		if(turnColor.equals("white")) System.out.println("Black has won!");
            		else System.out.println("White has won!");
            		break gameturn;
            	}
            	
            	//if in check let the user know.
                if(inCheck == true) System.out.println("Black is in check");
                
            	
                System.out.println("It is black's turn, enter your move: ");
                move = userInput.nextLine().toLowerCase();
                val = (move.contains(":") || move.contains("-"));
                // Quit Command
                if(move.compareTo("quit") == 0){
                    break play;
                }
                // Queen Side Castle Command
                if(move.equals("0-0-0")){
                    if(b.castleQueenSide(turnColor) == false){
                        System.out.println("You cannot castle on your Queen side");
                    }
                }
                // King Side Castle Command
                else if(move.equals("0-0")){
                    if(b.castleKingSide(turnColor) == false){
                        System.out.println("You cannot castle on your King side");
                    }
                }
                // Reset Command
                else if(move.equals("reset")){
                    turnColor = white;
                    System.out.println("The game has been reset.");
                    intro();
                    b = new Board();
                    b.setBoardStart();
                }
                // Concede Command
                else if(move.equals("concede")){
                	if(turnColor.equals("black")) System.out.println("White has won!");
                	win = true;
                	turnColor = white;
                	break gameturn;
                }
             // Move Coordinates
                else{
                    //convert move to readable array coordinates, then move the piece
                    if(val){
                        b.convert(move, turnColor);
                    }
                }
                if(b.validMove() && val){
                        pawnPromo(b, turnColor);
                        turnColor = white; // Change turn once a move has been made
                        
                    }
                else{
                        System.out.println("That is not a valid move, please reenter a valid move:");
                }
                
                
            }
        	b.printBoard();
        	
        	// A game has been won, provide prompts.
        	if(win == true){
            	System.out.println("Play again?");
            	if(userInput.nextLine().toLowerCase().equals("yes")){
            		b = new Board();
            		b.setBoardStart();
            		win = false;
            		intro();
            		b.printBoard();
            	}
            	else {
            		System.out.println("Thanks for playing!");
            		break;
            	}
            }
        }

        System.exit(0);
    }
    
    /**
     * Splash message for beginning a new game of Chess.
     */
    public static void intro(){
    	System.out.println("------------------------------------------------------------------------");
    	System.out.println("////////////////////////////////////////////////////////////////////////");
    	System.out.println("------------------------------------------------------------------------");
        System.out.println("A new game of chess has been started.");
        System.out.println("The white pieces are all upper case letters.");
        System.out.println("The black pieces are all lower case letters");
        System.out.println("The white players goes first.");
        System.out.println("Enter each move in the form of <start coordinate>:<end coordinate>.");
        System.out.println("Enter '0-0' for a king side castle and '0-0-0' for a queen side castle.");
        System.out.println("Type 'reset' in order to reset the game.");
        System.out.println("Type 'concede' to concede the match to the opponent.");
        System.out.println("Type 'quit' at anytime to quit the match.");
        
        
    }
    
    /**
     * Method to check if a Pawn is eligible for promotion. Black Pawns are eligible for promotion
     *    when they have reached Board Row 1 (array row 7). White Pawns are eligible for promotion
     *    when they have reached Board Row 8 (array row 0).
     * 
     * @param b
     * @param color
     */
    public  static void pawnPromo(Board b,String color){
        
    	// Check array rows 0 and 7 for Pawns
        for (int i = 0; i < 8; i++) {
            char x;
            char xLow;
            String myPos;
            String pawnColor;
            
            if (color.compareTo("white") == 0) { // Check for White Pawn at [0][i]
                x = b.getSpace(0, i).piece.getSymbol(color);
                myPos = b.getSpace(0, i).piece.getCurPos();
                pawnColor = b.getSpace(0, i).piece.getColor();
                
            } else {	// Check for Black Pawn at [7][i]
                x = b.getSpace(7, i).piece.getSymbol(color);
                myPos = b.getSpace(7, i).piece.getCurPos();
                pawnColor = b.getSpace(7, i).piece.getColor();
            }

            xLow = Character.toLowerCase(x);
            
            if (xLow == 'p' && color.compareTo(pawnColor) == 0) {
                System.out.println("Congratulations! Please choose a promotion for your pawn"
                        + "\n Rook"
                        + "\n Knight"
                        + "\n Bishop"
                        + "\n Queen");
                Scanner pawnPromoInput = new Scanner(System.in);
                String selection;
                selection = pawnPromoInput.nextLine();
                
                if (selection.toLowerCase().compareTo("rook") == 0) {
                    System.out.println("You chose a Rook"); 
                    
                    if (color.compareTo("white") == 0) {
                        b.getSpace(0, i).setPiece(new Rook(color, myPos));
                    } else {
                        b.getSpace(7, i).setPiece(new Rook(color, myPos));
                    }
                   
                } else if (selection.toLowerCase().compareTo("knight") == 0) {
                    System.out.println("You chose a Knight.");

                    if (color.compareTo("white") == 0) {
                        b.getSpace(0, i).setPiece(new Knight(color, myPos));
                    } else {
                        b.getSpace(7, i).setPiece(new Knight(color, myPos));
                    }
                    
                } else if (selection.toLowerCase().compareTo("bishop") == 0) {
                    System.out.println("You chose a Bishop.");

                    if (color.compareTo("white") == 0) {
                        b.getSpace(0, i).setPiece(new Bishop(color, myPos));
                    } else {
                        b.getSpace(7, i).setPiece(new Bishop(color, myPos));
                    }
                    
                } else if (selection.toLowerCase().compareTo("queen") == 0) {
                    System.out.println("You chose a Queen.");

                    if (color.compareTo("white") == 0) {
                        b.getSpace(0, i).setPiece(new Queen(color, myPos));
                    } else {
                        b.getSpace(7, i).setPiece(new Queen(color, myPos));
                    }
                    
                } else {
                    System.out.println("Try Again");
                    pawnPromo(b, color); // Invalid input for promotion, call method again.
                }

            }

        }
    }
    
    
    /**
     * Method begins the process of determining if a King is in check.
     * The process begins by finding the King of the current turn color.
     * The King's coordinates are then passed to a series of checking-methods in Board.
     * 
     * @param b
     * @param turnColor
     * @return
     * @throws NoKingException No King was found on the board for the color provided. A game has been lost.
     */
	public static boolean knInCk(Board b, String turnColor) throws NoKingException{
		int i = 0, j = 0, kinX = -1, kinY = -1;
		boolean chkForKin = false;
		
		while(chkForKin == false && i < 8){

			while(j < 8 && chkForKin == false){
		
				if(b.chessBoard[i][j].piece.getType().equals("King") && b.chessBoard[i][j].piece.getColor().equals(turnColor)){	
					b.chessBoard[i][j].piece.setCurX(j);
					b.chessBoard[i][j].piece.setCurY(i);
					kinX = b.chessBoard[i][j].piece.getCurX();
					kinY = b.chessBoard[i][j].piece.getCurY();
					chkForKin = true;
				}
				j++;
			}
			if(i == 7 && j == 8 && chkForKin == false){ // If no King(in color) was found at or by [7][7], there is no King in color.

				throw (new NoKingException());
			}
			
			// Rows remain to be checked. Increment i to the next row, reset j to the first column.
			i++;
			j = 0;
		}
		
		// Determine if the found King is in check
		boolean inCheck = false;
		if(kinX > -1 && kinY > -1) inCheck = b.kinChk(kinX, kinY);
	
		return inCheck;
	}
}
