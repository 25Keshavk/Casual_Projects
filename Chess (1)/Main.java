import java.util.*;

public class Main {

    // Class variables
    static private Pieces[] whitePieces = new Pieces[16];
    static private Pieces[] blackPieces = new Pieces[16];

    
    public static void main(String[] args) {
        
        boolean gameOver = false;
        //System.out.println("\u2656");


        // Create a test chess piece
        //Pieces p1w = new Pieces("pawn","white",2,1,1);
        //Pieces k1w = new Pieces("knight","white",1,2,3);
        //Pieces kingw = new Pieces("king","white",1,4,10);
        for (int col=1; col<=8; col++) {
          whitePieces[col-1] = 
              new Pieces("pawn","white",2,col,1,"\u2659");
          blackPieces[col-1] = 
              new Pieces("pawn","black",7,col,1,"\u2659");
        }
        //white
        whitePieces[8] = new Pieces("rook","white",1,1,5,"\u2656");
        whitePieces[9] = new Pieces("rook","white",1,8,5,"\u2656");
        whitePieces[10] = new Pieces("knight","white",1,2,3,"\u2658");
        whitePieces[11] = new Pieces("knight","white",1,7,3,"\u2658");
        whitePieces[12] = new Pieces("bishop","white",1,3,3,"\u2657");
        whitePieces[13] = new Pieces("bishop","white",1,6,3,"\u2657");
        whitePieces[14] = new Pieces("queen","white",1,4,9,"\u2655");
        whitePieces[15] = new Pieces("king","white",1,5,10,"\u2654");
        
        //black
        blackPieces[8] = new Pieces("rook","black",8,8,5,"\u2656");
        blackPieces[9] = new Pieces("rook","black",8,1,5,"\u2656");
        blackPieces[10] = new Pieces("knight","black",8,2,3,"\u2658");
        blackPieces[11] = new Pieces("knight","black",8,7,3,"\u2658");
        blackPieces[12] = new Pieces("bishop","black",8,3,3,"\u2657");
        blackPieces[13] = new Pieces("bishop","black",8,6,3,"\u2657");
        blackPieces[14] = new Pieces("queen","black",8,4,9,"\u2655");
        blackPieces[15] = new Pieces("king","black",8,5,10,"\u2654");
        
        Scanner chessMoves = new Scanner(System.in);

        int turncounter = 1;
        boolean isWhiteTurn = true;
        
        while (gameOver == false){
            
            displayPieces(whitePieces,blackPieces);
            
            if (turncounter % 2 == 0){
                isWhiteTurn = false;
            }else{
                isWhiteTurn = true;
            }
            // Get input to move a piece
            // What should the move command look like? a2 a3 
            if (isWhiteTurn){
                System.out.println("It is white's move");
            }else{
                System.out.println("It is black's move");
            }
            System.out.println("Enter the move (for example: d2 - d4)");
            
            String userMove = chessMoves.nextLine();
            
            // "parse" the input
            int startingColumn = userMove.charAt(0) - 'a' + 1;
            int startingRow = userMove.charAt(1) - '0';
            int endingColumn = userMove.charAt(userMove.length()-2) - 'a' +1;
            int endingRow = userMove.charAt(userMove.length()-1) - '0';
            // Perhaps make the entry parsing "smarter" ??? XXXXXXXXXXXX

            // Destination must differ from starting point XXXXXX
            if (startingColumn == endingColumn && startingRow == endingRow){
                System.out.print("illegal move");
                continue;
            }



            
            // Make sure that the beginning and ending positions are within the board bounds. 
            if (startingColumn < 1 || startingColumn > 8){
                System.out.println("The column must be between a and h.");
                continue;
            }
            if (startingRow < 1 || startingRow > 8){
                System.out.println("The row must be between 1 and 8");
                continue;
            }
            if (endingColumn < 1 || endingColumn > 8){
                System.out.println("The column must be between a and h.");
                continue;
            }
            if (endingRow < 1 || endingRow > 8){
                System.out.println("The row must be between 1 and 8");
                continue;
            }
            // If it is white's move, is there a white piece at the starting location?
            if (isWhiteTurn) {
                boolean pieceFound = false;
                for (int i = 0; i < 16; i++){
                    if (whitePieces[i].getRow() == startingRow 
                        && whitePieces[i].getColumn() == startingColumn) {
                        pieceFound = true;

                        // Is the move "legal"?
                        if (!isMoveLegal(whitePieces[i],endingColumn,endingRow)) {
                            System.out.println("Not a legal move for " + whitePieces[i].getName());
                            continue;
                        } 

                        // Is the destination square empty, or contain a black piece?

                        // Is the path between the start and and clear? (Except for knights?)

                        // Move the piece
                        // If there is a black piece at the destination, capture it.
                        
                        whitePieces[i].setRow(endingRow);
                        whitePieces[i].setColumn(endingColumn);
                    }
                }
              
                if (!pieceFound) {
                    // There wasn't a white piece at the starting location.
                    System.out.println("No white piece found at that location.");
                    continue;
                }
                
            } else {
                
                boolean pieceFound = false;
                
                for (int i = 0; i < 16; i++){
                    
                    if (blackPieces[i].getRow() == startingRow 
                        && blackPieces[i].getColumn() == startingColumn) {
                        pieceFound = true;

                        // Is the move "legal"?

                        // Is the destination square empty, or contain a black piece?

                        // Is the path between the start and and clear? (Except for knights?)

                        // Move the piece
                        blackPieces[i].setRow(endingRow);
                        blackPieces[i].setColumn(endingColumn);
                    }
                }
              
                if (!pieceFound) {
                    // There wasn't a white piece at the starting location.
                    System.out.println("No black piece found at that location.");
                    continue;

                }

            
            }
          
            // Same for black.
            
            // Is the move even "legal"?
            
            
            
            // See if there is a piece at the starting location
            
            for (int i = 0; i < 16; i++){
              if (blackPieces[i].getRow() == startingRow 
                  && blackPieces[i].getColumn() == startingColumn) {
                  blackPieces[i].setRow(endingRow);
                  blackPieces[i].setColumn(endingColumn);
              }
            }
            turncounter ++;
        }    
        
        chessMoves.close(); // close scanner
    
        
    }


