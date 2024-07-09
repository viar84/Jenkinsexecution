package Product;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.ExcelUtility;
import Generic_Utilities.FileUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.WebDriverUtility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class CreateProductTest extends BaseClass
{

	@Test(groups="regressionTest")
	public   void CreateProductTest() throws Throwable
	{
		// TODO Auto-generated method stub
		 
		HomePage home = new HomePage(driver);
		int rno = jLib.getRandomNumber();
		 
		String proName = eLib.getDataFromExcelFile("Product", 0,0)+rno;
		 
		home.clickProdLink();
		CreateProductPage prodPage = new CreateProductPage(driver);
		prodPage.clickCreateProduct();
		prodPage.addProduct(proName);
		Thread.sleep(2000);
		//String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product\"]")).getText();
		//System.out.println("Actual Data :"+actData);
		//Assert.assertTrue(actData.contains(proName),proName +" Campaign name is not verified");
	}

}
