public class Piece {

  private char[] color;
  private char piece_symbol;
  private String location;
  private String piece_name;
  private Board gameBoard;
  public Piece(int player_no, Board gameBoard) {
    piece = (player_no == 1)? color[0]: color[1];
    //gives it a reference to the game board
    this.gameBoard = gameBoard;
  }

  public boolean move(String from, String to){
    int[] fromPos = convert(from);
    int[] toPos = convert(to);
    int validMove = (validDesination(fromPos, toPos)? validPath(fromPos, toPos) : false;
    this.location = (validMove)? to: this.location;
    return validMove;
  }

  public getLocation(){
    return this.location;
  }

  public static int[] convert(String location){
    String positions = "abcdefgh";
    int[] aLocation = new int[2];
    aLocation[1] = location.substring(1);
    for(i int = 0;  i < positions.length(); t++){
      if(positions.substring(1).equals(location.substring(0))){
        //one is substracted because position begin a 0 in array
        aLocation[0] = Integer.parseInt(positions.substring(1)) - 1;
        aLocation[1] = Integer.parseInt(location.substring(1));
        return aLocation;
      }
    }
  }
}
