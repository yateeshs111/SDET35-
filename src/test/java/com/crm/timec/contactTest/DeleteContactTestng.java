package com.crm.timec.contactTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.TimeC.POMRepository.ContactInforamationPage;
import com.crm.TimeC.POMRepository.ContactPage;
import com.crm.TimeC.POMRepository.CreateContactPage;
import com.crm.TimeC.POMRepository.HomePage;

import generic_Utility.BaseClass;

public class DeleteContactTestng extends BaseClass
{
	@Test(groups="regressionTest")
	public void deleteContactTest() throws Throwable
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
				String value1 = cip.getSuccessFulMsg().getText();
				System.out.println(value1);
				Assert.assertEquals(value1.contains(valuec), true);
			
				
				/*if(value1.contains(valuec))
					{
					System.out.println("Contact is verified");
					}
				else
					{
					System.out.println("Contact is not verified");
					} */

				cip.deleteContact(driver);
				hp.getContactLink().click();
				cp.getSearchforContact().sendKeys(valuec);
				WebElement dropdownElement = cp.getDropdown();
				wlib.select(dropdownElement,"Last Name");
				cp.getSearchBtn().click();;
				
		//Verification in Contact information page	
				String noContact = cp.getNoContactfoundMsg().getText();
				System.out.println(noContact);
				Assert.assertEquals(noContact.contains(value1), false);
					
			/*	if(valuec.contains(noContact))
					{
					System.out.println("Deleted is not verified");
					}
				else
					{
					System.out.println("Deleted contct is  verified");
					}  */
				
	}

}
