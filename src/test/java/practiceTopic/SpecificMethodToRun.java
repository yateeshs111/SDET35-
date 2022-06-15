package practiceTopic;

import org.testng.annotations.Test;

import com.crm.TimeC.POMRepository.ContactInforamationPage;
import com.crm.TimeC.POMRepository.ContactPage;
import com.crm.TimeC.POMRepository.CreateContactPage;
import com.crm.TimeC.POMRepository.CreateOrganizationPage;
import com.crm.TimeC.POMRepository.HomePage;
import com.crm.TimeC.POMRepository.OrganizationInformationPage;
import com.crm.TimeC.POMRepository.OrganizationPage;

import generic_Utility.BaseClass;

public class SpecificMethodToRun extends BaseClass
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
	}

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
		if(savedOrg.contains(value))
		{
			System.out.println("Created Organization is verified");
		}
		else
		{
			System.out.println("created Organization is not verified");

		}
	}
}
