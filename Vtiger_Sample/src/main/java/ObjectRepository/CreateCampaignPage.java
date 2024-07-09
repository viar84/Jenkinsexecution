package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage 
{
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampaign;
	
	@FindBy(name = "campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Getter Methods
	
	public WebElement getCreateCampaign() {
		return createCampaign;
	}

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//BusinessLogic
	
	public  void addCampaign(String strCampName)
	{
		campaignNameTextField.sendKeys(strCampName);
		saveButton.click();
	}
	public void clickCreateCampaign()
	{
		createCampaign.click();
	}
	

}
