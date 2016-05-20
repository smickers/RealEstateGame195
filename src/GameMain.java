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

    public static final String ASH_NAME = "Ash";
    public static final String GARY_NAME = "Gary";
    public static final String MAY_NAME = "May";
    public static final String HILDA_NAME = "Hilda";
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
    	players = new ArrayList<Player>();
        
    	
    	/*
    	 * There was an if statement block here that set the
    	 * win points to win based on the number of players in the
    	 * game, however it ends up that it's actually just
    	 * 6 - the amount of players. --Kyler N
    	 */
    	wPToWin = 6 - playerNames.size();
        System.out.println("Win points needed = " + wPToWin);
        
        for(String p : playerNames)
        {
        	//turn order is 0, 1, 2, 3. NOT 1,2,3,4 --Kyler N
        	players.add(new Player(p, playerNames.indexOf(p)));
        }
        
        System.out.println("outputting players:");
        for(Player p : players)
        {
        	System.out.println(p.name + " With turn position of " + p.turnOrder);
        }
        
        
       
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
