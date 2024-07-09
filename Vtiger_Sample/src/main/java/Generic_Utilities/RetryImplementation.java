package Generic_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer
{

	 int count = 0;
	 int retryLimit =2;
	public boolean retry(ITestResult result)
	{
		// TODO Auto-generated method stub
		if (count<retryLimit)
		{
			count++;
			return true;
			
		}
		return false;
	}

}
