package codeusingPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.File_Utility;
import Utility.WebDriver_Utility;
import ObjectRepository1.Homepage;
import ObjectRepository1.Loginpage;
public class Homepagescript {
public static void main(String[] args) throws Throwable {

	// TODO Auto-generated method stub
//	FileInputStream fin = new FileInputStream("D:\\WORKSPACE\\SELENIUM\\Advance-selenium-learning\\src\\test\\resources\\prop.properties");
//	Properties pro = new Properties();
//	pro.load(fin);
//	String browser = pro.getProperty("browser");
//	String URL = pro.getProperty("url");
//	String UN = pro.getProperty("username");
//	String PWD = pro.getProperty("password");

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
//	 Loginpage login = new Loginpage(driver);
//	 login.getUserTextField().sendKeys(USERNAME);
//	 login.getPasswordTextField().sendKeys(PASSWORD);
//	 login.getLoginButton().click();
	
	
	//Businesslogics
	Loginpage login = new Loginpage(driver);
	login.loginToApp(USERNAME, PASSWORD);
	
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebDriver_Utility wlib = new WebDriver_Utility();
	wlib.WaitForpageToLoad(driver);
	wlib.maximize(driver);
	
	Homepage home = new Homepage(driver);
	home.calendar();
	wlib.backward(driver);
//	home.quickcreate();
//	wlib.backward(driver);
	home.morebutton();
	home.camplink();
	wlib.backward(driver);
	home.adminlink();
home.WidgetDropdown();
	wlib.backward(driver);

	home.Rss();
	
	


	


}
}