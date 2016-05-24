import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class TestTurnOutcome
{
    private GameMain gameMain;
    private TurnOutcome outcome;
    
    private TurnOutcome errorOutcome;

    @Before
    public void setUp() throws Exception
    {
        gameMain = new GameMain();
        outcome = new TurnOutcome( 3 , 5, 8);
        errorOutcome = new TurnOutcome(-5, 20, 45);
    }

    @Test
    public void testGetTurnOutcomeReturnsTheValueOfTheFirstDice()
    {
        assertTrue( this.outcome.getDieOne() == 3);
    }
    
    @Test
    public void testGetTurnOutcomeReturnsTheValueOfTheSecondDice()
    {
        assertTrue( this.outcome.getDieTwo() == 5);
    }
    
    @Test
    public void testGetTurnOutcomeReturnsTheValueOfTheIndex()
    {
        assertTrue( this.outcome.getIndex() == 8);
    }
    
    @Test
    public void testGetTurnOutcomeReturnsOneIfAPassedInValueIsOutOfRange()
    {
        assertTrue( this.errorOutcome.getDieOne() == 1);
        
        assertTrue( this.errorOutcome.getDieTwo() == 1);
        
    }

}
