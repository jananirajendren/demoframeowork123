package testNGScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateOrgTest {
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
public Object[][] getData()
{
	
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	
	Object[][] objArray = new Object[3][3];
	
	objArray[0][0]= "AAA" + ranNum; //int
	objArray[0][1]= "1234567890";
	objArray[0][2]= "hgd@gmail.com";
	
	objArray[1][0]= "BBB" + ranNum;
	objArray[1][1]= "1234567890";
	objArray[1][2]= "hgd@gmail.com";
	
	objArray[2][0]= "AAA" + ranNum;
	objArray[2][1]= "1234567890";
	objArray[2][2]= "hgd@gmail.com";

	return objArray;
}
}
