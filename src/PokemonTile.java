import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
 * 
 * Purpose: This class will handle the functionality for when a player lands on
 * a PokemonTile.
 *
 * @author Nathan MacNeil CST123 Cameron Auser CST102
 * @version 1.0
 */
public class PokemonTile extends Tile
{
    // Variable holding the cost to purchase the current PokemonTile.
    public int cost;

    // Variable holding the player that currently owns the current PokemonTile.
    private Player owner;

    // Variable holding the Pokemon for this tile.
    public Pokemon relatedPokemon;

    public GameBoard board;

    /**
     * Constructor Constructor for the PokemonTile class.
     * 
     * @param relatedPokemon
     * @param cost
     * @param board
     * @param name
     * @param image
     */
    public PokemonTile(Pokemon relatedPokemon, int cost, GameBoard board,
            String name, Image image)
    {
        super(name, image);
        this.relatedPokemon = relatedPokemon;
        this.cost = cost;
        this.board = board;
    }

    /**
     * The purpose of this method is to run through purchasing a pokemon when a
     * player lands on the tile.
     * 
     * @param player
     *            - the Player to perform the action on
     */
    public void action( Player player )
    {
        // If the Tile is owned there will be a battle.
        if ( owner != null )
        {
            // StackPane toShow = new StackPane();
            // Text notBought = new
            // Text("Pokemon already owned! Can't purchase again! (eventually this will be a battle)");
            // toShow.getChildren().add(notBought);
            // UpdateCenterView.updateScene(toShow);
            System.out
                    .println("Pokemon already owned! Can't purchase again! (eventually this will be a battle)");
            // TODO Hook up battle sequence
        }
        else
        {
            // tile is up for sale
            // purchase(player);
            // Setting up the User interface for buying a Pokemon.

            BorderPane toShow = new BorderPane();

            Text topMessage = new Text("Do you want to purchase " + super.name
                    + "?");
            toShow.setTop(topMessage);

            toShow.setCenter(new ImageView(super.image));

            Button btnYes = new Button("Yes");
            Button btnNo = new Button("No");

            HBox buttons = new HBox();
            buttons.getChildren().addAll(btnYes, btnNo);

            toShow.setBottom(buttons);

            btnYes.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle( ActionEvent event )
                {
                    // If the player has enough money buy the tile.
                    if ( player.sufficientBalance(cost) )
                    {
                        purchase(player);
                        // player.removeFromBalance(cost);
                        // changeOwner(player);
                        StackPane toShow = new StackPane();
                        Text notBought = new Text(
                                "Pokemon purchased and added to inventory!");

                        toShow.getChildren().add(notBought);
                        UpdateCenterView.updateScene(toShow);
                        System.out
                                .println("Pokemon purchased and added to inventory!");
                    }
                    // If not don't buy the tile.
                    else
                    {
                        StackPane toShow = new StackPane();
                        Text notBought = new Text(
                                "You don't have enough money to purchase the Pokemon!");
                        toShow.getChildren().add(notBought);
                        UpdateCenterView.updateScene(toShow);
                        System.out
                                .println("You don't have enough money to purchase the Pokemon!");
                    }
                    System.out.println("Balance=" + player.currentBalance());
                }
            });

            btnNo.setOnAction(new EventHandler<ActionEvent>()
            {
                // If the player doesn't want to buy the tile, nothing happens.
                public void handle( ActionEvent event )
                {
                    StackPane toShow = new StackPane();
                    Text notBought = new Text("Pokemon not purchased!");
                    toShow.getChildren().add(notBought);
                    UpdateCenterView.updateScene(toShow);
                    System.out.println("Pokemon not purchased!");
                }
            });

            UpdateCenterView.updateScene(toShow);
            System.out.println("Scene update called");
            // Update the GUI
        }

    }

    /**
     * 
     * Purpose: manages purchasing the pokemon for the player.
     * 
     * @param player
     *            Player who landed on the tile.
     */
    public void purchase( Player player )
    {
        // If player has enough money, buy the pokemon.
        if ( player.sufficientBalance(cost) )
        {
            player.removeFromBalance(cost);
            changeOwner(player);

            // System.out.println("Pokemon purchased and added to inventory!");
        }
        // If not, nothing happens
        else
        {
            System.out
                    .println("You don't have enough money to purchase the Pokemon!");

        }
        System.out.println("Balance= " + player.currentBalance());
    }

    /**
     * 
     * Purpose: changes the owner of the current tile.
     * 
     * @param newPlayer
     *            the player who is replacing the current owner.
     */
    public void changeOwner( Player newPlayer )
    {
        // Remove from the current owner's Pokedex
        if ( owner != null )
        {
            owner.removePokemon(this.relatedPokemon);
        }

        // Update to the new owner
        this.owner = newPlayer;
        newPlayer.addPokemon(this.relatedPokemon);
    }
}
