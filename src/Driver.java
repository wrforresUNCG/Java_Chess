
public class Driver {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**boolean white = true; //white pieces are capital case
        boolean black = false; //black pieces are lowercase
        boolean win = false;
        
        Board b = new Board();
        while(win == false){
            
        }**/
        
        Board b = new Board();
        b.printBoard();
        b.getSpace(0, 0).symbol = "|\u03de|";
        System.out.println("");
        System.out.println("");
         b.printBoard();
         System.out.println("");
        System.out.println("");
         b.movePiece(0, 0, 7, 0);
         b.printBoard();
           
    }
}
