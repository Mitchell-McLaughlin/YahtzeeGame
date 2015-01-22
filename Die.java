
import java.util.Random;


public class Die 
	{

	private Random gen = new Random();
	private int dieValue = sides;
	private static int sides = 6;
	
	public int faceValue(){
		return dieValue;
	}
	
	public void roll(){
		dieValue = gen.nextInt(sides) + 1;
	
	}
	
	public String toString(){
		return Integer.toString(faceValue());
	}
}
