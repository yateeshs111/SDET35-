package com.crm.timec.contactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.TimeC.POMRepository.ContactInforamationPage;
import com.crm.TimeC.POMRepository.ContactPage;
import com.crm.TimeC.POMRepository.CreateContactPage;
import com.crm.TimeC.POMRepository.HomePage;

import generic_Utility.BaseClass;

public class CreateContactTestng extends BaseClass
{

	@Test(groups="smokeTest")
	public void createContactTest() throws Throwable 
	{
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
				String actualcontact = cip.actualContactName();
				System.out.println(actualcontact);
				Assert.assertEquals(actualcontact.contains(valuec), true);
			
			/*	if(value1.contains(valuec))
				{
					System.out.println("Contact is verified");
				}
				else
				{
					System.out.println("Contact is not verified");
				}	*/
	}
}
