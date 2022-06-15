package practiceTopic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Unittest
{

	public static void main(String[] args) throws SQLException 
	{
		String ProjectName="Suresh";
		Connection conn = null;
		
		try
			{
			
			//Step 1 : Register to Data Base
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
		
			//Step 2: Get the Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root", "root");
			
			System.out.println("Connection is done");
			
			//Step 3 : create query statement
			Statement stat = conn.createStatement();	
			String query = "select * from employee_info";
			
			//Step 4: Execute the query
			ResultSet resultset = stat.executeQuery(query);
			while(resultset.next())
			{
			   String actProjectName = resultset.getString(2);
				   if(actProjectName.equals(ProjectName))
				   {
					   System.out.println("Project is present");
				   }
				   else 
				   {
					System.out.println("Project is not present");   
				   }
			   }
			}
		catch(Exception e)
		{
			
		}
		finally
		{
			//Step 5 : close the database connection
		conn.close();	
		}			
	}

}
