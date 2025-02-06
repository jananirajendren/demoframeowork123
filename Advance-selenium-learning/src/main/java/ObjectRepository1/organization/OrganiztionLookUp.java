package ObjectRepository1.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganiztionLookUp {
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement lookUpbutton;

public OrganiztionLookUp(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getLookUpbutton() {
	return lookUpbutton;
}

public void orgLookUp() {
	lookUpbutton.click();
}
}
