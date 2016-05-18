import java.util.Vector;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class DiceView extends Application {
	
	private static final int MAX_SLOT_PICS = 6;
    private Vector<Image> faces;
    private Thread dieOne, dieTwo;
    private static ImageView dice1, dice2;

    
    public DiceView()
    {
        dice1 = new ImageView();
        dice2 = new ImageView();
        obtainImages();
        
        dice1.setImage(faces.get((int)(Math.random() * 6)));
        dice2.setImage(faces.get((int)(Math.random() * 6)));
    }
    
	@Override
	public void start(Stage arg0) throws Exception 
	{
		
		
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
	                                img.setImage(faces.get((int)(Math.random() * 6)));
	                            }
	                        });
	                    try
	                    {
	                        Thread.sleep(20);
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
	        for(int i = 0; i < MAX_SLOT_PICS; i++)
	        {
	            faces.add(new Image("./img/img" + i + ".png"));
	        }
	    }
	
	public static void main(String[] args)
    {
        Application.launch(args);
    }

}
