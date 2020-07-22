package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class storingData {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc: deriver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	// @Test
	public void getAndStoreData() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select id, name, country_code from ohrm_location ");

		List<Map<String, String>> listOfData = new ArrayList<>();
		Map<String, String> mapData;

		while (rs.next()) {
			mapData = new LinkedHashMap<>();
			mapData.put("Location id", rs.getObject("id").toString());
			mapData.put("Office name ", rs.getObject("name").toString());
			mapData.put("Country code ", rs.getObject("country_code").toString());
			listOfData.add(mapData);
			System.out.println(mapData);// to print separet sets
		}
		System.out.println(listOfData);

		rs.close();
		st.close();
		con.close();
	}

	//@Test
	public void retriveAndStoreData() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_job_title");
		ResultSetMetaData reMataData = rs.getMetaData();
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> mapData;

		while (rs.next()) {
			mapData = new LinkedHashMap<>();
			for (int i = 1; i <= reMataData.getColumnCount(); i++) {
				mapData.put(reMataData.getColumnName(i), rs.getObject(i).toString());
				// reMataData.getColumnName(i) = gives us col name/ headers
				// rs.getObject(i).toString()) = gives us row data
			}
			// System.out.println(mapData);
			// list.add(mapData);
		}
		// System.out.println(list);
	}

	// display the information from nationality table,
	// but display id “nationality id”, name = “nationality”
	 @Test
	public void retriveAndStoreDataFromDiffTable() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select id as nationaltiyid, name as nationaltiy from ohrm_nationality");
		ResultSetMetaData rdMataData = rs.getMetaData();
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> mapData;
		while (rs.next()) {
			mapData = new LinkedHashMap<>();
			for (int i = 1; i <= rdMataData.getColumnCount(); i++) {
				mapData.put(rdMataData.getColumnName(i), rs.getObject(i).toString());
			}
			list.add(mapData);
		}
		System.out.println(list);
	}
	 // or=========
		@Test
		public void getAndStoreDataFrom() throws SQLException {
			Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from ohrm_nationality");
			ResultSetMetaData rsMetaData = rs.getMetaData();
			List<Map<String, String>> listOfData = new ArrayList<>();
			Map<String, String> mapData;
			while(rs.next()) {
				mapData = new LinkedHashMap<>();
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					if(rsMetaData.getColumnName(i).equalsIgnoreCase("id")) {
						mapData.put("Nationality ID", rs.getObject(i).toString());
					}else if(rsMetaData.getColumnName(i).equalsIgnoreCase("name")) {
						mapData.put("Nationality", rs.getObject(i).toString());
					}
				}
				listOfData.add(mapData);
			}
		}
}
