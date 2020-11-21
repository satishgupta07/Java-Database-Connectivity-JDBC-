package com.satishkumar06.JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
      	String url = "jdbc:mysql://localhost:3306/sampledb";
    	String uname= "root";
    	String pass = "root";
    	
    	// Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
     
        //Creating a connection
        Connection con = DriverManager.getConnection(url,uname,pass);
        
        if(con.isClosed()) {
        	System.out.println("Connection is Closed");
        }
        else {
        	System.out.println("Connecton Created...");
        }
      
    }
}
