class Queen extends Piece {
  private String piece_name = "QUEEN";
  private char[] color = {'♔', '♚'};

  //constructor for Knight
  public Queen(int playerNo, Board gameBoard, String location){
    //constructor of super class is called
    super(playerNo, gameBoard, location);
    //sets the piece symbol from the player number
    this.pieceSymbol = (playerNo == 0)? color[0]: color[1];
    //sets the pieces intial location
    initialLoc();
  }
}
