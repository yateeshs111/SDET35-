package com.crm.timec.contactTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import generic_Utility.ExcelUtility;
import generic_Utility.FileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteContactTest1 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriverUtility Wlib = new WebDriverUtility();
		FileUtility Flib= new FileUtility();
		JavaUtility Jlib=new JavaUtility();
		ExcelUtility Elib = new ExcelUtility();		
		
	//Get the data from Property File
		
		String browser = Flib.getPropertyKeyValue("browser");
		String url = Flib.getPropertyKeyValue("url");
		String username = Flib.getPropertyKeyValue("username");
		String password = Flib.getPropertyKeyValue("password");
		
		
		
	//Open the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		Wlib.waitForElementInDOM(driver);
		
	//Enter the data from property File
		
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		
		//Random Class
		
		int ran = Jlib.getRandomNum();
		System.out.println(ran);   
	
	// Get the data from Excel Sheet
		 String value=Elib.getExceldata("Sheet1", 1, 2)+ran;
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
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(value);
		WebElement drop = driver.findElement(By.xpath("(//select[@id='bas_searchfield'])"));
		
		Wlib.select(drop,"Last Name");
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		
		WebElement	elep=driver.findElement(By.xpath("//a[.='del']"));
		Wlib.waitForElement(driver, elep);
		elep.click();

		
	//Handle the Popup
		
		Wlib.swithToAlertWindowAndAccpect(driver, "Are You Sure You want to Delete?");
		Thread.sleep(2000);
		WebElement ele2 = driver.findElement(By.xpath("//span[contains(.,'No Contact Found !')]"));
		String deleted = ele2.getText();
		
		if(deleted !=value) 
			{
			System.out.println("Contact deleted successfully");
			}
		else
			{
			System.out.println("Contact deleted not successfully");
			}
	
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		//Perform Actions class
		Wlib.mouseOverOnElement(driver, ele1);
		
		driver.findElement(By.linkText("Sign Out")).click();
	
	}
}



