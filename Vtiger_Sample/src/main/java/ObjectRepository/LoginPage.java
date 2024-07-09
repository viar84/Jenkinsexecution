package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(name="user_name")
	private WebElement userNameTextfield;
	@FindBy(name= "user_password")
	private WebElement passwordtextField;
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	public  LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTextfield() {
		return userNameTextfield;
	}

	public WebElement getPasswordtextField() {
		return passwordtextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void loginToApp(String userName,String password)
	{
		userNameTextfield.sendKeys(userName);
		passwordtextField.sendKeys(password);
		submitButton.click();
		
	}
}
