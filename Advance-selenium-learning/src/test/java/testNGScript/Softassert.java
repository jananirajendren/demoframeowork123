package testNGScript;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassert {

	@Test
	public void m1() {
		System.out.println("step1");
		System.out.println("step2");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(false, true);
		System.out.println("step3");
		System.out.println("step4");
		sa.assertAll();
	}
}