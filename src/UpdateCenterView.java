import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
 *  [File header includes information about the file being submitted.]
 *  Date submitted: May 11, 2016
 *  Assignment number: N/A
 *  Course name:  CPMG195/COSA195
 *  Instructors: Steve Sutcliffe, Tanya Lung, Wade Lahoda, Sharon McDonald
 * 
 */

/**
 * 
 * Purpose: Simple test class for Pokemon Tile story (Story 2).
 *
 * @author Nathan MacNeil and Cameron Auser
 * @version 1.0
 */
public class UpdateCenterView extends Application
{
    private static Scene scene;
    private static Stage stage;

    public static void main( String[] args )
    {
        Application.launch(args);
    }

    public void start( Stage stage )
    {
        this.stage = stage;
        StackPane main = new StackPane();
        scene = new Scene(main);
        stage.setScene(scene);
        stage.show();

        // ///////////////////////////////////////////////

        String[] names = new String[] { "a", "b", "c" };
        Pokemon testPokemon = new Pokemon(names, null, 5, 3);
        PokemonTile test = new PokemonTile(testPokemon, 50, null,
                "Test Pokemon", null);

        Player testPlayer = new Player("Ash", 0);

        testPlayer.addToBalance(5000);
        test.action(testPlayer);

        // //////////////////////////////////////////////////

        // Test when Pokemon is already owned
        // /////////////////////////////////////////
        // String[] names = new String[] {"a", "b", "c"};
        // Pokemon testPokemon = new Pokemon(names, null, 5, 3);
        // PokemonTile test = new PokemonTile(testPokemon,50, null,
        // "Test Pokemon", null);
        // Player testPlayer = new Player(new Trainer("Test trainer",null,
        // null));
        // Player testPlayerTwo = new Player(new Trainer("Test trainer 2",null,
        // null));
        // testPlayerTwo.addToBalance(5000);
        // // test.action(testPlayer);
        // test.changeOwner(testPlayer);
        // test.action(testPlayerTwo);
        // //////////////////////////////////////////////////////
    }

    /**
     * 
     * Purpose: Update the main view of the screen with a passed in pane
     * 
     * @param newPane
     *            - the new pane to show
     */
    public static void updateScene( Pane newPane )
    {
        // Just update the scene
        stage.setScene(new Scene(newPane));
    }

}
