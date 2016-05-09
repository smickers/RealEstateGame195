

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class BuyingPokemonPane extends VBox
{
    public BuyingPokemonPane( Player player, Pokemon pokemon, int price , PokemonTile tile )
    {
        Text name = new Text(player.trainer.name);
        this.getChildren().add(name);
        
        Rectangle tempImg = new Rectangle();
        this.getChildren().add(tempImg);
        
        Text pokemonName = new Text(pokemon.currentName + "is WILD");
        this.getChildren().add(pokemonName);
       
        
        HBox bottomHalf = new HBox();
        bottomHalf.setSpacing(15);
        
        Text buyText = new Text("Catch for " + price);
        this.getChildren().add(buyText);
        
        HBox btns = new HBox();
        Button yesBtn = new Button("Yes");
        yesBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e) {
                tile.purchase(player);
            }
        });

        Button noBtn = new Button("No");
        noBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e) {
                
            }
        });

        btns.getChildren().addAll( yesBtn, noBtn );
        
        bottomHalf.getChildren().add(btns);
        
        Text balance = new Text("Your Wallet: Balance is currently Private");//+ player.balance);
        bottomHalf.getChildren().add(balance);
        
        this.getChildren().add(bottomHalf);
    }
}
