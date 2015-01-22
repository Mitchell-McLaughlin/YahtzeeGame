public class OfAKindBox extends DiceRollBox
{
	private int amount;
	
	public OfAKindBox(int amount)
	{
		super(amount + " of a kind");
		this.amount = amount;
	}
	
	protected int calculateScore(DiceCup roll)
	{
		int score = 0;
		//checking for yahtzee as a wildcard
				if(isYahtzee())
				{
					return (roll.count(1)*5);
				}
		if(roll.count(1)>=amount || roll.count(2)>=amount || roll.count(3)>=amount ||
				roll.count(4)>=amount || roll.count(5)>=amount ||roll.count(6)>=amount)
		{
			score = roll.total();
		}
		return score;
	}
}
