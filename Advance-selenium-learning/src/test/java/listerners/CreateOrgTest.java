package listerners;


	import static org.testng.Assert.fail;

import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;
	import org.testng.annotations.Test;

import ObjectRepository1.organization.OrganiztionLookUp;
import ObjectRepository1.organization.ValidateOrgPage;
import ObjectRepository1.organization.createOrganizationpage;
import Utility.BaseClass;
import Utility.Excel_Utility;
import Utility.File_Utility;
import Utility.Java_Utility;
import Utility.WebDriver_Utility;
import ObjectRepository1.Homepage;
import ObjectRepository1.Loginpage;
	public class CreateOrgTest extends BaseClass{
		
		@Test
		public void createOrganizationTest() throws Throwable {
			
			File_Utility flib = new File_Utility();
//			String browser = flib.getKeyAndValuePair("browser");
//			String URL = flib.getKeyAndValuePair("url");
//			String USERNAME = flib.getKeyAndValuePair("username");
//			String PASSWORD = flib.getKeyAndValuePair("password");
	//
//			WebDriver driver;
//			if (browser.contains("Chrome")) {
//				driver = new ChromeDriver();
//			} else if (browser.contains("Firefox")) {
//				driver = new FirefoxDriver();
//			} else {
//				driver = new EdgeDriver();
//			}
	//
//			driver.get(URL);
			//implemented using getter methods
//			 Loginpage login = new Loginpage(driver);
//			 login.getUserTextField().sendKeys(USERNAME);
//			 login.getPasswordTextField().sendKeys(PASSWORD);
//			 login.getLoginButton().click();
			
			
			//Businesslogics
//			Loginpage login = new Loginpage(driver);
//			login.loginToApp(USERNAME, PASSWORD);
			
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			WebDriver_Utility wlib = new WebDriver_Utility();
//			wlib.WaitForpageToLoad(driver);
//			wlib.maximize(driver);
			
		Homepage homepage = new Homepage(driver);
			homepage.Organizationbutton();
			
			OrganiztionLookUp lookupimg = new OrganiztionLookUp(driver);
			lookupimg.orgLookUp();
			
			Java_Utility jlib = new Java_Utility();
			int rannum=jlib.getRandomNum();
			
			Excel_Utility elib = new Excel_Utility();
			String OrgName = elib.getExcelData("Sheet1", 0, 0) + rannum;
			String phnNum = elib.getExcelDataUsingFormatter("Sheet1", 1, 0);
			String email = elib.getExcelDataUsingFormatter("Sheet1", 2, 0);

			createOrganizationpage page = new createOrganizationpage(driver);
			page.enterOrgDetails(OrgName, phnNum, email);
			
			//usingfailassert
			Assert.fail();
			page.clickSaveButton();

			ValidateOrgPage validate = new ValidateOrgPage(driver);
			String actualdata = validate.validateOrgDetails(driver, OrgName);
			Assert.assertEquals(actualdata, OrgName);
			System.out.println("Org is validated");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//homepage.adminlink();
		}
	}






