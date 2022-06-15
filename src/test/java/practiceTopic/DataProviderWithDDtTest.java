package practiceTopic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_Utility.ExcelUtility;

public class DataProviderWithDDtTest 
{
@Test(dataProvider = "bookTicketDataProvider")
public void bookTickets(String src, String dest, String ticket)
{
	System.out.println("source is "+src+" destination is "+dest+" number of ticket is "+ticket);
}

@DataProvider
public Object[][] bookTicketDataProvider() throws Throwable
{
	ExcelUtility elib=new ExcelUtility();
	String src1=elib.getExceldata("Sheet2", 1, 1);
	String dest1 = elib.getExceldata("Sheet2", 1, 2);
	String tickets1= elib.getExceldata("Sheet2", 1, 3);
	
	String src2=elib.getExceldata("Sheet2", 2, 1);
	String dest2 = elib.getExceldata("Sheet2", 2, 2);
	String tickets2= elib.getExceldata("Sheet2", 2, 3);
	
	String src3=elib.getExceldata("Sheet2", 3, 1);
	String dest3 = elib.getExceldata("Sheet2", 3, 2);
	String tickets3= elib.getExceldata("Sheet2", 3, 3);
	
	Object[][]objarr=new Object[3][3];
	objarr[0][0]=src1;
	objarr[0][1]=dest1;
	objarr[0][2]=tickets1;
	
	
	objarr[1][0]=src2;
	objarr[1][1]=dest2;
	objarr[1][2]=tickets2;
	
	objarr[2][0]=src3;
	objarr[2][1]=dest3;
	objarr[2][2]=tickets3;
	
	
	
	
	return objarr;
	
}
}
