package com.crm.timec.organizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.TimeC.POMRepository.ContactInforamationPage;
import com.crm.TimeC.POMRepository.CreateOrganizationPage;
import com.crm.TimeC.POMRepository.HomePage;
import com.crm.TimeC.POMRepository.LoginPage;
import com.crm.TimeC.POMRepository.OrganizationInformationPage;
import com.crm.TimeC.POMRepository.OrganizationPage;

import generic_Utility.ExcelUtility;
import generic_Utility.FileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgTest1P 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver;
		WebDriverUtility Wlib= new WebDriverUtility();
		FileUtility Plib = new FileUtility();
		JavaUtility Jlib = new JavaUtility();
		ExcelUtility Elib = new ExcelUtility();
	
		String browser = Plib.getPropertyKeyValue("browser");
		String url = Plib.getPropertyKeyValue("url");
		String username = Plib.getPropertyKeyValue("username");
		String password = Plib.getPropertyKeyValue("password");
			
//Open the browser
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		Wlib.waitForElementInDOM(driver);
		driver.manage().window().maximize();
	
//Login to the application	
		LoginPage lp=new LoginPage(driver);
		driver.get(url);
		lp.loginToApp(username, password);
//Navigate to the application		
		HomePage hp = new HomePage(driver);
//Navigate to the Organization	
		hp.getOrganizationLink().click();
//Navigate to create Organization
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganizationImg().click();
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
//Generate the Random Number		
		int ran = Jlib.getRandomNum();
		System.out.println("Created Random number is "+ ran);
//Get the value from Excel sheet		
		String value = Elib.getExceldata("Sheet1", 1, 0)+ran;
		System.out.println("Generated organization name is "+ value);
//Enter the Organization name 		
		cop.getOrganizationName().sendKeys(value);
		cop.getSaveButton().click();
		System.out.println("Organization Created successfully");
		
		OrganizationInformationPage oip= new OrganizationInformationPage(driver);
		String savedOrg = oip.getSuccessFulMsg().getText();
		if(savedOrg.contains(value))
			{
			System.out.println("Created Organization is verified");
			}
		else
			{
			System.out.println("created Organization is not verified");
			}
//Sign Out	from the application	
		hp.signOut();
	}

}
