package Generic_Utilities;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation extends BaseClass implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		 TakesScreenshot shot = (TakesScreenshot)SDriver;
		 File src = shot.getScreenshotAs(OutputType.FILE);
		 LocalDateTime dtime =  LocalDateTime.now();
		 String currDateTime = dtime.toString().replace(":", "_").replace(" ", "_");
		 File tgt = new File("./ScreenShots/ScreenShotName"+currDateTime+".png");
		 try
		 {
			 FileUtils.copyFile(src, tgt);
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	 
	}

	@Override
	public void onStart(ITestContext context) {
	 
	}

	@Override
	public void onFinish(ITestContext context) {
		 
	}
	

}
