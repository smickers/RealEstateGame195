// TODO: This doesn't work, because GameMain launches a GUI.
    // TODO: Consider fixing this implementation for a later release

//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//
//public class GameMainTest
//{
//    GameMain gm;
//    ArrayList<Player> playersTest;
//    
//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception
//    {
//    }
//
//    @Before
//    public void setUp() throws Exception
//    {
//        playersTest = new ArrayList<Player>();
//    }
//
//    @Test
//    public void testGameMainWithThreeTrainersThatAreInOrder()
//    {
//        playersTest.add(new Player("Ash", 0));
//        playersTest.add(new Player("Gary", 0));
//        playersTest.add(new Player("Hilda", 0));
//        gm = new GameMain(playersTest);
//        
//        assertEquals(gm.players.get(0).name, "Ash");
//        assertEquals(gm.players.get(1).name, "Gary");
//        assertEquals(gm.players.get(2).name, "Hilda");
//    }
//    
//    @Test
//    public void testGameMainWithThreeTrainersThatAreNotInOrder()
//    {
//        
//        playersTest.add(new Player("Gary", 0));
//        playersTest.add(new Player("May", 0));
//        playersTest.add(new Player("Hilda", 0));
//        
//        gm = new GameMain(playersTest);
//        
//        assertEquals(gm.players.get(0).name, "Gary");
//        assertEquals(gm.players.get(1).name, "May");
//        assertEquals(gm.players.get(2).name, "Hilda");
//    }
//    
//    @Test
//    public void testGameMainWithMinTwoTrainers()
//    {
//        playersTest.add(new Player("Ash", 0));
//        playersTest.add(new Player("Gary", 0));
//
//        gm = new GameMain(playersTest);
//        
//        assertEquals(gm.players.get(0).name, "Ash");
//        assertEquals(gm.players.get(1).name, "Gary");
//    }
//
//    @Test
//    public void testGameMainWithOnlyOneTrainer()
//    {
//        //While we can't prevent the game from functioning with one player in
//        //regards to our story, it is out of the scope of our story to do so.
//        //That functionality is handled by whichever story handled the 'Trainer
//        //Select Screen'.
//        playersTest.add(new Player("Ash", 0));
//
//        gm = new GameMain(playersTest);
//        
//        assertEquals(gm.players.get(0).name, "Ash");
//    }
//    
//    @Test
//    public void testGameMainWithMaxFourTrainers()
//    {
//        playersTest.add(new Player("Ash", 0));
//        playersTest.add(new Player("Gary", 0));
//        playersTest.add(new Player("May", 0));
//        playersTest.add(new Player("Hilda", 0));
//        
//
//        gm = new GameMain(playersTest);
//        
//        assertEquals(gm.players.get(0).name, "Ash");
//        assertEquals(gm.players.get(1).name, "Gary");
//        assertEquals(gm.players.get(2).name, "May");
//        assertEquals(gm.players.get(3).name, "Hilda");
//    }
//}
