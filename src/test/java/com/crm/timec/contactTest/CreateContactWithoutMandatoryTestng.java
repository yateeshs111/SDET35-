package com.crm.timec.contactTest;

import org.testng.annotations.Test;

import com.crm.TimeC.POMRepository.ContactPage;
import com.crm.TimeC.POMRepository.CreateContactPage;
import com.crm.TimeC.POMRepository.HomePage;

import generic_Utility.BaseClass;

public class CreateContactWithoutMandatoryTestng extends BaseClass
{
	@Test
	public void createContactWithoutMandatTest() throws Throwable 
	{
		
		//Navigate to the application		
				HomePage hp = new HomePage(driver);
				hp.getContactLink().click();
		//Navigate to contact page		
				ContactPage contpage = new ContactPage(driver);
				contpage.getCreateContactImg().click();
		
				CreateContactPage createcontpage = new CreateContactPage(driver);
				createcontpage.getSaveButton().click();
		
				wlib.swithToAlertWindowAndAccpect(driver, "Last Name cannot be empty");
				
	
	
	}	
}
