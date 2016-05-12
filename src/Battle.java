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
    /**
     * 
     * Purpose: This method contains the logic of walking through a battle.
     * 
     * @param challengingPlayer
     *            - The player who has landed on the tile
     * @param defendingPlayer
     *            - The player who owns the tile
     * @param challengingPokemon
     *            - The Pokemon of the player who has landed on the tile
     * @param defendingPokemon
     *            - The Pokemon represented by the tile landed on
     */
    private boolean challengerReady = false;
    private boolean defenderReady = false;
    private Player challengingPlayer;
    private Player defendingPlayer;
    private Pokemon challengingPokemon;
    private Pokemon defendingPokemon;
    private int amountToPay;

    public Battle(Player challengingPlayer,
            Player defendingPlayer, Pokemon challengingPokemon,
            Pokemon defendingPokemon, int tileCost )
            {
                this.challengingPlayer = challengingPlayer;
                this.defendingPlayer = defendingPlayer;
                this.challengingPokemon = challengingPokemon;
                this.defendingPokemon = defendingPokemon;
                this.amountToPay = tileCost / 2;
            }
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

        BattleGUITest.updateScene(toShow);
    }

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
                    public void handle(ActionEvent event)
                    {
                        challengerReady = true;
                        if (challengerReady && defenderReady)
                        {
                            rollScreen();
                        }
                        btnChallengerReady.setDisable(true);
                    }
                });
        
        btnDefenderReady.setOnAction(new EventHandler<ActionEvent>()
                {
            public void handle(ActionEvent event)
            {
                defenderReady = true;
                if (challengerReady && defenderReady)
                {
                    rollScreen();
                }
                btnDefenderReady.setDisable(true);
            }
        });
        
        readyButtons.getChildren().addAll(btnChallengerReady, btnDefenderReady);
        BattleGUITest.updateScene(readyButtons);
    }
    
    private void rollScreen()
    {
        //Die die = new Die();
        
        int challengerAttack = challengingPokemon.attackPoints + 
                Die.rollBattleDie();
        
        int defendingAttack = defendingPokemon.attackPoints + 
                Die.rollBattleDie();
        
        if( challengerAttack > defendingAttack )
        {
            challengerWins();
        }
        else if( challengerAttack < defendingAttack )
        {
            defenderWins();
        }
        else
        {
            tie();
        }
        
        System.out.println("Roll screen called!");
    }
    
    private void challengerWins()
    {
        
        if(defendingPlayer.sufficientBalance( amountToPay ) )
        {
            moneyExchange( challengingPlayer, defendingPlayer );
        }
        else if( defendingPokemon.currentIndex == 0 )
        {
            // TODO
            //pokemonExchange();
        }
        else 
        {
            //devolvePokemon();
        }
        
    }
    
    private void defenderWins()
    {
        if(defendingPlayer.sufficientBalance( amountToPay ) )
        {
            moneyExchange( defendingPlayer, challengingPlayer );
        }
        else if( defendingPokemon.currentIndex == 0 )
        {
            //TODO
            //pokemonExchange();
        }
        else 
        {
            //devolvePokemon();
        }
        
        
    }
    
    //Splash
    private void tie()
    {
        
    }
    
    public void moneyExchange(Player winner, Player loser)
    {
        winner.addToBalance( amountToPay );
        loser.removeFromBalance( amountToPay );
    }
    
    
    
}
