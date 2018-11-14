public class Game {

    // The following five constants were defined in the starter code (kt54)
    private static String ILLEGALMOVE_MSG   = "Illegal move!";

    private Board gameBoard;
    private Player[] players = new Player[2];

    // Minimal constructor. Expand as needed (kt54)
    public Game() {
        gameBoard = new Board();
        //First Player is White
        players[0] = new Players(0, gameBoard);
        //Second Player is Black
        players[1] = new Players(1, gameBoard);
    }

    // Build on this method to implement game logic.
    public void play() {
        //The initiatisation of object which obtains input
        EasyIn2 reader = new EasyIn2();
        //object which stores allows for use of game board
        gameBoard = new Board();
        //stores whose turn it is
        int turn = 0;
        //condition checks if any player has no pieces left
        while(players[0].state() == false && players[1].state() == false){
            //prints the board
            gameBoard.printBoard();
            do{
              //Prompts the player for input
              player[this.turn].promptInput();
              //gets position they wany to move from and to
              String pos1 = reader.getString();
              String pos2 = reader.getString();
              //condition makes sure that move was valid
            }while(players[0].move(pos1, pos2));
            //changes the turn to that of the other player
            turn = (turn == 0)? 1: 0;
        }
      }
}
