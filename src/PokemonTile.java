
public class PokemonTile
{
    //Variable holding the cost to purchase the current PokemonTile.
    public int cost;
    
    //Variable holding the player that currently owns the current PokemonTile. 
    private Player owner;
    
    
    public Pokemon relatedPokemon;
    
    public PokemonTile( Pokemon relatedPokemon, int cost )
    {
        this.relatedPokemon = relatedPokemon;
        this.cost = cost;
    }
    
    public void action( Player player )
    {
        
    }
    
    public void purchase( Player player )
    {
        if( player.sufficientBalance( this.cost ) )
        {
            player.pokedex.addPokemon( this.relatedPokemon );
            
            changeOwner( player );
        }
        else
        {
            
        }
    }
    
    public void changeOwner( Player newPlayer )
    {
        this.owner = newPlayer;
    }
}
