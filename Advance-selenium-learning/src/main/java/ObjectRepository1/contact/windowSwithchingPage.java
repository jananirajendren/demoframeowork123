package ObjectRepository1.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class windowSwithchingPage {
	@FindBy(name = "search_text")
    private WebElement searchTextBox;

    @FindBy(name = "search")
    private WebElement searchButton;
    
    @FindBy(name="accountname")
    private WebElement orgname;
    


		//getters
		public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	public WebElement getOrgNametextfield() {
		return orgname;
	}

		// TODO Auto-generated method stub
		public windowSwithchingPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	
		public void searchField(WebDriver driver,String orgname) {
			
	      searchTextBox.sendKeys(orgname);
	      searchButton.click();
		  driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();


		}
	}


