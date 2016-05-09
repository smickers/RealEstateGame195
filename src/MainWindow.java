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
//        VBox main = new VBox();
//        main.setAlignment(Pos.CENTER);
//
//        // Set up ImageView for logo
//        ImageView logo = new ImageView(new Image("img/logo.png"));
//
//        Button btnNewGame = new Button("New Game");
//        Button btnLoadGame = new Button("Load");
//        Button btnExit = new Button("Exit");
//
//        btnNewGame.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
//        btnLoadGame.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
//        btnExit.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
//
//        btnNewGame.setFont(BUTTON_FONT);
//        btnLoadGame.setFont(BUTTON_FONT);
//        btnExit.setFont(BUTTON_FONT);
//
//        main.setSpacing(10.0);
//
//        main.getChildren().addAll(logo, btnNewGame, btnLoadGame, btnExit);
//
//        Scene scene = new Scene(main);
//        stage.setScene(scene);
//        stage.show();
//
//        btnNewGame.setOnAction(new EventHandler<ActionEvent>()
//        {
//            public void handle( ActionEvent event )
//            {
//                // TODO Start a new game
//            }
//
//        });
        
//
//        btnLoadGame.setOnAction(new EventHandler<ActionEvent>()
//        {
//
//            @Override
//            public void handle( ActionEvent event )
//            {
//                // Attempt to load an existing game file
//                try
//                {
//                    Object game = LoadFile.load("Pokemon.opoly");
//                }
//                catch ( Exception e )
//                {
//                    // TODO Auto-generated catch block
//                    btnLoadGame.setDisable(true);
//                    Alert alert = new Alert(AlertType.ERROR, "No save file was found!");
//                    alert.show();
//                }
//            }
//
//        });
//
//        btnExit.setOnAction(new EventHandler<ActionEvent>()
//        {
//            public void handle( ActionEvent event )
//            {
//                try
//                {
//                    System.out.println("Stopping");
//                    stage.close();
//                }
//                catch ( Exception e )
//                {
//                    System.out.println("Exception caught!");
//                }
//            }
//        });
    }

    public static void setScene( Pane newPane )
    {
        if ( newPane != null )
        {
            scene = new Scene(newPane);
        }
    }

}
