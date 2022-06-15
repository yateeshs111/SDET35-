package practiceTopic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest 
{
	public static void main(String[] args) throws MalformedURLException 
	{
	
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			driver.get("https://wwww.google.com");
			
			driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("google");
			
			driver.findElement(By.xpath("//input[@value='Google Search']")).click();
			
			
			
		}	
	
}
