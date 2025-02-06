package Hardcoding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.WebDriver_Utility;

public class Assignment4 {
//Login to vtiger application->mouseOverOn more Link->click on campaigns->
	// click on create campaign lookup image->Enter campaignName->Click on Product
	// plus img->
	// Handle the PopUp->Product name should be added into campaign createpage->
	// click on save Btn->verify whether the campaign is created in campaign
	// Information page and Logout from the application.
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
		String prodname = pro.getProperty("pt");
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

		Actions a = new Actions(driver);
		WebElement ele = driver.findElement(By.linkText("More"));
		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();

		String path = "D:\\selenium-learning\\Excel\\Book1.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		org.apache.poi.ss.usermodel.Sheet s = book.getSheet("sheet1");
		Row r = s.getRow(0);
		Cell c = r.getCell(0);
		String value = c.getStringCellValue();
		System.out.println(value);
		driver.findElement(By.name("campaignname")).sendKeys(value);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
//		Set<String> set = driver.getWindowHandles();
//		Iterator<String> itr = set.iterator();

//		while (itr.hasNext()) {
//			String window = itr.next();
//			Thread.sleep(2000);	
//			driver.switchTo().window(window);
//			Thread.sleep(2000);
//			if(window.contains("Products&action")) {
//				break;
//		}
//		}

		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.windowSwitching(driver, "Products&action");
		
		
		driver.findElement(By.id("search_txt")).sendKeys(prodname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + prodname + "']")).click();

//		Set<String> set1 = driver.getWindowHandles();
//		Iterator<String> itr1= set1.iterator();
//		
//		while (itr1.hasNext()) {
//			String window1 = itr1.next();
//			Thread.sleep(2000);	
//			driver.switchTo().window(window1);
//			Thread.sleep(2000);
//			if(window1.contains("Campaigns&action")) {
//				break;
//		}
//		}
		wlib.windowSwitching1(driver, "Campaigns&action");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (actdata.contains(actdata)) {
			System.out.println("campaign is created");
		} else {
			System.out.println("campaign is not created");
		}

		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

	}
}
