import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TurnStartScreen {

	
	
	
	public static Pane displayStart(Stage stage, Player p)
	{
		
		Image trainerPic = new Image(ImageReference.getPlayerImage(p));
		VBox main = new VBox();
		ImageView trainerImageView = new ImageView(trainerPic);
		trainerImageView.setFitHeight(300);
		trainerImageView.setFitWidth(150);

		Text text = new Text("It's " + p.name + "'s turn");
		main.getChildren().add(text);
		main.getChildren().add(trainerImageView);
		
		Button button = new Button("Start turn");
		main.setPrefSize(500,500);
		main.setAlignment(Pos.CENTER);
		main.getChildren().add(button);
		
		
		return main;
		
	}
}
