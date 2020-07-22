package com.hrms.pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;


public class DashboardPageElement extends CommonMethods{

	@FindBy(id="welcome")
	public WebElement welcome;
	
	@FindBy(xpath="//div[@id='branding']/a[1]/img")
	public WebElement logo;
	
	
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
	public WebElement PIM;
	
	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
	public WebElement addEmp;
	
	@FindBy(id= "menu_core_viewDefinedPredefinedReports")
	public WebElement reports;
	
	
	@FindBy(id="menu_pim_viewEmployeeList")
	public WebElement empListPage;
	
	@FindBy(xpath="//div[@class='menu']/ul/li")
	public List<WebElement> adminMenu;
	
	@FindBy(xpath = "//div[@class='menu']/ul/li")
	public List<WebElement> essMenu;
	
	@FindBy(id="welcome-menu")
	public WebElement logout;
	
	public DashboardPageElement() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	public void navigateToAddEmployee() {
		jsClick(PIM);
		jsClick(addEmp);
	}
	
}

