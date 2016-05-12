import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/*
 *  [File header includes information about the file being submitted.]
 *  Date submitted: May 11, 2016
 *  Assignment number: N/A
 *  Course name:  CPMG195/COSA195
 *  Instructors: Steve Sutcliffe, Tanya Lung, Wade Lahoda, Sharon McDonald
 * 
 */

/**
 * Purpose: Perform all aspects of a battle in the Pokemonopoly game.
 *
 * @author Cameron Auser & Nathan MacNeil
 * @version 1.0
 */

public class Battle
{

    private boolean challengerReady = false;
    private boolean defenderReady = false;
    private Player challengingPlayer;
    private Player defendingPlayer;
    private Pokemon challengingPokemon;
    private Pokemon defendingPokemon;

    /**
     * 
     * Constructor for the Battle class.
     * 
     * @param challengingPlayer
     *            - The player who has landed on the tile
     * @param defendingPlayer
     *            - The player who owns the tile
     * @param challengingPokemon
     *            - The Pokemon that will be used by the challenging player
     * @param defendingPokemon
     *            - The Pokemon represented by the tile landed on by the
     *            challenging player
     */
    public Battle(Player challengingPlayer, Player defendingPlayer,
            Pokemon challengingPokemon, Pokemon defendingPokemon)
    {
        this.challengingPlayer = challengingPlayer;
        this.defendingPlayer = defendingPlayer;
        this.challengingPokemon = challengingPokemon;
        this.defendingPokemon = defendingPokemon;
    }

    /**
     * 
     * Purpose: Run through a battle, calling methods as necessary depending on
     * the outcome of the battle.
     */
    public void battle()
    {
        // Roll a die for both players
        // Determine which player wins
        // Determine the outcome of the battle
        // Do whatever needs doing according to the outcome

        // Build a "pre-battle" GUI
        HBox trainers = new HBox(10);
        ImageView firstTrainer = new ImageView(
                challengingPlayer.trainer.trainerImage);
        Text txtVersus = new Text("vs");
        txtVersus.setFont(GameFont.GAME_FONT);

        ImageView secondTrainer = new ImageView(
                defendingPlayer.trainer.trainerImage);

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

        // TODO Change this to update the actual GUI
        BattleGUITest.updateScene(toShow);
    }

    /**
     * 
     * Purpose: Display a ready screen, and have both players click on a
     * "Continue" button before a battle begins
     */
    private void readyScreen()
    {
        // Create a new view for the ready screen
        // TODO Change these to the Pokemon's images once we have
        // Pokemon images
        HBox trainers = new HBox(50);
        ImageView firstTrainer = new ImageView(
                challengingPlayer.trainer.trainerImage);

        ImageView secondTrainer = new ImageView(
                defendingPlayer.trainer.trainerImage);

        firstTrainer.setPreserveRatio(true);
        secondTrainer.setPreserveRatio(true);
        firstTrainer.setFitHeight(150);
        secondTrainer.setFitHeight(150);

        trainers.getChildren().addAll(firstTrainer, secondTrainer);

        HBox readyButtons = new HBox(50);
        Button btnChallengerReady = new Button("Ready");
        Button btnDefenderReady = new Button("Ready");

        btnChallengerReady.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle( ActionEvent event )
            {
                challengerReady = true;
                if ( challengerReady && defenderReady )
                {
                    rollScreen();
                }
                btnChallengerReady.setDisable(true);
            }
        });

        btnDefenderReady.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle( ActionEvent event )
            {
                defenderReady = true;
                if ( challengerReady && defenderReady )
                {
                    rollScreen();
                }
                btnDefenderReady.setDisable(true);
            }
        });

        readyButtons.getChildren().addAll(btnChallengerReady, btnDefenderReady);
        // TODO Change this to update the actual GUI
        BattleGUITest.updateScene(readyButtons);
    }

    /**
     * 
     * Purpose: Display the result of the two dice rolling during a battle.
     */
    private void rollScreen()
    {
        // TODO Implement this method once the Die clas has been finished
        System.out.println("Roll screen called!");
    }

    /**
     * 
     * Purpose: Do the work related to exchanging a Pokemon between the winner
     * and the loser of a batte
     * 
     * @param winner
     *            - The player who won
     * @param loser
     *            - The player who lost
     */
    public void pokemonExchange( Player winner, Player loser )
    {
        // Remove the Pokemon from the loser's hand
        // Add that Pokemon to the winner's hand

        // Keep track of the winner's name, and the Pokemon they won
        String winnerName = winner.trainer.name;
        String pokemonWon = "";

        if ( loser.equals(defendingPlayer) )
        {

            // The defendingPlayer lost, so we'll move their Pokemon to the
            // challengingPlayer's hand
            if ( defendingPlayer.removePokemon(defendingPokemon) )
            {
                // Ensure that the Pokemon was removed
                challengingPlayer.addPokemon(defendingPokemon);
                pokemonWon = defendingPokemon.currentName;
                // TODO Remove owner attribute from PokemonTile. Instead,
                // just reference the owner from the relatedPokemon
                // attribute
            }
            else
            {
                System.err.println("Couldn't remove Pokemon from the"
                        + " defender's hand!");
            }
            // Add an evolution point to the Pokemon that won the battle
            challengingPokemon.addEvolutionPoint();
        }
        else
        {
            // The challengingPlayer lost, so there Pokemon is given to the
            // defendingPlayer
            if ( challengingPlayer.removePokemon(challengingPokemon) )
            {
                pokemonWon = challengingPokemon.currentName;
                defendingPlayer.addPokemon(challengingPokemon);
            }
            else
            {
                System.err.println("Couldn't remove Pokemon from the"
                        + " challenger's hand!");
            }
            // Add an evolution point to the winning Pokemon
            defendingPokemon.addEvolutionPoint();
        }

        // TODO Uncomment this line after merging stories with Nathan and his
        // battle story
        // resultScreen(winner, pokemonWon, false);

    }
}
