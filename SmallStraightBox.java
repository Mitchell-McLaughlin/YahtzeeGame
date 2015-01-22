
public class SmallStraightBox extends DiceRollBox
{
	public SmallStraightBox()
	{
		super("Small Straight");
	}
	@Override
	protected int calculateScore(DiceCup Roll)
	{
		int score = 0;
		//checking for yahtzee as a wildcard
				for(int i = 1; i<7; ++i)
				{
					if(Roll.count(i) == 5)
					{
					return(30);
					}
				}
		if(Roll.count(1)>=1 && Roll.count(2)>=1 && Roll.count(3)>=1 && Roll.count(4)>=1)
		{
			score = 30;
		}
		else if(Roll.count(2)>=1 && Roll.count(3)>=1 && Roll.count(4)>=1 && Roll.count(5)>=1)
		{
			score = 30;
		}
		else if(Roll.count(3)>=1 && Roll.count(4)>=1 && Roll.count(5)>=1 && Roll.count(6)>=1)
		{
			score = 30;
		}
		return score;
	}
	


}
