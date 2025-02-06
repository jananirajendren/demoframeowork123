package Hardcoding;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Createproductanddelete {
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
FileInputStream fin = new FileInputStream("D:\\WORKSPACE\\SELENIUM\\Advance-selenium-learning\\src\\test\\resources\\prop.properties");
Properties pro = new Properties();
pro.load(fin);
String browser = pro.getProperty("browser");
String URL = pro.getProperty("url");
String UN = pro.getProperty("username");
String PWD = pro.getProperty("password");
String productname1=pro.getProperty("pt1");
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
driver.findElement(By.linkText("Products")).click();
driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
driver.findElement(By.name("productname")).sendKeys(productname1);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
	Alert a = driver.switchTo().alert();
	a.accept();
	
	}
}
