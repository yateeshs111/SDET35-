package practiceTopic;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActiTime 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "./Softwares/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demo.actitime.com/login.do");
		
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		
		
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
		
		
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		
		driver.close();		
	}

}
