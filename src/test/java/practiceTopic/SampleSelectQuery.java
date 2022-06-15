package practiceTopic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleSelectQuery
{

	public static void main(String[] args) throws SQLException 
	{
		Connection conn = null;
		
		try
		{
			//Register to Data Base
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			
			//Get the Connection
			Statement stat = conn.createStatement();
			
			//Create Query
			String query = "select * from students_info";
			
			//Execute the Query
			ResultSet resultset = stat.executeQuery(query);
			
			while(resultset.next())
			{
				System.out.println(resultset.getInt(1) + "\t" + resultset.getString(2));
			}
		}
		catch(Exception e)
			{
				e.printStackTrace();		
			}
			
		//Close the Data Base Connection
		finally
			{
				conn.close();
			}
		}

	}


