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
 * Purpose: Hold all information and behaviors for a Player of Pokemonopoly.
 * 
 * @author Nathan MacNeil and Cameron Auser
 *
 */
public class Player
{

    // The player's Pokedex
    private Pokedex pokedex;
    // The pokecards that the player has in their hand
    private Vector<Pokecard> pokecardsInHand;
    // The player's balance
    private int balance;
    // The number of winpoints the player has
    public int winPoints;
    // The player's current location
    public int currentLocation;
    public int turnOrder;
    public String name;

    /**
     * 
     * Constructor for the Player class.
     * 
     * @param trainer
     *            - the trainer to create the player with .
     */
    public Player(String name, int turnOrder)
    {
    	
        // Initialize the variables associated with a player
    	if(name == null || name == "")
    	{
    		this.name = "missingNo";
    	}
    	else
    	{
    		this.name = name;
    	}
        
        this.turnOrder = turnOrder;
        pokecardsInHand = new Vector<Pokecard>();
        pokedex = new Pokedex(this);
        balance = 0;
        
    }

    /**
     * 
     * Purpose: gives the trainer a pokemon.
     * 
     * @param pokemon
     *            the pokemon being given to the player.
     */
    public void addPokemon( Pokemon pokemon )
    {
        // Add the Pokemon to the player's Pokedex
        pokedex.addPokemon(pokemon);
      //TODO This syso shouldn't be here, delete it.
        System.out.println("Balance after add: " + balance);
    }

    /**
     * 
     * Purpose: takes pokemon away from the player.
     * 
     * @param pokemon
     *            the pokemon being taken away from the player.
     * @return true if pokemon was removed.
     */
    public boolean removePokemon( Pokemon pokemon )
    {
        // Remove & return the status of removing
        // A pokemon from a user's Pokedex
        return pokedex.removePokemon(pokemon);
    }

    /**
     * 
     * Purpose: increases the player's balance by the amount specified.
     * 
     * @param toAdd
     *            amount to give the player.
     */
    public void addToBalance( int toAdd )
    {
 
        // Ensure the balance is > 0, then add it
        if ( toAdd > 0 )
        {
            balance += toAdd;
        }
    }

    /**
     * 
     * Purpose: decreases the player's balance by the amount specified.
     * 
     * @param toRemove
     *            amount to remove from the player.
     * @return true if any money was removed.
     */
    public boolean removeFromBalance( int toRemove )
    {
        boolean toReturn = false;
        // If the amount to remove is > the current balance,
        // then nothing will happen and false will be returned
        if ( toReturn = sufficientBalance(toRemove) && toRemove > 0 )
        {
            balance -= toRemove;
            toReturn = true;
        }
        // Return true if the amount was removed from the balance
        return toReturn;
    }

    /**
     * 
     * Purpose: checks to see if the player has enough balance to have an amount
     * removed.
     * 
     * @param amountToRemove
     *            the amount being tested against the player's balance.
     * @return true if player has more balance than the amount passed in.
     */
    public boolean sufficientBalance( int amountToRemove )
    {
        // Determine if the amount passed in can be removed,
        // and return a boolean with the answer
        return (balance - amountToRemove >= 0);
    }

    /**
     * 
     * Purpose: gives the trainer a pokecard.
     * 
     * @param pokecard
     *            card to give player.
     */
    public void addPokecard( Pokecard pokecard )
    {
        // Add a pokecard to their pokedex
        pokecardsInHand.add(pokecard);
    }

    /**
     * 
     * Purpose: takes away the specified card from the player.
     * 
     * @param pokecard
     *            card to take away.
     * @return true if a card was taken away.
     */
    public boolean removePokecard( Pokecard pokecard )
    {
        // Remove and return the result of removing
        // a pokemon from the pokedex
        return pokecardsInHand.remove(pokecard);
    }

    /**
     * 
     * Purpose: returns the current balance of the player.
     * 
     * @return the current balance of the player.
     */
    public int currentBalance()
    {
        // Just return their balance
        return balance;
    }

}
