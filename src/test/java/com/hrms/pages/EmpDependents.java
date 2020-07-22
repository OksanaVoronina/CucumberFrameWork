package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class EmpDependents extends CommonMethods {

	@FindBy(xpath="//a[text()='Dependents']")
	public WebElement depend;
	
	@FindBy(id="btnAddDependent")
	public WebElement addBtn;
	
	@FindBy(id="dependent_name")
	public WebElement fName;
	
	@FindBy(id="dependent_relationshipType")
	public WebElement relat ;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	public WebElement month;
	
	@FindBy(xpath= "//select[@class='ui-datepicker-year']")
	public WebElement year;
	
	@FindBy(xpath= "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
	public List<WebElement> day;
	
	@FindBy(xpath= "//img[@class='ui-datepicker-trigger']")
	public WebElement calendarClick;

	
	@FindBy(id="btnSaveDependent") 
	public WebElement saveBtn;
	
	@FindBy(xpath="//td[@class='btnCancel']/a")
	public WebElement nameAdded;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[2]")
	public WebElement empClick;
	
	@FindBy(id="dependent_relationship") 
	public WebElement specify;
	
	public EmpDependents() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
