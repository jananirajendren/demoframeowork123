package testNGScript;

import org.testng.annotations.Test;

public class sampleTest {
	@Test
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
