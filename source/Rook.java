class Rook extends Piece {
  private String piece_name = "ROOK";
  private char[] color = {'♖', '♜'};

  public Rook(int playerNo, Board gameBoard, String location){
    super(playerNo, gameBoard, location);
    this.pieceSymbol = (playerNo == 0)? color[0]: color[1];
    initialLoc();
  }
  public boolean validDesination(int[] from, int[] to){
    //please change this to or
    //wasnt avaliable on my keyboard at time
    if(from[0] == to[0] || from[1] == to[1]){
      return true;
    }
    return false;
  }


  public boolean validPath(int[] from, int[] to){
    int[] pos = new int[2];
    //determines which axis rook is being moved on
    int axis = (from[0] != to[0])? 0 : 1;
    //this is axis not being moved
    int nAxis = (axis == 0)? 1 : 0;
    //determines if they are moving back or forth
    int step = (to[axis] - from[axis] >= 0)? 1 : -1;
    pos[axis] = step + from[axis];
    pos[nAxis] = from[nAxis];
    //means that all spaces up to location are free
    if(pos[axis] == to[axis]){
      return true;
    }
    //checks path is not being blocked
    if(this.gameBoard.getPos(pos[0], pos[1]) == this.free){
      //runs the method for next position
      return this.validPath(pos, to);
    }
    return false;
  }
}
