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

    public static final String ASH_NAME = "Ash";
    public static final String GARY_NAME = "Gary";
    public static final String MAY_NAME = "May";
    public static final String HILDA_NAME = "Hilda";
    public ArrayList<Player> players;
    private Pokemon[] pokemon;
    private GameBoard gameBoard;
    private UpdateCenterView centerViewUpdater;
    public int currentPlayer;
    private int wPToWin;
    private boolean hasAnyoneWon = false; // if any player has won this will be
    // true
    public Pane currentText; //
    public StackPane temp;

    public static final int NUM_OF_TILES = 40;

    public GameMain(ArrayList<Player> p)
    {
        Stage stage1 = new Stage();
        gameBoard = new GameBoard(p, this);
        MainWindow.newStart(stage1, gameBoard, "palette-town.mp3");

        currentPlayer = 0;
        
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
                + players.get(currentPlayer).name + "'s turn!");
        topInfo.setFont(GameFont.GAME_FONT);
        currentText.getChildren().add(topInfo);
        gameBoard.displayPane(currentText, 0, 0, 9, 1);
    }

    /**
     * Purpose: Determines where the player's token will land
     * 
     * @param rollTotal
     */
    public int calculateNewLocation( int rollTotal )
    {
        System.out.println("ROLL TOTAL IN CALCULATE :" + rollTotal);
        System.out.println(players.get(currentPlayer).currentLocation);

        // Add roll
        players.get(currentPlayer).currentLocation += rollTotal;

        System.out.println(players.get(currentPlayer).currentLocation);
        // tiles stop at 39, allows player to pass go
        if ( players.get(currentPlayer).currentLocation > 39 )
        {
            players.get(currentPlayer).currentLocation -= 40;
            passGo();
        }

        // Move token
//        gameBoard.moveToken(players.get(currentPlayer).token,
//                players.get(currentPlayer).currentLocation);
        
        return players.get(currentPlayer).currentLocation;

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
    
    public TurnOutcome getTurnOutcome()
    {
        int roll1 = (int) ((Math.random() * 6)+1);
        int roll2 = (int) ((Math.random() * 6)+1);
        
        return new TurnOutcome(roll1, roll2, calculateNewLocation(roll1 + roll2) );
    }
}
