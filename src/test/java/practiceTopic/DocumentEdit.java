package practiceTopic;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_Utility.ExcelUtility;
import generic_Utility.FileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DocumentEdit 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriverUtility Wlib= new WebDriverUtility();
		FileUtility Plib = new FileUtility();
		JavaUtility Jlib = new JavaUtility();
		ExcelUtility Elib = new ExcelUtility();

			
		String browser = Plib.getPropertyKeyValue("browser");
		String url = Plib.getPropertyKeyValue("url");
		String username = Plib.getPropertyKeyValue("username");
		String password = Plib.getPropertyKeyValue("password");
	
			
	//Open the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		Wlib.waitForElementInDOM(driver);
		driver.manage().window().maximize();
		
		driver.get(url);						
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);		
		driver.findElement(By.name("user_password")).sendKeys(password);						
		driver.findElement(By.xpath("//input[@type='submit']")).click();	
		
	//Navigate to Documents
		
		driver.findElement(By.xpath("//a[.='Documents']")).click();
		
		int ran = Jlib.getRandomNum();
		System.out.println(ran);
		
		String value = Elib.getExceldata("Sheet1", 5, 2);
		System.out.println(value);
		
		String valued = Elib.getExceldata("Sheet1", 5, 2)+ran;
		System.out.println(valued);
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		WebElement ele3 = driver.findElement(By.xpath("//input[@name='notes_title']"));

		Wlib.waitForElement(driver,ele3);
		ele3.sendKeys(valued);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
	//Verification
		WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String actual = ele.getText();
		if(actual.contains(valued))
		{
			System.out.println("Created Document is verified");
			}
		else
			{
			System.out.println("created document is not verified");
			}
	// Edit the document	
		driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();
		driver.findElement(By.xpath("//input[@name='notes_title']")).click();
		
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_BACK_SPACE);
		rbt.keyRelease(KeyEvent.VK_BACK_SPACE);
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
	//Verification after edition
		
		WebElement ele2 = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		Wlib.waitForPage(driver, "Documents&parenttab");
		String actual2 = ele2.getText();
		if(actual2.contains(value))
		{
			System.out.println("Edited Document is verified");
			}
		else
			{
			System.out.println("Edited document is not verified");
			}
	//Log out	
		WebElement ele4 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Wlib.mouseOverOnElement(driver, ele4);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logged out uccessfully");
		

	}

}
