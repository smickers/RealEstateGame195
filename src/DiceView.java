import java.util.Vector;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class DiceView extends ImageView 
{
	
	private static final int MAX_SLOT_PICS = 6;
    private Vector<Image> faces;
    private Thread dieOne, dieTwo;
    //private static ImageView dice1, dice2;
    
    private final int DICE_STARTING_POSITION = 1;

    //For testing only, delete later
   
    
    private Text rollTotal;
    
    //TODO
    //private Button roll;
//    
//    public DiceView()
//    {
//        //TODO CONSTRUCTOR FOR TESTING
//    }
    
    public DiceView(/*boolean oneDiceRoll*/)
    {
       // this.rollTotal = new Text(" ");
        
//    	
//    	
//        dice1 = new ImageView();
//        dice2 = new ImageView();
//        obtainImages();
//        
//        dice1.setImage(faces.get(DICE_STARTING_POSITION));
//        dice2.setImage(faces.get(DICE_STARTING_POSITION));
        
        this.setImage(faces.get(DICE_STARTING_POSITION));
        
        //HBox dieView = new HBox();
        //VBox base = new VBox();
        //roll = new Button("Roll Dice");
        
        //specifies battle or move roll
        //1 die for battle, 2 for move
//        if( oneDiceRoll == true)
//        {
//            dieView.getChildren().addAll(dice1);
//
//            
//        }
//        else
//        {
//            dieView.getChildren().addAll(dice1, dice2);
//
//            
//        }
        
        //TODO
        //this.getChildren().addAll(dieView, rollTotal /*,roll*/);
    }

//    
//	 public Image getImage(int index)
//	    {
//	        return faces.get(index);
//	        
//	    }
//
//	    
//	    
//	    public void changeDice1(int num)
//	    {
//	        dice1.setImage(faces.get(num)  );
//	    }
//	    
//	    public void changeDice2(int num)
//	    {
//	        dice2.setImage(faces.get(num)  );
//	    }
//	    
//	    
//	   
//	    
//	    private void obtainImages()
//	    {
//	        faces = new Vector<Image>(MAX_SLOT_PICS);
//	        for(int i = 1; i <= MAX_SLOT_PICS; i++)
//	        {
//	            faces.add(new Image("./img/img" + i + ".png"));
//	        }
//	    }
//	    
//	    public void dispalyRoll(int rollTotal)
//	    {
//	        this.rollTotal.setText("You rolled a: " + rollTotal); 
//	    }


}
