import java.lang.Math;

class Knight extends Piece {
  private String piece_name = "KNIGHT";
  private char[] color = {'♘', '♞'};

  //constructor for Knight
  public Knight(int playerNo, Board gameBoard, String location){
    //constructor of super class is called
    super(playerNo, gameBoard, location);
    //sets the piece symbol from the player number
    this.pieceSymbol = (playerNo == 0)? color[0]: color[1];
    //sets the pieces intial location
    initialLoc();
  }

  public boolean validDesination(int[] from, int[] to){
    //determines if the location that is requested can be reached by night
    if(Math.abs(to[0] - from[0]) == 2 && Math.abs(to[1]- from[1]) == 1){
      return true;
    }
    if(Math.abs(to[1] - from[1]) == 2 && Math.abs(to[0]- from[0]) == 1){
      return true;
    }
    return false;
  }
}
