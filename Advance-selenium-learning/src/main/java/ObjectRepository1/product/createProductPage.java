package ObjectRepository1.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createProductPage {
@FindBy(name="productname")
private WebElement productNameTextField;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveButton;


public createProductPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getProductNameTextField() {
	return productNameTextField;
}
public WebElement getSaveButton() {
	return saveButton;
}

public void enterProductName(String prdName) {
	productNameTextField.sendKeys(prdName);
}
public void clickSaveButton() {
	saveButton.click();
}
}
