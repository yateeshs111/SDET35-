package practiceTopic;

import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class PracticeHome 
{
	public static void main(String[] args) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream("path");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet1");
		
		Row row = sheet.getRow(1);
		
		Cell cell = row.getCell(0);
		
		String value = cell.getStringCellValue();
		
		System.out.println(value);
		
		FileOutputStream fout = new FileOutputStream("path");
		book.write(fout);
		
		}

}



/*String parentid = driver.getWindowHandle();

Set<String> ids = driver.getWindowHandles();

System.out.println(ids); */

/* for (String allids : ids) 
{
	driver.switchTo().window(allids);
	String currentUrl = driver.getCurrentUrl();
	{
	if(currentUrl.contains("localhost:8888/index.php?module=Products&action=Popup&html=Popup_picker&form=HelpDeskEditView&popuptype=specific&fromlink="));
	{
		System.out.println("Switch to Child Browser");
		
		driver.findElement(By.linkText("Product1920")).click();
		
		Thread.sleep(2000);
		driver.switchTo().window(parentid);
	}	
}*/
/*for (String allids : ids)
{
if(parentid.equals(allids)==false)
	{
	driver.switchTo().window(allids);
	System.out.println("Switched to child browser successfully");
	Thread.sleep(2000);
	
	driver.findElement(By.linkText("Product1920")).click();
	Thread.sleep(2000);
	}

}
	driver.switchTo().window(parentid);
	System.out.println("Switched to Parent parent Window ");
	Thread.sleep(2000);	*/





