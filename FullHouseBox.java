public class FullHouseBox extends DiceRollBox
{
	public FullHouseBox()
	{
		super("Full House");
	}

	@Override
	protected int calculateScore(DiceCup Roll) 
	{	int score = 0;
	
	//checking for yahtzee as a wildcard
	if(isYahtzee())
	{
		return (25);
	}
		if(Roll.count(1)==3)
		{
			if(Roll.count(2)==2 || Roll.count(3)==2 || Roll.count(4)==2 || Roll.count(5)==2 || Roll.count(6)==2)
			score = 25;
		}
		else if(Roll.count(2)==3)
		{
			if(Roll.count(1)==2 || Roll.count(3)==2 || Roll.count(4)==2 || Roll.count(5)==2 || Roll.count(6)==2)
			score = 25;
		}
		else if(Roll.count(3)==3)
		{
			if(Roll.count(1)==2 || Roll.count(2)==2 || Roll.count(4)==2 || Roll.count(5)==2 || Roll.count(6)==2)
			score = 25;
		}
		else if(Roll.count(4)==3)
		{
			if(Roll.count(1)==2 || Roll.count(2)==2 || Roll.count(3)==2 || Roll.count(5)==2 || Roll.count(6)==2)
			score = 25;
		}
		else if(Roll.count(5)==3)
		{
			if(Roll.count(1)==2 || Roll.count(2)==2 || Roll.count(3)==2 || Roll.count(4)==2 || Roll.count(6)==2)
			score = 25;
		}
		else if(Roll.count(6)==3)
		{
			if(Roll.count(1)==2 || Roll.count(2)==2 || Roll.count(3)==2 || Roll.count(4)==2 || Roll.count(5)==2)
			score = 25;
		}
		
		return score;
	}

}
