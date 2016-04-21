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
        row = i;
        column = j;
        symbol = "|_|";
        piece = null;
    }
    
    public void setPiece(Piece movPiece){
        //is there anothe piece here? if so, capture piece
        
        piece = movPiece; //set piece in space
        symbol = ("|" + piece.getSymbol(piece.getColor()) + "|");
    }
    
    public String getSymbol(){
        return symbol;
    }
    
      public Piece getPiece(){
        return piece;
    }
    
    public void removePiece(){
        piece = null;
        symbol = "|_|";
    }
}
