package com.crm.timec.contactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.TimeC.POMRepository.ContactInforamationPage;
import com.crm.TimeC.POMRepository.ContactPage;
import com.crm.TimeC.POMRepository.CreateContactPage;
import com.crm.TimeC.POMRepository.HomePage;
import com.crm.TimeC.POMRepository.LoginPage;

import generic_Utility.ExcelUtility;
import generic_Utility.FileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteContactTest1P 
{

	public static void main(String[] args) throws Throwable 
	{
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
		WebDriver driver =new ChromeDriver();
		Wlib.waitForElementInDOM(driver);
		driver.manage().window().maximize();
	
//Login to the application	
		LoginPage lp=new LoginPage(driver);
		driver.get(url);
		lp.loginToApp(username, password);
//Navigate to the application		
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
//Navigate to contact page		
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactImg().click();
//Navigate to Create contact 	
//Get the data from the Excel
		int ran = Jlib.getRandomNum();
		System.out.println(ran);
		
		String valuec = Elib.getExceldata("Sheet1", 0, 2)+ran;
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createContact(valuec);
//Verification in Contact information page		
		ContactInforamationPage cip=new ContactInforamationPage(driver);
		String value1 = cip.getSuccessFulMsg().getText();
		System.out.println(value1);
	
		if(value1.contains(valuec))
		{
			System.out.println("Contact is verified");
		}
		else
		{
			System.out.println("Contact is not verified");
		}

		cip.deleteContact(driver);
		hp.getContactLink().click();
		cp.getSearchforContact().sendKeys(valuec);
		WebElement dropdownElement = cp.getDropdown();
		Wlib.select(dropdownElement,"Last Name");
		cp.getSearchBtn().click();;
		
		//Verification in Contact information page	
		String noContact = cp.getNoContactfoundMsg().getText();
		System.out.println(noContact);
			
		if(valuec.contains(noContact))
		{
			System.out.println("Deleted is not verified");
		}
		else
		{
			System.out.println("Deleted contct is  verified");
		}
		
		
		Wlib.waitForElementInDOM(driver);
		
//Logout		
		hp.signOut();
	}

}
