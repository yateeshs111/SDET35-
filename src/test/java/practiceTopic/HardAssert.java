package practiceTopic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert 
{
@Test
public void createOrganization()
{
	System.out.println("Test1 Executed");
	System.out.println("Test2 Executed");
	Assert.assertEquals("A", "B");
	System.out.println("Test3 Executed");
	System.out.println("Test4 Executed");
}
@Test
public void createContact() 
{
	System.out.println("Test5 Executed");
	System.out.println("Test6 Executed");
	
}

}
