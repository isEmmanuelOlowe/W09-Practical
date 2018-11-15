public class Player {

  //stores the location of the pieces that belong to the user
  private Piece[] pieces = new Piece[4];
  private String playerName;
  private String opponentName;
  private int noPieces = 4;
  private String name;
  private int movePiece;
  private Board gameBoard;

  public Player(int playerNo, Board gameBoard) {
    this.gameBoard = gameBoard;
    this.playerName = (playerNo == 0)?"White": "Black";
    this.opponentName = (playerNo == 0)?"Black":"White";
    this.pieces[0] = new Rook(playerNo, gameBoard, "a1");
    this.pieces[1] = new Bishop(playerNo, gameBoard, "c1");
    this.pieces[2] = new Bishop(playerNo, gameBoard, "f1");
    this.pieces[3] = new Rook(playerNo, gameBoard, "h1");
  }

  public boolean move(String from, String to){
    boolean validTurn = false;
    //checks if the player actually has piece in initial position
    //checks if the player already has piece in destination
    if(from != to){
      if(inPlay(from) == true && inPlay(to) == false){
        validTurn = this.pieces[movePiece].move(from, to);
      }
    }
    if(validTurn == false){
      System.out.println("Illegal move!");
    }
    return validTurn;
  }

  //checks if that location has a piece in play by player
  public boolean inPlay(String location){
    for(int i = 0; i < pieces.length; i++){

      if(this.pieces[i] != null){
        if(this.pieces[i].getLocation().equals(location)){
          this.movePiece = i;
          return true;
        }
      }
    }
    return false;
  }

  //prompts the user for input on their turn
  public void promptInput(){
    System.out.println(this.playerName + " plays. Enter move:");
  }

  //checks that a player still has pieces left
  //notifes winner if no pieces remain
  public boolean state(){
    if(noPieces == 0){
      this.gameBoard.printBoard();
      System.out.println(this.opponentName + " wins!");
      return true;
    }
    return false;
  }

  //determines if a player lost a piece due to thier opponents turn
  public void pieceTaken(String location){
    if(this.inPlay(location)){
      //deletes piece fron their list of pieces
      this.pieces[movePiece] = null;
      //decreases
      this.noPieces -= 1;
    }
  }
}
