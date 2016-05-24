
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author cst104, Hilary Fehr, Nathan MacNeil
 *
 */
public class DiceViewTest extends Application
{
    GameBoard board;
    public static void main(String[] args)
    {
        Application.launch(args);

    }
   
    @Override
    public void start(Stage stage) throws Exception
    {
    	board = new GameBoard();
    	
    	
      Button btnRoll = board.btnRoll;
      board.testAddListener();
      
        VBox main = new VBox();
        HBox dice = new HBox();
        dice.getChildren().addAll(board.die1, board.die2);
        
        
      
        
        main.getChildren().addAll(dice, btnRoll);
  
        
        Scene scn = new Scene(main);
        stage.setScene(scn);
        stage.show();
        
    }
    


}
