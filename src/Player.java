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
    public Pokedex pokedex;
    public Pokecard[] pokeCardsInHand;
    private int balance;
    public int winPoints;
    public int currentLocation;
    public int newLocation;
    
    public Player(Trainer trainer)
    {
        this.trainer = trainer;
    }
    
    public void changeBalance(int amountToChange)
    {
        amountToChange += balance;
    }
    
    public boolean sufficientBalance(int amountToChange)
    {
        return (amountToChange -= balance) >= 50;   
    }
    
    public void addPokeCard(Pokecard pokecard)
    {
        Pokecard[]temp = pokeCardsInHand;
        pokeCardsInHand = new Pokecard[temp.length+1];
        System.arraycopy(temp, 0, pokeCardsInHand, 0, temp.length);
        ///NEED TO FIX THE BELOW LINE///
        //pokeCardsInHand[temp.length] = new Pokecard(pokecard);
    }
    
    public Tile getLocation()
    {
        return GameBoard.gameTiles[currentLocation];
    }

}
