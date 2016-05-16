import static org.junit.Assert.*;
import javafx.scene.image.Image;

import org.junit.Before;
import org.junit.Test;

public class BattleStoryThirteenTests
{
    public Player challenger;
    public Player defender;
    public Pokemon testChallenger;
    public Pokemon testDefender;
    public Pokemon extraPoke;
    String[] names = new String[] { "a", "b", "c" };

    // ///////////////////////////////////////////////
    // // Ensure you've commented out the correct ////
    // // lines in Battle.java before ////
    // // running any of these tests! ////
    // ///////////////////////////////////////////////
    @Before
    public void setup()
    {
        testChallenger = new Pokemon(names, null, 5, 3);
        challenger = new Player(new Trainer("Test trainer A", null, null));
        challenger.addPokemon(testChallenger);

        defender = new Player(new Trainer("Test trainer B", null, null));
        testDefender = new Pokemon(names, null, 5, 3);
        defender.addPokemon(testDefender);

    }

    @Test
    public void testThatPokemonExchangeCorrectlyExchangesPokemon()
    {
        Battle testBattle = new Battle(challenger, defender, testChallenger,
                testDefender, 200);
//        testBattle.pokemonExchange(challenger, defender);
        testBattle.battle();

        assertEquals(challenger.numberOfPokemonOwned(), 0);
        assertEquals(defender.numberOfPokemonOwned(), 2);
    }

    @Test
    public void testThatPokemonExchangeWorksCorrectlyWithMorePokemon()
    {
        extraPoke = new Pokemon(names, null, 5, 3);
        defender.addPokemon(extraPoke);

        Battle testBattle = new Battle(challenger, defender, testChallenger,
                testDefender, 200);
//        testBattle.pokemonExchange(challenger, defender);
        testBattle.battle();

        assertEquals(challenger.numberOfPokemonOwned(), 0);
        assertEquals(defender.numberOfPokemonOwned(), 3);
    }

}
