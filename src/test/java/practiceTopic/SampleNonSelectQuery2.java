package practiceTopic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleNonSelectQuery2 {

	public static void main(String[] args) throws SQLException 
	{
		Connection conn = null;
		int result=0;
		
		try
			{
			
			//Register to Data Base
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
		
			//Get the Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root", "root");
		
			//Create the Query
			Statement stat = conn.createStatement();
			String query = "insert into employee_info(empid,firstname,middlename,lastname) values('2','Suresh','bengaluru','k')";
	    
			//Execute the Query
			result = stat.executeUpdate(query);
			}
		catch(Exception e)
			{
			
			}
		finally 
			{
			if(result==1)
				{
				System.out.println("Row it is Added successfully");
				}
			else
				{
				System.out.println("Row it is not added");
				}
			
			//close the database connection
			conn.close();
	}
	}
	}


