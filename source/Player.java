public class Player {

  //stores the location of the pieces that belong to the user
  private Piece[] piece = new Piece[4];
  private String playerName;
  private String opponentName;
  private int noPieces = 4;
  private String name;
  private int movePiece;
  public Player(int playerNo) {
    this.playerName = (playerNo == 0)?"White": "Black";
    this.opponentName = (playerNo == 0)?"Black":"White";
    this.piece[0] = new Rook(player_no, gameBoard);
    this.piece[1] = new Bishop(player_no, gameBoard);
    this.piece[2] = new Bishop(player_no, gameBoard);
    this.piece[3] = new Rook(player_no, gameBoard);
  }

  public boolean move(String from, String to){
    boolean validTurn = false;
    //checks if the player actually has piece in initial position
    //checks if the player already has piece in destination
    if(inPlay(from) == true && inPlay(to) == false){
      vaildTurn = this.piece[movePiece].move(from, to);
    }
  }

  //checks if that location has a piece in play by player
  public boolean inPlay(String location){
    for(int i; i < piece.length; i++){
      if(this.piece.getLocation.equals(location)){
        this.movePiece = i;
        return true;
      }
    }
    return false;
  }
  public void promptInput(){
    System.out.println(this.playerName + "plays. Enter move:");
  }

  public boolean state(){
    if(noPieces == 0){
      System.out.println(this.opponentName + " wins!");
      return true;
    }
    return false;
  }
}
