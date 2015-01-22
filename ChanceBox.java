
public class ChanceBox extends DiceRollBox
{
	public ChanceBox()
	{
		super("Chance");
	}

	@Override
	protected int calculateScore(DiceCup Roll) 
	{
		//checking for yahtzee as a wildcard
		if(isYahtzee())
		{
			return (6*5);
		}
		
		return Roll.total();
	}
	
}
