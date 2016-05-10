import static org.junit.Assert.assertEquals;


import javafx.scene.image.Image;

import org.junit.Before;
import org.junit.Test;


public class TestPokemon
{
    private Pokemon singleEvolution;
    private String[] singleTitles = {"Magikarp", "Gyarados" };
    private Image[] singleImages = {new Image("pic"), new Image("pic")};

    private Pokemon doubleEvolution; 
    private String[] doubleTitles = {"Charmander", "Charmeleon", "Charizard" };
    private Image[] doubleImages = {new Image(""), new Image("")};
    
    
    @Before
    public void setUp() throws Exception
    {
        this.singleEvolution = new Pokemon(this.singleTitles, 
                this.singleImages, 10, 1);
        
        this.doubleEvolution = new Pokemon(this.doubleTitles, 
                doubleImages, 5, 1);
    } 

    @Test
    public void testThatEvolveAndDevolveChangeTheNameAndImageOfThePokemon()
    {
        this.singleEvolution.evolve();
        String result = this.singleEvolution.currentName;
        
        this.doubleEvolution.evolve();
        String result2 = this.doubleEvolution.currentName;
        
        this.doubleEvolution.evolve();
        String result3 = this.doubleEvolution.currentName;
        
        assertEquals("Gyarados", result);
        assertEquals("Charmeleon", result2);
        assertEquals("Charizard", result3);
        
        this.singleEvolution.devolve();
        String result4 = this.singleEvolution.currentName;
        
        this.doubleEvolution.devolve();
        String result5 = this.doubleEvolution.currentName;
        
        this.doubleEvolution.devolve();
        String result6 = this.doubleEvolution.currentName;
        
        assertEquals("Magikarp", result4);
        assertEquals("Charmeleon", result5);
        assertEquals("Charmander", result6);
    }
    
    @Test
    public void testThatAddEvolutionPointsIncrementsTheAmountOfEvolutionPoints()
    {
        this.singleEvolution.addEvolutionPoint();
        int result = this.singleEvolution.evolutionPoints;
        
        this.singleEvolution.addEvolutionPoint();
        int result2 = this.singleEvolution.evolutionPoints;
        
        this.doubleEvolution.addEvolutionPoint();
        int result3 = this.doubleEvolution.evolutionPoints;
        
        assertEquals(1, result);
        assertEquals(2, result2);
        assertEquals(1, result3);
    }
    
    @Test
    public void testThatResetEvolutionPointsSetsEvolutionPointsToZero()
    {
        this.singleEvolution.resetEvolutionPoints();
        int result = this.singleEvolution.evolutionPoints;
        
        this.doubleEvolution.resetEvolutionPoints();
        int result2 = this.doubleEvolution.evolutionPoints;
        
        assertEquals(0, result);
        assertEquals(0, result2);
    }
    
    @Test
    public void testThatAddAttackPointsIncreasesAttackPoints()
    {
        this.singleEvolution.addToAttackPoints( 5 );
        int result = this.singleEvolution.attackPoints;
        
        this.doubleEvolution.addToAttackPoints( 10 );
        int result2 = this.doubleEvolution.attackPoints;
        
        assertEquals(5, result);
        assertEquals(10, result2);
    }
    
    @Test
    public void testThatIsMaxEvolutionReturnsTrueIfPokemonIsAtLastEvolution()
    {
        this.singleEvolution.evolve();
        boolean result = this.singleEvolution.isMaxEvolution();
        
        this.doubleEvolution.evolve();
        this.doubleEvolution.evolve();
        boolean result2 = this.doubleEvolution.isMaxEvolution();
        
        assertEquals(true, result);
        assertEquals(true, result);
    }
    
    @Test
    public void testThatIsMaxEvolutionReturnsFalseIfPokemonNotAtLastEvolution()
    {
        boolean result = this.singleEvolution.isMaxEvolution();
        
        boolean result2 = this.doubleEvolution.isMaxEvolution();
        
        assertEquals(false, result);
        assertEquals(false, result2);
    }
}
