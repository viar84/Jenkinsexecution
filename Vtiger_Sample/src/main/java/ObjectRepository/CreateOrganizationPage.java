package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage
{
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrg;
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgNametextField;
	
	@FindBy(id = "otherphone")
	private WebElement phoneNoTextField;
	
	@FindBy(name = "email1")
	private WebElement emailTextField;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getCreateOrg() {
		return createOrg;
	}

	public WebElement getOrgNametextField() {
		return orgNametextField;
	}

	public WebElement getPhoneNoTextField() {
		return phoneNoTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void clickCreateOrg()
	{
		createOrg.click();
	}

	public void addOrg(String orgName,String phNo,String email)
	{
		orgNametextField.sendKeys(orgName);
		phoneNoTextField.sendKeys(phNo);
		emailTextField.sendKeys(email);
		saveButton.click();
	}
}
