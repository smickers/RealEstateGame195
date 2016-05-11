import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/*
 *  [File header includes information about the file being submitted.]
 *  Date submitted:
 *  Assignment number:
 *  Course name:  COSC 190
 *  Instructors: Sharon McDonald, Nelson Wong
 * 
 */

/**
 * @author cst104
 *
 */
public class GameMain
{

    private ArrayList<Player> players;
    private Pokemon[] pokemon;
    private GameBoard gameBoard;
    private UpdateCenterView centerViewUpdater;
    private int wPToWin;
    private int currentPlayer;
    //
    private Button rollDieBtn;

    
    public GameMain(Player[] players)
    {
        //The main game should not only set up the players, but
        //it should also set up the number of WinPoints necessary to win
        //the game (based on how many players are playing the game)
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
    
    private void initializeBoard()
    {
        
    }
    
    private void initializePokemon()
    {
        
    }
    
    public void initializeGame()
    {
        
    }
    
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
