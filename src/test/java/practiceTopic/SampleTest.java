package practiceTopic;

import org.testng.annotations.Test;
public class SampleTest 
{
	@Test(priority = 2)
	public void createContactTest()
	{
		System.out.println("Contact Created");	
	}

	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest()
	{
		
		System.out.println("Contact modified");	
	}



	@Test
	public void delteContactTest()
	{
		System.out.println("Contact deleted");	
	}
}
