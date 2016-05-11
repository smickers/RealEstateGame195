import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class PokemonTile extends Tile
{
    //Variable holding the cost to purchase the current PokemonTile.
    public int cost;
    
    //Variable holding the player that currently owns the current PokemonTile. 
    private Player owner;
    
    //Variable holding the Pokemon for this tile.
    public Pokemon relatedPokemon;
    
    public GameBoard board;
    
    public PokemonTile( Pokemon relatedPokemon, int cost, GameBoard board, String name, Image image )
    {
        super(name, image);
        this.relatedPokemon = relatedPokemon;
        this.cost = cost;
        this.board = board;
    }
    
    public void action( Player player )
    {
        if (owner != null)
        {
//            StackPane toShow = new StackPane();
//            Text notBought = new Text("Pokemon already owned! Can't purchase again! (eventually this will be a battle)");
//            toShow.getChildren().add(notBought);
//            UpdateCenterView.updateScene(toShow);
            System.out.println("Pokemon already owned! Can't purchase again! (eventually this will be a battle)");
        }
        else
        {
            // tile is up for sale
            purchase(player);
        }
    }
    
    public void purchase( Player player )
    {
//        if (player.sufficientBalance(cost))
//        {
//            BorderPane toShow = new BorderPane();
//            
//            Text topMessage = new Text("Do you want to purchase " + super.name + "?");
            
            System.out.println("Do you want to purchase " + super.name + "?");
            Scanner in = new Scanner(System.in);
            char result = in.next().charAt(0);
            
            if (result == 'y')
            {
                if (player.sufficientBalance(cost))
                {
                    player.removeFromBalance(cost);
                    changeOwner(player);

                    System.out.println("Pokemon purchased and added to inventory!");
                }
                else
                {
                    System.out.println("You don't have enough money to purchase the Pokemon!");
                }
            }
            else if (result == 'n')
            {
                System.out.println("Pokemon not purchased!");
            }
            
//            toShow.setTop(topMessage);
//            
//            toShow.setCenter(new ImageView(super.image));
//            
//            Button btnYes = new Button("Yes");
//            Button btnNo = new Button("No");
//            
//            HBox buttons = new HBox();
//            buttons.getChildren().addAll(btnYes, btnNo);
//            
//            toShow.setBottom(buttons);
//            
//            btnYes.setOnAction(new EventHandler<ActionEvent>()
//                    {
//                        public void handle(ActionEvent event)
//                        {
//                            if (player.sufficientBalance(cost))
//                            {
////                                player.removeFromBalance(cost);
////                                changeOwner(player);
////                                StackPane toShow = new StackPane();
////                                Text notBought = new Text("Pokemon purchased and added to inventory!");
////                                toShow.getChildren().add(notBought);
////                                UpdateCenterView.updateScene(toShow);
//                                System.out.println("Pokemon purchased and added to inventory!");
//                            }
//                            else
//                            {
////                                StackPane toShow = new StackPane();
////                                Text notBought = new Text("You don't have enough money to purchase the Pokemon!");
////                                toShow.getChildren().add(notBought);
////                                UpdateCenterView.updateScene(toShow);
//                                System.out.println("You don't have enough money to purchase the Pokemon!");
//                            }
//                        }
//                    });
//            
//            btnNo.setOnAction(new EventHandler<ActionEvent>()
//                    {
//                        public void handle(ActionEvent event)
//                        {
////                            StackPane toShow = new StackPane();
////                            Text notBought = new Text("Pokemon not purchased!");
////                            toShow.getChildren().add(notBought);
////                            UpdateCenterView.updateScene(toShow);
//                            System.out.println("Pokemon not purchased!");
//                        }
//                    });
//            
//            UpdateCenterView.updateScene(toShow);
//            System.out.println("Scene update called");
            //Update the GUI
        }
//        else
//        { 
//            StackPane toShow = new StackPane();
//            Text notBought = new Text("You don't have enough money to purchase the Pokemon!");
//            toShow.getChildren().add(notBought);
//            UpdateCenterView.updateScene(toShow);
//        }
//    }
    
    public void changeOwner( Player newPlayer )
    {
        // Remove from the current owner's Pokedex
        if (owner != null)
        {
            owner.removePokemon(this.relatedPokemon);
        }
        
        // Update to the new owner
        this.owner = newPlayer;
        newPlayer.addPokemon(this.relatedPokemon);
    }
}
