package practiceTopic;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_Utility.BaseClass;

@Listeners(generic_Utility.ListnerImgClass.class)
public class SampleScreenTest extends BaseClass
{
	@Test
public void screen()
{
	System.out.println("-----Test Starts-----");
	
	Assert.assertEquals(false, true);
	
	System.out.println("----Test Ends------");
}
}
