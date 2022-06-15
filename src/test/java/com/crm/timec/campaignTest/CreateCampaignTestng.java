package com.crm.timec.campaignTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.TimeC.POMRepository.CampaignInformationPage;
import com.crm.TimeC.POMRepository.CampaignPage;
import com.crm.TimeC.POMRepository.CreateCampaignPage;
import com.crm.TimeC.POMRepository.HomePage;
import com.crm.TimeC.POMRepository.LoginPage;

import generic_Utility.BaseClass;
import generic_Utility.ExcelUtility;
import generic_Utility.FileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTestng extends BaseClass
{
	@Test(groups="smokeTest")
	public void createCampaign() throws Throwable
	{
		
//Navigate to the application		
	HomePage hp = new HomePage(driver);
	
//Navigate to the Campaign page
	hp.getMoreLink().click();
	hp.getCampaingsLink().click();
	
//Navigate to Create Campaign page
	CampaignPage cp = new CampaignPage(driver);
	cp.getCreateCompaignImg().click();
	
//Enter the Details in to Create campaign Page	
	CreateCampaignPage ccp = new CreateCampaignPage(driver);
	
//Generate the Random Number		
	int ran = Jlib.getRandomNum();
	System.out.println("Created Random number is "+ ran);
	
	
//Get the value from Excel sheet		
	String value = Elib.getExceldata("Sheet1", 1, 4)+ran;
	System.out.println("Generated Campaign name is "+ value);
	ccp.getCamapaingName().sendKeys(value);
	ccp.getSaveButton().click();
	System.out.println("Campaign Created successfully");
	
//Navigate to Campaign information p
	CampaignInformationPage cip= new CampaignInformationPage(driver);
	String savedCamapign = cip.getSavedmsg().getText();
	if(savedCamapign.contains(value))	
		{
		System.out.println("Created Camapaign is verified");
		}
	else
		{
		System.out.println("created Camapaign is not verified");
		}
	
	}
}
