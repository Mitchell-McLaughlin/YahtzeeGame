
public class LargeStraightBox extends DiceRollBox
{
	public LargeStraightBox()
	{
		super("Large Straight");
	}
	@Override
	protected int calculateScore(DiceCup Roll) 
	{
		//checking for yahtzee as a wildcard
		if(isYahtzee())
		{
			return (40);
		}
			int score = 0;
			if(Roll.count(1)>=1 && Roll.count(2)>=1 && Roll.count(3)>=1 && Roll.count(4)>=1 && Roll.count(5)>=1)
			{
				score = 40;
			}
			else if(Roll.count(2)>=1 && Roll.count(3)>=1 && Roll.count(4)>=1 && Roll.count(5)>=1 && Roll.count(6)>=1)
			{
				score = 40;
			}
			return score;
		
	}

	

}
