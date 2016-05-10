import java.util.Vector;

/*
 *  [File header includes information about the file being submitted.]
 *  Date submitted:
 *  Assignment number:
 *  Course name:  COSC 190
 *  Instructors: Sharon McDonald, Nelson Wong
 * 
 */

/**
 * @author cst104
 *
 */
public class Player
{
    public Trainer trainer;
    private Pokedex pokedex;
    private Vector<Pokecard> pokecardsInHand;
    private int balance;
    public int winPoints;
    public int currentLocation;
    
    public Player(Trainer trainer)
    {
        this.trainer = trainer;
        pokecardsInHand = new Vector<Pokecard>();
        pokedex = new Pokedex();
    }
    
    public void addPokemon(Pokemon pokemon)
    {
//        pokedex.addPokemon(pokemon);
    }
    
//    public boolean removePokemon(Pokemon pokemon)
//    {
////        return pokedex.removePokemon(pokemon);
//    }
    
    public void addToBalance(int toAdd)
    {
        if (toAdd > 0)
        {
            balance += toAdd;
        }
    }
    
    public boolean removeFromBalance(int toRemove)
    {
        boolean toReturn = false;
        if (toReturn = sufficientBalance(toRemove) && toRemove > 0)
        {
            balance -= toRemove;
//            toReturn = true;
        }
        return toReturn;        
    }
    
    public boolean sufficientBalance(int amountToRemove)
    {
        return (balance - amountToRemove >= 0);
    }
    
    public void addPokecard(Pokecard pokecard)
    {
        pokecardsInHand.add(pokecard);
    }
    
    public boolean removePokecard(Pokecard pokecard)
    {
        return pokecardsInHand.remove(pokecard);
    }
    
    public int currentBalance()
    {
        return balance;
    }
    

}
