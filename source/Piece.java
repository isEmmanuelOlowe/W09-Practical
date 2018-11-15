class Piece {

  protected char pieceSymbol;
  protected String location;
  protected String piece_name;
  protected Board gameBoard;
  protected int playerNo;
  protected final char free = '.';
  public Piece(int playerNo, Board gameBoard, String location) {
    this.playerNo = playerNo;
    //gives it a reference to the game board
    this.gameBoard = gameBoard;
    //gives the piece an initial location
    this.location = location;
  }

  public void initialLoc(){
    int[] pos = convert(this.location);
    this.location = this.location.substring(0, 1) + (this.playerNo * 7 + 1);
    System.out.println(this.location);
    this.gameBoard.setPiece(pos[0], this.playerNo * 7, this.pieceSymbol);
  }
  public boolean move(String from, String to){
    int[] fromPos = convert(from);
    int[] toPos = convert(to);
    if(toPos[0] == -1){
      return false;
    }
    boolean validMove = (validDesination(fromPos, toPos))? validPath(fromPos, toPos) : false;
    if(validMove){
      this.location = to;
      this.gameBoard.setPiece(fromPos[0], fromPos[1], this.free);
      this.gameBoard.setPiece(toPos[0], toPos[1], this.pieceSymbol);
    }
    return validMove;
  }

  public boolean validDesination(int[] from, int[] to){
    return true;
  }

  public boolean validPath(int[] from, int[] to){
    return true;
  }

  public String getLocation(){
    return this.location;
  }

  public static int[] convert(String location){
    String positions = "abcdefgh";
    int[] aLocation = new int[2];
    //sets second index
    aLocation[1] = Integer.parseInt(Character.toString(location.charAt(1))) - 1;
    for(int i = 0;  i < positions.length(); i++){
      if(positions.charAt(i) == location.charAt(0)){
        aLocation[0] = i;
        //one is substracted because position begin a 0 in array
        return aLocation;
      }
    }
    aLocation[0] = -1;
    return aLocation;
  }
}
