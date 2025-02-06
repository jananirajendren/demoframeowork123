package ddt;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example_1 {

	public static void main(String[] args) throws Throwable {
		// launching different browsers AND read data to login vtiger app?
		FileInputStream fis = new FileInputStream("D:\\WORKSPACE\\SELENIUM\\Advance-selenium-learning\\prop.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String brow = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String UN = pro.getProperty("username");
		String PWD = pro.getProperty("password");
		


		WebDriver driver;
		if (brow.contains("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(brow.contains("Firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		
driver.get(URL);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.name("user_name")).sendKeys(UN);
driver.findElement(By.name("user_password")).sendKeys(PWD);
driver.findElement(By.id("submitButton")).click();
	}

}
