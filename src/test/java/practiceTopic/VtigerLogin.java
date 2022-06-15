package practiceTopic;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerLogin {

	public static void main(String[] args) throws Throwable 
	{
		
		//Property File
		
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
			
			
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
			
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Data From Excel
			Random ran = new Random();
			int org = ran.nextInt(1000);
			System.out.println(org);   
		
		
			FileInputStream fexcel = new FileInputStream("./TestFolder/data driven.xlsx");
				
			Workbook book = WorkbookFactory.create(fexcel);
					
			Sheet sheet = book.getSheet("Sheet1");
				
			Row row = sheet.getRow(3);
				
			Cell cell = row.getCell(0);
				
			String value = cell.getStringCellValue()+org;;
				
			System.out.println(value+org);
			//String value = book.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
				
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(value+org);
				
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();	
				
	}

}
