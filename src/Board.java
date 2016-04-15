
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
          for(int i=0;i<chessBoard.length;i++){
              System.out.print(8-i+"|");
            for(int j=0;j<chessBoard.length;j++){
                System.out.printf(chessBoard[i][j].getSymbol());
            }
            System.out.println();
        }
          System.out.println("  |a||b||c||d||e||f||g||h|");
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
        
         
        
        
         System.out.println("The start position is: " + startX + ", " + startY);
         System.out.println("The end position is: " + endX + ", " + endY);
    }
    
    public Space getSpace(int i, int j){
            return chessBoard[i][j];
        }
    
    public void printBoard(){
          int count =0;
          for(int i=0;i<chessBoard.length;i++){
            for(int j=0;j<chessBoard.length;j++){
                System.out.printf(chessBoard[i][j].getSymbol());
            }
            System.out.println();
        }
    }
}
