import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/*
 *  Pane that focuses on evolving and devolving pokemon
 *  
 *  Date submitted: N/A
 *  Assignment number: N/A
 *  Course name:  COSACPMG195
 * 
 */

/**
 * @author Kyler, Travis
 *
 */
public class evolutionPane extends Thread implements Runnable
{

    private static String evolutionSong = "evolution.mp3";
    private static String devolutionSong = "devolutionCut.mp3";
    private static Pokemon pokemon;
    private static ImageView iv1;
    private static Image pokemonFirstImage;
    private static Thread evolveDevolveAnimation;
    public static final String EVOLVE_TEXT = "evolved";
    public static final String DEVOLVE_TEXT = "devolved";

    /**
     * Setting up the pane and images/text for when the pokemon is being evolved
     * 
     * @param p
     *            The pokemon being evolved/devolved
     * @return The pane that was created.
     */
    public static Pane buildEvolutionPane(Pokemon p)
    {
        pokemon = p;

        // Begin playing the evolution jingle from pokemon
        sound music = new sound();
        music.playSound(evolutionSong);

        // Creating the vbox.
        VBox vbox = new VBox();
        // Setting the size of the vbox
        vbox.setPrefSize(500, 500);
        // Saving the pokemons name before they have been evolved
        String pokemonFirstName = pokemon.currentName;
        // Saving the pokemons image before they have been evolved
        pokemonFirstImage = pokemon.currentImage;
        // Setting the text of the pane to show the pokemons name and
        // "is evolving"!
        Text t = new Text(pokemon.currentName + " is evolving!");
        iv1 = new ImageView(pokemon.currentImage);
        // Forcing the image to only be 200x200, to prevent scaling issues.
        iv1.setFitHeight(200);
        iv1.setFitWidth(200);
        // TODO Test button, this code will run automatically without the button
        // After testing is complete.
        Button button = new Button("Add Evolution Point");
        Button button2 = new Button("Remove Evolution Point");
        button2.setDisable(true);
        Text title = new Text("EVOLUTION!");
        // Adding everything to the pane.
        vbox.getChildren().add(title);
        vbox.getChildren().add(iv1);
        vbox.getChildren().add(t);
        vbox.getChildren().add(button);
        vbox.getChildren().add(button2);

        // Calling the evolve of the pokemon
        

        // Creating the thread to change the images, passing in everything
        // needed
        
        // Alert alert = new Alert(AlertType.INFORMATION, "Woah, " +
        // pokemon.currentName + " is evolving!" );
        // alert.show();
        vbox.setAlignment(Pos.CENTER);

        /**
         * Temporary anonymous class to test the evolution/devolution, this will
         * happen automatically in the release.
         */
        button.setOnAction(new EventHandler<ActionEvent>()
        {
            /**
             * Purpose: shows the evolution when button is pressed
             */
            @SuppressWarnings("static-access")
            public void handle(ActionEvent event)
            {
                pokemon.addEvolutionPoint();
                System.out.println(pokemon.evolutionPoints);
                if(pokemon.evolutionPoints == 0)
                {
                    //pokemon.evolve();
                    
                    evolveDevolveAnimation = new Thread(new EvolutionAnimationThread(iv1,
                            pokemon, pokemonFirstName, pokemonFirstImage,
                            pokemon.currentImage, t, EVOLVE_TEXT));
                    evolveDevolveAnimation.start();
                }
            }

        });
        

        return vbox;
    }

    /**
     * Sets up the pane for when the pokemon is being devolved
     * 
     * @param p
     *            the pokemnon being devolved.
     * @return the pane being created
     */
    public static Pane buildDevolutionPane(Pokemon p)
    {
        pokemon = p;
        // Begin playing the evolution jingle from pokemon
        sound music = new sound();
        music.playSound(devolutionSong);
        // Creating the vbox.
        VBox vbox = new VBox();
        // Setting the size of the vbox
        vbox.setPrefSize(500, 500);
        // Stores the pokemons name before they are devolved.
        String pokemonFirstName = pokemon.currentName;
        // Stored the image of the pokemon before they are devolved.
        pokemonFirstImage = pokemon.currentImage;
        // Setting the text to reflect that the pokemon is devolving.
        Text t = new Text(pokemon.currentName + " is devolving!");
        iv1 = new ImageView(pokemon.currentImage);
        // Forcing the image to be 200x200
        iv1.setFitHeight(200);
        iv1.setFitWidth(200);
        // Temporary button for testing.
        Text title = new Text("DEVOLUTION! I didn't know that could happen");
        Button button = new Button("Add Evolution Point");
        Button button2 = new Button("Remove Evolution Point");
        button.setDisable(true);
        vbox.getChildren().add(title);
        vbox.getChildren().add(iv1);
        vbox.getChildren().add(t);
        vbox.getChildren().add(button);
        vbox.getChildren().add(button2);

        // Calling the devolution
        // Creating the new thread with the pokemon being devolved.
        
        // Alert alert = new Alert(AlertType.INFORMATION, "Woah, " +
        // pokemon.currentName + " is evolving!" );
        // alert.show();
        vbox.setAlignment(Pos.CENTER);

        /**
         * Temporary anonymous button handler to test
         */
        button2.setOnAction(new EventHandler<ActionEvent>()
        {
            /**
             * Purpose: shows the evolution when button is pressed
             */
            @SuppressWarnings("static-access")
            public void handle(ActionEvent event)
            {
                pokemon.removeEvolutionPoint();
                System.out.println(pokemon.evolutionPoints);
                if(pokemon.evolutionPoints == pokemon.evolutionPointsToEvolve - 1)
                {
                    pokemon.devolve();
                    evolveDevolveAnimation = new Thread(new EvolutionAnimationThread(iv1,
                            pokemon, pokemonFirstName, pokemonFirstImage,
                            pokemon.currentImage, t, DEVOLVE_TEXT));
                    evolveDevolveAnimation.start();
                    System.out.println("Pokemons Evo point after DEvolution: " + pokemon.evolutionPoints);
                }
                
                //button.setDisable(true);
            }

        });

        return vbox;
    }

}
