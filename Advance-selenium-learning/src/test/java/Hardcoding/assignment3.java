package Hardcoding;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.sl.usermodel.Sheet;
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

import Utility.Excel_Utility;
import Utility.File_Utility;
import Utility.Java_Utility;
import Utility.WebDriver_Utility;

public class assignment3 {
	public static void main(String[] args) throws Throwable {
//Login to vtiger application->mouseOver On more Link->click on campaigns->
	//click on create campaign lookup image->Enter campaignName->
	//click on save Btn->verify whether the campaign is created in campaign Information page and Logout from the application
//	FileInputStream fin = new FileInputStream("D:\\WORKSPACE\\SELENIUM\\Advance-selenium-learning\\src\\test\\resources\\prop.properties");
//	Properties pro = new Properties();
//    pro.load(fin);
//	String browser = pro.getProperty("browser");
//	String URL = pro.getProperty("url");
//	String UN = pro.getProperty("username");
//	String PWD = pro.getProperty("password");
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String UN = flib.getKeyAndValuePair("username");
		String PWD = flib.getKeyAndValuePair("password");
	
	WebDriver driver;
	if (BROWSER.contains("Chrome")) {
		driver = new ChromeDriver();
	}
	else if(BROWSER.contains("Firefox")) {
		driver = new FirefoxDriver();
	}
	else {
		driver = new EdgeDriver();
	}

	
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(UN);
	driver.findElement(By.name("user_password")).sendKeys(PWD);
	driver.findElement(By.id("submitButton")).click();
	
//	Actions a=new Actions(driver);
	WebElement ele = driver.findElement(By.linkText("More"));
//	a.moveToElement(ele).perform();
	WebDriver_Utility wlib = new WebDriver_Utility();
	wlib.moveToElement(driver, ele);
	
	
	driver.findElement(By.linkText("Campaigns")).click();
	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	
	//To Avoid Duplicates
//	Random ran = new Random();
//	int ranNum = ran.nextInt(1000);
	Java_Utility jlib = new Java_Utility();
	int rannum = jlib.getRandomNum();
	
	
	
//	String path = "D:\\selenium-learning\\Excel\\Book1.xlsx";
//	FileInputStream file = new FileInputStream(path);
//	Workbook book = WorkbookFactory.create(file);
//    org.apache.poi.ss.usermodel.Sheet s = book.getSheet("sheet1");
//	Row r = s.getRow(0);
//	Cell c = r.getCell(0);
//	String campname = c.getStringCellValue()+rannum;
//	System.out.println(campname);
//driver.findElement(By.name("campaignname")).sendKeys(campname);

	Excel_Utility elib = new Excel_Utility();
	String campname = elib.getExcelData("Sheet1", 0, 0)+rannum;
	
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if (actdata.contains(actdata)){
		System.out.println("campaign is created");
	}
	else {
		System.out.println("campaign is not created");	
	}
	
	
	 driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		driver.findElement(By.linkText("Sign Out")).click();
}
}
