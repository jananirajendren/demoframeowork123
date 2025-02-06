package testNGScript;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderEx1 {
@Test(dataProvider="getData")

public void bookTickets(String src, String dest, int noofpeople)
{
	System.out.println("Book tickets from " + src + " to " + dest + " is " + noofpeople);
}

@DataProvider
public Object[][] getData(){
	Object[][] objArray = new Object[3][3];
	
	objArray[0][0]= "bangalore"; //int
	objArray[0][1]= "goas";
	objArray[0][2]= 201;
	
	objArray[1][0]= "bang";
	objArray[1][1]= "mumbai";
	objArray[1][2]= 201;
	
	objArray[2][0]= "chennai";
	objArray[2][1]= "goa";
	objArray[2][2]= 201;

	return objArray;
}
}
