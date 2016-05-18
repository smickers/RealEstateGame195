import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DieTests
{
    private Die die;
    private DiceView view;
    @Before
    public void setUp()
    {
        view = new DiceView();
        die = new Die(view);
    }
    
    @Test
    public void testThatRollBattleDieAlwaysReturnsBetweenOneAndSixInclusive()
    {
        int[] numbersRolled = new int[] { 0, 0, 0, 0, 0, 0 };

        try
        {
            for ( int i = 0; i < 1000; i++ )
            {
                //int value = Die.rollBattleDie();
                int value = die.rollBattleDie();
                numbersRolled[value - 1]++;
            }
            assertTrue(true);
        }
        catch ( Exception e )
        {
            assertTrue(false);
        }
    }
    
    @Test
    public void testThatRollTwoDieAlwaysReturnsBetweenTwoAndTwelveInclusive()
    {
        boolean tripped = false;
        for (int i = 0; i < 1000; i++)
        {
           // int value = Die.rollTwoDie();
            int value = die.rollTwoDie();
            if (value > 12 || value < 2)
            {
                tripped = true;
            }
        }
        assertFalse(tripped);
    }
    
//    @Test
//    public void testThatGetLocationReturnsTheTileThePlayerIsCurrentlyOn()
//    {
//        Player test = new Player(new Trainer("A", null,null));
//        test.currentLocation = 5;
//        GameBoard.gameTiles = new Tile[15];
//        for (int i = 0; i < 15; i++)
//        {
//            GameBoard.gameTiles[i] = new TestTile(i);
//        }
//        assertTrue(test.getLocation().equals(GameBoard.gameTiles[5]));
//        
//        test.currentLocation = 0;
//        
//        assertTrue(test.getLocation().equals(GameBoard.gameTiles[0]));
//        
//        test.currentLocation = 9;
//        
//        assertTrue(test.getLocation().equals(GameBoard.gameTiles[9]));
//        
//        // roll a die
//        // set player location to 0
//        // make sure player's new location is the roll value % 40
//        
//    }
//    
//    @Test
//    public void testThatWhenADieIsRolledThePlayerLocationIsUpdated()
//    {
//        Player currentPlayer = new Player(new Trainer("A", null,null));
//        
//        System.out.println("Current location: " + currentPlayer.currentLocation);
//        int oldLocation = currentPlayer.currentLocation;
//        //int roll = Die.rollTwoDie();
//        int roll = die.rollTwoDie();
//        System.out.println("Rolled value: " + roll);
//        //Set the player's new location to be the 
//        //current location PLUS the value returned by 
//        //the dice roll. Also, ensure that this plays 
//        //nicely with the 40 tiles on the board.
//        currentPlayer.newLocation = 
//                (currentPlayer.currentLocation + roll) 
//                % 40;
//        System.out.println("New location: " + currentPlayer.newLocation);
//        
//        assertTrue((oldLocation + roll) % 40 == currentPlayer.newLocation);
//    }

}
