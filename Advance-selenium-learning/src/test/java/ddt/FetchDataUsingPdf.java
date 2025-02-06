package ddt;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchDataUsingPdf {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
File file = new File("./src/test/resources/Annotation.pdf");
PDDocument doc = PDDocument.load(file);
int pages = doc.getNumberOfPages();
System.out.println(pages);

PDFTextStripper pdfdata = new PDFTextStripper();
String readdata = pdfdata.getText(doc);
//System.out.println(readdata);

pdfdata.setStartPage(2);
String readdata1 = pdfdata.getText(doc);
//System.out.println(readdata1);

pdfdata.setStartPage(2);
pdfdata.setEndPage(2);
String readdata2 = pdfdata.getText(doc);
System.out.println(readdata2);


	}

}
