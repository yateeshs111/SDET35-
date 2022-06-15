package practiceTopic;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest 
{
	@Test
	public void createcontact()
	{
		System.out.println("Test1 Executed");
		System.out.println("Test2 Executed");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("A", "B");
		System.out.println("Test3 Executed");
		System.out.println("Test4 Executed");
		soft.assertAll();
	}
	
	@Test
	public void organization()
	{
		System.out.println("Test6 Executed");
		System.out.println("Test7 Executed");
		System.out.println("Test8 Executed");
	}

}
