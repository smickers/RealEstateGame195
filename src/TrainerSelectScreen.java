import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class TrainerSelectScreen
{
//    public Player[] players;
//    public Player[] playersToReturn;
    
//    public TrainerSelectScreen()
//    {
//        
//    }
    
    public static Pane displayScreen()
    {
        VBox main = new VBox();
        HBox trainerImages = new HBox();
        
        Text txtChooseTrainer = new Text("Choose your trainer:");
        
        ImageView trainerOne = new ImageView(new Image("img/trainers/ash.png"));
        ImageView trainerTwo = new ImageView(new Image("img/trainers/ash.png"));
        ImageView trainerThree = new ImageView(new Image("img/trainers/ash.png"));
        ImageView trainerFour = new ImageView(new Image("img/trainers/ash.png"));
        
        trainerImages.getChildren().addAll(trainerOne, trainerTwo, trainerThree, trainerFour);
        main.getChildren().addAll(txtChooseTrainer, trainerImages);
        return main;
    }
    
    public void enableContinueButton()
    {
        
    }
}
