import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class TestTurnOutcome
{
    private TurnOutcome firstOutcome;
    private TurnOutcome secondOutcome;

    @Before
    public void setUp() throws Exception
    {
        firstOutcome = new TurnOutcome( 6 , 4, 10);
        
        secondOutcome = new TurnOutcome(1, 3, 25);
        
    }

    @Test
    public void testGetTurnOutcomeReturnsTheValueOfTheFirstDice()
    {
        assertTrue( this.firstOutcome.getDieOne() == 6);
        
        assertTrue( this.secondOutcome.getDieOne() == 1);
    }
    
    @Test
    public void testGetTurnOutcomeReturnsTheValueOfTheSecondDice()
    {
        assertTrue( this.firstOutcome.getDieTwo() == 4);
        
        assertTrue( this.secondOutcome.getDieTwo() == 3);
    }
    
    @Test
    public void testGetTurnOutcomeReturnsTheValueOfTheIndex()
    {
        assertTrue( this.firstOutcome.getIndex() == 10);
        
        assertTrue( this.secondOutcome.getIndex() == 25);
    }


}
