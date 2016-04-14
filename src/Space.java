public class Space {
    
    int row;
    int column;
    Piece piece;
    String symbol;
    
    public Space(int i, int j){
        row = i;
        column = j;
        symbol = "|_|";
    }
    
    public void setPiece(Piece movPiece){
        //is there anothe piece here? if so, capture piece
        
        piece = movPiece; //set piece in space
        symbol = piece.symbol;
    }
    
    public String getSymbol(){
        return symbol;
    }
