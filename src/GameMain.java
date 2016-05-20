import java.util.ArrayList;
import java.util.List;

import javafx.stage.Stage;

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
    private boolean hasAnyoneWon = false;
    
    public static final int NUM_OF_TILES = 40;
    
    public GameMain(ArrayList<Player> p)
    {

    	   System.out.println("tag");
        Stage stage1 = new Stage();
        gameBoard = new GameBoard(p);
        //stage.close();
        MainWindow.newStart(stage1, gameBoard, 
                "palette-town.mp3");

    	
    	players = p;
        //The main game should not only set up the p, but
        //it should also set up the number of WinPoints necessary to win
        //the game (based on how many p are playing the game)
        if(p.size() == 2)
        {
            wPToWin = 4;
        }
        else if (p.size() == 3)
        {
            wPToWin = 3;
        }
        else if (p.size() == 4)
        {
            wPToWin = 2;
        }
        
     
    //    initializeBoard();
    //    initializePokemon();
        play();
       
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
//        while((players.get(currentPlayer) != null) && 
//                (players.get(currentPlayer).winPoints <= wPToWin))
//        {
//            //For each player who is playing the game ...
//            for (Player currentPlayer : players)
//            {
//                //when player clicks "roll dice" button...
//                
//                //Roll the dice to retrieve a number of tiles to move.
//                int roll = Die.rollTwoDie();
//                
//                //move the Player's token around the board
//                
//                //Update the player's current location with the current roll,
//                //and ensure that it plays nice with the board wraparound of
//                //40 tiles.
//                currentPlayer.currentLocation = (currentPlayer.currentLocation
//                        + roll) % 40;
//                
//                // Run the action method on that tile for the player that
//                // just rolled and moved
//                // TODO Uncomment line below this once GameBoard has been finished
//                //gameBoard.tileAtIndex(currentPlayer.currentLocation).action(currentPlayer);
//            }
//        }
        
        
        /**
         * Travis started here
         */
      	int j = 0;
      	
      	gameBoard.displayPane(new DemoTileView(), 0, 0, 2, 2);
      	
//        while (hasAnyoneWon == false)
//        {
//      
//        	for (int i = 0; i < players.size() && !hasAnyoneWon; i++)
//        	{
//        		
//        		
//        		//Display Trainer
//        		
//        		//Roll Dice in GameBoard
//        		gameBoard.moveToken(players.get(0).token, 5);
//        		System.out.println("you went too far");
//        		
//
//        	//winningSituation();
//  
//        	}
//       }
        
    }
    
    public void calculateNewLocation(int rollTotal)
    {
    	//Add roll
    	players.get(currentPlayer).currentLocation += rollTotal;
    	
    	//tiles stop at 39, allows player to pass go
    	if (players.get(currentPlayer).currentLocation > 39)
    	{
    		players.get(currentPlayer).currentLocation -= 40;
    		passGo();
    	}
    	
    	gameBoard.moveToken(players.get(currentPlayer).token, players.get(currentPlayer).currentLocation);
    	//Call token action
    }
    
    public void checkForWinner(Player player)
    {
    	if (player.winPoints >= wPToWin)
    	{
    		hasAnyoneWon = true;
    	}
    }
    
    public void winningSituation()
    {
    	System.out.println("Somebody won! Congrats");
    }
    
    public void passGo()
    {
    	//Display Passed Go
    	players.get(currentPlayer).addToBalance(200);
    }
}
