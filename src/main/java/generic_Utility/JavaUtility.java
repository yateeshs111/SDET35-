package generic_Utility;

import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public int getRandomNum()
	{
		Random ran = new Random();
		int value = ran.nextInt(1000);
		return value;	
	}
	
	public String  getSystemDate() 
	{
		/*its used to get the current system date based on YYYY-MM-DD formate
	 * @return
	 */

		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		
		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;
	
			String formate = yyyy+"-"+mm+"-"+dd;
			return formate;
	}

}
