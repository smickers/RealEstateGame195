import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class TrainerSelectScreen
{

    
	static ArrayList<String> trainers = new ArrayList<String>();
    
	static	int count;
	static Button button;
	
    public static Pane displayScreen()
    {
        VBox main = new VBox();
        HBox trainerImages = new HBox();
        
        ImageView title = new ImageView (new Image("img/cyttitle.png"));
        title.setFitWidth(900);
        title.setFitHeight(150);
        ImageView trainerOne = new ImageView(new Image("img/trainers/ash.png"));
        trainerOne.setFitWidth(150);
        trainerOne.setFitHeight(400);
        ImageView trainerTwo = new ImageView(new Image("img/trainers/gary.png"));
        trainerTwo.setFitWidth(150);
        trainerTwo.setFitHeight(400);
        ImageView trainerThree = new ImageView(new Image("img/trainers/may.png"));
        trainerThree.setFitWidth(150);
        trainerThree.setFitHeight(400);
        ImageView trainerFour = new ImageView(new Image("img/trainers/hilda.png"));
        trainerFour.setFitWidth(200);
        trainerFour.setFitHeight(450);
        
        trainerImages.getChildren().addAll(trainerOne, trainerTwo, trainerThree, trainerFour);
        main.getChildren().addAll(title, trainerImages);
        trainerImages.setAlignment(Pos.CENTER);
        
        button = new Button("Start!");
        button.setPrefHeight(80);
        button.setPrefWidth(200);
      
        trainerOne.setOnMouseClicked(new EventHandler <MouseEvent>()
        		{
			@Override
			public void handle(MouseEvent me) {
			
				
				DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
		
				if (trainerOne.getEffect() == null)
				{
					count++;
				trainerOne.setEffect(ds);
				}
				else
				{
					count--;
					trainerOne.setEffect(null);
				}
				
				System.out.println(count);
				enableContinueButton();
			}});
        
        trainerTwo.setOnMouseClicked(new EventHandler <MouseEvent>()
        		{
			@Override
			public void handle(MouseEvent me) {
			
				DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
		
				if (trainerTwo.getEffect() == null)
				{
					count++;
				trainerTwo.setEffect(ds);
				}
				else
				{
					count--;
					trainerTwo.setEffect(null);
				}
				
				enableContinueButton();
			}});
        
        trainerThree.setOnMouseClicked(new EventHandler <MouseEvent>()
        		{
			@Override
			public void handle(MouseEvent me) {
			
				DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
		
				if (trainerThree.getEffect() == null)
				{
					count++;
				trainerThree.setEffect(ds);
				}
				else
				{
					count--;
					trainerThree.setEffect(null);
				}
				enableContinueButton();
				
			}});
        
        trainerFour.setOnMouseClicked(new EventHandler <MouseEvent>()
        		{
			@Override
			public void handle(MouseEvent me) {
			
				DropShadow ds = new DropShadow( 20, Color.CHARTREUSE );
		
				if (trainerFour.getEffect() == null)
				{
					count++;
				trainerFour.setEffect(ds);
				}
				else
				{
					count--;
					trainerFour.setEffect(null);
				}
				enableContinueButton();
				
			}});
        
        button.setOnMouseClicked(new EventHandler <MouseEvent>()
        		{

					@Override
					public void handle(MouseEvent arg0) {
					
						if (trainerOne.getEffect()!= null)
						{
							trainers.add("Ash");
						}
						if (trainerTwo.getEffect()!= null)
						{
							trainers.add("Gary");
						}
						if (trainerThree.getEffect()!= null)
						{
							trainers.add("May");
						}
						if (trainerFour.getEffect()!= null)
						{
							trainers.add("Hilda");
						}
						
						System.out.println(trainers.toString());
					//	GameMain gameMain = new GameMain(trainers);
						
						b B = new b();
						
					}
        	
        		});
        
        main.getChildren().add(button);
        main.setAlignment(Pos.CENTER);
        button.setDisable(true);
        return main;
    }
    
    public static void enableContinueButton()
    {
        if (count >= 2)
        {
        	button.setDisable(false);
        }
        else
        {
        	button.setDisable(true);
        }
    }
}