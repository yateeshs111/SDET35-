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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteContactTest {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./TestFolder/data.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		String browser = pro.getProperty("browser");
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		
		
		
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
		
		Random ran = new Random();
		int org = ran.nextInt(1000);
		System.out.println(org);   
	
	
		FileInputStream fexcel = new FileInputStream("./TestFolder/data driven.xlsx");
			
		Workbook book = WorkbookFactory.create(fexcel);
				
		Sheet sheet = book.getSheet("Sheet1");
			
		Row row = sheet.getRow(1);
			
		Cell cell = row.getCell(2);
			
		String value = cell.getStringCellValue()+org;;
		
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
		
		WebElement drop = driver.findElement(By.xpath("(//select[@id='bas_searchfield'])[1]"));
		
		Select sel = new Select(drop);
		
		sel.selectByVisibleText("Last Name");
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[.='del']")).click();
		
		
		Alert al = driver.switchTo().alert();
		
		al.accept();
		
		WebElement ele2 = driver.findElement(By.xpath("//span[contains(.,'No Contact Found !')]"));
		
		String deleted = ele2.getText();
		
		if(deleted !=value) 
			{
			System.out.println("Contact deleted successfully");
			}
		else
			{
			System.out.println("Contact deleted successfully");
			}
	
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(ele1).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
	
	}
}
