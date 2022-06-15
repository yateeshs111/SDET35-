package com.crm.timec.contactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_Utility.ExcelUtility;
import generic_Utility.FileUtility;
import generic_Utility.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest 
{
	public static void main(String[] args) throws Throwable 
	{
	
//		FileInputStream fis = new FileInputStream("./TestFolder/data.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
		
//		String browser = pro.getProperty("browser");
//		String url = pro.getProperty("url");
//		String username = pro.getProperty("username");
//		String password = pro.getProperty("password");
		
		FileUtility Plib = new FileUtility();
		String browser = Plib.getPropertyKeyValue("browser");
		String url = Plib.getPropertyKeyValue("url");
		String username = Plib.getPropertyKeyValue("username");
		String password = Plib.getPropertyKeyValue("password");
		
		
		
	//Open the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(url);
				
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
				
		driver.findElement(By.name("user_password")).sendKeys(password);
				
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		
//		Random ran = new Random();
//		int org = ran.nextInt(1000);
//		System.out.println(org);   
		
		 JavaUtility Jlib = new JavaUtility();
		 int ran = Jlib.getRandomNum();
		 
//		FileInputStream fexcel = new FileInputStream("./TestFolder/data driven.xlsx");
//			
//		Workbook book = WorkbookFactory.create(fexcel);
//				
//		Sheet sheet = book.getSheet("Sheet1");
//			
//		Row row = sheet.getRow(1);
//			
//		Cell cell = row.getCell(2);
//			
//		String value = cell.getStringCellValue()+ran;;
//			
//		System.out.println(value);
		 
		 ExcelUtility Elib = new ExcelUtility();
		 String value = Elib.getExceldata("Sheet1",0,2)+ran;
		 System.out.println(value);
//		 
		 
		 
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
			}//span[contains(.,'No Contact Found !')]
	WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	Actions act = new Actions(driver);
	
	act.moveToElement(ele1).perform();
	
	driver.findElement(By.linkText("Sign Out")).click();	
	}
}
