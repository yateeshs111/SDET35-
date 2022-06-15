package practiceTopic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertFileAllBrowser 
{

	public static void main(String[] args) throws Throwable 
	{
		
		//get the java representation of the object for Physical file
		
				FileInputStream fis = new FileInputStream("./TestFolder/data.properties");
				
				
				//Create a object to property class to load all the keys
				
				Properties pro = new Properties();
				pro.load(fis);
				
				
				//Read the value using getProperty()
				
				String browser = pro.getProperty("browser");
				
				String url = pro.getProperty("url");
				
				String username = pro.getProperty("username");
				
				String password = pro.getProperty("password");
				
				
				//Launch the browser	
				
				WebDriver driver = null;
				if(browser.equals("chrome"))
				{
				WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}
				 else if(browser.equals("fireFox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();				
				}
				else
				{
					driver = new ChromeDriver();
				}
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(url);
				
				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);

				driver.findElement(By.name("user_password")).sendKeys(password);

				
				driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
