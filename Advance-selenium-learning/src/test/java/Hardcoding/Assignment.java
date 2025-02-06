package Hardcoding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class Assignment {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
FileInputStream fin = new FileInputStream("D:\\WORKSPACE\\SELENIUM\\Advance-selenium-learning\\src\\test\\resources\\prop.properties");
Properties pro = new Properties();
pro.load(fin);
String browser = pro.getProperty("browser");
String URL = pro.getProperty("url");
String UN = pro.getProperty("username");
String PWD = pro.getProperty("password");
String Orgname=pro.getProperty("orgname");	
String Phonenumber=pro.getProperty("phonenumber");
String mail = pro.getProperty("mail");


WebDriver driver;
if (browser.contains("Chrome")) {
	driver = new ChromeDriver();
}
else if(browser.contains("Firefox")) {
	driver = new FirefoxDriver();
}
else {
	driver = new EdgeDriver();
}


driver.get(URL);
driver.findElement(By.name("user_name")).sendKeys(UN);
driver.findElement(By.name("user_password")).sendKeys(PWD);
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
driver.findElement(By.name("accountname")).sendKeys(Orgname);
driver.findElement(By.id("phone")).sendKeys(Phonenumber);
driver.findElement(By.id("email1")).sendKeys(mail);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//WebElement productInfoHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
//        By.className("dvHeaderText")));
//
//if (productInfoHeader.getText().contains(Orgname)) {
//    System.out.println("Organization '" + Orgname + "' is created successfully.");
//} else {
//    System.out.println("Organiztion creation failed.");
//}


String actualdata = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
if(actualdata.contains(Orgname)) {	
	System.out.println("Org is created.");
}else {
	System.out.println("Org is not created.");
}


Actions a = new Actions(driver);
WebElement icon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
a.moveToElement(icon).perform();
WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement logoutLink = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='index.php?module=Users&action=Logout']")));
logoutLink.click();
//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//driver.findElement(By.linkText("Sign Out")).click();

	}
}
