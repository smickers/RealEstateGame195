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


public class DiceView extends Application {
	
	private static final int MAX_SLOT_PICS = 6;
    private Vector<Image> faces;
    private Thread dieOne, dieTwo;
    private static ImageView dice1, dice2;

    //For testing only, delete later
    public boolean oneDiceRoll;
    
    public DiceView()
    {
    	
    	
        dice1 = new ImageView();
        dice2 = new ImageView();
        obtainImages();
        
        dice1.setImage(faces.get((int)(Math.random() * 5)));
        dice2.setImage(faces.get((int)(Math.random() * 5)));
    }
    
    public DiceView(boolean oneDiceRoll)
    {
    	//TODO This value will be passed in
    			//replace with this.twoDiceRoll = twoDiceRoll
    	    	this.oneDiceRoll = false; 
  	}
    
    /**
     * will be changed to pass pane to calling method
     */
	@Override
	public void start(Stage stage) throws Exception 
	{
		HBox dieView = new HBox();
		VBox base = new VBox();
		Button roll = new Button("Roll Dice");
		
		//specifies battle or move roll
		//1 die for battle, 2 for move
		if( oneDiceRoll == true)
		{
			dieView.getChildren().addAll(dice1);

			
			roll.setOnAction(new EventHandler<ActionEvent>()
					{

				@Override
				public void handle(ActionEvent arg0) {
					//dieOne = new Thread();
					Spinners test = new Spinners(dice1, 3);
					test.start();
					//dieOne.start();

				}

					});
			base.getChildren().addAll(dieView, roll);
		}
		else
		{
			dieView.getChildren().addAll(dice1, dice2);

			
			roll.setOnAction(new EventHandler<ActionEvent>()
					{

				@Override
				public void handle(ActionEvent arg0) {

					Spinners test = new Spinners(dice1, 3);
					test.start();
					Spinners test2 = new Spinners(dice2, 3);
					test2.start();


				}

					});
			base.getChildren().addAll(dieView, roll);
		}
		
		Scene scene = new Scene(base);
		stage.setScene(scene);
		stage.show();
		
	}
	
	 public Image getImage(int index)
	    {
	        return faces.get(index);
	        
	    }
	    
	    private class Spinners extends Thread implements Runnable
	    {
	        ImageView img;
	        int time;
	        long start;
	        long end;
	        
	        public Spinners(ImageView img, int time)
	        {
	            this.img = img;
	            this.time = time;
	            this.start = System.currentTimeMillis();
	            this.end = start + (time * 1000);
	        }
	        
	        @Override
	        public void run()
	        {
	            while(System.currentTimeMillis() < end)
	            {
	                for (int i = 0; i < time; i++)
	                {
	                    Platform.runLater(new Runnable()
	                        {
	                            @Override
	                            public void run()
	                            {
	                                img.setImage(faces.get((int)(Math.random() * 5)));
	                            }
	                        });
	                    try
	                    {
	                    	
	                        Thread.sleep(130);
	                    }
	                    catch (InterruptedException e)
	                    {
	                        currentThread().interrupt();
	                    } 
	                    
	                }
	            }
	        }
	    }
	    
	    private class ChickenDinner extends Thread implements Runnable
	    {
	        ImageView one, two, three;
	        Text text;
	        public ChickenDinner(ImageView one, ImageView two, Text text)
	        {
	            this.one = one;
	            this.two = two;
	            this.text = text; 
	        }
	        @Override
	        public void run()
	        {
	            while(true)
	            {
	                try
	                {
	                    dieOne.join();
	                    dieTwo.join();
	                }
	                catch (InterruptedException e)
	                {
	                    System.out.println("Whoops, " + e + ".");
	                }
	                
	                try
	                {
	                    Thread.currentThread();
	                    Thread.sleep(5000);
	                }
	                catch (InterruptedException e)
	                {}
	            }
	        } 
	    }
	    
	    private void obtainImages()
	    {
	        faces = new Vector<Image>(MAX_SLOT_PICS);
	        for(int i = 1; i < MAX_SLOT_PICS; i++)
	        {
	            faces.add(new Image("./img/img" + i + ".png"));
	        }
	    }
	
	public static void main(String[] args)
    {
        Application.launch(args);
    }

}
