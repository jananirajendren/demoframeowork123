package Hardcoding;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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
import ObjectRepository1.Homepage;
import ObjectRepository1.Loginpage;
public class CreateProductAndDeleteit {
	


		public static void main(String[] args) throws Throwable {
//			// step1:- get the file path connection
//			FileInputStream fis = new FileInputStream("D:\\WORKSPACE\\SELENIUM\\Advance-selenium-learning\\src\\test\\resources\\prop.properties");
//
//			// step2:- load all the keys
//			Properties pro = new Properties();
//			pro.load(fis);
//
//			// step3:- read key value
//			String BROWSER = pro.getProperty("browser");
//			String URL = pro.getProperty("url");
//			String USERNAME = pro.getProperty("username");
//			String PASSWORD = pro.getProperty("password");

			
			File_Utility flib = new File_Utility();
			String BROWSER = flib.getKeyAndValuePair("browser");
			String URL = flib.getKeyAndValuePair("url");
			String USERNAME = flib.getKeyAndValuePair("username");
			String PASSWORD = flib.getKeyAndValuePair("password");
			
			WebDriver driver;
			if (BROWSER.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}

			else if (BROWSER.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}

			else if (BROWSER.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else {
				driver = new EdgeDriver();
			}
			driver.get(URL);
			//implemented using getter methods
//			 Loginpage login = new Loginpage(driver);
//			 login.getUserTextField().sendKeys(USERNAME);
//			 login.getPasswordTextField().sendKeys(PASSWORD);
//			 login.getLoginButton().click();
			
			
			//Businesslogics
			Loginpage login = new Loginpage(driver);
			login.loginToApp(USERNAME, PASSWORD);
			
//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			driver.findElement(By.id("submitButton")).click();

//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebDriver_Utility wlib = new WebDriver_Utility();
			wlib.WaitForpageToLoad(driver);
			wlib.maximize(driver);

			driver.findElement(By.linkText("Products")).click();

			driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();

			// To Avoid Duplicates
//			Random ran = new Random();
//			int ranNum = ran.nextInt(1000);

			Java_Utility jlib = new Java_Utility();
			int rannum = jlib.getRandomNum();
			
//			// Step1:-get the connection of physical file
//			FileInputStream fis1 = new FileInputStream("D:\\selenium-learning\\Excel\\Book1.xlsx");
//
//			// step2:- open workbook in read mode
//			Workbook book = WorkbookFactory.create(fis1);
//
//			// step3:-get control of the Sheet
//			Sheet sheet = book.getSheet("Sheet1");
//
//			// step4:-get control of the row
//			Row row = sheet.getRow(0);
//
//			// step5:-get control of the cell
//			Cell cel = row.getCell(0);
//
//			// //step6:-read cell value
//			String PrdName = cel.getStringCellValue() + rannum;
//			System.out.println(PrdName);
			
			Excel_Utility elib = new Excel_Utility();
			String PrdName = elib.getExcelDataUsingFormatter("Sheet1", 0, 0)+rannum;

			driver.findElement(By.name("productname")).sendKeys(PrdName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

			if (actData.equals(PrdName)) {
				System.out.println("Product Name is Created");
			} else {
				System.out.println("Product name is not created");
			}

			// -------------------------------------------------------------------------------------------------------------------------
			// Navigating to product table
			driver.findElement(By.xpath("//a[text()='Products']")).click();

			// driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='Product
			// Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
	driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+PrdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
		
		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
		
		//driver.switchTo().alert().accept();
		wlib.acceptAlert(driver);
		
		
		WebElement prd=driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+PrdName+"']"));
	    if(prd.equals(PrdName))
		{
			System.out.println("Product Name is Present");
		}
		else
		{
			System.out.println("Product name is not Present");
		}
	    
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

//		Actions act = new Actions(driver);
//		act.moveToElement(ele).perform();
		wlib.moveToElement(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		}
}
