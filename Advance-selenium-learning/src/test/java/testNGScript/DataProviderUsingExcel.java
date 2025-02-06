package testNGScript;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Excel_Utility;

public class DataProviderUsingExcel {	
		
			@Test(dataProvider="getData")
			
			public void createOrganization(String orgname, String phonenumber, String email) throws Throwable  {
			
		WebDriver driver=new ChromeDriver();
			driver.get("http://localhost:8888/index.php?");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			driver.findElement(By.id("phone")).sendKeys(phonenumber);
			driver.findElement(By.id("email1")).sendKeys(email);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		}

		@DataProvider
		public Object[][] getData() throws Throwable
		{
			
			Excel_Utility elib = new Excel_Utility();
			Object[][] data = elib.getDataproviderData("dataprovider");
			return data;
			
			
	}

}
