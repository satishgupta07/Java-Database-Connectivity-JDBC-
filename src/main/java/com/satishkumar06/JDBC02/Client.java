package com.satishkumar06.JDBC02;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) {
		try {
			Connection con = ConnectionProvider.getConnection();
			
			String query = "insert into images(pic) values(?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			JFileChooser jfc = new JFileChooser();
			
			jfc.showOpenDialog(null);
			
			File file = jfc.getSelectedFile();
			
			FileInputStream fis = new FileInputStream(file);
			
			pstmt.setBinaryStream(1, fis,fis.available());
			
			pstmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
