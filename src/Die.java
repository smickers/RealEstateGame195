import java.util.Vector;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;



public class Die
{
    //Constant for the # of faces on the die
    private static final int MAX_SLOT_PICS = 6;
    
    //Image vector that holds the pictures for the die faces
    private Vector<Image> faces;
    //Threading for each die
    private Thread dieOne, dieTwo;
    //ImageViews for the pictures of the die
    private static ImageView dice1, dice2;
    //Button for rolling
    private Button rollBtn;

///////////////////////////////////////////////////////////////////////////////    
/////////////////////////////////////////////////////////////////////////////// 
    
    /**
     * CONSTRUCTOR: Die
     * @info: creates the dice for the game. Retrieves and sets image faces
     *          for GUI implementation. When the 'Roll' button is clicked,
     *          starts the dice threads to roll the die.
     */
    public Die()
    {
        //Image for first die
        dice1 = new ImageView();
        //Image for second die
        dice2 = new ImageView();
        
        //Retrieve the images for the die
        getImages();
        
        //Set the images on the die - random initially
        dice1.setImage(faces.get((int)(Math.random() * 6)));
        dice2.setImage(faces.get((int)(Math.random() * 6)));
        
        //When the button is clicked
        rollBtn.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event)
                    {
                        //Create the spinners (Threads) and how long each will
                        //roll (for this iteration, max 2 seconds)
                        dieOne = new Spinners(dice1, 1);
                        dieTwo = new Spinners(dice2, 2);
                        //IGNORE STUFF IN THE BOX FOR NOW
                        //////////////////////////////////////////////////////
                        //winnerWinner = new ChickenDinner(dice1, dice2, slot3, winMsg);
                        //////////////////////////////////////////////////////
                        //Start the threads
                        dieOne.start();                
                        dieTwo.start();
                    }
                });
        
        
    }
    
    /**
     * METHOD: rollTwoDie()
     * @info: when called, the Player will roll two dice at the same time.
     * @return: The sum of two die rolls - each roll is a whole number between
     *          1 and 6 inclusive, .:. returns a whole number between 2 and 12.
     */
    public static int rollTwoDie()
    {
        //d1 and d2 are the die to roll = random number between 1 and 6 inc.
        int d1 = (int) Math.floor(Math.random() * 6 + 1);
        int d2 = (int) Math.floor(Math.random() * 6 + 1);
        int roll = d1 + d2;
        return roll;
    }
    
    /**
     * METHOD: rollBattleDie()
     * @info: when called, the player will roll a single die. Only called
     *          during Pokémon Battle.
     * @return: a whole number between 1 and 6 inclusive.
     */
    public static int rollBattleDie()
    {
        int roll = (int) Math.floor(Math.random() * 6 + 1);
        return roll;
    }
    
    /**
     * METHOD: getImages
     * @info: creates a Vector array of images, adds the images to the vector.
     */
    private void getImages()
    {
        faces = new Vector<Image>(MAX_SLOT_PICS);
        for(int i = 0; i < MAX_SLOT_PICS; i++)
        {
            faces.add(new Image("img" + i + ".png"));
        }
    }
    
    /**
     * CLASS(INNER): Spinners
     * @info: Threads to handle the dice roll
     * @author cst104
     *
     */
    private class Spinners extends Thread implements Runnable
    {
        //image that will show up on the die
        ImageView img;
        // amount of time spinner will run
        int time;
        //current system time
        long start;
        //start time, plus the length of time the die will roll
        long end;
        
        /**
         * CONSTRUCTOR: Spinners(Imageview img, int time)
         * @param img: An image for the die
         * @param time: the length of time the die should roll, in seconds
         */
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
            //While we haven't reached the end time yet
            while(System.currentTimeMillis() < end)
            {
                //for the length of time specified
                for (int i = 0; i < time; i++)
                {
                    //Create a new Runnable
                    Platform.runLater(new Runnable()
                        {
                            //That, while running,
                            @Override
                            public void run()
                            {
                                //Sets a random image as the die face
                                img.setImage(faces.get((int)(Math.random() * 6)));
                            }
                        });
                    try
                    {
                        //Change every 20ms
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
    //||         WIN MSG THREADING - IGNORE DIS            ||\\
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
    

    
}
