package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writedatainpropfile {

//	public static void main(String[] args) throws Throwable {
//		// write data into property file
//		FileInputStream fis = new FileInputStream("D:\\WORKSPACE\\SELENIUM\\Advance-selenium-learning\\prop.properties");
//		Properties pro = new Properties();
//		
//		pro.setProperty("browser","Chrome");
//		pro.setProperty("url","http://localhost:8888/index.php?action=Login&module=Users");
//		pro.setProperty("username","admin");
//		pro.setProperty("password","admin");
//		
//		FileOutputStream fout = new FileOutputStream("D:\\WORKSPACE\\SELENIUM\\Advance-selenium-learning\\prop.properties");
//		pro.store(fout, "VtigerData");
		
		

		

			public static void main(String[] args) throws Throwable {
				// TODO Auto-generated method stub
				String path = "D:\\selenium-learning\\Excel\\Book1.xlsx";
				FileInputStream file = new FileInputStream(path);
				Workbook book = WorkbookFactory.create(file);
				Sheet s = book.getSheet("Sheet1");
				Row r = s.getRow(0);
				Cell c = r.getCell(0);
				 String number = c.getStringCellValue();
				System.out.println(number);

			}

}
