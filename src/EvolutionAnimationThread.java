import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/*
 *  [File header includes information about the file being submitted.]
 *  Date submitted:
 *  Assignment number:
 *  Course name:  COSC 190
 *  Instructors: Shane McDonald, Kevin Bryant
 * 
 */

/**
 * @author cst131
 *
 */
public class EvolutionAnimationThread implements Runnable {

	ImageView img;
    Pokemon poke;
    int time = 1;
    Image currentPokemonState;
    Image nextPokemonState;
    String pokemonFirstName;
    Text t;
    
    public EvolutionAnimationThread(ImageView img, Pokemon poke, String pokemonFirstName, Image currentPokemonState, Image nextPokemonState, Text t)
    {
    	this.img = img;
    	this.poke = poke;
    	this.currentPokemonState =currentPokemonState;
    	this.nextPokemonState= nextPokemonState;
    	this.pokemonFirstName = pokemonFirstName;
    	this.t = t;
    }
    
    @Override
    public void run()
    {
        for(int i = 0; i < 25; i++)
        {
        	if(i % 2 == 0)
        	{
        		img.setImage(nextPokemonState);
        	}
        	else
        	{
        		img.setImage(currentPokemonState);
        	}
        	try {
				Thread.sleep(75);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        t.setText(pokemonFirstName + " evolved into " + poke.currentName +"!");
        
    }
}
