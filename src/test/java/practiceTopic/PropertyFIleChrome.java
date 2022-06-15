package practiceTopic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFIleChrome {

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
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(username);

		driver.findElement(By.name("user_password")).sendKeys(password);

		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		
		
	}

}
