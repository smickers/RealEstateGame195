
/**
 * @author cst104, Hilary Fehr, Nathan MacNeil
 *
 */
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