package ObjectRepository1.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class validateConPage {
	public validateConPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateConDetails(WebDriver driver,String actualdata)
	{
		String actualdata1 = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText(); //firstname
//		if (firstName.contains(firstname)) {
//			System.out.println("contact is created");
//		} else {
//			System.out.println("contact is not created");
//		}
		return actualdata1;
	}
}

