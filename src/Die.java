//import javafx.application.Platform;
//
//
//
//
//public class Die
//{
//    DiceView view;
//    
//    private int dice1Result;
//    private int dice2Result;
//    
//
//    public Die(DiceView view)
//    {
//    	this.view = view;
//    	dice1Result = 0;
//    	//this.view.addHandler(this);
//    }
//    
//    public int rollTwoDie()
//    {
//        dice1Result = (int) Math.floor(Math.random() * 6 + 1);
//        dice2Result = (int) Math.floor(Math.random() * 6 + 1);
////        int d1 = (int) Math.floor(Math.random() * 6 + 1);
////        int d2 = (int) Math.floor(Math.random() * 6 + 1);
//        
//        int roll = dice1Result + dice2Result;
////        int rollTotal = d1 + d2;
//import javafx.application.Platform;
//
//
//
//
public class Die
{
	public Die()
	{
		
	}
	
	public static int roll()
	{
		int roll = (int) Math.floor(Math.random() * 6 );
		//System.out.println(roll);
		return roll;
	}
	 public static int rollTwo()
	 {
		 int result = roll() + roll();
		 //System.out.println(result);
		 return result;
	 }

}
//    DiceView view;
//    
//    private int dice1Result;
//    private int dice2Result;
//    
//
//    public Die(DiceView view)
//    {
//    	this.view = view;
//    	dice1Result = 0;
//    	//this.view.addHandler(this);
//    }
//    
//    public int rollTwoDie()
//    {
//        dice1Result = (int) Math.floor(Math.random() * 6 + 1);
//        dice2Result = (int) Math.floor(Math.random() * 6 + 1);
////        int d1 = (int) Math.floor(Math.random() * 6 + 1);
////        int d2 = (int) Math.floor(Math.random() * 6 + 1);
//        
//        int roll = dice1Result + dice2Result;
////        int rollTotal = d1 + d2;
//        
//        return roll;
//    }
//    
//    public int rollBattleDie() 
//    {
//        dice1Result = (int) Math.floor(Math.random() * 6 + 1);
////        int d1 = (int) Math.floor(Math.random() * 6 + 1);
//        
//        return dice1Result;
//    }
//    
//    public int startBattleRolling(DiceView view)
//    {
//        int result = rollBattleDie();
//        Spinners roll = new Spinners( 3, false );
//        
//        roll.start();
//
//        
//        System.out.println("\n"+result+"\n");
//       return result;
//    }
//    
//    public int startMoveRolling( )
//    {
//        int result = rollTwoDie();
//        
//        Spinners roll = new Spinners( 3, true );
//        
//        roll.start();
//
////        
////        System.out.println("\n"+dice1Result+"\n");
////        System.out.println("\n"+dice2Result+"\n");
//        System.out.println("\n"+result+"\n");
//        
//        return result;
//        
//    }
//    
////    public synchronized int getDie1Result()
////    {
////        return dice1Result;
////    }
//    
//    private class Spinners extends Thread implements Runnable
//    {
//        boolean twoDice;
//        int time;
//        long start;
//        long end;
//        
//        public Spinners( int time, boolean twoDice )
//        {
//            this.twoDice = twoDice;
//            this.time = time;
//            this.start = System.currentTimeMillis();
//            this.end = start + (time * 1000);
//        }
//        
//        @Override
//        public void run()
//        {
//            while(System.currentTimeMillis() < end)
//            {
//                for (int i = 0; i < time; i++)
//                {
//                    Platform.runLater(new Runnable()
//                        {
//                            @Override
//                            public void run()
//                            {
//                                int num = (int) Math.floor((Math.random() * 6) + 1);
//                                view.changeDice1(num - 1);
//                                
//                                if(twoDice)
//                                {
//                                    int num2 = (int) Math.floor((Math.random() * 6) + 1);
//                                    view.changeDice2(num2 - 1);
//                                }
//                            }
//                        });
//                    try
//                    {
//                        
//                        Thread.sleep(130);
//                    }
//                    catch (InterruptedException e)
//                    {
//                        currentThread().interrupt();
//                    } 
//                    
//                }
//                
//               
//                
//                
//            }
//            view.changeDice1(dice1Result-1);
//            
//            int rollTotal = dice1Result;
//            
//            if(twoDice)
//            {
//                view.changeDice2(dice2Result-1);
//                rollTotal += dice2Result;
//            }
//            view.dispalyRoll(rollTotal);
//        }
//    }
//    
//   
//}
