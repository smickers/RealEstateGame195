import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class TurnStartScreenTest extends Application {

	
	
	public static void main(String[] args)
	{
		Application.launch(args);
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		
		
		Pane pane = TurnStartScreen.displayStart(stage,new Player(new Trainer("Ash","trainers/ash.png","ashPixie.png")));
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
	
}
