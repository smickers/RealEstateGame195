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

    ImageView img;
    Pokemon poke;
    int time = 1;
    Image currentPokemonState;
    Image nextPokemonState;
    private String dunDunDun = "dundundun.mp3";
    private String evolve = "evolve.mp3";
    String pokemonFirstName;
    Text t;
    String evOrDev;

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
     * @param evorDev
     *            Whether the pokemon is evolving or devolving.
     */
    public EvolutionAnimationThread(ImageView img, Pokemon poke,
            String pokemonFirstName, Image currentPokemonState,
            Image nextPokemonState, Text statusText, String evorDev)
    {
        this.img = img;
        this.poke = poke;
        this.currentPokemonState = currentPokemonState;
        this.nextPokemonState = nextPokemonState;
        this.pokemonFirstName = pokemonFirstName;
        this.t = statusText;
        this.evOrDev = evorDev;

    }

    @Override
    public void run()
    {
        /*
         * Loop over and over changing the image each time, ending on the
         * pokemons final state.
         */
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
        t.setText(pokemonFirstName + " has " + evOrDev + " into "
                + poke.currentName + "!");
        sound music = new sound();

        if (evOrDev.equals(evolutionPane.DEVOLVE_TEXT))
        {
            // Play a "negative" sound effect if the pokemon was devolved
            music.playSound(dunDunDun);
        }
        else
        {
            // Play a "positive" sound effect if the pokemon was evolved.
            music.playSound(evolve);
        }

    }
}
