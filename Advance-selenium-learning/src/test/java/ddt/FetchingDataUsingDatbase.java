package ddt;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchingDataUsingDatbase {

	public static void main(String[] args) throws Throwable {

		// step1:-register/load mysql database
//		Driver driverRef = new com.mysql.jdbc.Driver();
//		DriverManager.registerDriver(driverRef);
//
//		// step2:- connect to database
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket_bookings", "root", "root");
//
//		// step3:- create SQL statement
//		Statement statement = conn.createStatement();
//		String Query = "select*from booking";
//
//		// step4:- execute query
//		ResultSet result = statement.executeQuery(Query);
//
//		while (result.next()) {
//			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
//					+ result.getString(4));
//		}

		// step5:- close DataBAse
//		conn.close();
		
		
		
		//insert data into database
		// step1:-register/load mysql database
		Driver driverRef = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driverRef);

		// step2:- connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket_bookings", "root", "root");

		// step3:- create SQL statement
		Statement statement = conn.createStatement();
		String query = "insert into booking(id,first_name,last_name,address)values('3','pooja','rawat','mysore')";
		
		//step4:- execute query
		int result = statement.executeUpdate(query);
		if(result==1)
		{
			System.out.println("Data is created");
		}else
		{
			System.out.println("Data is not created");
		}
		//step5:close database
		conn.close();
		
	}

}
