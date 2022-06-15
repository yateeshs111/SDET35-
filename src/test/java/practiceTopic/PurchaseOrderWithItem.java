package practiceTopic;

import java.awt.Window;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_Utility.ExcelUtility;
import generic_Utility.FileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PurchaseOrderWithItem 
{

	public static void main(String[] args) throws Throwable, Throwable 
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
		
		driver.get(url);						
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);		
		driver.findElement(By.name("user_password")).sendKeys(password);						
		driver.findElement(By.xpath("//input[@type='submit']")).click();	
		
	//Navigate to vendors
		
		WebElement ele = driver.findElement(By.xpath("//a[.='More']"));
		Wlib.mouseOverOnElement(driver, ele);
		driver.findElement(By.xpath("//a[.='Vendors']")).click();
			
		// Create vendor
			driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
			
		//Random class
			int ran = Jlib.getRandomNum();
			System.out.println(ran);
			
		//Get the data from excel
			String value = Elib.getExceldata("Sheet1", 1, 8)+ran;
			System.out.println(value);
			
			driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys(value);
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			System.out.println("vendor created successfulled");
			Thread.sleep(2000);
			
		//Navigate to product
			driver.findElement(By.xpath("//a[.='Products']")).click();		
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			//Random Class
			int ranp = Jlib.getRandomNum();
			System.out.println(ranp);
			
		//Get the data from Excel
			String valuep = Elib.getExceldata("Sheet1", 1, 6)+ranp;
			System.out.println(valuep);
			driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(valuep);
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();	
			WebElement elep = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
			String actualp = elep.getText();
			if(actualp.contains(valuep))
			{
				System.out.println("Created Product is verified");
				}
			else
				{
				System.out.println("created Product is not verified");
				}
			
			
		//Verification for created vendor
			WebElement ele1 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
			String actual = ele1.getText();
			if(actual.contains(value))
				
			{
				System.out.println("Created vendor is verified");
			}
			else
				{
				System.out.println("created vendor is not verified");
				}	
			
			
	//Navigate to Purchase order
		WebElement ele2 = driver.findElement(By.xpath("//a[.='More']"));
		Wlib.mouseOverOnElement(driver, ele2);
		driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Purchase Order...']")).click();
			
			
		int ran1 = Jlib.getRandomNum();
		System.out.println(ran1);
		
		String value1 = Elib.getExceldata("Sheet1", 1, 10)+ran1;
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(value1);
		
		
	//select for vendor
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		Wlib.swithToWindow(driver,"partialWindowTitle");
		System.out.println("Switched to child browser successfully");
		Thread.sleep(2000);
		
		driver.findElement(By.id("search_txt")).sendKeys(value);
		Thread.sleep(2000);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(value)).click();
		Thread.sleep(2000);
		
		Wlib.swithToWindow(driver,"partialWindowTitle");
		System.out.println("Switcged to parent window");
		
		int ran2 = Jlib.getRandomNum();
		System.out.println(ran2);
		
		String value2 = Elib.getExceldata("Sheet1", 1, 12)+ran2;
		System.out.println(value2);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(value2);
		
		int ran3 = Jlib.getRandomNum();
		System.out.println(ran3);
		
		String value3 = Elib.getExceldata("Sheet1", 1, 14)+ran3;
		driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(value3);
		
	//scroll by	
		
		Wlib.scrollBy(driver);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@src='themes/images/products.gif']")).click();
		
		Wlib.swithToWindow(driver,"partialWindowTitle");
		System.out.println("Switched to child browser successfully");
		Thread.sleep(2000);
		
		driver.findElement(By.id("search_txt")).sendKeys(valuep);
		Thread.sleep(2000);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(valuep)).click();
		Thread.sleep(2000);
		
		Wlib.swithToWindow(driver,"partialWindowTitle");
		System.out.println("Switcged to parent window");
		
		
		String value5 =""+Elib.getExceldataNumeric("Sheet1", 5, 0);
		//String value6 = ""+value5;
		driver.findElement(By.xpath("//input[@name='qty1']")).sendKeys(value5);
		
		Wlib.scrollBy(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
		//Verification	
		WebElement ele3 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		String actual3 = ele3.getText();
		if(actual3.contains(value1))
			
		{
			System.out.println("Created purchase with Item is verified");
		}
		else
			{
			System.out.println("Created purchase with Item is verified");
			}
		
	//Log out	
		WebElement ele4 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Wlib.mouseOverOnElement(driver, ele4);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logged out uccessfully");
		
	}

}
