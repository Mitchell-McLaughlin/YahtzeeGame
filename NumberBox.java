
public class NumberBox extends DiceRollBox 
{
	private int number;
	public NumberBox(int number)	//might need to take in another parameter 
	{
		super(number+"s");
		this.number=number;
	}
	protected int calculateScore(DiceCup r)
	{
		//checking for yahtzee as a wildcard
				for(int i = 1; i<7; ++i)
				{
					if(r.count(i) == 5)
					{
					return(number*5);
					}
				}
		return r.count(number)*number;
	}
}
