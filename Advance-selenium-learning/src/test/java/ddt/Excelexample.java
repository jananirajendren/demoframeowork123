package ddt;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelexample{

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

