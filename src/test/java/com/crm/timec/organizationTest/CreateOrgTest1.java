package com.crm.timec.organizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_Utility.ExcelUtility;
import generic_Utility.FileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgTest1 
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
		
	//	Enter the Details
		driver.get(url);						
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);		
		driver.findElement(By.name("user_password")).sendKeys(password);						
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	//Navigate to Organization	
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		
	//Create Organization	
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		int ran = Jlib.getRandomNum();
		System.out.println(ran);
		
	//get the data from Excel	
		String value = Elib.getExceldata("Sheet1", 1, 0)+ran;		
		System.out.println(value);
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(value);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();	
		System.out.println("Organization is created");
	//Verification	
	
		WebElement ele1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));	
		String actual = ele1.getText();
		if(actual.contains(value))
		{
			System.out.println("Created Organization is verified");
			}
		else
			{
			System.out.println("created Organization is not verified");
			}
		
	//Logout
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Wlib.mouseOverOnElement(driver, ele2);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Loggedout Successfully");

	}

}
