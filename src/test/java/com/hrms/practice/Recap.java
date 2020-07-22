package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


public class Recap {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc: deriver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test 
	public void getConnection() throws SQLException {
		Connection con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		DatabaseMetaData dbMatadata=con.getMetaData();
		String driverName=dbMatadata.getDriverName();
		System.out.println(driverName);
		
		Statement st=con.createStatement();
		ResultSet result=st.executeQuery("select * from ohrm_skill");
		ResultSetMetaData resMataData=result.getMetaData();
		int col=resMataData.getColumnCount();
		// headers 
		for(int i=1;i<=col;i++) {
			String colName=resMataData.getColumnName(i);
			System.out.println(colName);
		}
		String id;
		String name;
		String description;
		 while(result.next()) {
			
			 id=result.getObject("id").toString();
			 name=result.getObject("name").toString();
			 description=result.getObject("description").toString();
			 System.out.println(id+" = "+ name+" = "+description);
			 
		 }
		result.close();
		st.close();
		 con.close();
	}
}
