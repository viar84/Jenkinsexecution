package Generic_Utilities;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility
{
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void waitForElementToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void mouseOverElement(WebDriver driver,WebElement elemnet) 
	{
		Actions act =  new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	public static String  getScreenshotPath(WebDriver driver,String screenShotName)
	{
		TakesScreenshot shot = (TakesScreenshot)driver;
		 File src = shot.getScreenshotAs(OutputType.FILE);
		 LocalDateTime dtime =  LocalDateTime.now();
		 String currDateTime = dtime.toString().replace(":", "_").replace(" ", "_");
		 File tgt = new File("./ScreenShots/"+screenShotName+currDateTime+".png");
		 try
		 {
			 FileUtils.copyFile(src, tgt);
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 return tgt.getAbsolutePath();
	}


}
