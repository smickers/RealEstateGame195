import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PlayerTests
{
    Player playerToTest;
    @Before
    public void setUp()
    {
        playerToTest = new Player("Ash");
    }

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
