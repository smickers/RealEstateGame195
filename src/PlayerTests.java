import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PlayerTests
{
    Player playerToTest;
    @Before
    public void setUp()
    {
        playerToTest = new Player("Ash", 0);
    }
    
    ////////////////////////////////////////
    //          S19 TESTS                 //
    ////////////////////////////////////////
    
    @Test
    public void testThatPlayerAshWasCreatedInPositionZero()
    {
        assertEquals("Ash", playerToTest.name);
        assertEquals(0, playerToTest.turnOrder);
    }
    
    @Test
    public void testThatGaryWasCreatedInPositionThree()
    {
        playerToTest = new Player("Gary", 3);
        assertEquals("Gary", playerToTest.name);
        assertEquals(3, playerToTest.turnOrder);
    }
    
    @Test
    public void testThatGaryWasCreatedInBoundaryPositionFour()
    {
        //Gary player is created, as this will allow for the game to support 
        //more than 4 players in the long run
        playerToTest = new Player("Gary", 4);
        assertEquals("Gary", playerToTest.name);
        assertEquals(4, playerToTest.turnOrder);
    }
    
    @Test
    public void testForNullPlayerException()
    {
        playerToTest = new Player(null, 0);
        assertEquals("missingNo", playerToTest.name);
        assertEquals(0, playerToTest.turnOrder);
    }
    
    ////////////////////////////////////////
    //         END S19 TESTS              //
    ////////////////////////////////////////
    
    @Test
    public void testThatPlayerBalanceCanBeAddedTo()
    {
        playerToTest.addToBalance(500);
        assertEquals(500, playerToTest.currentBalance());
    }
    
    @Test
    public void testThatPlayerBalanceCanBeAddedToMultipleTimes()
    {
        for (int i = 0; i < 10; i++)
        {
            playerToTest.addToBalance(1000);
        }
        assertEquals(10000, playerToTest.currentBalance());
    }
    
    @Test
    public void testThatPlayerBalanceCanBeSubtracted()
    {
        playerToTest.addToBalance(5000);
        playerToTest.removeFromBalance(1000);
        assertEquals(4000, playerToTest.currentBalance());
    }
    
    @Test
    public void testThatThePlayerCantSubtractMoreThanTheirTotalBalance()
    {
        playerToTest.addToBalance(50000);
        assertTrue(playerToTest.removeFromBalance(45000));
        
        setUp();
        playerToTest.addToBalance(50000);
        assertFalse(playerToTest.removeFromBalance(-1));
        
        setUp();
        playerToTest.addToBalance(50000);
        assertFalse(playerToTest.removeFromBalance(0));
        
        setUp();
        playerToTest.addToBalance(50000);
        assertTrue(playerToTest.removeFromBalance(50000));
        
        setUp();
        playerToTest.addToBalance(50000);
        assertFalse(playerToTest.removeFromBalance(50001));
    }

}
