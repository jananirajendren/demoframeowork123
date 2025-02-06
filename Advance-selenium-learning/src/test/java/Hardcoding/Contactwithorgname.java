package Hardcoding;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import Utility.File_Utility;
import Utility.WebDriver_Utility;
import ObjectRepository1.Homepage;
import ObjectRepository1.Loginpage;

public class Contactwithorgname {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
//		FileInputStream fin = new FileInputStream("D:\\WORKSPACE\\SELENIUM\\Advance-selenium-learning\\src\\test\\resources\\prop.properties");
//		Properties pro = new Properties();
//		pro.load(fin);
//		String browser = pro.getProperty("browser");
//		String URL = pro.getProperty("url");
//		String UN = pro.getProperty("username");
//		String PWD = pro.getProperty("password");
//		String Firstname = pro.getProperty("firstname");
//		String Lastname = pro.getProperty("lastname");
//
//		String Orgname = pro.getProperty("orgname");

		File_Utility flib = new File_Utility();
		String browser = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");
		String Firstname = flib.getKeyAndValuePair("firstname");
     	String Lastname = flib.getKeyAndValuePair("lastname");
         String Orgname = flib.getKeyAndValuePair("orgname");
         
         
		WebDriver driver;
		if (browser.contains("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.contains("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}

		driver.get(URL);
		//implemented using getter methods
//		 Loginpage login = new Loginpage(driver);
//		 login.getUserTextField().sendKeys(USERNAME);
//		 login.getPasswordTextField().sendKeys(PASSWORD);
//		 login.getLoginButton().click();
		
		
		//Businesslogics
		Loginpage login = new Loginpage(driver);
		login.loginToApp(USERNAME, PASSWORD);

//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.WaitForpageToLoad(driver);
		wlib.maximize(driver);
		
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement dropdown = driver.findElement(By.name("salutationtype"));
		Select s1 = new Select(dropdown);
		s1.selectByVisibleText("Ms.");
		driver.findElement(By.name("firstname")).sendKeys(Firstname);
		driver.findElement(By.name("lastname")).sendKeys(Lastname);

		driver.findElement(By.xpath("//img[@alt='Select']")).click();
//		Set<String> set = driver.getWindowHandles();
//		Iterator<String> itr = set.iterator();
//
//		while (itr.hasNext()) {
//			String window = itr.next();
//			Thread.sleep(2000);
//			driver.switchTo().window(window);
//			Thread.sleep(2000);
//			if (window.contains("Contacts&action")) {
//				break;
//			}
//		}
		wlib.windowSwitching(driver, "Contacts&action");
		
		driver.findElement(By.id("search_txt")).sendKeys(Orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + Orgname + "']")).click();

//		Set<String> set1 = driver.getWindowHandles();
//		Iterator<String> itr1 = set1.iterator();
//
//		while (itr1.hasNext()) {
//			String window1 = itr1.next();
//			Thread.sleep(2000);
//			driver.switchTo().window(window1);
//			Thread.sleep(2000);
//			if (window1.contains("Contacts&action")) {
//				break;
//			}
//		}
		wlib.windowSwitching1(driver, "Contacts&action");
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (actdata.contains(actdata)) {
			System.out.println("contact is created");
		} else {
			System.out.println("contact is not created");
		}

WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		driver.findElement(By.linkText("Sign Out")).click();
//		Actions act = new Actions(driver);
//		act.moveToElement(ele).perform();
		wlib.moveToElement(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
