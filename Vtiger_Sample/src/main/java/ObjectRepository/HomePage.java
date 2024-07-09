package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriverUtility;

public class HomePage
{
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	@FindBy(linkText = "Campaigns")
	private WebElement cmpLink;
	@FindBy(linkText = "Products")
	private WebElement prodLink;
	@FindBy(partialLinkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logOutLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getCmpLink() {
		return cmpLink;
	}

	public WebElement getProdLink() {
		return prodLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}

	 

	public WebElement getLogOutLink() {
		return logOutLink;
	}
	
	//Business Logic
	
	

	 
	public void clickOrgLink()
	{
		orgLink.click();
	}
	public void clickCampaignLink()
	{
		cmpLink.click();
	}
	public void clickProdLink()
	{
		prodLink.click();
	}
	public void clickMoreLink()
	{
		moreLink.click();
	}
	
	public void mouseHoverSignOut(WebDriver driver)
	{
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.mouseOverElement(driver, logOutLink);
	}
	
	public void ClickSignOut()
	{
		signOutLink.click();
	}
}
