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
    
    public Player(Trainer trainer)
    {
        this.trainer = trainer;
    }
    

}
