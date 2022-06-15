package com.crm.timec.campaignTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_Utility.ExcelUtility;
import generic_Utility.FileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampainWithProductTest1 
{

	public static void main(String[] args) throws Throwable 
	{
	//General Utility classes
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
		
	//Navigate to Product product
		
		driver.findElement(By.xpath("//a[.='Products']")).click();		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
	//Random Class
		int ran = Jlib.getRandomNum();
		System.out.println(ran);
		
	//Get the data from Excel
		String value = Elib.getExceldata("Sheet1", 1, 6)+ran;
		System.out.println(value);
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(value);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();	
		WebElement ele1 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		String actual = ele1.getText();
		if(actual.contains(value))
		{
			System.out.println("Created Product is verified");
			}
		else
			{
			System.out.println("created Product is not verified");
			}
	//Navigate to Campaign	
		WebElement ele = driver.findElement(By.xpath("//a[.='More']"));
		Wlib.mouseOverOnElement(driver, ele);
		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		
	//Create Campaign	
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		int ran1 = Jlib.getRandomNum();
		System.out.println(ran1);
	//Get the Data from Excel	
		String value1 = Elib.getExceldata("Sheet1",1,4)+ran1;
		System.out.println(value1);
		
		
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(value1);
		
	//Select the Product	
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Wlib.swithToWindow(driver,"Products&action");
		System.out.println("Switched to child browser successfully");
		
		driver.findElement(By.id("search_txt")).sendKeys(value);
		
		//driver.findElement(By.id("search_txt")).sendKeys(value);
		//Thread.sleep(2000);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(value)).click();
		
		Wlib.swithToWindow(driver,"Campaigns&action");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Verification	
			WebElement ele2 = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			String actual2 = ele2.getText();
			if(actual2.contains(value))
				
			{
				System.out.println("Created Camapaign with Product is verified");
			}
			else
				{
				System.out.println("created Camapaign with Product is not verified");
				}	
	//Mouse over action for logout 
			
			WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Wlib.mouseOverOnElement(driver, ele3);
			driver.findElement(By.linkText("Sign Out")).click();	
			System.out.println("Logged out successfully");
		

	}
	

}
