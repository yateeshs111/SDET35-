package com.crm.timec.contactTest;

import java.util.concurrent.TimeUnit;

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

public class CreateContactTest1 
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
			
	//Get the data from Property file				
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	//Navigate to Contact
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
	//	Random Class
			int ran = Jlib.getRandomNum();
			System.out.println(ran);
			 
	//Get the Value data from Excel Sheet	 
			
			String value = Elib.getExceldata("Sheet1",0,2)+ran;
			System.out.println(value);
			 
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(value);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			String actual = ele.getText();
			if(actual.contains(value))
				{
				System.out.println("Created contact is verified");
				}
			else
				{
				System.out.println("created contact is not verified");
				}
			
		//Mouse Over Actions
			WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Wlib.mouseOverOnElement(driver, ele1);
			driver.findElement(By.linkText("Sign Out")).click();	
		}
	}



