import javafx.scene.image.Image;




/*
 *  [File header includes information about the file being submitted.]
 *  Date submitted:
 *  Assignment number:
 *  Course name:  CPMG
 *  Instructors: Sharon McDonald, Nelson Wong
 * 
 */

/**
 * @author Nathan MacNeil cst123
 *
 */
public class Pokemon
{
    //Variable holding the names of all the current pokemon's evolutions.
    public String[] titles;
    
    //Variable holding the images associated with each evolutions of the 
    // current pokemon.
    public Image[] pokemonImages;
    
    //Variable holding the name of the current evolution for the current 
    // pokemon.
    public String currentName;
    
    //Variable holding the current image of the current pokemon.
    public Image currentImage;
    
    //Variable holding the number of evolution point required for this pokemon
    // to evolve.
    public int evolutionPointsToEvolve;
    
    //Variable holding the current amount of evolution points for the current 
    // pokemon.
    public int evolutionPoints;
    
    //Variable holding the current amount of attack points for the current 
    // pokemon.
    public int attackPoints;
    
    //Variable holding the default amount of attack points for the current
    // pokemon. 
    public int defaultAttackPoints;
    
    
    public Pokemon( String[] titles, Image[] pokemonImages, 
            int evolutionPointsToEvolve, int defaultAttackPoints )
    {
        this.titles = titles;
        this.currentName = this.titles[0];
        
        this.pokemonImages = pokemonImages;
        this.currentImage = this.pokemonImages[0];
        
        this.evolutionPointsToEvolve = evolutionPointsToEvolve;
        this.defaultAttackPoints = defaultAttackPoints;
        this.evolutionPoints = 0;
        
    }
    
    public boolean evolve()
    {
        
        return false;
    }
    
    public boolean devolve() 
    {
        return false;
    }
    
    public void addEvolutionPoint()
    {
        this.evolutionPoints++;
    }
    
    public void resetEvolutionPoints()
    {
        this.evolutionPoints = 0;
    }
    
    public void addToAttackPoints( int pointsToAdd )
    {
        this.attackPoints += pointsToAdd;
    }
    
    public boolean isMaxEvolution()
    {
        boolean result = false;
        
        if( this.currentName.equals( this.titles[this.titles.length-1] ) )
        { 
            result = true;
        }
        
        return result;
    }
}

