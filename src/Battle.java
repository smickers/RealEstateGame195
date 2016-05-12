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
 * @author Cameron Auser & Nathan MacNeil & Hilary Fehr
 * @version 1.0
 */

public class Battle
{
    /**
     * 
     * Purpose: This method contains the logic of walking through a battle.
     * 
     * @param challengerPlayerReady
     *            - Whether the player is ready to start the battle
     * @param defenderPlayerReady
     *            - Whether the player is ready to start the battle  
     * @param challengingPlayer
     *            - The player who has landed on the tile
     * @param defendingPlayer
     *            - The player who owns the tile
     * @param challengingPokemon
     *            - The Pokemon of the player who has landed on the tile
     * @param defendingPokemon
     *            - The Pokemon represented by the tile landed on
     * @param amountToPay
     *            - The amount the must be paid by the battle's loser
     */
    
    private boolean challengerReady = false;
    private boolean defenderReady = false;
    private Player challengingPlayer;
    private Player defendingPlayer;
    private Pokemon challengingPokemon;
    private Pokemon defendingPokemon;
    private int amountToPay;

    /**
     * Constructor for the Battle class.
     * @param challengingPlayer
     * @param defendingPlayer
     * @param challengingPokemon
     * @param defendingPokemon
     * @param tileCost
     */
    public Battle(Player challengingPlayer, Player defendingPlayer,
            Pokemon challengingPokemon, Pokemon defendingPokemon, int tileCost)
    {
        this.challengingPlayer = challengingPlayer;
        this.defendingPlayer = defendingPlayer;
        this.challengingPokemon = challengingPokemon;
        this.defendingPokemon = defendingPokemon;
        this.amountToPay = tileCost / 2;
    }

    /**
     * Purpose: this method will setup and display the user interface with 
     *  the information passed for the current battle. 
     */
    public void battle()
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
                challengingPlayer.trainer.trainerImage);
        Text txtVersus = new Text("vs");


        //Image of the defending trainer.
        ImageView secondTrainer = new ImageView(
                defendingPlayer.trainer.trainerImage);

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
                System.out.println("Continue clicked!");
                readyScreen();
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

    /**
     * Purpose: displays the interface that waits for both players to be ready
     *  before the battle starts.
     */
    private void readyScreen()
    {
        // Create a new view for the ready screen
        // TODO Change these to the Pokemon's images once we have
        // Pokemon images
        
        VBox main = new VBox();
        
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
                challengerReady = true;
                if (challengerReady && defenderReady)
                {
                    rollForPlayers();
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
                defenderReady = true;
                if (challengerReady && defenderReady)
                {
                    rollForPlayers();
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
     * Purpose: rolls for both players and determines the winner
     */
    private void rollForPlayers()
    {

        // TODO testing
        System.out.println("\n ");
        int challengerAttack = challengingPokemon.attackPoints
                + Die.rollBattleDie();

        int defendingAttack = defendingPokemon.attackPoints
                + Die.rollBattleDie();

        //If the challenger attack is stronger
        if (challengerAttack > defendingAttack)
        {
            // TODO testing
            System.out.println("challenger wins");
            
            
            challengerWins();
        }
        //If the defeder attack is stronger.
        else if (challengerAttack < defendingAttack)
        {
            // TODO testing
            System.out.println("defender wins");
            
            
            defenderWins();
        }
        //Else it will be a tie.
        else
        {
            // TODO testing
            System.out.println("tie");
            
            
            tie();
        }

    }

    /**
     * Purpose: determines the result of the battle based on the condition of 
     *  the loser.
     */
    private void challengerWins()
    {

        //If the loser has enough in their balance to pay the winner, then
        // start a money exchange.
        if (defendingPlayer.sufficientBalance(amountToPay))
        {
            moneyExchange(challengingPlayer, defendingPlayer);
        }
        //If the defeated Pokemon is at its lowest evolution, then start a 
        // Pokemon exchange.
        else if (defendingPokemon.currentIndex == 0)
        {
            // TODO
            // pokemonExchange();
        }
        //Else the defeated Pokemon will be devolved.
        else
        {
            // devolvePokemon();
        }

    }

    /**
     * Purpose: determines the result of the battle based on the condition of 
     *  the loser.
     */
    private void defenderWins()
    {
        //If the loser has enough in their balance to pay the winner, then
        // start a money exchange.
        if (challengingPlayer.sufficientBalance(amountToPay))
        {
            moneyExchange(defendingPlayer, challengingPlayer);
        }
        //If the defeated Pokemon is at its lowest evolution, then start a 
        // Pokemon exchange.
        else if( challengingPokemon.currentIndex == 0 )
        {
            // TODO
            // pokemonExchange();
        }
        //Else the defeated Pokemon will be devolved.
        else
        {
            // devolvePokemon();
        }

    }

    /**
     * Purpose: makes sure the correct result screen is displayed for a tie.
     */
    private void tie()
    {
        //Call the result interface with nothing being won.
        resultScreen(null, "", true);
    }

    /**
     * Purpose: provides the functionality for a battle resulting in an 
     *  exchange of money.
     * @param winner player that won the battle.
     * @param loser player that lost the battle.
     */
    public void moneyExchange(Player winner, Player loser)
    {
        //Increase the winner's balance.
        winner.addToBalance(amountToPay);
        //Decrease the loser's balance.
        loser.removeFromBalance(amountToPay);

        //Display the result interface with what was won.
        resultScreen(winner, String.valueOf(amountToPay), false);
    }

    /**
     * Purpose: displays an interface describing the results of the battle.
     * @param winner player that won the battle.
     * @param winnings String describing what was won by the victor.
     * @param isTie boolean describing whether the result of the battle was 
     *  a tie.
     */
    private void resultScreen(Player winner, String winnings, boolean isTie)
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

}
