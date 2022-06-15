package practiceTopic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithoutDDTTest 
{
	@Test(dataProvider ="bookTicketDataProvider" )
	public void bookTicket(String src, String dest, int ticket)
	{
		System.out.println("source is "+src+" destination is "+dest+" number of ticket is "+ticket);
	}
	
	
	@DataProvider
	public Object[][] bookTicketDataProvider()
	{
		Object [][] objarr=new Object[3][3];
		objarr[0][0]="Bangalore";
		objarr[0][1]="Mysore";
		objarr[0][2]=	10;	
		
		objarr[1][0]="Bangalore";
		objarr[1][1]="Goa";
		objarr[1][2]=20;
		
		objarr[2][0]="Bangalore";
		objarr[2][1]="Kerala";
		objarr[2][2]=30;
								
		return objarr;
	}
	
	
}




