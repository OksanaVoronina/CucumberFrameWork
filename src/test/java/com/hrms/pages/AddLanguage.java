package com.hrms.pages;

import java.util.List;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class AddLanguage extends CommonMethods{
	
	@FindBy(id="menu_admin_viewAdminModule")
	public  WebElement admin;
	@FindBy(id="menu_admin_Qualifications")
	public  WebElement qualific;
	
	@FindBy(xpath="//ul[@id='sidenav'] //a[text()='Qualifications']")
	public  WebElement qualific2;
	
	@FindBy(id="menu_admin_viewLanguages")
	public  WebElement language;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[2]")
	public  List<WebElement> emp;

	@FindBy(xpath="//table[@id='recordsListTable']/tbody/tr/td")
	public  List<WebElement>languageValidation;
	
	@FindBy(id="btnAdd")
	public  WebElement addBtn;
	
	@FindBy(id="addLanguage")
	public  WebElement addLang;
	
	@FindBy(id="language_code")
	public  WebElement selectLanguage ;

	@FindBy(id="language_name")
	public  WebElement langName;
	
	@FindBy(id="btnSave")
	public  WebElement saveBtn;
	
	@FindBy(id="language_lang_type")
	public  WebElement fluency;
	
	@FindBy(id="btnLanguageSave")
	public  WebElement langBtnSave;
	
	@FindBy(id="btnEditCustom")
	public  WebElement aditBtn;
	
	@FindBy(xpath="//table[@id='lang_data_table']/tbody/tr/td")
	public  List<WebElement> saveLangValid;
	
	@FindBy(id="language_competency")
	public  WebElement competency;
	

	public AddLanguage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
