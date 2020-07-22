package com.hrms.practice;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JDBCDemo {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc: deriver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void abc() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery("select * from hs_hr_employees");
		
		result.next();
		String firstname = result.getString("emp_firstname");
		System.out.println(firstname);
		result.next();
		System.out.println(result.getObject("emp_lastname").toString());
		String allData;
		while (result.next()) {
			allData = result.getObject("emp_firstname").toString();
			// System.out.println(allData);
		}
	}

	
	@Test
	public void listTask() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_job_title");
		List<String> jobTitle = new ArrayList<>();
		while (rs.next()) {
			jobTitle.add(rs.getObject("job_title").toString());
		}
		System.out.println(jobTitle);
		for (String jobTitles : jobTitle) {
			System.out.println(jobTitles);
		}
		 rs.close();
		 st.close();
		 conn.close();

	}
}
