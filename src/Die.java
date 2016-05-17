import javafx.application.Platform;
import javafx.scene.image.ImageView;




public class Die
{
    DiceView view;
    
    private int dice1Result;
    int dice2Result;

    public Die(DiceView view)
    {
    	this.view = view;
    	dice1Result = 0;
    	//this.view.addHandler(this);
    }
    
    public static int rollTwoDie()
    {
        int d1 = (int) Math.floor(Math.random() * 6 + 1);
        int d2 = (int) Math.floor(Math.random() * 6 + 1);
        int roll = d1 + d2;
        return roll;
    }
    
    public void rollBattleDie() throws InterruptedException
    {
        //int roll = (int) Math.floor(Math.random() * 6 + 1);
        Spinners roll = new Spinners( 3 );
        roll.start();
        //roll.join();
        
        System.out.println(getDie1Result());
    }
    
    public synchronized int getDie1Result()
    {
        return dice1Result;
    }
    
    private class Spinners extends Thread implements Runnable
    {
        ImageView img;
        int time;
        long start;
        long end;
        
        public Spinners( int time )
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
                                dice1Result = (int) Math.floor((Math.random() * 6) + 1);
                                System.out.println(dice1Result);
                                view.changeDice1(dice1Result - 1);
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
    
   
}
