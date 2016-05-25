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
 * Purpose: This holds the main method, and is used to start the game and update
 * the GUI
 *
 * Date: May 9 2016
 * 
 * @author cst109 Hilary, cst152 Travis, cstCAM
 */
public class MainWindow extends Application
{

    public static Scene scene = new Scene(new StackPane());

    /**
     * Purpose: Launches initial window
     * 
     * @param args
     */
    public static void main( String[] args )
    {

        Application.launch(args);
    }

    /**
     * Purpose: Initial start screen
     */
    @Override
    public void start( Stage stage )
    {
        setScene(SplashScreen.buildSplashScreen(stage));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Purpose: Validates newPane and sets scene to newPane
     * 
     * @param newPane
     */
    public static void setScene( Pane newPane )
    {
        if ( newPane != null )
        {
            scene = new Scene(newPane);
        }
    }

    /**
     * Purpose: additional start screens
     * 
     * @param stage
     * @param pane
     * @param song
     *            - path name of audio
     */
    public static void newStart( Stage stage, Pane pane, String song )
    {
        sound.stop();
        setScene(pane);
        stage.setScene(scene);
        stage.show();
        sound.playSound(song);

    }

}
