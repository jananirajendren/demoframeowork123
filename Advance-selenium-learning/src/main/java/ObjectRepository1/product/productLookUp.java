package ObjectRepository1.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productLookUp {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement productlookUpbutton;
	@FindBy(xpath="//table[@class='lvt small']//tr[3]/td[1]//input[@type='checkbox']")
	private WebElement checkbox;
	@FindBy(xpath="//input[@value=\"Delete\"]")
	private WebElement deleteButtion;

	
	public productLookUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//getters
	public WebElement getCheckbox() {
		return checkbox;
	}
	
	public WebElement getProductlookUpbutton() {
		return productlookUpbutton;
	}
	public WebElement getDeleteButtion() {
		return deleteButtion;
	}
	
	
	
	//methods
	public void clickProductLookUpButton() {
		productlookUpbutton.click();
	}
	public void clickCheckbox() {
		
		checkbox.click();
	}
	public void clickDeleteButtion() {
		deleteButtion.click();
	}
	public void validatedeletedproddetails(WebDriver driver,String prdName) {
		
		WebElement prd=driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+prdName+"']"));
	    if(prd.equals(prdName))
		{
			System.out.println("Product Name is Present");
		}
		else
		{
			System.out.println("Product name is not Present");
		}

}
}