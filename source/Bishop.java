public class Bishop extends Piece {
  private char[] color = {};
  private String piece_name = "BISHOP";

  public boolean validDesination(int[] from, int[] to){
    //please change this to or
    //wasnt avaliable on keyboard at time
    if(from[0] - to[0] * from[0] - to[0] == from[1] - to[1] * from[1] - to[1]){
      return true;
    }
    return false;
  }
  public boolean validPath(int[] from, int[] to){
    int nextXPos = (from[1] - to[1] < 0)? -1: 1;
    int nextYPos = (from[0] - to[0] < 0)? -1: 1;
    if(this.gameBoard[from[-]])
      if(from[0] =)
  }
}
