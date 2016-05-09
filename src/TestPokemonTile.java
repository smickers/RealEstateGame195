import static org.junit.Assert.*;
import java.awt.Image;

import org.junit.Before;
import org.junit.Test;


public class TestPokemonTile
{
    private Trainer trainer;
    
    private Player player;
    
    private Pokemon pokemon;
        private String[] evols = {"Magikarp", "Gyarados" };
        private Image[] imgs = {null, null};
    
    private PokemonTile tile;
    
    private static final int COST_OF_TILE = 100;

    @Before
    public void setUp() 
    {
        this.trainer = new Trainer( "Ash", null, null );
        
        this.player( this.trainer );
        
        this.pokemon = new Pokemon(this.evols, this.imgs, 10, 1 );
        
        this.tile = new PokemonTile( this.pokemon, COST_OF_TILE );
        
    }
    
    @Test
    public void testThatPurchaseDeductsFromPlayersBalanceIfTheyHaveEnoughCash()
    {
        this.player.changeBalance( 100 );
        
        this.tile.purchase( this.player );
        
        int result = this.player.balance;
        
        assertEquals(0, result);
        
    }
    
    @Test
    public void testThatPurchaseDoesntDeductFromPlayersIFBalanceIsInsufficient()
    {
        this.player.changeBalance( 50 );
        
        this.tile.purchase( this.player );
        
        int result = this.player.balance;
        
        assertEquals(50, result);
    }
    
    @Test
    public void testThatPurchaseGivesPokemonToPlayer()
    {
        this.player.changeBalance( 100 );
        
        this.tile.purchase( this.player );
        
        String result = this.player.pokedex.pokemonOwned[0].currentName; 
        
        assertEquals("Magikarp", result);
    }
    
    @Test
    public void testThatChangeOwnerChangesTheTileOwner()
    {
        this.tile.changeOwner( this.player );
        
        String result = this.player.trainer.name;
        
        assertEquals("Ash", result);
        
    }
    
   

}
