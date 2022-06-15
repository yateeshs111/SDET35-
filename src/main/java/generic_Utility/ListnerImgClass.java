package generic_Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImgClass implements ITestListener 
{
	public void onTestFailure(ITestResult result)
	{
		System.out.println(".......Test case Fails.......");
		 	JavaUtility jlib = new JavaUtility();
		 	
		 	String testName = result.getMethod().getMethodName();
		 	
		 	EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sdriver);
		 	File src = eDriver.getScreenshotAs(OutputType.FILE);
		 	File dst = new File("./screenshot/"+testName+" "+jlib.getSystemDate()+".png");
		 	
		 	try 
		 	{
		 		FileUtils.copyFile(src, dst);
		 	}
		 	catch(IOException e)
		 	{
		 		
		 	}
	}

}
