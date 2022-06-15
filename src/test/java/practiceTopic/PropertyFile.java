package practiceTopic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertyFile {

	public static void main(String[] args) throws IOException, InterruptedException
	{


		FileInputStream fis = new FileInputStream("./TestFolder/data.properties");
		Properties pro = new Properties();
		pro.load(fis);


		System.setProperty("webdriver.gecko.driver","./Softwares/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(pro.getProperty("url"));

		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(pro.getProperty("username"));

		driver.findElement(By.name("user_password")).sendKeys(pro.getProperty("password"));

		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

	}

}
