package Campaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.ExcelUtility;
import Generic_Utilities.FileUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.WebDriverUtility;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

@Listeners(Generic_Utilities.ExtentReportImplementation.class)
public class CreatecampaignTest extends BaseClass
{
 
	//@Test(groups= "smokeTest")
	@Test(retryAnalyzer = Generic_Utilities.RetryImplementation.class)
	public  void  CreatecampaignTest() throws Throwable
	{ 
		// TODO Auto-generated method stub
		 
		HomePage home = new HomePage(driver);
		
		int rno = jLib.getRandomNumber();	 
		String url = fLib.getDataFromPropertyFile("url");
		String CampName = eLib.getDataFromExcelFile("Campaign", 0,0)+rno;
		home.clickMoreLink();
		home.clickCampaignLink();
		//Assert.assertEquals(false, true);
		
		CreateCampaignPage campaign = new CreateCampaignPage(driver);
		campaign.clickCreateCampaign();
		campaign.addCampaign(CampName);
		Thread.sleep(2000);
		
	 
	}
}
