package com.hrms.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.mysql.cj.xdevapi.TableFilterParams;

public class ViewEmployeePageElements {

	@FindBy (id="empsearch_employee_name_empName")
	public WebElement EmpName;
	
	@FindBy (id="empsearch_id")
	public WebElement EmpID;
	
	@FindBy (xpath="//table[@id='resultTable']")
	public WebElement employeesTable;
	
	@FindBy (xpath="//table[@id='resultTable']//tbody/tr/td[3]")
	public List<WebElement> tableFirstName;
	
	public boolean isTableDisplayed() {
		return employeesTable.isDisplayed();
	}
	
	public List<Map<String,String>> getFirstNameTable(){
		 List<Map<String,String>> uiName=new ArrayList<>();
	for( WebElement row : tableFirstName) {
	
		Map<String,String> storeUiNames= new LinkedHashMap<>();	
		
		String []tableName = row.getText().split(" ");
		String name=tableName[0];
		storeUiNames.put("emp_firstname",name);
		 uiName.add(storeUiNames);
	}
		 return uiName;

	}
	//public List

	@FindBy(id = "searchBtn")
	public WebElement searchBtn;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[2]")
	public WebElement clickEmpBth;
	
	public  ViewEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver,this);
	}
}
