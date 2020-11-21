package com.satishkumar06.JDBC01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
        
        // Create a query
        String q = "create table table1(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(400))";
        
        //Create a Statement
        Statement stmt = con.createStatement();
        
        stmt.executeUpdate(q);
       
        System.out.println("Table created in database..");
        
        con.close();
        
        
    }
}
