public class Rook extends Piece {
  private char[] color = {'♖', '♜', '.'};
  private String piece_name = "ROOK";

  public boolean validDesination(int[] from, int[] to){
    //please change this to or
    //wasnt avaliable on my keyboard at time
    if(from[0] != from[0] && from[1] != from[1]){
      return true;
    }
    return false;
  }

  public boolean validPath(int[] from, int[] to){

  }
}
