package TestNG;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTestNG 
{
	@Test//(priority = -1)
	public void createProduct()
	{
		System.out.println("Product Created");
		//Assert.fail();
	}
	
	@Test//(priority = 0,invocationCount = 2,dependsOnMethods = "createProduct")
	public void modiftProduct()
	{
		System.out.println("Product Modified");
	}
	@Test//(priority = 1,enabled = false)
	public void deleteProduct()
	{
		System.out.println("Product Deleted");
	}

}
