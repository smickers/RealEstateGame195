import java.util.Vector;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;



public class Die
{
    private static final int MAX_SLOT_PICS = 6;
    private Vector<Image> faces;
    private Thread dieOne, dieTwo;
    private static ImageView dice1, dice2;
    private Button spinBtn;

    public Die()
    {
        dice1 = new ImageView();
        dice2 = new ImageView();
        obtainImages();
        
        dice1.setImage(faces.get((int)(Math.random() * 6)));
        dice2.setImage(faces.get((int)(Math.random() * 6)));
        
        spinBtn.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event)
                    {
                        dieOne = new Spinners(dice1, 1);
                        dieTwo = new Spinners(dice2, 2);
                        //winnerWinner = new ChickenDinner(dice1, dice2, slot3, winMsg);
                        dieOne.start();                
                        dieTwo.start();
                    }
                });
        
        
    }
    
    public static int rollTwoDie()
    {
        int d1 = (int) Math.floor(Math.random() * 6 + 1);
        int d2 = (int) Math.floor(Math.random() * 6 + 1);
        int roll = d1 + d2;
        return roll;
    }
    
    public static int rollBattleDie()
    {
        int roll = (int) Math.floor(Math.random() * 6 + 1);
        return roll;
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
    //|||||||||||||||||||||||||||||||||||||||||||||||||||||||\\
    //||                  WIN MSG THREADING                ||\\
    //|||||||||||||||||||||||||||||||||||||||||||||||||||||||\\
//    private class ChickenDinner extends Thread implements Runnable
//    {
//        ImageView one, two, three;
//        Text text;
//        public ChickenDinner(ImageView one, ImageView two, Text text)
//        {
//            this.one = one;
//            this.two = two;
//            this.text = text; 
//        }
//        @Override
//        public void run()
//        {
//            while(true)
//            {
//                try
//                {
//                    dieOne.join();
//                    dieTwo.join();
//                }
//                catch (InterruptedException e)
//                {
//                    System.out.println("Whoops, " + e + ".");
//                }
//                
//                try
//                {
//                    Thread.currentThread();
//                    Thread.sleep(5000);
//                }
//                catch (InterruptedException e)
//                {}
//            }
//        } 
//    }
    
    private void obtainImages()
    {
        faces = new Vector<Image>(MAX_SLOT_PICS);
        for(int i = 0; i < MAX_SLOT_PICS; i++)
        {
            faces.add(new Image("img" + i + ".png"));
        }
    }
    
    
}
