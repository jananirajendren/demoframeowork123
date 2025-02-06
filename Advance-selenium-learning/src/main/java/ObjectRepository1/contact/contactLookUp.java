package ObjectRepository1.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactLookUp {
		@FindBy(xpath="//img[@title='Create Contact...']")
		private WebElement lookUpbutton;
		

		
		public contactLookUp(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		public WebElement getLookUpbutton() {
			return lookUpbutton;
		}
	
		//methods
		public void contactLookUp() {
			lookUpbutton.click();
}
		
}