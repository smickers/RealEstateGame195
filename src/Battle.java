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
     * @param challengingPlayer
     *            - The player who has landed on the tile
     * @param defendingPlayer
     *            - The player who owns the tile
     * @param challengingPokemon
     *            - The Pokemon of the player who has landed on the tile
     * @param defendingPokemon
     *            - The Pokemon represented by the tile landed on
     */
//    private boolean challengerReady = false;
//    private boolean defenderReady = false;
    private Player challengingPlayer;
    private Player defendingPlayer;
    private Pokemon challengingPokemon;
    private Pokemon defendingPokemon;
    private int amountToPay;
    public String result;
    public Player winner;
    public static final String POKEMON_EXCHANGE_OUTCOME = "pokemon-exchange";
    public static final String POKEMON_DEVOLVE_OUTCOME = "pokemon-devolve";
    public static final String POKEMON_TIE_OUTCOME = "tie";
    public String outcomeMessage;

    /**
     * Constructor for the Battle class.
     * 
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
     * Purpose: this method will setup and display the user interface with the
     * information passed for the current battle.
     */
    public void battle()
    {
        // First we'll call rollForPlayers to have them roll dice to determine
        // what "bonus points" will be added to their Pokemon for the battle
        rollForPlayers();
    }

    /**
     * Purpose: rolls for both players and determines the winner
     */
    public void rollForPlayers()
    {
        // TODO Implement the dice rolling story, eventually
        // TODO Add checks below here for different battle outcomes
        // For now we will only call tie(), because the other stories
        // required for fully completing the battle class haven't been
        // implemented
        tie();

        //this.winner = defendingPlayer;
        //pokemonExchange();
    }

    /**
     * Purpose: determines the result of the battle based on the condition of
     * the loser.
     */
    private void challengerWins()
    {

        if ( defendingPlayer.sufficientBalance(amountToPay) )
        {
            moneyExchange(challengingPlayer, defendingPlayer);
        }
        else if ( defendingPokemon.currentIndex == 0 )
        {
            // TODO
            // pokemonExchange();
        }
        else
        {
            // devolvePokemon();
        }

    }

    /**
     * Purpose: determines the result of the battle based on the condition of
     * the loser.
     */
    private void defenderWins()
    {
        if ( defendingPlayer.sufficientBalance(amountToPay) )
        {
            moneyExchange(defendingPlayer, challengingPlayer);
        }
        else if ( defendingPokemon.currentIndex == 0 )
        {
            // TODO
            // pokemonExchange();
        }
        else
        {
            // devolvePokemon();
        }

    }

    /**
     * Purpose: provides the functionality for a battle resulting in an exchange
     * of money.
     * 
     * @param winner
     *            player that won the battle.
     * @param loser
     *            player that lost the battle.
     */
    private void moneyExchange( Player winner, Player loser )
    {
        // Increase the winner's balance.
        winner.addToBalance(amountToPay);
        // Decrease the loser's balance.
        loser.removeFromBalance(amountToPay);

        // Display the result interface with the appropriate information.
        BattleGUITest.resultScreen(winner, String.valueOf(amountToPay), false);
    }
    
    /**
     * 
     * Purpose: Manage a Pokemon exchange outcome. This includes moving
     * the loser's Pokemon from the loser's hand to the winner's hand.
     */
    private void pokemonExchange()
    {
        // TODO Look into removing all evolutionPoints from a Pokemon
        // after it has been given to another player
        
        // Determine which player is the winner
        Pokemon pokemonToMove;
        Player loser;
        if (winner.equals(challengingPlayer))
        {
            // Challenging player won - move the defending player's Pokemon
            // to the challenging player's hand
            pokemonToMove = defendingPokemon;
            loser = defendingPlayer;
            defendingPlayer.removePokemon(pokemonToMove);
            challengingPlayer.addPokemon(pokemonToMove);
        }
        else
        {
            // Otherwise the defendingPlayer won, so we'll move the challenger's
            // Pokemon to the defender's Pokedex
            pokemonToMove = challengingPokemon;
            loser = challengingPlayer;
            challengingPlayer.removePokemon(pokemonToMove);
            defendingPlayer.addPokemon(pokemonToMove);
        }
        this.result = POKEMON_EXCHANGE_OUTCOME;
        this.outcomeMessage = winner.trainer.name + " has taken " + 
                pokemonToMove.currentName + " from " + loser.trainer.name + "!";
    }

    /**
     * 
     * Purpose: This method will be called if a tie occurs. This means that no
     * money will change hands, no Pokemon will change hands and no Pokemon will
     * be evolved or devolved.
     */
    public void tie()
    {
        // Just call resultScreen. We can get away with passing in
        // nulls since it won't use the passed in player or String,
        // because we're marking it as a tie result.

        this.result = POKEMON_TIE_OUTCOME;
    }

 
}

