package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fetchalllinksasoutput {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//fetch all the links and display as output
		String path = "D:\\selenium-learning\\Excel\\Book1.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("Sheet1");

		int lastrow = sheet.getLastRowNum()+1;
		System.out.println(lastrow);

		for(int i=0 ; i<lastrow ; i++)
		{
			Row row = sheet.getRow(i); 
			Cell cell = row.getCell(0);
			String linkslist = cell.getStringCellValue();
			System.out.println(linkslist);
		}
	}

}
