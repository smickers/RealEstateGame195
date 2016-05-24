
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class DiceViewTest extends Application
{
GameBoard board;
    public static void main(String[] args)
    {
        Application.launch(args);

    }
    private Button roll = new Button("Roll");
    @Override
    public void start(Stage stage) throws Exception
    {
    	board = new GameBoard();
    	
    	
      Button btnRoll = board.btnRoll;
      board.testAddListener();
      
        VBox main = new VBox();
        HBox dice = new HBox();
        dice.getChildren().addAll(board.die1, board.die2);
        
        
        DieView view = new DieView();
        
         
        
        
        main.getChildren().addAll(dice, btnRoll);
        
        
        //Die die = new Die(view);
        
        //addHandler(die);
        
        Scene scn = new Scene(main);
        stage.setScene(scn);
        stage.show();
        
    }
    
//    public void addHandler(Die die)
//    {
//        System.out.println("it made handler");
//        roll.setOnAction(new EventHandler<ActionEvent>()
//                {
//
//            @Override
//            public void handle(ActionEvent ae) {
//                //dieOne = new Thread();
//
//                    System.out.println("It worked");
//                    //die.startBattleRolling();
//                    die.startMoveRolling();
//
//                //dieOne.start();
//
//            }
//
//                });
//    }

}
