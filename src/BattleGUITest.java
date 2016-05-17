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
    
    private static Battle newBattle;

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
        Pokemon testChallenger = new Pokemon(names, null, 0, 3);
        testChallenger.evolve();
        Player challenger = new Player(new Trainer("Ash", 
                new Image("img/trainers/ash.png"), null));
        challenger.addToBalance(0);
//        test.action(challenger);
        
        Player defender = new Player(new Trainer("Hidla", 
                new Image("img/trainers/hilda.png"), null));
        Pokemon testDefender = new Pokemon(names, null, 0, 3);
        defender.addToBalance(0);
        testDefender.devolve();
        newBattle = new Battle(challenger, defender, 
                testChallenger, testDefender, 200);
        
        
        
        BattleGUITest.battle();
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
    
    public static void battle()
    {
        // Roll a die for both players
        // Determine which player wins
        // Determine the outcome of the battle
        // Do whatever needs doing according to the outcome

        // Build a "pre-battle" GUI
        //HBox that will hold the images of the two trainers.
        HBox trainers = new HBox(50);
        
        //Image of the challenging trainer.
        ImageView firstTrainer = new ImageView(
                newBattle.challengingPlayer.trainer.trainerImage);
        Text txtVersus = new Text("vs");


        //Image of the defending trainer.
        ImageView secondTrainer = new ImageView(
                newBattle.defendingPlayer.trainer.trainerImage);

        //Set the size of the images and preserve their ratios.
        firstTrainer.setPreserveRatio(true);
        secondTrainer.setPreserveRatio(true);
        firstTrainer.setFitHeight(150);
        secondTrainer.setFitHeight(150);

        //Add the images to the trainers HBox.
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

        //Display the next interface when the user clicks on the continue 
        // button.
        btnContinue.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                BattleGUITest.readyScreen(newBattle);
            }
        });

        //Main pane for the screen.
        VBox toShow = new VBox(15.0);
        // TODO Uncomment the Pokemon add in the line below once we have images
        // TODO Figure out how to align the button in the center of the screen
        btnContinue.setAlignment(Pos.CENTER);
        toShow.getChildren().addAll(trainers, /* pokemon, */btnContinue);

        // TODO testing
        BattleGUITest.updateScene(toShow);
    }

    
    public static void resultScreen(Player winner, String winnings, 
            boolean isTie, Player challengingPlayer, Player defendingPlayer)
    {
        // Create a new view for the ready screen
        // TODO Change these to the Pokemon's images once we have
        // Pokemon images
        
        //Main pane for the result screen.
        VBox resultScreen = new VBox();
        
        //HBox that will hold the images of the two trainers.
        HBox trainers = new HBox(50);
        
        //Image of the challenging trainer.
        ImageView firstTrainer = new ImageView(
                challengingPlayer.trainer.trainerImage);

        //Image of the defending trainer.
        ImageView secondTrainer = new ImageView(
                defendingPlayer.trainer.trainerImage);

        //Set the size of the images and preserve their ratios.
        firstTrainer.setPreserveRatio(true);
        secondTrainer.setPreserveRatio(true);
        firstTrainer.setFitHeight(150);
        secondTrainer.setFitHeight(150);

        //Add the images to the trainers HBox.
        trainers.getChildren().addAll(firstTrainer, secondTrainer);

        //Text field that will display what the result of the battle was.
        Text results;

        //If the battle resulted in a tie display the appropriate information.
        if (isTie)
        {
            results = new Text("The Battle has resulted in a tie");
        }
        //Else display what was won and by whom.
        else
        {
            results = new Text(winner.trainer.name + " wins " + winnings);
        }
        
        //Set the font for results to the standard game font.
        results.setFont(GameFont.GAME_FONT);

        // TODO testing
        System.out.println("Challenger: \t"
                + challengingPlayer.currentBalance());
        System.out.println("Defender: \t" + defendingPlayer.currentBalance());

        //Add the trainer images and result text to the main VBox.
        resultScreen.getChildren().addAll(trainers, results);
        
       

        // TODO this is only for testing until the board is done.
        BattleGUITest.updateScene(resultScreen);
    }
    
    public static void readyScreen(Battle battle)
    {
        // Create a new view for the ready screen
        // TODO Change these to the Pokemon's images once we have
        // Pokemon images
        
        VBox main = new VBox();
        
        //HBox that will hold the images of the two trainers.
        HBox trainers = new HBox(50);
        
        //Image of the challenging trainer.
        ImageView firstTrainer = new ImageView(
                battle.challengingPlayer.trainer.trainerImage);

        //Image of the defending trainer.
        ImageView secondTrainer = new ImageView(
                battle.defendingPlayer.trainer.trainerImage);

        //Set the size of the images and preserve their ratios.
        firstTrainer.setPreserveRatio(true);
        secondTrainer.setPreserveRatio(true);
        firstTrainer.setFitHeight(150);
        secondTrainer.setFitHeight(150);

        trainers.getChildren().addAll(firstTrainer, secondTrainer);

        //HBox that will hold both of the ready buttons.
        HBox readyButtons = new HBox(50);
        
        //The two ready buttons to display.
        Button btnChallengerReady = new Button("Ready");
        Button btnDefenderReady = new Button("Ready");

        //When a ready button is clicked it will make sure that both are 
        // clicked before proceeding to start the battle.
        btnChallengerReady.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                battle.challengerReady = true;
                if (battle.challengerReady && battle.defenderReady)
                {
                    battle.rollForPlayers();
                }
                btnChallengerReady.setDisable(true);
            }
        });

        //When a ready button is clicked it will make sure that both are 
        // clicked before proceeding to start the battle.
        btnDefenderReady.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                battle.defenderReady = true;
                if (battle.challengerReady && battle.defenderReady)
                {
                    battle.rollForPlayers();
                }
                btnDefenderReady.setDisable(true);
            }
        });

        //Add the buttons to the HBox.
        readyButtons.getChildren().addAll(btnChallengerReady, 
                btnDefenderReady);
        
        //Add the buttons and images to the main pane.
        main.getChildren().addAll(trainers, readyButtons);
        
        // TODO testing
        BattleGUITest.updateScene(main);
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
