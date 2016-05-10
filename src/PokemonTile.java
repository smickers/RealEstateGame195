
public class PokemonTile
{
    //Variable holding the cost to purchase the current PokemonTile.
    public int cost;
    
    //Variable holding the player that currently owns the current PokemonTile. 
    private Player owner;
    
    //Variable holding the Pokemon for this tile.
    public Pokemon relatedPokemon;
    
    public GameBoard board;
    
    public PokemonTile( Pokemon relatedPokemon, int cost, GameBoard board )
    {
        this.relatedPokemon = relatedPokemon;
        this.cost = cost;
        this.board = board;
    }
    
    public void action( Player player )
    {
        this.board.updateCenterView( 
                new BuyingPokemonPane(player, this.relatedPokemon, 
                        this.cost, this) );
    }
    
    public void purchase( Player player )
    {
        if( player.sufficientBalance( this.cost ) )
        {
            player.pokedex.addPokemon( this.relatedPokemon );
            
            changeOwner( player );
            
            //Update the GUI
        }
        else
        {
            //Update the GUI with the 
        }
    }
    
    public void changeOwner( Player newPlayer )
    {
        this.owner = newPlayer;
    }
}
