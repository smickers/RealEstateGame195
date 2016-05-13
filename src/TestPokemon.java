import static org.junit.Assert.assertEquals;


import javafx.scene.image.Image;

import org.junit.Before;
import org.junit.Test;


public class TestPokemon
{
    private Pokemon singleEvolution;
    private String[] singleTitles = {"Magikarp", "Gyarados" };

    //Need actual pictures to test 
    private Image[] singleImages = {null, null};

    private Pokemon doubleEvolution; 
    private String[] doubleTitles = {"Charmander", "Charmeleon", "Charizard" };
    
    //Need actual pictures to test 
    private Image[] doubleImages = {null, null, null};
    
    
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
        this.singleEvolution.evolutionPoints = 5;
        this.singleEvolution.evolve();
        String result = this.singleEvolution.currentName;
        
        this.doubleEvolution.evolutionPoints = 5;
        this.doubleEvolution.evolve();
        String result2 = this.doubleEvolution.currentName;
        
        this.doubleEvolution.evolutionPoints = 5;
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
        this.singleEvolution.evolutionPoints = 5;
        this.singleEvolution.evolve();
        boolean result = this.singleEvolution.isMaxEvolution();
        
        this.doubleEvolution.evolutionPoints = 5;
        this.doubleEvolution.evolve();
        this.doubleEvolution.evolutionPoints = 5;
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
    
    @Test
    public void addEvolutionPoint()
    {
        singleEvolution.addEvolutionPoint();
        assertEquals(1, singleEvolution.evolutionPoints);
        singleEvolution.addEvolutionPoint();
        singleEvolution.addEvolutionPoint();
        singleEvolution.addEvolutionPoint();
        singleEvolution.addEvolutionPoint();
        assertEquals(5, singleEvolution.evolutionPoints);
        
        
        //If evolve is called, check their evolution points are equal to 0
        //singleEvolution.evolve();
        assertEquals(0, singleEvolution.evolutionPoints);

    }
}
