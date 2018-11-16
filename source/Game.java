public class Game {

    //stores the gameBoard
    private Board gameBoard;
    //stores the players
    private Player[] players = new Player[2];

    public Game() {
        //object which stores allows for use of game board
        gameBoard = new Board();
        //First Player is White
        players[0] = new Player(0, gameBoard);
        //Second Player is Black
        players[1] = new Player(1, gameBoard);
    }

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
              //gets position they wany to move from
              String pos1 = reader.getString();
              //quits if the user enters 'quit'
              if(pos1.equals("quit")){
                System.exit(1);
              }
              //gets the position the user wants to move to
              String pos2 = reader.getString();
              //determines and moves the player if move is valid
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
