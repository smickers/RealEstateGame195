import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GameMainTest
{
    GameMain gm;
    ArrayList<String> playersTest;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
        playersTest = new ArrayList<String>();
    }

    @Test
    public void testGameMainWithThreeTrainersThatAreInOrder()
    {
        playersTest.add("Ash");
        playersTest.add("Gary");
        playersTest.add("Hilda");
        gm = new GameMain(playersTest);
        
        assertEquals(gm.players.get(0).name, "Ash");
        assertEquals(gm.players.get(1).name, "Gary");
        assertEquals(gm.players.get(2).name, "Hilda");
    }
    
    @Test
    public void testGameMainWithThreeTrainersThatAreNotInOrder()
    {
        
        playersTest.add("Gary");
        playersTest.add("May");
        playersTest.add("Hilda");
        
        gm = new GameMain(playersTest);
        
        assertEquals(gm.players.get(0).name, "Gary");
        assertEquals(gm.players.get(1).name, "May");
        assertEquals(gm.players.get(2).name, "Hilda");
    }
    
    @Test
    public void testGameMainWithMinTwoTrainers()
    {
        playersTest.add("Ash");
        playersTest.add("Gary");

        gm = new GameMain(playersTest);
        
        assertEquals(gm.players.get(0).name, "Ash");
        assertEquals(gm.players.get(1).name, "Gary");
    }

    @Test
    public void testGameMainWithOnlyOneTrainer()
    {
        //While we can't prevent the game from functioning with one player in
        //regards to our story, it is out of the scope of our story to do so.
        //That functionality is handled by whichever story handled the 'Trainer
        //Select Screen'.
        playersTest.add("Ash");

        gm = new GameMain(playersTest);
        
        assertEquals(gm.players.get(0).name, "Ash");
    }
    
    @Test
    public void testGameMainWithMaxFourTrainers()
    {
        playersTest.add("Ash");
        playersTest.add("Gary");
        playersTest.add("May");
        playersTest.add("Hilda");
        

        gm = new GameMain(playersTest);
        
        assertEquals(gm.players.get(0).name, "Ash");
        assertEquals(gm.players.get(1).name, "Gary");
        assertEquals(gm.players.get(2).name, "May");
        assertEquals(gm.players.get(3).name, "Hilda");
    }
}
