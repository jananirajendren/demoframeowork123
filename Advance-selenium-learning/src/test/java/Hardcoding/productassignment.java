package Hardcoding;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productassignment {
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fin = new FileInputStream(
				"D:\\WORKSPACE\\SELENIUM\\Advance-selenium-learning\\src\\test\\resources\\prop.properties");
		Properties pro = new Properties();
		pro.load(fin);
		String browser = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String UN = pro.getProperty("username");
		String PWD = pro.getProperty("password");
		String productname = pro.getProperty("pt");
		
		
		WebDriver driver;
		if (browser.contains("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.contains("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}

		
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//Verify product creation on "Product Information" page
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//WebElement productInfoHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
//        By.className("lvtHeaderText")));
//
//if (productInfoHeader.getText().contains(productname)) {
//    System.out.println("Product '" + productname + "' is created successfully.");
//} else {
//    System.out.println("Product creation failed.");
//}
		String actdata = driver.findElement(By.xpath("//span[@id='id='dtlview_Product Name']")).getText();
		if (actdata.contains(productname)) {
			System.out.println("Product created");
		} else {
			System.out.println("Product not created");
		}
       
		
		
		//Navigating to product table
		driver.findElement(By.xpath("//a[text()='Products']")).click();

		// driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='Product
		// Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + productname
				+ "']/../preceding-sibling::td//input[@type='checkbox']")).click();

		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();

		driver.switchTo().alert().accept();

		WebElement prd = driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + productname + "']"));
		if (prd.equals(productname)) {
			System.out.println("Product Name is Present");
		} else {
			System.out.println("Product name is not Present");
		}

		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
}
