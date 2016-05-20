
/**
 * 
 * @author Nathan MacNeil, Hilary Fehr 
 *
 */
public class TurnOutcome 
{
    //Variable holding the result of the first dice.
	private int result1;
	//Variable holding the result of the second dice.
	private int result2;
	//Variable holding the position the player will end their turn on.
	private int index;
	
	/**
	 * Constructor for the Turn Outcome.
	 * @param result1
	 * @param result2
	 * @param index
	 */
	public TurnOutcome(int result1, int result2, int index)
	{
		this.result1 = result1;
		this.result2 = result2;
		this.index = index;
	}
	
	/**
	 * Purpose: to provide the value of the first dice.
	 * @return
	 */
	public int getDieOne()
	{
		return result1;
	}
	
	/**
	 * Purpose: to provide the value of the second dice.
	 * @return
	 */
	public int getDieTwo()
	{
		return result2;
	}
	
	/**
	 * Purpose: to provide the ending position of the player.
	 * @return
	 */
	public int getIndex()
	{
		return index;
	}

}
