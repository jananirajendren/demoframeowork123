package ObjectRepository1.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class createContactPage {
	@FindBy(name = "salutationtype")
	private WebElement firstNameDropdown;
    @FindBy(name = "firstname")
	private WebElement firstName;
	@FindBy(name = "lastname")
	private WebElement lastName;
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement conlookupicon;
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	//constructor
	public createContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//getter
	public WebElement getfirstNameDropdown() {
		return firstNameDropdown;
	}

	public WebElement getFirstname() {
		return firstName;
	}

	public WebElement getLastname() {
		return lastName;
	}

	public WebElement getconlookupicon() {
		return conlookupicon;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

//methods
	public void firstNameDropdown(String salutation) {
		Select select = new Select(firstNameDropdown);
		select.selectByVisibleText(salutation);
		firstNameDropdown.click();
	}

	public void enterconDetails(String firstname, String lastname) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
	}

	public void conlookupicon() {
		conlookupicon.click();
	}

	public void clickSaveButton() {
		saveButton.click();
	}
}
