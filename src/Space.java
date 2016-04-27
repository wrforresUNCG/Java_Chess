/**
 * Class representing an empty space on the chess board
 * 
 * @author Rene Fernandez
 * @author William Forrest
 *
 */public class Space {
    
    int row;
    int column;
    Piece piece;
    String symbol;
    
    public Space(int i, int j){
        row = j;
        column = i;
        symbol = "|_|";
        piece = new EmptyPiece(column, row);
    }
    
    /**
     * Set a piece in the Space.
     * 
     * @param movPiece
     */
    public void setPiece(Piece movPiece){
        piece = movPiece; //set piece in space
        symbol = ("|" + piece.getSymbol(piece.getColor()) + "|");
    }
    
    public String getSymbol(){
    	return symbol;
    }
    
    public Piece getPiece(){
        return piece;
    }
    
    /**
     * Remove a piece from a specified Space
     * 
     * @param y
     * @param x
     */
    public void removePiece(int y, int x){
        piece = new EmptyPiece(y, x);
        symbol = ("|" + piece.getSymbol(piece.getColor()) + "|");
    }
}
