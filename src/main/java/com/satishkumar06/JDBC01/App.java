package com.satishkumar06.JDBC01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException, IOException
    {
      	String url = "jdbc:mysql://localhost:3306/sampledb";
    	String uname= "root";
    	String pass = "root";
    	
    	// Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
     
        //Creating a connection
        Connection con = DriverManager.getConnection(url,uname,pass);
        
        // Create a query
        String q = "insert into table1(tName, tCity) values (?, ?)";
        
        //get the PreparedStatement object
        PreparedStatement pstmt = con.prepareStatement(q);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter Name : ");
        String name = br.readLine();
        
        System.out.println("Enter City : ");
        String city = br.readLine();
        		
        //set the values to query
        pstmt.setString(1, name);
        pstmt.setString(2, city);
        
        pstmt.executeUpdate();
        
        System.out.println("Inserted...");
        
        con.close();
        
        
    }
}
