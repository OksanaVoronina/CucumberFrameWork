package com.hrms.steps;

import java.util.List;
import java.util.Map;

import com.hrms.utils.DBUtil;

import io.cucumber.java.en.Then;

public class DBStep {
	
public static List<Map<String,String>> dbData;
	@Then("get first name from db")
	public void get_first_name_from_db() {
	String sqlQuery= "select emp_firstname from hs_hr_employees where employee_id = 14589";
	dbData=DBUtil.storeDataFromDB(sqlQuery);
	System.out.println(DBUtil.storeDataFromDB(sqlQuery));
	}
}
