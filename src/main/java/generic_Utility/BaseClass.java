package generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.TimeC.POMRepository.HomePage;
import com.crm.TimeC.POMRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	//Base class created
	public FileUtility flib= new FileUtility();
	public WebDriverUtility wlib= new WebDriverUtility();
	public WebDriver driver = null;
	public JavaUtility Jlib = new JavaUtility();
	public ExcelUtility Elib = new ExcelUtility();
	public static WebDriver sdriver=null;
	
	// Connect the Data Base Connection
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void beforeSuite()
	{
		System.out.println("Data Base Connection");
	}
	
	//Specify the Type of execution
	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void beforeTest()
	{
		System.out.println("Execute the scripts in parallel mode");
	}
	
	//Launching the browser
	@Parameters("Browser")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void beforeClass(@Optional("chrome")  String Browser) throws Throwable
	{
//String Browser = flib.getPropertyKeyValue("browser");
		Reporter.log(Browser, true);
	if(Browser.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if (Browser.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	
	//Maximize the window
	driver.manage().window().maximize();
	
	//Implicitly wait
	wlib.waitForElementInDOM(driver);
	sdriver=driver;   //for Screen shots
	
	//Get the URL from the Property file
	String url = flib.getPropertyKeyValue("url");
	driver.get(url);
	}
	
	//Login to the application
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void beforeMethod() throws Throwable
	{
		String username = flib.getPropertyKeyValue("username");
		String password = flib.getPropertyKeyValue("password");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApp(username, password);
	}
	
	//Sign out from the application
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void afterMethod()
	{
		HomePage homepage = new HomePage(driver);
		homepage.signOut();
	}
	
	
	//Quite the browser
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void AfterClass()
	{
		driver.quit();
	}
	
	@AfterTest(groups= {"smokeTest","regressionTest"})
	public void afterTest()
	{
		System.out.println("Parallel executuin is completed");
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void afterSuite()
	{
		System.out.println("Data Base Connection Is closed");
	}
	
	
}
