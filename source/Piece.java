class Piece {

  protected char pieceSymbol;
  protected String location;
  protected String piece_name;
  protected Board gameBoard;
  protected int playerNo;
  protected final char free = '.';

  //constructor for Pieces
  public Piece(int playerNo, Board gameBoard, String location) {
    //assigns the player who owns piece
    this.playerNo = playerNo;
    //gives it a reference to the game board
    this.gameBoard = gameBoard;
    //gives the piece an initial location
    this.location = location + (this.playerNo * 7 + 1);
  }

  //method for setting a pieces intial location
  public void initialLoc(){
    //converts to position
    int[] pos = convert(this.location);
    //sets piece on the board
    this.gameBoard.setPiece(pos[0], pos[1], this.pieceSymbol);
  }

  //Determines if a move to a location is valid for a piece
  public boolean move(String from, String to){
    int[] fromPos = convert(from);
    int[] toPos = convert(to);
    //determines if there are inValid to position locations
    if(toPos[0] == -1 || toPos[1] == -1){
      return false;
    }
    //determins if a user can move to a position
    boolean validMove = (validDesination(fromPos, toPos))? validPath(fromPos, toPos) : false;
    //changes the piece location on the board if their move was valid
    if(validMove){
      //changes their current location
      this.location = to;
      //sets piece on board
      this.gameBoard.setPiece(fromPos[0], fromPos[1], this.free);
      this.gameBoard.setPiece(toPos[0], toPos[1], this.pieceSymbol);
    }
    return validMove;
  }

  //base method for validDesination
  public boolean validDesination(int[] from, int[] to){
    return true;
  }

  //base method for validPath
  public boolean validPath(int[] from, int[] to){
    return true;
  }

  //getter method for location variable
  public String getLocation(){
    return this.location;
  }

  //converts string to array of integer coordinates
  public static int[] convert(String location){
    String[] positions = {"abcdefgh", "12345678"};
    //sets invalid location incase of invalid input
    int[] aLocation = {-1, -1};
    //sets second index
    for(int i = 0;  i < positions[0].length(); i++){
      //checks if the char are equal at a location in array
      if(positions[0].charAt(i) == location.charAt(0)){
        aLocation[0] = i;
        //one is substracted because position begin a 0 in array
      }
      //same check for second index
      if(positions[1].charAt(i) == location.charAt(1)){
        aLocation[1] = i;
        //one is substracted because position begin a 0 in array
      }
    }
    return aLocation;
  }
}
