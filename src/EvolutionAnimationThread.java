
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/*
 *  Thread class that will alter the images of a pokemon when they are being
 *  evolved or devolved
 *  Date submitted: N/A
 *  Assignment number: N/A
 *  Course name:  COSACPMG195
 * 
 */

/**
 * @author Kyler, Travis
 *
 */
public class EvolutionAnimationThread implements Runnable
{

    private ImageView img;
    private Pokemon  poke;
    private Image currentPokemonState;
    private Image nextPokemonState;
    private String devolveSong = "dundundun.mp3";
    private String evolveSong = "evolve.mp3";
    private String pokemonPreEvolutionName;
    private Text subtitle;
    private String evolutionOrDevolution;

    /**
     * Constructor, grabs all the passed in information to evolve or devolve a
     * pokemon
     * 
     * @param img
     *            The image on the pane being changed
     * @param poke
     *            The pokemon currently being evolved.
     * @param pokemonFirstName
     *            The original name of the pokemon prior to change
     * @param currentPokemonState
     *            The pokemons image prior to changing
     * @param nextPokemonState
     *            The pokemons evolution/devolution
     * @param statusText
     *            The text in the pane that will be altered
     * @param evOrDev
     *            Whether the pokemon is evolving or devolving.
     */
    public EvolutionAnimationThread(ImageView img, Pokemon poke,
            String pokemonFirstName, Image currentPokemonState,
            Image nextPokemonState, Text statusText, String evOrDev)
    {
        this.img = img;
        this.poke = poke;
        this.currentPokemonState = currentPokemonState;
        this.nextPokemonState = nextPokemonState;
        this.pokemonPreEvolutionName = pokemonFirstName;
        this.subtitle = statusText;
        this.evolutionOrDevolution = evOrDev;

    }

    @Override
    public void run()
    {
        /*
         * Loop over and over changing the image each time, ending on the
         * pokemons final state.
         */
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        for (int i = 0; i < 25; i++)
        {
            // If the "i" is even, we want to display the pokemons "next" state,
            // Otherwise we want to show how they are pre-state change.
            if (i % 2 == 0)
            {
                img.setImage(nextPokemonState);
            }
            else
            {
                img.setImage(currentPokemonState);
            }
            try
            {
                // Sleep so it doesn't change the images instantly.
                Thread.sleep(75);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        /*
         * After everything is altered and the image is the finals pokemon
         * evolution, we want to change the text displayed under the pokemon to
         * explain what happened. evOrDev will display either "evolved" or
         * "devolved", allowing us to have this thread work for both evolution
         * and devolution
         */
        subtitle.setText(pokemonPreEvolutionName + " has " + evolutionOrDevolution + " into "
                + poke.currentName + "!");
        sound music = new sound();

        if (evolutionOrDevolution.equals(evolutionPane.DEVOLVE_TEXT))
        {
            // Play a "negative" sound effect if the pokemon was devolved
            music.playSound(devolveSong);
        }
        else
        {
            // Play a "positive" sound effect if the pokemon was evolved.
            music.playSound(evolveSong);
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
