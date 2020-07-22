package com.hrms.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;


public class AddEmployeePageElement extends CommonMethods  {

	@FindBy(id= "firstName")
	public WebElement firstName;
	
	@FindBy(id="middleName")
	public WebElement middleName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="photofile")
	public  WebElement photoFile;
	
	@FindBy(id = "employeeId")
	public WebElement employeeId;
	
	@FindBy(id = "chkLogin")
	public WebElement checkboxLoginDetails;
	
	@FindBy(id = "user_name")
	public WebElement username;

	@FindBy(id = "user_password")
	public WebElement password;

	@FindBy(id = "re_password")
	public WebElement confirmPassword;
	
	@FindBy(id="btnSave")
	public WebElement btnSave;

	//@FindBy(xpath="//span[text()='Required']")
	//public WebElement errorMsg;
	
	public AddEmployeePageElement() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void createEmpLoginCR() {
		sendText(username, ConfigsReader.getPropery("empUsername"));
		sendText(password, ConfigsReader.getPropery("empPassword"));
		sendText(confirmPassword, ConfigsReader.getPropery("empPassword"));
		click(btnSave);
	}
}

