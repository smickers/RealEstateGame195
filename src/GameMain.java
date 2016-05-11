import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


/**CLASS: GameMain
 * @info: Creates the main state of the game, allows users to play PokeMonopoly.
 * @author cst104
 *
 */
public class GameMain
{
    //Array of Players playing the game
    private ArrayList<Player> players;
    //List of Pokemon available in the game
    private Pokemon[] pokemon;
    //Game Board to use
    private GameBoard gameBoard;
    private UpdateCenterView centerViewUpdater;
    //number indicating Win Points required to win
    private int wPToWin;
    private int currentPlayer;
    //For Demo-ing functionality - not tied to anything
    private Button rollDieBtn;

///////////////////////////////////////////////////////////////////////////////    
/////////////////////////////////////////////////////////////////////////////// 
    
    /**
     * CONSTRUCTOR : GameMain
     * FUNCTIONALITY: Creates the game state with the given number of players/
     *                  Sets the wPToWin based on the number of players.
     * @param players: the list of players that will be playing the game
     */
    public GameMain(Player[] players)
    {
        //The main game should not only set up the players, but
        //it should also set up the number of WinPoints necessary to win
        //the game (based on how many players are playing the game)
        //////////////////////////
        //   NOT FOR RELEASE 1  //
        //////////////////////////
        if(players.length == 2)
        {
            wPToWin = 4;
        }
        else if (players.length == 3)
        {
            wPToWin = 3;
        }
        else if (players.length == 4)
        {
            wPToWin = 2;
        }
    }
    
    //NOT FOR RELEASE 1
    private void initializeBoard()
    {
        
    }
    
    //NOT FOR RELEASE 1
    private void initializePokemon()
    {
        
    }
    
    //NOT FOR RELEASE 1
    public void initializeGame()
    {
        
    }
    
    /**
     * METHOD: play
     * @info: Provides gameplay function. Allows users to click a button
     *          to roll the dice, and then will move their token to the new
     *          location specified.
     *          RELEASE 1 INFO: functionality only. Does not talk to the GUI.
     *          rollDieBtn is only to demo functionality. No animation.
     */
    public void play()
    {
        //While there is a player to play, and the current player does not have
        //enough Win Points to win the game ...
        while((players.get(currentPlayer) != null) && 
                (players.get(currentPlayer).winPoints <= wPToWin))
        {
            //For each player who is playing the game ...
            for (Player currentPlayer : players)
            {
                //when player clicks "roll dice" button...
                rollDieBtn.setOnAction(new EventHandler<ActionEvent>()
                        {

                            @Override
                            public void handle(ActionEvent ae)
                            {
                                //Roll the dice to retrieve a number of tiles 
                                //to move.
                                int roll = Die.rollTwoDie();
                                //Set the player's new location to be the 
                                //current location PLUS the value returned by 
                                //the dice roll. Also, ensure that this plays 
                                //nicely with the 40 tiles on the board.
                                currentPlayer.newLocation = 
                                        (currentPlayer.currentLocation + roll) 
                                        % 40;
                            }
                    
                        });                
                //set the player's current location to the new location
                currentPlayer.currentLocation = currentPlayer.newLocation;

                            ////////////////////////////////
                            //          GUI               //
                            ////////////////////////////////
                //Player's token lands on a tile and then takes an action based
                //on the type of tile they landed on
                currentPlayer.getLocation().action(currentPlayer);
            }
        }
    }
}
