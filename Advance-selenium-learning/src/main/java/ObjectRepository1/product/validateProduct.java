package ObjectRepository1.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class validateProduct {
	
	public validateProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateProductDetails(WebDriver driver,String prdName) {
	String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

	if (actData.equals(prdName)) {
		System.out.println("Product Name is Created");
	} else {
		System.out.println("Product name is not created");
	}
}

}