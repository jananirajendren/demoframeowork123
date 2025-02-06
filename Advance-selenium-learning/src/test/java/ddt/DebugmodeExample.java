package ddt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DebugmodeExample {

    public static void main(String[] args) {
        // Variable swapping
//        int a = 10;
//        int b = 20;
//        System.out.println(a);
//        System.out.println(b);
//
//        int temp;
//        temp = a;
//        a = b;
//        b = temp;
//        System.out.println(a);
//        System.out.println(b);

  
    		
    		WebDriver driver=new ChromeDriver();
    		
    		methods ele = new methods();
    		ele.maximizeWindow(driver);
    		
    		driver.get("https://www.flipkart.com");
    		
    		driver.findElement(By.name("q")).sendKeys("Puma");
    }
}
