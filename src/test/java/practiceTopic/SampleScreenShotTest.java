package practiceTopic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.sun.org.apache.bcel.internal.classfile.Method;

import generic_Utility.BaseClass;
import generic_Utility.JavaUtility;

public class SampleScreenShotTest extends BaseClass
{
@Test
public void verifyHomePage(Method mtd) throws Throwable
{
	System.out.println(mtd.getName());
	String currentTestNAme = mtd.getName();
	System.out.println("------Test Starts -----");
	
	JavaUtility  jlib=new JavaUtility();
	
	
	EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
	File src = edriver.getScreenshotAs(OutputType.FILE);
	File dst = new File("./screenshot"+currentTestNAme+".png");
	
	try 
	{
		FileUtils.copyFile(src, dst);
	}
	catch
	(IOException e)
	{
		
	}
	System.out.println("------Test Ends------");
	
}

}
