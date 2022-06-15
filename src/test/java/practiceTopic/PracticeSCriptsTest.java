package practiceTopic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class PracticeSCriptsTest 
{
				@Test
		     public void property() throws InterruptedException
		     {
					
			System.setProperty("webdriver.gecko.driver","./Softwares/geckodriver.exe");
			
			WebDriver driver = new FirefoxDriver();
			
			driver.get("http://localhost:8888/");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
			Thread.sleep(2000);
			
			driver.findElement(By.name("user_password")).sendKeys("admin");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
			Thread.sleep(2000);
			
			
			
			}

	}

	
	
	
	
