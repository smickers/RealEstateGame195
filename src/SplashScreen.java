import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Purpose: Creates the SplashScreen pane, to be passed into the Main Window
 * The Pane Allows the GameMaster to start a new game, or load a saved game
 * Date: May 10, 2016	
 * @author cst109 Hilary, cst152 Travis, cstCAM

 */
public class SplashScreen
{
	//The name of save file
    public static final String SAVE_FILE_NAME = "Pokemon.opoly"; 
    //The uniform button width
    private static final int BUTTON_WIDTH = 200;
    //The uniform button height
    private static final int BUTTON_HEIGHT = 40;
    //The uniform button font
    private static final Font BUTTON_FONT = new Font("Comic Sans MS", 26.0);
    
    /**
     * Purpose: Builds and returns splash screen pane
     * @param stage
     * @return Pane
     */
    public static Pane buildSplashScreen(Stage stage)
    {
        VBox main = new VBox();
        main.setAlignment(Pos.CENTER);

        // Set up ImageView for logo
        ImageView logo = new ImageView(new Image("img/logo.png"));
        //Set up buttons
        Button btnNewGame = new Button("New Game");
        Button btnLoadGame = new Button("Load");
        Button btnExit = new Button("Exit");

        btnNewGame.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnLoadGame.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnExit.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

        btnNewGame.setFont(BUTTON_FONT);
        btnLoadGame.setFont(BUTTON_FONT);
        btnExit.setFont(BUTTON_FONT);

        main.setSpacing(10.0);

        main.getChildren().addAll(logo, btnNewGame, btnLoadGame, btnExit);

        btnNewGame.setOnAction(new EventHandler<ActionEvent>()
        {
        	/**
        	 * Purpose: Handles New Game button functionality
        	 */
            @SuppressWarnings("static-access")
			public void handle( ActionEvent event )
            {
			
            	TrainerSelectScreen tss = new TrainerSelectScreen();
				MainWindow mw = new MainWindow();
				Stage stage1 = new Stage();
				mw.newStart(stage1, tss.displayScreen(stage1), "opening.mp3");
				stage.close();
            }

        });

        btnLoadGame.setOnAction(new EventHandler<ActionEvent>()
        {
        	/**
        	 * Purpose: Loads previous game file
        	 */
            @Override
            public void handle( ActionEvent event )
            {
                // Attempt to load an existing game file
                try
                {
                   Object game = LoadFile.load("Pokemon.opoly");
                	

                }
                catch ( Exception e )
                {
                    // TODO Auto-generated catch block
                    btnLoadGame.setDisable(true);
                    Alert alert = new Alert(AlertType.ERROR,
                    		"No save file was found!");
                    alert.show();
                    e.printStackTrace();
                }
            }

        });

        btnExit.setOnAction(new EventHandler<ActionEvent>()
        {
        	/**
        	 * Purpose: Handles Exit button functionality
        	 */
            public void handle( ActionEvent event )
            {
                try
                {
                    System.out.println("Stopping");
                    // TODO Pass a stage into this class' constructor
                    stage.close();
                }
                catch ( Exception e )
                {
                    System.out.println("Exception caught!");
                }
            }
        });
        
        
        return main;
    }
}
