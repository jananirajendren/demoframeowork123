package ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fetchingcombinationdatafromexcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

	String path = "D:\\selenium-learning\\Excel\\Book1.xlsx";
	FileInputStream file = new FileInputStream(path);
	Workbook book = WorkbookFactory.create(file);
	Sheet sheet = book.getSheet("Sheet1");
Row row=sheet.getRow(0);
Cell cell = row.getCell(0);
DataFormatter format = new DataFormatter();
String data = format.formatCellValue(cell);
System.out.println(data);
}
}