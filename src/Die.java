


public class Die
{
    

    public Die()
    {
    	
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
    
   
}
