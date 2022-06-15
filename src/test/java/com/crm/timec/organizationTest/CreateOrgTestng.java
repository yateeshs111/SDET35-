package com.crm.timec.organizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.TimeC.POMRepository.CreateOrganizationPage;
import com.crm.TimeC.POMRepository.HomePage;
import com.crm.TimeC.POMRepository.LoginPage;
import com.crm.TimeC.POMRepository.OrganizationInformationPage;
import com.crm.TimeC.POMRepository.OrganizationPage;

import generic_Utility.BaseClass;
import generic_Utility.ExcelUtility;
import generic_Utility.FileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgTestng extends BaseClass
{

	@Test(groups="smokeTest")
	public void createOrg() throws Throwable
	{
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
		System.out.println(savedOrg);
		Assert.assertEquals(savedOrg.contains(value), true);
		
		
		
	/*	if(savedOrg.contains(value))
			{
			System.out.println("Created Organization is verified");
			}
		else
			{
			System.out.println("created Organization is not verified");
			}		*/
	}
}
