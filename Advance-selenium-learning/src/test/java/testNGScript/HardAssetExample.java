package testNGScript;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.exceptions.AssertionFailedException;

public class HardAssetExample {

//	@Test
//	public void m1() {
//		System.out.println("step1");
//		System.out.println("step2");
//Assert.assertEquals("B", "A");
//		System.out.println("step3");
//		System.out.println("step4");
//
//	}
//	@Test
//	public void m2() {
//		String ExpData="shobha ";
//		String ActualData="shobha";
//Assert.assertEquals(ActualData, ExpData);
//	}
//	
//	@Test
//	public void m3() {
//		int a=10;
//		int b=1;
//		Assert.assertEquals(b,a, "not equal");
//		System.out.println("values are equal");
//	}
//	
//	@Test
//	public void m4() {
//		int a=10;
//		int b=1;
//		Assert.assertNotEquals(b,a, "not equal");
//		System.out.println("values are equal");
//}
//	
//	@Test
//	public void m5() {
//		String expdata="Qspiders";
//		String actualdata="Qspiders";
//Assert.assertTrue(actualdata.equalsIgnoreCase(expdata), "False=");
//		System.out.println("True==");
//}
//	@Test
//	public void m6() {
//		String expdata="Qspiders";
//		String actualdata="Qspiders";
//Assert.assertFalse(actualdata.equalsIgnoreCase(expdata), "True=");
//		System.out.println("False==");
//}
//	@Test
//	public void m7() {
//		String s="null";    //we can also give any datatypes values
//		Assert.assertNull(s, "it is not null");
//		System.out.println("it is null");
//	}
//	
//	@Test
//	public void m8() {
//		String s="Qspiders";
//		Assert.assertNull(s, "it is not null");
//		System.out.println("it is null");
//	}
//	@Test
//	public void m9() {
//		String s=" ";
//		Assert.assertNull(s, "it is not null");
//		System.out.println("it is null");
//	}
//	@Test
//	public void m10() {
//		String s="Qspiders";
//		Assert.assertNotNull(s, "it is  null");
//		System.out.println("it is not null");
//	}
	@Test
	public void m11() {
		String s="Hello";
		String s1="Hello";
		Assert.assertSame(s1, s, "not same");
		System.out.println("it is same");
	}
	@Test
	public void m12() {
		String s="Hello";
		String s1="qqq";
		Assert.assertNotSame(s1, s, "same");
		System.out.println("it is not same");
	}
	@Test
	public void m13() {
		Assert.fail("Iam failing the script");
	}
}