    public static void displayPieces(Pieces[] white, Pieces[] black) {

        String ANSI_RESET = "\u001B[0m";
        // Declaring the background color
        String ANSI_WHITE = "\u001B[97m";
        String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        String ANSI_WHITE_BACKGROUND = "\u001B[107m";
        String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_YELLOW_BACKGROUND = "\u001b[44m";
        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_BOLD = "\u001B[1m";

        String BACKGROUND_1 = ANSI_YELLOW_BACKGROUND;
        String BACKGROUND_2 = ANSI_RED_BACKGROUND;

        String pieceString = "";
        
        for (int row = 1; row <= 8; row++) {
            
            for (int column = 1; column <=8; column++) {

                pieceString = " ";
                if ((  row+column) % 2 == 1) {
                    System.out.print(BACKGROUND_1);
                } else {
                    System.out.print(BACKGROUND_2);
                }
                // Insert a piece here ????
                for (Pieces p : white) {
                    if (p.row == row && p.column == column) {
                        pieceString = ANSI_WHITE 
                            + ANSI_BOLD 
                            + p.shape;
                    }
                }
                for(Pieces f : black) {
                  if (f.row == row && f.column == column){
                    pieceString = ANSI_BLACK 
                      + ANSI_BOLD 
                      +  f.shape;
                  }
                }
         
                System.out.print(" " + pieceString + " " + ANSI_RESET);
            }
            System.out.println(" "+ row);
                
        }

        // Print letters underneath board to indicate rows

        System.out.println(" a  b  c  d  e  f  g  h");
      
    }  


    public static boolean isMoveLegal(Pieces p, int endingColumn, int endingRow ) {

        switch (p.getName()) {

            case "pawn":
                if (p.getColor() == "white") {

                    // Moving one row forward is legal
                    if (endingColumn == p.getColumn() 
                        && endingRow == p.getRow()+1) return true;

                    // Moving two rows is legal on the pawn's first move
                    if (p.hasMoved == false 
                        && endingColumn == p.getColumn() 
                        && endingRow == p.getRow()+2) return true;

                    // Moving diagonal is legal only to capture
                    // Need to see if a black piece is at the destination
                    if (Math.abs(endingColumn - p.getColumn()) == 1 
                        && endingRow == p.getRow() + 1 ) {
                        // Is there a black piece at the destination?
                        Pieces dest_p = checksquare(endingColumn,endingRow);
                        if (dest_p == null) return false; // no piece at the location
                        if (dest_p.getColor() == "black") return true;
                        return false;
                    }

                    // Need to figure out en pessant XXXXXX

                    
                } else {

                    
                }

                
            case "rook":
                if (endingRow != p.getRow() && endingColumn != p.getColumn()) {
                    return false;
                } else {
                    return true;
                }
                
            case "bishop":
                return true;

            case "queen":
                return true;
                
        }
        return true;
      

    }






    public static Pieces checksquare(int column, int row){

        // Loop through both pieces arrays.
        // See if there is a piece at the column and row.
        // If so, return the piece.
        for (Pieces p : whitePieces) {
            if (p.getRow() == row && p.getColumn() == column) return p;
        }
        for (Pieces p : blackPieces){
          if (p.getRow() == row && p.getColumn() == column)
            return p;
        }

        // Otherwise return null.
        return null;
      
    }
    
}

