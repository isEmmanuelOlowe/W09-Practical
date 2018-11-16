class Queen extends Piece {
  private String piece_name = "QUEEN";
  private char[] color = {'♕', '♛'};
  //stores if queen is moving diagonally
  private boolean isDiagonal;
  //constructor for Queen
  public Queen(int playerNo, Board gameBoard, String location){
    //constructor of super class is called
    super(playerNo, gameBoard, location);
    //sets the piece symbol from the player number
    this.pieceSymbol = (playerNo == 0)? color[0]: color[1];
    //sets the pieces intial location
    initialLoc();
  }

  public boolean validDesination(int[] from, int[] to){
    //cheks if their final destination can be reached
    //use factor they must move same distance in square in both axis
    //since they can only move diagonally
    if(Math.abs(from[0] - to[0]) == Math.abs(from[1] - to[1])){
      //queen is moving diagonally
      this.isDiagonal = true;
      return true;
    }
    if(from[0] == to[0] || from[1] == to[1]){
      //queen is moving across horizontally or vertically
      this.isDiagonal = false;
      return true;
    }
    return false;
  }

public boolean validPath(int[] from, int[] to){
  boolean validMove = (this.isDiagonal)? diagonally(from, to): horizontally(from, to);
  return validMove;
  }

  //basically rook
  public boolean horizontally(int[] from, int[] to){
    //stores positions
    int[] pos = new int[2];
    //determines which axis queen is being moved on
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

  //basically bishop
  public boolean diagonally(int[] from, int[] to){
    //used to store the next step in the direction
    int stepX = (to[0]- from[0] >= 0)? 1: -1;
    stepX += from[0];
    int stepY = (to[1] - from[1] >= 0)? 1: -1;
    stepY += from[1];
    //is only true if all the squares up to it are free
    if(stepX == to[0]){
      return true;
    }
    //makes use the there position they are passing through is free
    if(this.gameBoard.getPos(stepX, stepY) == this.FREE){
      int[] nextFrom = {stepX, stepY};
      //runs method again for the next position
      return this.validPath(nextFrom, to);
    }
    return false;
  }
}
