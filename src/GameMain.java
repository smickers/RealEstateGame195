import java.util.ArrayList;
import java.util.List;

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
    private int currentPlayer;
    private int wPToWin;

    
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
        
        initializeBoard();
        initializePokemon();
//        play();
       
    }
    
    private void initializeBoard()
    {
        
    }
    
    private void initializePokemon()
    {
        
    }
    
//    public void initializeGame()
//    {
//        
//    }
    
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
                
                //Roll the dice to retrieve a number of tiles to move.
                int roll = Die.rollTwoDie();
                
                //move the Player's token around the board
                
                //Update the player's current location with the current roll,
                //and ensure that it plays nice with the board wraparound of
                //40 tiles.
                currentPlayer.currentLocation = (currentPlayer.currentLocation
                        + roll) % 40;
                
                // Run the action method on that tile for the player that
                // just rolled and moved
                gameBoard.tileAtIndex(currentPlayer.currentLocation).action(currentPlayer);
            }
        }
    }
}
