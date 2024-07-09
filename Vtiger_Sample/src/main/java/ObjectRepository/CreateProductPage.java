package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage 
{
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProduct;
	@FindBy(name = "productname")
	private WebElement productNameTexttField;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	public WebElement getCreateProduct() {
		return createProduct;
	}
	public WebElement getproductNameTexttField() {
		return productNameTexttField;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	public void clickCreateProduct()
	{
		createProduct.click();
	}
	public void addProduct(String productName)
	{
		productNameTexttField.sendKeys(productName);
		saveButton.click();
	}
}
