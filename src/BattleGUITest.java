import java.util.HashMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
public class BattleGUITest extends Application
{
    private static Scene scene;
    private static Stage stage;
    private static Player challenger;
    private static Player defender;
    private static boolean challengerReady = false;
    private static boolean defenderReady = false;
    private static Battle newBattle;

    private static HashMap<String, String> trainerImages;
    

    public static void main( String[] args )
    {
    	trainerImages = new HashMap<String, String>();
        trainerImages.put(GameMain.ASH_NAME, "img/trainers/ash.png");
        trainerImages.put(GameMain.GARY_NAME, "img/trainers/Gary.png");
        trainerImages.put(GameMain.MAY_NAME, "img/trainers/May.png");
        trainerImages.put(GameMain.HILDA_NAME, "img/trainers/hilda.png");
        
        challenger = new Player("Ash", 0);
        challenger.addToBalance(5000);
        
        defender = new Player("Hilda", 3);
        defender.addToBalance(5000);
        
        
        Application.launch(args);
    }

    /**
     * The default start method required by JavaFX.
     */
    public void start( Stage stage )
    {
        this.stage = stage;
        StackPane main = new StackPane();
        scene = new Scene(main);
        stage.setScene(scene);
        stage.show();
        
        // ///////////////////////////////////////////////

        String[] names = new String[] { "a", "b", "c" };
        Pokemon testChallenger = new Pokemon(names, null, 5, 3);
        
        // test.action(challenger);

        
        Pokemon testDefender = new Pokemon(names, null, 5, 3);
        

        // Set up the battle we're using here
        newBattle = new Battle(challenger, defender, testChallenger,
                testDefender, 200);

        // Put together a pre-battle GUI

        // Build a "pre-battle" GUI
        HBox trainers = new HBox(10);
        ImageView firstTrainer = new ImageView(trainerImages.get(challenger.name));
        Text txtVersus = new Text("vs");
        txtVersus.setFont(GameFont.GAME_FONT);

        ImageView secondTrainer = new ImageView(trainerImages.get(defender.name));

        firstTrainer.setPreserveRatio(true);
        secondTrainer.setPreserveRatio(true);
        firstTrainer.setFitHeight(150);
        secondTrainer.setFitHeight(150);

        trainers.getChildren().addAll(firstTrainer, txtVersus, secondTrainer);

        // TODO Uncomment this once we have Pokemon images

        // HBox pokemon = new HBox(50);
        // ImageView firstPokemon = new
        // ImageView(challengingPokemon.currentImage);
        // ImageView secondPokemon = new
        // ImageView(defendingPokemon.currentImage);
        //
        // pokemon.getChildren().addAll(firstPokemon, secondPokemon);

        Button btnContinue = new Button("Continue");

        // Display the next interface when the user clicks on the continue
        // button.
        btnContinue.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle( ActionEvent event )
            {
                System.out.println("Continue clicked!");
                readyScreen();
            }
        });

        VBox toShow = new VBox(15.0);
        // TODO Uncomment the Pokemon add in the line below once we have images
        // TODO Figure out how to align the button in the center of the screen
        btnContinue.setAlignment(Pos.CENTER);
        toShow.getChildren().addAll(trainers, /* pokemon, */btnContinue);

        BattleGUITest.updateScene(toShow);
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
        // Just update the scene AS LONG AS IT ISN'T NULL
        if ( stage != null )
        {
            stage.setScene(new Scene(newPane));
        }
    }

    public static void readyScreen()
    {
        // Create a new view for the ready screen
        // TODO Change these to the Pokemon's images once we have
        // Pokemon images
        HBox trainers = new HBox(50);
        ImageView firstTrainer = new ImageView(trainerImages.get(challenger.name));

        ImageView secondTrainer = new ImageView(trainerImages.get(defender.name));

        firstTrainer.setPreserveRatio(true);
        secondTrainer.setPreserveRatio(true);
        firstTrainer.setFitHeight(150);
        secondTrainer.setFitHeight(150);

        trainers.getChildren().addAll(firstTrainer, secondTrainer);

        HBox readyButtons = new HBox(50);
        Button btnChallengerReady = new Button("Ready");
        Button btnDefenderReady = new Button("Ready");
//TODO Requires implementation with new system redesign
//        btnChallengerReady.setOnAction(new EventHandler<ActionEvent>()
//        {
//            public void handle( ActionEvent event )
//            {
//                challengerReady = true;
//                if ( challengerReady && defenderReady )
//                {
//                    newBattle.rollForPlayers();
//                    if ( newBattle.result.equals("tie") )
//                    {
//                        resultScreen(null, null, true);
//                    }
//                    else
//                    {
//                        resultScreen(newBattle.winner, "", false);
//                    }
//                }
//                btnChallengerReady.setDisable(true);
//            }
//        });

//        btnDefenderReady.setOnAction(new EventHandler<ActionEvent>()
//        {
//            public void handle( ActionEvent event )
//            {
//                defenderReady = true;
//                if ( challengerReady && defenderReady )
//                {
//                    newBattle.rollForPlayers();
//                    if ( newBattle.result.equals("tie") )
//                    {
//                        resultScreen(null, null, true);
//                    }
//                    else
//                    {
//                        resultScreen(newBattle.winner, "", false);
//                    }
//                }
//                btnDefenderReady.setDisable(true);
//            }
//        });

        readyButtons.getChildren().addAll(btnChallengerReady, btnDefenderReady);
        BattleGUITest.updateScene(readyButtons);
    }

    public static void resultScreen( Player winner, String winnings,
            boolean isTie )
    {
        // Create a new view for the ready screen
        // TODO Change these to the Pokemon's images once we have
        // Pokemon images

        // Main pane for the result screen.
        VBox resultScreen = new VBox();

        // HBox that will hold the images of the two trainers.
        HBox trainers = new HBox(50);

        // Image of the challenging trainer.
        ImageView firstTrainer = new ImageView(trainerImages.get(challenger.name));

        // Image of the defending trainer.
        ImageView secondTrainer = new ImageView(trainerImages.get(defender.name));

        // Set the size of the images and preserve their ratios.
        firstTrainer.setPreserveRatio(true);
        secondTrainer.setPreserveRatio(true);
        firstTrainer.setFitHeight(150);
        secondTrainer.setFitHeight(150);

        // Add the images to the trainers HBox.
        trainers.getChildren().addAll(firstTrainer, secondTrainer);

        // Text field that will display what the result of the batttle was.
        Text results;

        // If the battle resulted in a tie display the appropriate information.
        if ( isTie )
        {
            results = new Text("The Battle has resulted in a tie");
        }
        // Else display what was won and by whom.
        else
        {
            results = new Text(winner.name + " wins " + winnings);
        }

        // Set the font for results to the standard game font.
        results.setFont(GameFont.GAME_FONT);

        // TODO testing
        System.out.println("Challenger: \t" + challenger.currentBalance());
        System.out.println("Defender: \t" + defender.currentBalance());

        // Add the trainer images and result text to the main VBox.
        resultScreen.getChildren().addAll(trainers, results);

        // TODO this is only for testing until the board is done.
        BattleGUITest.updateScene(resultScreen);
    }

}
