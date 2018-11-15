public class Game {

    private Board gameBoard;
    private Player[] players = new Player[2];

    // Minimal constructor. Expand as needed (kt54)
    public Game() {
        //object which stores allows for use of game board
        gameBoard = new Board();
        //First Player is White
        players[0] = new Player(0, gameBoard);
        //Second Player is Black
        players[1] = new Player(1, gameBoard);
    }

    // Build on this method to implement game logic.
    public void play() {
        //The initiatisation of object which obtains input
        EasyIn2 reader = new EasyIn2();
        //stores whose turn it is
        int turn = 0;
        //condition checks if any player has no pieces left
        while(players[0].state() == false && players[1].state() == false){
            //used to determine if the user took a valid turn
            boolean validTurn = false;
            do{
              //prints the board
              this.gameBoard.printBoard();
              //Prompts the player for input
              players[turn].promptInput();
              //gets position they wany to move from and to
              String pos1 = reader.getString();
              String pos2 = reader.getString();
              if(players[turn].move(pos1, pos2)){
                //informs a valid turn has been taken
                validTurn = true;
                //changes the turn to that of the other player
                turn = (turn == 0)? 1: 0;
                //checks if they lost a piece due to a valid turn
                players[turn].pieceTaken(pos2);
              }
            //condition makes sure that move was valid
            }while(validTurn == false);
        }
      }
}
