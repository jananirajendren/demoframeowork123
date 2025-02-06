package ObjectRepository1.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createOrganizationpage {
@FindBy(name="accountname")
private WebElement orgNametextfield;
@FindBy(name="email1")
private WebElement emailtextfield;
@FindBy(name="phone")
private WebElement phonetextfield;
@FindBy(name="accounttype")
private WebElement typeDropDown;
@FindBy(linkText="Customer")
private WebElement customerDropdown;
@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
private WebElement saveButton;


//getter methods
public WebElement getOrgNametextfield() {
	return orgNametextfield;
}
public WebElement getEmailtextfield() {
	return emailtextfield;
}
public WebElement getPhonetextfield() {
	return phonetextfield;
}
public WebElement getTypeDropDown() {
	return typeDropDown;
}
public WebElement getCustomerDropdown() {
	return customerDropdown;
}
public WebElement getSaveButton() {
	return saveButton;
}

//element intialization
public createOrganizationpage(WebDriver driver) {
PageFactory.initElements(driver, this);
}


//methods
public void enterOrgDetails(String orgName,String phoneNo,String email) {
	orgNametextfield.sendKeys(orgName);
	emailtextfield.sendKeys(email);
	phonetextfield.sendKeys(phoneNo);
}
public void TypeDropDown() {
	typeDropDown.click();
}
public void customerDropDown() {
	customerDropdown.click();
}
public void clickSaveButton()
{
	saveButton.click();
}
}
