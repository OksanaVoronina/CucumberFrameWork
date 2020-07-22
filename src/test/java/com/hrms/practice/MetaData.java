package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MetaData {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc: deriver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	@Test
	public void dbMetadata() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData mdata = conn.getMetaData();
		String drivername = mdata.getDriverName();
		String dbVersion = mdata.getDatabaseProductVersion();
		System.out.println(drivername);
		System.out.println(dbVersion);
	}

	@Test
	public void rsMatedata() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees");
		ResultSetMetaData rsMatadata = rs.getMetaData();
		int col = rsMatadata.getColumnCount();
		String firstCol = rsMatadata.getColumnName(1);
		System.out.println(firstCol);
		// System.out.println(rsMatadata.toString());
		for (int i = 1; i <= col; i++) {
			//System.out.println(rsMatadata.getColumnName(i));
		}
	}

	// hw get the resultset metadata store it in the arraylist and retrieve it from
	// arraylist
	// also get column type name get the table names
	@Test
	public void listData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees");
		List<String> list = new ArrayList<>();
		ResultSetMetaData rsMatadata = rs.getMetaData();
		int col = rsMatadata.getColumnCount();
		for (int i = 1; i <= col; i++) {
			list.add(rsMatadata.getColumnName(i));
		}
		for(String lists:list) {
		System.out.println(lists);
		}
	}

}
