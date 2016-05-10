import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PlayerTests
{
    Player a;
    @Before
    public void setUp()
    {
        a = new Player(null);
    }

    @Test
    public void testThatPlayerBalanceCanBeAddedTo()
    {
        a.addToBalance(500);
        assertEquals(500, a.currentBalance());
    }
    
    @Test
    public void testThatPlayerBalanceCanBeAddedToMultipleTimes()
    {
        for (int i = 0; i < 10; i++)
        {
            a.addToBalance(1000);
        }
        assertEquals(10000, a.currentBalance());
    }
    
    @Test
    public void testThatPlayerBalanceCanBeSubtracted()
    {
        a.addToBalance(5000);
        a.removeFromBalance(1000);
        assertEquals(4000, a.currentBalance());
    }
    
    @Test
    public void testThatThePlayerCantSubtractMoreThanTheirTotalBalance()
    {
        a.addToBalance(50000);
        assertTrue(a.removeFromBalance(45000));
        
        setUp();
        a.addToBalance(50000);
        assertFalse(a.removeFromBalance(-1));
        
        setUp();
        a.addToBalance(50000);
        assertFalse(a.removeFromBalance(0));
        
        setUp();
        a.addToBalance(50000);
        assertTrue(a.removeFromBalance(50000));
        
        setUp();
        a.addToBalance(50000);
        assertFalse(a.removeFromBalance(50001));
    }

}
