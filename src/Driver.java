import java.util.*;
import java.io.*;

public class Driver {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         boolean white = true; //white pieces are capital case
        boolean black = false; //black pieces are lowercase
        boolean win = false;
        String move;
        
        Board b = new Board();
        intro();
        b.setBoardStart();
        b.printBoard();
        Scanner userInput = new Scanner(System.in);
        
        play:
        while(win == false){
            if(white == true){
                System.out.println("It is the white's turn, enter your move: ");
                move = userInput.nextLine();
                if(move.compareTo("quit") == 0){
                    break play;
                }
                //convert move to readable array coordinates, then move the piece
                b.convert(move);
                
                white = false;
                black = true;
            }
            
            else if(black == true){
                System.out.println("It is black's turn, enter your move: ");
                move = userInput.nextLine();
                if(move.compareTo("quit") == 0){
                    break play;
                }
                //convert move to readable array coordinates, then move the piece
                b.convert(move);
                
                black = false;
                white = true;
            }
            
            //display board
            b.printBoard();
        }
        
        
        System.exit(0);
        
        /*Board b = new Board();
        b.printBoard();
        b.getSpace(0, 0).symbol = "|\u03de|";
        System.out.println("");
        System.out.println("");
         b.printBoard();
         System.out.println("");
        System.out.println("");
         b.movePiece(0, 0, 7, 0);
         b.printBoard();*/
           
    }
    
    public static void intro(){
        System.out.println("A new game of chess has been started.");
        System.out.println("The white pieces are all capital letters.");
        System.out.println("The black pieces are all lowercase letters");
        System.out.println("The white players goes first.");
        System.out.println("Enter each move in the form of <start coordinate>:<end coordinate>");
        System.out.println("Type 'quit' at anytime to quit the match.");
    }
    
}
