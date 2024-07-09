package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass
{
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver ;
	public static WebDriver SDriver  ;
	
	@BeforeSuite(groups = { "smokeTest","regressionTest"})
	public void beforeSuite() 
	{
		System.out.println("Connected to server");
	}
	
	@BeforeTest(groups = { "smokeTest","regressionTest"})
	public void beforeTest()
	{
		System.out.println("Connected to database");
		
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest","regressionTest"})
	public void beforeClass() throws Throwable
	{
		String browser = fLib.getDataFromPropertyFile("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
		   driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			 driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		SDriver = driver;
	}
	@BeforeMethod(groups = { "smokeTest","regressionTest"})
	public void beforeMethod() throws Throwable
	{
		wLib.maximizeWindow(driver);
		LoginPage login = new LoginPage(driver);
		String userName = fLib.getDataFromPropertyFile("username");
		String password = fLib.getDataFromPropertyFile("password");
		String URL = fLib.getDataFromPropertyFile("url");
		driver.get(URL);
		wLib.waitForElementToLoad(driver);
		login.loginToApp(userName, password);
	}
	@AfterMethod(groups = { "smokeTest","regressionTest"})
	public void afterMethod()
	{
		HomePage home = new HomePage(driver);
		home.mouseHoverSignOut(driver);
		home.ClickSignOut();
		
	}
	
	@AfterClass(groups = { "smokeTest","regressionTest"})
	public void afterClass()
	{
		driver.quit();
	}
	@AfterTest(groups = { "smokeTest","regressionTest"})
	public void afterTest()
	{
		System.out.println("DisConnected to server");
	}
	@AfterSuite(groups = { "smokeTest","regressionTest"})
	public void  afterSuite() 
	{
		System.out.println("DisConnected to server");
	}

}
