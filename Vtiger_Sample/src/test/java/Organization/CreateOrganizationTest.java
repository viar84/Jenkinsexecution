package Organization;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.ExcelUtility;
import Generic_Utilities.FileUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.WebDriverUtility;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class CreateOrganizationTest extends BaseClass
{
	@Test 
	public   void  CreateOrganizationTest() throws Throwable 
	{
	 
		HomePage home = new HomePage(driver);
		 
		int rno = jLib.getRandomNumber();
		  
		String orgName = eLib.getDataFromExcelFile("Organization", 0,0)+rno;
		String phone = eLib.getDataFromExcelFile("Organization", 0,1);
		String email = eLib.getDataFromExcelFile("Organization", 0,2);
		CreateOrganizationPage createOrg = new CreateOrganizationPage(driver);
		
		home.clickOrgLink();
		createOrg.clickCreateOrg();
		createOrg.addOrg(orgName, phone, email);
		Thread.sleep(2000);
	}

}
