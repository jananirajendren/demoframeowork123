package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Usingexcelsheet {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
//		String path = "D:\\selenium-learning\\Excel\\Book1.xlsx";
//		FileInputStream file = new FileInputStream(path);
//		Workbook book = WorkbookFactory.create(file);
//		Sheet s = book.getSheet("Sheet1");
//		Row r = s.getRow(0);
//		Cell c = r.getCell(0);
//		 String number = c.getStringCellValue();
//		System.out.println(number);
		
		//write data into excel sheet
//		String path = "D:\\selenium-learning\\Excel\\Book1.xlsx";
//		FileInputStream file = new FileInputStream(path);
//		Workbook book = WorkbookFactory.create(file);
//		Sheet s = book.getSheet("Sheet1");
//		Row r = s.getRow(0);
//		Cell c = r.getCell(0);
//		c.setCellValue("hello");
//		FileOutputStream fout = new FileOutputStream("D:\\selenium-learning\\Excel\\Book1.xlsx");
//book.write(fout);
//book.close();

//find all the links in flipkaart and insert the links in excel sheet

String path = "D:\\selenium-learning\\Excel\\Book1.xlsx";
FileInputStream file = new FileInputStream(path);
Workbook book = WorkbookFactory.create(file);
Sheet sheet = book.getSheet("Sheet1");

WebDriver driver=new ChromeDriver();
driver.get("https://www.flipkart.com/");
 List<WebElement> ref = driver.findElements(By.tagName("a"));

 for(int i=0;i<ref.size();i++)
 {
	Row row = sheet.createRow(i); 
	Cell cell = row.createCell(0);
 cell.setCellValue(ref.get(i).getAttribute("href"));
 }
FileOutputStream fout = new FileOutputStream("D:\\selenium-learning\\Excel\\Book1.xlsx");
book.write(fout);	





}
	}

