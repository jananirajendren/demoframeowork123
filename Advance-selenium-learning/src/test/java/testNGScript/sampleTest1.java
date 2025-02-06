package testNGScript;

import org.testng.annotations.Test;
//shobha
public class sampleTest1 {
	@Test(invocationCount=2)
	public void createcontact() {
		
	System.out.println("contact created");
}
	@Test()
public void modifycontact() {
	System.out.println("contact modified");
}
	@Test(dependsOnMethods= {"createcontact","modifycontact"})
public void deletecontact() {
	System.out.println("contact deleted");
}
}
