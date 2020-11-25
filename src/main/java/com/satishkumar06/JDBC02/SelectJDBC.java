package com.satishkumar06.JDBC02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectJDBC {

	public static void main(String[] args) {
		
		try {
			
			Connection con = ConnectionProvider.getConnection();
			
			String query = "select * from table1";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String city = rs.getString(3);
				
				System.out.println(id+" : "+name+" : "+city);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
