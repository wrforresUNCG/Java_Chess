
public class Board {
Space[][] chessBoard = new Space[8][8];
    
    public Board(){
        
        for(int i=0;i<chessBoard.length;i++){
            for(int j=0;j<chessBoard.length;j++){
                chessBoard[i][j]= new Space(i,j);
            }
        }
        
    }
    
    public Space getSpace(int i, int j){
            return chessBoard[i][j];
        }
    
    public void printBoard(){
          int count =0;
          for(int i=0;i<chessBoard.length;i++){
            for(int j=0;j<chessBoard.length;j++){
                System.out.printf(chessBoard[i][j].getSymbol());
                count++;
                if(count == 8){
                    System.out.print("\n");
                    count =0;
                }
            }
        }
    }
}
