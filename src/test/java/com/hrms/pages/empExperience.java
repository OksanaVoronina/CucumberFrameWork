package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class empExperience extends CommonMethods {

	@FindBy(xpath ="//ul[@id='sidenav'] //a[text()='Qualifications']")
	public WebElement qul;

	@FindBy(id = "addWorkExperience")
	public WebElement add;

	@FindBy(id = "experience_employer")
	public WebElement expEmp;

	@FindBy(id = "experience_jobtitle")
	public WebElement jobTitle;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	public WebElement month;

	@FindBy(id = "experience_from_date")
	public WebElement calendarFrom;

	@FindBy(id = "experience_to_date")
	public WebElement calendarTo;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	public WebElement year;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
	public WebElement day;

	@FindBy(id = "experience_comments")
	public WebElement comments;

	@FindBy(id = "btnWorkExpSave")
	public WebElement saveBtn;

	@FindBy(xpath = "//td[@class='name']/a")
	public WebElement nameAdded;

	public empExperience() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
