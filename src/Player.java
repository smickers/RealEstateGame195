/**CLASS: Player
 * @info: Creates an individual Player object
 * @author cst104
 *
 */
public class Player
{
    //Trainer the Player has chosen as a token
    public Trainer trainer;
    //provides the list of Pokemon the player 'owns'
    public Pokedex pokedex;
    //List of PokeCards the player possesses
    public Pokecard[] pokeCardsInHand;
    //Player's bank balance
    private int balance;
    //Win Points (max evolved Pokemon) the current player has accumulated
    public int winPoints;
    //Player's current location
    public int currentLocation;
    //New location player will move to
    public int newLocation;
    
///////////////////////////////////////////////////////////////////////////////    
///////////////////////////////////////////////////////////////////////////////    
    
    //NOT FOR RELEASE 1
    public Player(Trainer trainer)
    {
        this.trainer = trainer;
    }
    
    //NOT FOR RELEASE 1
    public void changeBalance(int amountToChange)
    {
        amountToChange += balance;
    }
    
    //NOT FOR RELEASE 1
    public boolean sufficientBalance(int amountToChange)
    {
        return (amountToChange -= balance) >= 50;   
    }
    
    //NOT FOR RELEASE 1
    public void addPokeCard(Pokecard pokecard)
    {
        Pokecard[]temp = pokeCardsInHand;
        pokeCardsInHand = new Pokecard[temp.length+1];
        System.arraycopy(temp, 0, pokeCardsInHand, 0, temp.length);
        ///NEED TO FIX THE BELOW LINE///
        //pokeCardsInHand[temp.length] = new Pokecard(pokecard);
    }
    
    /**
     * METHOD: getLocation()
     * @info:   When called, returns the Tile the player is currently located
     *          on.
     * @return: Tile that the player is currently on.
     */
    public Tile getLocation()
    {
        return GameBoard.gameTiles[currentLocation];
    }

}
