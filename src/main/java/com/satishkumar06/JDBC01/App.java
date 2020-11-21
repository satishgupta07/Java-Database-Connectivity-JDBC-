package com.satishkumar06.JDBC01;

import java.io.FileInputStream;
import java.io.IOException;
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
        String q = "insert into images(pic) values(?)";
        
        //get the PreparedStatement object
        PreparedStatement pstmt = con.prepareStatement(q);
        
        FileInputStream fis = new FileInputStream("image01.png");
        
        pstmt.setBinaryStream(1, fis,fis.available());
        
        pstmt.executeUpdate();
        
        System.out.println("done...");
        
        con.close();
        
        
    }
}
