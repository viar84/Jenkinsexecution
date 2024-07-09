package TestNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEample {

	@Test(dataProvider = "getData")
	public  void createOrg(String orgName,String phNo,String email) throws IOException, Throwable
	{
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
	    driver.findElement(By.id("submitButton")).click();
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(orgName);
	    driver.findElement(By.id("phone")).sendKeys(phNo);
	    driver.findElement(By.id("email1")).sendKeys(email);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    Thread.sleep(1000);
	    driver.quit();

	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] orgData = new Object[3][3];
		
		orgData[0][0] = "Test1";
		orgData[0][1]="1236541236";
		orgData[0][2]="ddddfd@jhj.com";
		
		orgData[1][0] = "Test2";
		orgData[1][1]="1236541236";
		orgData[1][2]="ddddfd@jhj.com";
		
		orgData[2][0] = "Test3";
		orgData[2][1]="1236541236";
		orgData[2][2]="ddddfd@jhj.com";
		
		return orgData;
		
	}

}
