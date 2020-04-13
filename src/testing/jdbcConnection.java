package testing;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcConnection {
	
	public static String connect(String username) throws SQLException
	{
		String host = "localhost";
		String port = "3306";
		String DBname = "kalai";
		//Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/kalai", "root","Testing@123");
		//Connection c = DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port + "/" + DBname, "root","Testing@123");
		// ?autoReconnect=true&useSSL=false -- is added to avoid Establishing SSL connection warning
		Connection c = DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port + "/" + DBname + "?autoReconnect=true&useSSL=false","root","Testing@123");
		
//		Statement s = c.createStatement();
//		ResultSet rs = s.executeQuery("Select *from userdetails");
//		System.out.println ("NAME" + "\t" + "PWD" +"\n");	
//		while(rs.next())
//		{
//			String name = rs.getString("name");
//			String pwd = rs.getString(2);
//			System.out.println (name + "\t" + pwd);			
//		}
		
		PreparedStatement ps = c.prepareStatement("Select pwd from userdetails where name = ?");
		ps.setString(1,username);
				
		ResultSet rs = ps.executeQuery();

		String pwd = null;
		while(rs.next())
		{
			pwd = rs.getString("pwd");
			System.out.println (pwd);			
		}
		
		return pwd;
		
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
connect("admin");

}
}
