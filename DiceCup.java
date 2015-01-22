
public class DiceCup 
{
	private Die dice[];
	private boolean[] locked;
	
	public DiceCup (int dice)
	{
		this.dice = new Die[dice];
		locked = new boolean[dice];
			for(int cnt = 0; cnt < this.dice.length; cnt++)
			{
				this.dice[cnt]=new Die();
			}
	}
	public void roll()
	{
		for(int cnt = 0; cnt < this.dice.length; cnt++)
		{
			if(!locked[cnt])
			{
				
				dice[cnt].roll();
			}
		}
	}
	public int count(int number)
	{
		int counter = 0;
		for(int cnt = 0; cnt < dice.length; cnt++)
		{
			if(number==dice[cnt].faceValue())
			{
				++counter;
			}
		}
		return counter;
	}
	public int total()
	{
		int total = 0;
		for(int cnt = 0; cnt < dice.length; cnt++)
		{
			total += dice[cnt].faceValue();
		}
		return total;
	}
	public void toggle(int die)
	{
		if(die >= 0 && die <= 4)
		{
			locked[die] = !locked[die];
		}
		/*if(locked[die-1])
		{
			locked[die-1] = false;
		}
		else
		{
			locked[die-1] = true;
		}
*/		
	}
	public void unlockAll()
	{
		for(int cnt = 0; cnt < locked.length; cnt++)
		{
			locked[cnt]=false;
		}
	}
	public String toString()	//String of two lines
	{
		String string = "";
		for(int cnt = 0; cnt < dice.length; cnt++)
		{
			string += dice[cnt].faceValue() + " ";
		}
		string += "\n";
		for(int cnt = 0; cnt < dice.length; cnt++)
		{
			if(locked[cnt])
			{
				string += "X" + " ";
			}
			else
			{
				string += " " + " ";
			}
			
		}
		return string;
	}
}
