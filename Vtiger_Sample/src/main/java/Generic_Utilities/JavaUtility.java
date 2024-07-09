package Generic_Utilities;

import java.util.Random;

public class JavaUtility 
{
	public int getRandomNumber()
	{
		Random ran = new Random();
		int rno = ran.nextInt(1000);
		return rno;
	}

}
