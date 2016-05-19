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
    public Player player1, player2, player3, player4;
    
    public static final int NUM_OF_TILES = 40;
    
    public GameMain(ArrayList<String> playerNames)
    {
        //The main game should not only set up the players, but
        //it should also set up the number of WinPoints necessary to win
        //the game (based on how many players are playing the game)
        if(playerNames.size() == 2)
        {
            wPToWin = 4;
//            this.players.add(new Player(playerNames.get(0), 1));
//            this.players.add(new Player(playerNames.get(1), 1));
            
        }
        else if (playerNames.size() == 3)
        {
            wPToWin = 3;
        }
        else if (playerNames.size() == 4)
        {
            wPToWin = 2;
        }
        for(String p : playerNames)
        {
        	//playernames index of will make their turn order 0,1,2,3 instead of 1,2,3,4.
        	//If you don't want this, just +1 it every time.
        	players.add(new Player(p, playerNames.indexOf(p)));
        }
        
        
//        initializeBoard();
        //initializePokemon();
//        play();
        
       
    }
    
//    private void initializeBoard()
//    {
//        
//    }
//    
    /**
     * Will create every base evolution of every pokemon, no need to make the 
     * 2nd and third evolutions
     */
    private void initializePokemon()
    {
        
    }
    
    /**
     * Will set up the turn order of the game
     */
    public void initializeGame()
    {
        
    }
    
   
}
