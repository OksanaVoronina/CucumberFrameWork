package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class database {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc: deriver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void storeData() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = con.createStatement();
		st.executeQuery("select * from hs_hr_employees");
	}

}
