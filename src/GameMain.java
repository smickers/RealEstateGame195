import java.util.ArrayList;
import java.util.List;

/**

 * @author Stephanie M, Kyler Nyhagen, Nathan MacNeil, Hilary Fehr
 *
 */
public class GameMain
{

    public static final String ASH_NAME = "Ash";
    public static final String GARY_NAME = "Gary";
    public static final String MAY_NAME = "May";
    public static final String HILDA_NAME = "Hilda";
    public static ArrayList<Player> players;
    private Pokemon[] pokemon;
    private GameBoard gameBoard;
    private UpdateCenterView centerViewUpdater;
    private int currentPlayer;
    private int wPToWin;
    
   
    public Player player1, player2, player3, player4;
    public boolean debug = false;

    public static final int NUM_OF_TILES = 40;
    
    public GameMain()
    {
    	//TODO Testing purposes only 
    }
    
    public GameMain(ArrayList<String> playerNames)
    {
    	players = new ArrayList<Player>();
    	/*
    	 * There was an if statement block here that set the
    	 * win points to win based on the number of players in the
    	 * game, however it ends up that it's actually just
    	 * 6 (minus) the amount of players. --Kyler N
    	 */
    	wPToWin = 6 - playerNames.size();
    	if(debug)
    	{
    	    System.out.println("Win points needed = " + wPToWin);
    	}

        for(String p : playerNames)
        {
        	//turn order is 0, 1, 2, 3. NOT 1,2,3,4 --Kyler N
        	players.add(new Player(p, playerNames.indexOf(p)));
        }
        
        if(debug)
        {
            System.out.println("outputting players:");
            for(Player p : players)
            {
                System.out.println(p.name + " With turn position of " + 
            p.turnOrder);
            }
        }
    }

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
                int roll = Die.roll();
                
                //move the Player's token around the board
                
                //Update the player's current location with the current roll,
                //and ensure that it plays nice with the board wraparound of
                //40 tiles.
                currentPlayer.currentLocation = (currentPlayer.currentLocation
                        + roll) % 40;
                
                // Run the action method on that tile for the player that
                // just rolled and moved
                // TODO Uncomment line below this once GameBoard has been 
                //  finished
                //gameBoard.tileAtIndex(currentPlayer.currentLocation)
                //  .action(currentPlayer);
            }
        }
    }
   
    
    /**
     * Purpose: to construct a new instance of TurnOutcome to provide to the 
     *  GUI
     * @return outcome TurnOutcome object holding the results of both dice, and
     *  the position the current player will end at.
     */
    public TurnOutcome getTurnOutcome()
    {
        //Set the final results for both dice to be two 
        // randomly generated numbers.
    	int result1 = (int) Math.floor(Math.random() * 
    	        DieView.MAX_SIDES_TO_DICE );
    	int result2 = (int) Math.floor(Math.random() * 
    	        DieView.MAX_SIDES_TO_DICE );
    	
    	//TODO uncomment when valid array of player can be used.
    	//int index = players.get(currentPlayer).currentLocation 
    	// + result1 + result2; 
    	
    	//Testing//
    	int index = 1;
    	///////////
    	
    	//Construct the TurnOutcome.
    	TurnOutcome outcome = new TurnOutcome(result1, result2, index);
    	
		return outcome;
    	
    }
}
