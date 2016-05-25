import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author cst104, cst152, cst102
 *
 */
public class GameMain
{

    private ArrayList<Player> players;
    private Pokemon[] pokemon;
    private GameBoard gameBoard;
    private UpdateCenterView centerViewUpdater;
    private int currentPlayer;
    private int wPToWin;
    private boolean hasAnyoneWon = false; // if any player has won this will be
    // true
    public Pane currentText; //
    public StackPane temp;

    public static final int NUM_OF_TILES = 40;

    public GameMain(ArrayList<Player> p)
    {
        Stage stage1 = new Stage();
        gameBoard = new GameBoard(p);
        MainWindow.newStart(stage1, gameBoard, "palette-town.mp3");

        players = p;
        // The main game should not only set up the p, but
        // it should also set up the number of WinPoints necessary to win
        // the game (based on how many p are playing the game)
        if ( p.size() == 2 )
        {
            wPToWin = 4;
        }
        else if ( p.size() == 3 )
        {
            wPToWin = 3;
        }
        else if ( p.size() == 4 )
        {
            wPToWin = 2;
        }

        // initializeBoard();
        // initializePokemon();
        play();

    }

    /**
     * Purpose: Will instantiate the tiles to be used
     */
    private void initializeBoard()
    {

    }

    /**
     * Purpose: Will instantiate the Pokemon to be used
     */
    private void initializePokemon()
    {

    }

    // public void initializeGame()
    // {
    //
    // }

    public void play()
    {
        // BEGIN TEST CODE
        Button btnMoveToken = new Button("Move token");
        btnMoveToken.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle( ActionEvent event )
            {
                if ( temp != null )
                {
                    gameBoard.getChildren().remove(temp);
                }

               

                System.out.println("It is "
                        + players.get(currentPlayer).trainer.name + "'s  turn");
                System.out.println(players.get(currentPlayer).currentBalance()
                        + " current balance");

                int tilesToMove = (int) (Math.random() * 12 + 1);
                // int tilesToMove = 3;
                calculateNewLocation(tilesToMove);
                // add number to player's location
                // players.get(0).currentLocation += tilesToMove;
                // pass location into gameboard
                // StackPane temp = new StackPane();
                // Text topInfo = new Text("It's " +
                // players.get(currentPlayer).trainer.name + " turn!");
                // temp.getChildren().add(topInfo);
                // gameBoard.getChildren();
                // gameBoard.displayPane(temp, 0, 0, 9, 1);
                // indicatePlayerTurn();

                
                //gameBoard.rollDice();
                //calculate index
                //moveToken(players.get(currentPlayer).token, calculateNewLocation());
                
                gameBoard.displayPane(
                        new DemoTileView(players.get(currentPlayer),
                                tilesToMove), 0, 0, 9, 8);
                System.out.println("Tiles to move: " + tilesToMove);

                currentPlayer++;

                if ( currentPlayer == players.size() )
                {
                    currentPlayer = 0;
                }

                // gameBoard.moveToken(gameBoard.tokenArray[0],
                // players.get(0).currentLocation);

                
                  
                

            }
        });

        StackPane temp = new StackPane();
        temp.getChildren().add(btnMoveToken);

        gameBoard.displayPane(temp, 3, 8, 3, 1);

    }

    /**
     * Purpose: Indicates whose turn it is before they roll the dice
     */
    public void indicatePlayerTurn()
    {
        if ( currentText != null )
        {
            gameBoard.getChildren().remove(currentText);
        }

        currentText = new StackPane();
        Text topInfo = new Text("It's "
                + players.get(currentPlayer).trainer.name + "'s turn!");
        topInfo.setFont(GameFont.GAME_FONT);
        currentText.getChildren().add(topInfo);
        gameBoard.displayPane(currentText, 0, 0, 9, 1);
    }

    /**
     * Purpose: Determines where the player's token will land
     * 
     * @param rollTotal
     */
    public void calculateNewLocation( int rollTotal )
    {
        // Add roll
        players.get(currentPlayer).currentLocation += rollTotal;

        // tiles stop at 39, allows player to pass go
        if ( players.get(currentPlayer).currentLocation > 39 )
        {
            players.get(currentPlayer).currentLocation -= 40;
            passGo();
        }

        // Call token action
        gameBoard.moveToken(players.get(currentPlayer).token,
                players.get(currentPlayer).currentLocation);
    }

    /**
     * Purpose: Checks if a player has enough points to win the current game If
     * so, sets hasAnyoneWon to true and stops game after the winning player's
     * turn
     * 
     * @param player
     */
    public void checkForWinner( Player player )
    {
        if ( player.winPoints >= wPToWin )
        {
            hasAnyoneWon = true;
        }
    }

    /**
     * Purpose: When a player has won, they will be notified
     */
    public void winningSituation()
    {
        System.out.println("Somebody won! Congrats");
    }

    /**
     * Purpose: When a player passes go, 200 is added to their balance
     */
    public void passGo()
    {
        // Display Passed Go
        players.get(currentPlayer).addToBalance(200);
    }
}
