import java.lang.Math;

class Bishop extends Piece {
  private char[] color = {'♗', '♝'};
  private String piece_name = "BISHOP";

  //constructor for bishop
  public Bishop(int playerNo, Board gameBoard, String location){
    //constructor for super class
    super(playerNo, gameBoard, location);
    //assigns the colour of the piece from player no
    this.pieceSymbol = (playerNo == 0)? color[0]: color[1];
    //sets the pieces intial location
    this.initialLoc();
  }

  //checks if it possible to reach destination
  public boolean validDesination(int[] from, int[] to){
    //cheks if their final destination can be reached
    //use factor they must move same distance in square in both axis
    //since they can only move diagonally
    if(Math.abs(from[0] - to[0]) == Math.abs(from[1] - to[1])){
      return true;
    }
    return false;
  }

  //checks path is clear to move to a destination
  public boolean validPath(int[] from, int[] to){
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
    if(this.gameBoard.getPos(stepX, stepY) == this.free){
      int[] nextFrom = {stepX, stepY};
      //runs method again for the next position
      return this.validPath(nextFrom, to);
    }
    return false;
  }
}
