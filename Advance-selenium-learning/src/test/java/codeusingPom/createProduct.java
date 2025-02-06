package codeusingPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository1.product.createProductPage;
import ObjectRepository1.product.productLookUp;
import ObjectRepository1.product.validateProduct;
import Utility.Excel_Utility;
import Utility.File_Utility;
import Utility.Java_Utility;
import Utility.WebDriver_Utility;
import ObjectRepository1.Homepage;
import ObjectRepository1.Loginpage;

public class createProduct {
	public static void main(String[] args) throws Throwable {

		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");
			
			
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
				homepage.clickproductLink();
				
				productLookUp prodlookup = new productLookUp(driver);
				prodlookup.clickProductLookUpButton();
				
				Java_Utility jlib = new Java_Utility();
				int rannum=jlib.getRandomNum();
				
				Excel_Utility elib = new Excel_Utility();
                String prdName = elib.getExcelData("Sheet1", 8, 0);
				createProductPage productpage = new createProductPage(driver);
				productpage.enterProductName(prdName);
				productpage.clickSaveButton();
				
				validateProduct validateprod = new validateProduct(driver);
				validateprod.validateProductDetails(driver, prdName);
				
				//delete product
				// Navigating to product table
				homepage.clickproductLink();
				prodlookup.clickCheckbox();
				prodlookup.clickDeleteButtion();
			    wlib.acceptAlert(driver);
			    Thread.sleep(2000);
			    prodlookup.validatedeletedproddetails(driver, prdName);

				
				homepage.adminlink();
			
			
		
		   
}
}