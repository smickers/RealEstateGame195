import java.awt.Image;

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
    public int evolutionsPointsToEvolve;
    
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
        
    }
    
    public void resetEvolutionPoints()
    {
        
    }
    
    public void addToAttackPoints( int pointsToAdd )
    {
        
    }
    
    public boolean isMaxEvolution()
    {
        return false;
    }
}
