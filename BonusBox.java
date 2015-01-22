
public abstract class BonusBox extends ScoringBox
{
	public BonusBox(String label)
	{
		super(label);
	}

	@Override
	public final boolean isUsed() 
	{
		return true;
	}

	@Override
	public final void score(DiceCup roll) 
	{
		
	}
		
	
}
