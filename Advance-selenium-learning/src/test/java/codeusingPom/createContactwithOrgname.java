package codeusingPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository1.contact.contactLookUp;
import ObjectRepository1.contact.createContactPage;
import ObjectRepository1.contact.validateConPage;
import ObjectRepository1.contact.windowSwithchingPage;
import ObjectRepository1.organization.ValidateOrgPage;
import ObjectRepository1.organization.createOrganizationpage;
import Utility.Excel_Utility;
import Utility.File_Utility;
import Utility.Java_Utility;
import Utility.WebDriver_Utility;
import ObjectRepository1.Homepage;
import ObjectRepository1.Loginpage;

public class createContactwithOrgname {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// TODO Auto-generated method stub
//				FileInputStream fin = new FileInputStream("D:\\WORKSPACE\\SELENIUM\\Advance-selenium-learning\\src\\test\\resources\\prop.properties");
//				Properties pro = new Properties();
//				pro.load(fin);
//				String browser = pro.getProperty("browser");
//				String URL = pro.getProperty("url");
//				String UN = pro.getProperty("username");
//				String PWD = pro.getProperty("password");

				File_Utility flib = new File_Utility();
				String browser = flib.getKeyAndValuePair("browser");
				String URL = flib.getKeyAndValuePair("url");
				String USERNAME = flib.getKeyAndValuePair("username");
				String PASSWORD = flib.getKeyAndValuePair("password");

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
//				 Loginpage login = new Loginpage(driver);
//				 login.getUserTextField().sendKeys(USERNAME);
//				 login.getPasswordTextField().sendKeys(PASSWORD);
//				 login.getLoginButton().click();
				
				
				//Businesslogics
				Loginpage login = new Loginpage(driver);
				login.loginToApp(USERNAME, PASSWORD);
				
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				WebDriver_Utility wlib = new WebDriver_Utility();
				wlib.WaitForpageToLoad(driver);
				wlib.maximize(driver);
				
				Homepage homepage = new Homepage(driver);
				homepage.contactButton();
				
				contactLookUp page = new contactLookUp(driver);
				page.contactLookUp();
				
				Java_Utility jlib = new Java_Utility();
				int rannum=jlib.getRandomNum();
				

				createContactPage contactdetailpage = new createContactPage(driver);
				contactdetailpage.firstNameDropdown("Ms.");
				
				
				Excel_Utility elib = new Excel_Utility();
                String firstname = elib.getExcelData("Sheet1", 5, 0);
				String lastname = elib.getExcelData("Sheet1", 6, 0);
				
				
				contactdetailpage.enterconDetails(firstname, lastname);
				contactdetailpage.conlookupicon();
				wlib.windowSwitching(driver, "Contacts&action");
				
				windowSwithchingPage window = new windowSwithchingPage(driver);
				String orgname = elib.getExcelData("Sheet1", 7, 0);

				window.searchField(driver, orgname);
				wlib.windowSwitching1(driver, "\"Contacts&action\"");
				contactdetailpage.clickSaveButton();
				
				
				//validation
				validateConPage validate = new validateConPage(driver);
				validate.validateConDetails(driver,firstname);


				
			homepage.adminlink();

				
	}

}
