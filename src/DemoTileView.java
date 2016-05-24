import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class DemoTileView extends VBox{

	Text title;
	Text info = new Text("What luck! You find $100 in the tall grass!");
//	Button button = new Button("Press me");
	
	
	public DemoTileView(Player current, int tilesMoved)
	{
		title  = new Text("You moved " + tilesMoved + " spaces and landed on a Pokemon Card Tile");
		this.setAlignment(Pos.CENTER);
		title.setFont(GameFont.SMALL_GAME_FONT);
		info.setFont(GameFont.SMALL_GAME_FONT);
		ImageView trainerImg = new ImageView(current.trainer.trainerImage);
		trainerImg.setPreserveRatio(true);
		trainerImg.setFitHeight(465);
		this.getChildren().add(trainerImg);
		this.getChildren().add(title);
		this.getChildren().add(info);
		this.setBackground(new Background(new BackgroundFill(Color.web("FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY)));
		this.setMaxWidth(586);
		
	}
	
}
