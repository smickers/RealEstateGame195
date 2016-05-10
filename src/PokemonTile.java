import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;


public class PokemonTile extends Tile
{
    //Variable holding the cost to purchase the current PokemonTile.
    public int cost;
    
    //Variable holding the player that currently owns the current PokemonTile. 
    private Player owner;
    
    //Variable holding the Pokemon for this tile.
    public Pokemon relatedPokemon;
    
    public GameBoard board;
    
    public PokemonTile( Pokemon relatedPokemon, int cost, GameBoard board, String name, Image image )
    {
        super(name, image);
        this.relatedPokemon = relatedPokemon;
        this.cost = cost;
        this.board = board;
    }
    
    public void action( Player player )
    {
        if (owner != null)
        {
            // do a battle
        }
        else
        {
            // tile is up for sale
            purchase(player);
        }
    }
    
    public void purchase( Player player )
    {
//        if( player.sufficientBalance( this.cost ) )
//        {
//            player.pokedex.addPokemon( this.relatedPokemon );
//            
//            changeOwner( player );
            
        if (player.sufficientBalance(cost))
        {
            BorderPane toShow = new BorderPane();
            
            Text topMessage = new Text("Do you want to purchase " + super.name + "?");
            
            toShow.setTop(topMessage);
            
            toShow.setCenter(new ImageView(super.image));
            //Update the GUI
        }
        else
        {
            //Update the GUI with the not enough money message
        }
    }
    
    public void changeOwner( Player newPlayer )
    {
        this.owner = newPlayer;
    }
}
