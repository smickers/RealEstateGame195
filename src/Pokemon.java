import javafx.scene.image.Image;

/*
 *  [File header includes information about the file being submitted.]
 *  Date submitted: May 11, 2016
 *  Assignment number: N/A
 *  Course name:  CPMG195/COSA195
 *  Instructors: Steve Sutcliffe, Tanya Lung, Wade Lahoda, Sharon McDonald
 * 
 */

/**
 * @author Nathan MacNeil cst123
 *
 */
public class Pokemon
{
    // Variable holding the names of all the current pokemon's evolutions.
    public String[] titles;

    // Variable holding the images associated with each evolutions of the
    // current pokemon.
    public Image[] pokemonImages;

    // Variable holding the name of the current evolution for the current
    // pokemon.
    public String currentName;

    // Variable holding the current image of the current pokemon.
    public Image currentImage;

    // Variable holding the number of evolution point required for this pokemon
    // to evolve.
    public int evolutionPointsToEvolve;

    // Variable holding the current amount of evolution points for the current
    // pokemon.
    public int evolutionPoints;

    // Variable holding the current amount of attack points for the current
    // pokemon.
    public int attackPoints;

    // Variable holding the default amount of attack points for the current
    // pokemon.
    public int defaultAttackPoints;

    private int currentIndex = 0;

    /**
     * 
     * Constructor for the Pokemon class.
     * 
     * @param titles
     * @param pokemonImages
     * @param evolutionPointsToEvolve
     * @param defaultAttackPoints
     */
    public Pokemon(String[] titles, Image[] pokemonImages,
            int evolutionPointsToEvolve, int defaultAttackPoints)
    {
        this.titles = titles;
        this.currentName = this.titles[0];

        this.pokemonImages = pokemonImages;
        // TODO Uncomment when we have images
        this.currentImage = this.pokemonImages[0];

        this.evolutionPointsToEvolve = evolutionPointsToEvolve;
        this.defaultAttackPoints = defaultAttackPoints;
        this.evolutionPoints = 0;

    }

    /**
     * 
     * Purpose: Evolve a Pokemon
     * 
     * @return boolean, whether it was evolved or not
     */
    public boolean evolve()
    {
        boolean result = false;
        
        if ( !this.isMaxEvolution() && this.evolutionPoints == 5 )
        {
            this.currentIndex++;

            this.currentName = this.titles[this.currentIndex];
            this.currentImage = this.pokemonImages[this.currentIndex];

            this.resetEvolutionPoints();

            result = true;
        }

        return result;
    }

    /**
     * 
     * Purpose: Devolve a Pokemon.
     * 
     * @return boolean - whether is was devolved or not.
     */
    public boolean devolve()
    {
        boolean result = false;

        if ( !(this.currentIndex == 0) && this.evolutionPoints == -1 )
        {
        	this.currentIndex--;

            this.currentName = this.titles[this.currentIndex];
            this.currentImage = this.pokemonImages[this.currentIndex];

            this.resetEvolutionPoints();

            result = true;
        }

        return result;
    }

    /**
     * 
     * Purpose: Add an evolution point to the Pokemon.
     */
    public void addEvolutionPoint()
    {
        this.evolutionPoints++;
    }
    
    /**
     * PurposE: remove evolution point
     */
    public void removeEvolutionPoint()
    {
        this.evolutionPoints--;
    }
    

    /**
     * 
     * Purpose: Reset a Pokemon's evolution points to zero.
     */
    public void resetEvolutionPoints()
    {
        this.evolutionPoints = 0;
    }

    /**
     * 
     * Purpose: Add a number of points to a Pokemon's set number of attack
     * points.
     * 
     * @param pointsToAdd
     *            - the number of points to add
     */
    public void addToAttackPoints( int pointsToAdd )
    {
        this.attackPoints += pointsToAdd;
    }

    /**
     * 
     * Purpose: Determine if a Pokemon is at it's max evolution.
     * 
     * @return boolean - true if it is at it's max evolution, false otherwise.
     */
    public boolean isMaxEvolution()
    {
        boolean result = false;

        // Determine if the current name is the last name in the array of names
        if ( this.currentName.equals(this.titles[this.titles.length - 1]) )
        {
            result = true;
        }

        return result;
    }

    /**
     * Return a String representation of the Pokemon.
     * 
     * @return String - the Pokemon's name.
     */
    public String toString()
    {
        return this.currentName;
    }
}
