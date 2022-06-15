package com.crm.timec.campaignTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampainWithProductTest
{

	public static void main(String[] args) throws Throwable, Throwable
	{
		//Fetch data from Property File
		
		FileInputStream fis = new FileInputStream("./TestFolder/data.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
	//Get the data by getProprty	
		String browser = pro.getProperty("browser");
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		
		
	//Open the browser and Login to Application
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(url);
				
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
				
		driver.findElement(By.name("user_password")).sendKeys(password);
				
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	//Create product
		
		driver.findElement(By.xpath("//a[.='Products']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
	//Random Class
		
		Random ran = new Random();
		int org = ran.nextInt(1000);
		System.out.println(org);   
	
	//Fetch the Value from Excel
		FileInputStream fexcel = new FileInputStream("./TestFolder/data driven.xlsx");
			
		Workbook book = WorkbookFactory.create(fexcel);
				
		Sheet sheet = book.getSheet("Sheet1");
			
		Row row = sheet.getRow(1);
			
		Cell cell = row.getCell(6);
			
		String value = cell.getStringCellValue()+org;;
			
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
		
	//Create the Campaign
			
		 WebElement ele = driver.findElement(By.xpath("//a[.='More']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(ele).perform();
		
		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		Random ran1 = new Random();
		int org1 = ran1.nextInt(1000);
		System.out.println(org1);   
	
	
		FileInputStream fexcel1 = new FileInputStream("./TestFolder/data driven.xlsx");
			
		Workbook book1 = WorkbookFactory.create(fexcel1);
				
		Sheet sheet1 = book.getSheet("Sheet1");
			
		Row row1 = sheet.getRow(1);
			
		Cell cell1 = row.getCell(4);
			
		String value1 = cell.getStringCellValue()+org1;;
			
		System.out.println(value1);
		
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(value1);
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		
		
		
	//Switch to Child browser
			Set<String> set1 = driver.getWindowHandles();
			Iterator<String> it1 = set1.iterator();	
			
			
			while(it1.hasNext())
			{
				String Cid = it1.next();
				driver.switchTo().window(Cid);
				String title1 = driver.getTitle();
				if(title1.contains("Products&action")) 
				{
					break;
				}
			}
			
			System.out.println("Switched to child browser successfully");
			Thread.sleep(2000);
			
			driver.findElement(By.id("search_txt")).sendKeys(value);
			Thread.sleep(2000);
			
			driver.findElement(By.name("search")).click();
			driver.findElement(By.linkText(value)).click();
			
			Set<String> set2 = driver.getWindowHandles();
			Iterator<String> it2 = set2.iterator();
			
			while(it2.hasNext())
			{
				String Cid2 = it2.next();
				driver.switchTo().window(Cid2);
				String title2 = driver.getTitle();
				if(title2.contains("Campaigns&action"))
					{
					break;
					}	
			}
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			Thread.sleep(2000);
			
			WebElement ele3 = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			
			String actual3 = ele3.getText();
			
			if(actual.contains(value1))
			{
				System.out.println("Created camapin with product is verified");
				}
			else
				{
				System.out.println("created contact is not verified");
			
			
		//Log Out
			WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			
			Actions act2 = new Actions(driver);
			
			act2.moveToElement(ele2).perform();
			
			driver.findElement(By.linkText("Sign Out")).click();
			
			System.out.println("Logged Out Successfully");
		}		
		
	}

}
