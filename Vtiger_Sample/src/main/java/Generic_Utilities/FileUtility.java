package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility 
{
	public String getDataFromPropertyFile(String strKey) throws Throwable
	{
		FileInputStream fis = new FileInputStream("D:\\viji\\AdvancedSelenium\\DataFiles\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String strValue = prop.getProperty(strKey);
		return strValue;
	}
	
}
