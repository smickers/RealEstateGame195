import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestBattleWithMoneyExchange
{

    private Trainer trainer;

    private Player challenger;

    private Pokemon challengerPokemon;
    private String[] evols = { "Magikarp", "Gyarados" };
    
    private Trainer trainer2;

    private Player defender;

    private Pokemon defenderPokemon;
    private String[] evols2 = { "Pikachu", "Raichu" };
    // private Image[] imgs = {null, null};

    private Battle battle;
   

    // The cost of a Pokemon tile
    private static final int COST_OF_TILE = 200;
    private static final int STARTING_PLAYER_BALANCE = 500;

    @Before
    public void setUp()
    {
        this.trainer = new Trainer("Ash", null, null);
        
        this.challenger = new Player("Ash", 0);
        this.challenger.addToBalance( 500 );

        this.challengerPokemon = new Pokemon(this.evols, null, 10, 1);
        
        
        
        this.trainer2 = new Trainer("Gary", null, null);

        this.defender = new Player("Gary", 1);
        this.defender.addToBalance( 500 );

        this.defenderPokemon = new Pokemon(this.evols, null, 10, 1);
        
        this.battle = new Battle(challenger, defender, challengerPokemon,
                defenderPokemon, COST_OF_TILE);

    }

    
    public void testThatChallengerWinsBattle()
    {
        this.battle.moneyExchange(challenger, defender);
        
        
        assertEquals( STARTING_PLAYER_BALANCE + (COST_OF_TILE/2), 
                challenger.currentBalance() );
        assertEquals( STARTING_PLAYER_BALANCE - (COST_OF_TILE/2), 
                defender.currentBalance() );
    }
    
    @Test
    public void testThatDefenderWinsBattle()
    {
        this.battle.moneyExchange(defender, challenger);
        
        assertEquals( STARTING_PLAYER_BALANCE + (COST_OF_TILE/2), 
                defender.currentBalance() );
        assertEquals( STARTING_PLAYER_BALANCE - (COST_OF_TILE/2), 
                challenger.currentBalance() );
    }
//    @Test
//    public void testThatChallengerWinsBattle()
//    {
//        this.battle.moneyExchange(challenger, defender);
//        
//        
//        assertEquals( 600, challenger.currentBalance() );
//        assertEquals( 400, defender.currentBalance() );
//    }
//    
//    @Test
//    public void testThatDefenderWinsBattle()
//    {
//        this.battle.moneyExchange(defender, challenger);
//        
//        assertEquals( 600, defender.currentBalance() );
//        assertEquals( 400, challenger.currentBalance() );
//        
//    }
//    @Test
//    public void testThatChallengerWinsBattle()
//    {
//        this.battle.moneyExchange(challenger, defender);
//        
//        
//        assertEquals( 600, challenger.currentBalance() );
//        assertEquals( 400, defender.currentBalance() );
//    }
//    
//    @Test
//    public void testThatDefenderWinsBattle()
//    {
//        this.battle.moneyExchange(defender, challenger);
//        
//        assertEquals( 600, defender.currentBalance() );
//        assertEquals( 400, challenger.currentBalance() );
//        
//    }
    
    
    
    
    
    

}
