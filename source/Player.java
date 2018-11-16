public class Player {

  //stores the location of the pieces that belong to the user
  private Piece[] pieces = new Piece[4];
  private int noPieces = 4;
  //stores location of piece that is requested to be move
  private int movePiece;
  private Board gameBoard;
  private int playerNo;
  //stores the player colours
  private String[] color = {"White", "Black"};

  //constructor for player class
  public Player(int playerNo, Board gameBoard) {
    //stores the gameBoard
    this.gameBoard = gameBoard;
    //assigns their player number
    this.playerNo = playerNo;
    //assigns pieces initial positions
    this.pieces[0] = new Rook(playerNo, gameBoard, "a");
    this.pieces[1] = new Bishop(playerNo, gameBoard, "c");
    this.pieces[2] = new Bishop(playerNo, gameBoard, "f");
    this.pieces[3] = new Rook(playerNo, gameBoard, "h");
  }

  //moves one of the players pieces
  public boolean move(String from, String to){
    boolean validTurn = false;
    //checks that they have a piece at from location
    //checks they dont have a piece at their to location
    if(inPlay(from) == true && inPlay(to) == false){
      //runs to see if this a valid move for the type of piece
      validTurn = this.pieces[movePiece].move(from, to);
    }
    //prompts player their move was invalid
    if(validTurn == false){
      System.out.println("Illegal move!");
    }
    return validTurn;
  }

  //checks if that location has a piece in play by player
  public boolean inPlay(String location){
    for(int i = 0; i < pieces.length; i++){
      //checks incase piece has been taken
      if(this.pieces[i] != null){
        //linear search
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
    System.out.println(this.color[this.playerNo] + " plays. Enter move:");
  }

  //checks that a player still has pieces left
  //notifes winner if no pieces remain
  public boolean state(){
    if(noPieces == 0){
      //prompts that their opponent has won the game
      this.gameBoard.printBoard();
      System.out.println(this.color[1 - this.playerNo] + " wins!");
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
