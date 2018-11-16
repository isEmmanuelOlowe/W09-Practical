class Rook extends Piece {
  private String piece_name = "ROOK";
  private char[] color = {'♖', '♜'};

  //constructor for Rook
  public Rook(int playerNo, Board gameBoard, String location){
    //constructor of super class is called
    super(playerNo, gameBoard, location);
    //sets the piece symbol from the player number
    this.pieceSymbol = (playerNo == 0)? color[0]: color[1];
    //sets the pieces intial location
    initialLoc();
  }
  public boolean validDesination(int[] from, int[] to){
    //determines if it is possible for a rook to move to a location
    //one axis value must remain constant since on vertical or horizontal motion
    if(from[0] == to[0] || from[1] == to[1]){
      return true;
    }
    return false;
  }

  //determines if there are pieces block path
  //runs recursively
  public boolean validPath(int[] from, int[] to){
    //stores positions
    int[] pos = new int[2];
    //determines which axis rook is being moved on
    int axis = (from[0] != to[0])? 0 : 1;
    //this is axis not being moved
    int nAxis = (axis == 0)? 1 : 0;
    //determines if they are moving back or forth
    int step = (to[axis] - from[axis] >= 0)? 1 : -1;
    //stores position of next location on board to destination
    pos[axis] = step + from[axis];
    pos[nAxis] = from[nAxis];
    //means that all spaces up to location are free
    if(pos[axis] == to[axis]){
      return true;
    }
    //checks path is not being blocked
    if(this.gameBoard.getPos(pos[0], pos[1]) == this.FREE){
      //runs the method for next position
      return this.validPath(pos, to);
    }
    return false;
  }
}
