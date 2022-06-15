package practiceTopic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;

public class PropertyFileAllBrowser2 
{

	public static void main(String[] args) throws Throwable 
	{
		//get the java representation of the object for Physical file
		
		FileInputStream fis = new FileInputStream("./TestFolder/data.properties");
		
		
		//Create a object to property class to load all the keys
		
		Properties pro = new Properties();
		pro.load(fis);
		
		
		//Read the value using getProperty()
		
		String browser = pro.getProperty("browser1");
		
		String url = pro.getProperty("url1");
		
		String username = pro.getProperty("username1");
		
		String password = pro.getProperty("password1");
		
		
		//Launch the browser	
		
		WebDriver driver = null;
		 if(browser.equals("fireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();				
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(url);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		Thread.sleep(4000);
	}

}
