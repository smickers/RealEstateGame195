import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class DemoTileView extends VBox{

	Text title = new Text("This is a demo pane, please hire us again");
	Button button = new Button("Press me");
	
	
	public DemoTileView()
	{
		this.setAlignment(Pos.CENTER);
		title.setFont(Font.font(30));
		this.getChildren().add(title);
		this.getChildren().add(button);
	}
	
}
