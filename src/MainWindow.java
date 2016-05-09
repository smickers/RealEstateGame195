import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 
 * Purpose: This holds the main method, and is pretty much used to start the
 * game and update the center view of the board.
 *
 * @author Red Group
 * @version 1.0
 */
public class MainWindow extends Application
{
    

    public static Scene scene = new Scene(new StackPane());

    public static void main( String[] args )
    {
        Application.launch(args);
    }

    @Override
    public void start( Stage stage )
    {
//       setScene(SplashScreen.buildSplashScreen(stage));
        setScene(TrainerSelectScreen.displayScreen());
       stage.setScene(scene);
       stage.show();
    }

    public static void setScene( Pane newPane )
    {
        if ( newPane != null )
        {
            scene = new Scene(newPane);
        }
    }

}
