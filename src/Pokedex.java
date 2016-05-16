import java.util.Vector;

/*
 *  [File header includes information about the file being submitted.]
 *  Date submitted: May 11, 2016
 *  Assignment number: N/A
 *  Course name:  CPMG195/COSA195
 *  Instructors: Steve Sutcliffe, Tanya Lung, Wade Lahoda, Sharon McDonald
 * 
 */

/**
 * 
 * The Pokedex class will be used to keep track of Pokemon in a player's hand.
 *
 * @author Nathan MacNeil and Cameron Auser
 * @version 1.0
 */
public class Pokedex
{
    public Player player;
    public Vector<Pokemon> pokemonOwned;

    public Pokedex(Player player)
    {
        // Initiate the variables related to a Pokedex
        this.player = player;
        pokemonOwned = new Vector<Pokemon>();
//        System.out.println("Initial pokemon: " + pokemonOwned.toString());
    }

    /**
     * 
     * Purpose: adds pokemon to the current pokedex.
     * 
     * @param pokemon
     *            the pokemon to add to the pokedex
     */
    public void addPokemon( Pokemon pokemon )
    {
        // Add the passed in Pokemon to their pokedex
        pokemonOwned.add(pokemon);
//        System.out.println("Pokemon added to hand");
//        System.out.println("Current hand: " + pokemonOwned.toString());
    }

    /**
     * 
     * Purpose: removes a specified pokemon from the pokedex.
     * 
     * @param pokemon
     *            the pokemon to remove.
     * @return true if a pokemon was removed from the pokedex.
     */
    public boolean removePokemon( Pokemon pokemon )
    {
        // Remove and return the status of removing
        // a Pokemon from the vector
        return pokemonOwned.remove(pokemon);
    }
}
