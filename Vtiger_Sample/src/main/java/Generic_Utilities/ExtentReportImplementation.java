package Generic_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result)
	{
		 test=report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, result.getMethod().getMethodName());
		 test.log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		test.log(Status.FAIL, result.getMethod().getMethodName());
		 test.log(Status.FAIL, result.getThrowable());
		 
		 String ScreenShot = null;
		 try
		 {
			 ScreenShot =WebDriverUtility.getScreenshotPath(BaseClass.SDriver, result.getMethod().getMethodName());
			 
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 test.addScreenCaptureFromPath(ScreenShot);
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP, result.getMethod().getMethodName());
		 test.log(Status.SKIP, result.getThrowable());
		 
	}

	@Override
	public void onStart(ITestContext context)
	{
		JavaUtility jLib = new JavaUtility();
		int rNo= jLib.getRandomNumber();
		ExtentSparkReporter spark= new ExtentSparkReporter("ExtentReport/Report_"+rNo+".html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Viji");
		spark.config().setDocumentTitle("Testing");
		
		report = new ExtentReports();
		 report.attachReporter(spark);
		 report.setSystemInfo("OS", "Windows");
		 report.setSystemInfo("ExecutedBy", "Viji");
		 report.setSystemInfo("ReviewedBy", "Viji");
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	 
	}

}
