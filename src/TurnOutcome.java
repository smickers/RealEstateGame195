
public class TurnOutcome 
{
	private int result1;
	private int result2;
	private int index;
	
	public TurnOutcome(int result1, int result2, int index)
	{
		this.result1 = result1;
		this.result2 = result2;
		this.index = index;
	}
	
	public int getDieOne()
	{
		return result1;
	}
	
	public int getDieTwo()
	{
		return result2;
	}
	
	public int getIndex()
	{
		return index;
	}

}
