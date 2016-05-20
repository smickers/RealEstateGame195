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
    
    public boolean challengerReady = false;
    public boolean defenderReady = false;
    public Player challengingPlayer;
    public Player defendingPlayer;
    public Pokemon challengingPokemon;
    public Pokemon defendingPokemon;
    public int amountToPay;

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
//    public void battle()

    
    /**
     * Purpose: rolls for both players and determines the winner
     */
    public void rollForPlayers()
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
        //If the defender attack is stronger.
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
//            BattleGUITest.resultScreen(this.challengingPlayer, 
//                    String.valueOf(amountToPay), false, this.challengingPlayer, 
//                    this.defendingPlayer);
        }
        //If the defeated Pokemon is at its lowest evolution, then start a 
        // Pokemon exchange.
        else if (defendingPokemon.currentIndex == 0)
        {
        	devolvePokemon(defendingPokemon);
            evolutionPane.buildDevolutionPane(defendingPokemon);
            System.out.println(defendingPokemon);
            // TODO
            // pokemonExchange();
        }
        //Else the defeated Pokemon will be devolved.
        else
        {
            devolvePokemon(defendingPokemon);
            evolutionPane.buildDevolutionPane(defendingPokemon);
            System.out.println(defendingPokemon);
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
//            BattleGUITest.resultScreen(this.defendingPlayer, 
//                    String.valueOf(amountToPay), false, this.challengingPlayer, 
//                    this.defendingPlayer);
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
             devolvePokemon(challengingPokemon);
             evolutionPane.buildDevolutionPane(challengingPokemon);
        }
        

    }

    /**
     * Purpose: makes sure the correct result screen is displayed for a tie.
     */
    private void tie()
    {
        //Call the result interface with nothing being won.
//        BattleGUITest.resultScreen(null, "", true, this.challengingPlayer, 
//                this.defendingPlayer);
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
        //resultScreen(winner, String.valueOf(amountToPay), false);
    }
    
    public void devolvePokemon(Pokemon loser)
    {
    	loser.devolve();
    	
    }

 
}
