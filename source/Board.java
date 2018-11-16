public class Board {

    // The following five constants were defined in the starter code (kt54)
    private static final int  DEFAULT_SIZE = 8;
    private static final char FREE         = '.';
    private static final char WHITEROOK    = '♖';
    private static final char BLACKROOK    = '♜';
    private static final char WHITEBISHOP  = '♗';
    private static final char BLACKBISHOP  = '♝';

    // The following constants are not needed for the basic solution, but some
    // people might find them useful for extensions
    private static final char WHITEKING    = '♔';
    private static final char BLACKKING    = '♚';
    private static final char WHITEQUEEN   = '♕';
    private static final char BLACKQUEEN   = '♛';
    private static final char WHITEKNIGHT  = '♘';
    private static final char BLACKKNIGHT  = '♞';
    private static final char WHITEPAWN    = '♙';
    private static final char BLACKPAWN    = '♟';

    private int boardsize;
    private char[][] board;

    // Default constructor was provided by the starter code. Extend as needed (kt54)
    public Board() {
        this.boardsize = DEFAULT_SIZE;

        board = new char[boardsize][boardsize];

        // Clear all playable fields
        for(int x=0; x<boardsize; x++)
            for(int y=0; y<boardsize; y++)
                board[x][y] = FREE;
    }

    // Prints the board. This method was provided with the starter code. Better not modify to ensure
    // output consistent with the autochecker (kt54)
    public void printBoard() {

        // Print the letters at the top
        System.out.print(" ");
        for(int x=0; x<boardsize; x++)
            System.out.print(" " + (char)(x + 'a'));
        System.out.println();

        for(int y=0; y<boardsize; y++)
        {
            // Print the numbers on the left side
            System.out.print(8-y);

            // Print the actual board fields
            for(int x=0; x<boardsize; x++) {
                System.out.print(" ");
                char value = board[x][y];
                if(value == FREE) {
                    System.out.print(".");
                } else if(value >= WHITEKING && value <= BLACKPAWN) {
                    System.out.print(value);
                } else {
                    System.out.print("X");
                }
            }
            // Print the numbers on the right side
            System.out.println(" " + (8-y));
        }

        // Print the letters at the bottom
        System.out.print(" ");
        for(int x=0; x<boardsize; x++)
            System.out.print(" " + (char)(x + 'a'));
        System.out.print("\n\n");
    }

    //Sets a piece to a location on the board
    public void setPiece(int x, int y, char piece){
      //7 is required due to the design of the coordinate System
      //7 - y is to fact for reversed positions in array
      this.board[x][7-y] = piece;
    }
    
    //gets what is on position on the board
    public char getPos(int x, int y){
      //7 - y is to fact for reversed positions in array
      return this.board[x][7-y];
    }
}
