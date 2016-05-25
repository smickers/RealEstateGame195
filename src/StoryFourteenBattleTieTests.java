
import static org.junit.Assert.*;
import javafx.scene.image.Image;

import org.junit.Before;
import org.junit.Test;

public class StoryFourteenBattleTieTests
{
    public Player challenger;
    public Player defender;
    public Pokemon testChallenger;
    public Pokemon testDefender;
    public Pokemon extraPoke;
    String[] names = new String[] { "a", "b", "c" };

    @Before
    public void setup()
    {
         Image[] singleImages = { null, null };
        testChallenger = new Pokemon(names, singleImages, 5, 3);
        challenger = new Player("Ash", 0);
        challenger.addPokemon(testChallenger);
        challenger.addToBalance(500);

        defender = new Player("May", 2);
        testDefender = new Pokemon(names, singleImages, 5, 3);
        defender.addPokemon(testDefender);
        defender.addToBalance(500);

    }
//TODO
    //Fix this test - battle system needs enhancement.
    @Test
    public void testThatATieResultsInNoMoneyOrPokemonChangingHands()
    {
        Battle battle = new Battle(challenger, defender, testChallenger,
                testDefender, 100);
        //NOT IN THE SCOPE OF S19 - IGNORE DURING DEMO
        battle.battle();

        // Check number of Pokemon, and balance of both players
        assertTrue(challenger.numberOfPokemonOwned() == 1);
        assertTrue(defender.numberOfPokemonOwned() == 1);
        assertTrue(challenger.currentBalance() == 500);
        assertTrue(defender.currentBalance() == 500);
        
        // Make sure that the battle result is a tie
        assertEquals(battle.result, "tie");
    }

}
