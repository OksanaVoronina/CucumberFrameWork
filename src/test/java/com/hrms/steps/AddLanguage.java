package com.hrms.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddLanguage extends CommonMethods {

	@When("Admin navigate on Admin")
	public void admin_navigate_on_Admin() {
		click(addLang.admin);

	}

	@When("clicks on Qaulifications")
	public void clicks_on_Qaulifications() {
		click(addLang.qualific);
	}

	@When("clicks on Language")
	public void clicks_on_Language() {
		wait(2);
		click(addLang.language);

	}

	@When("click on add language button")
	public void click_on_add_language_button() {
		click(addLang.addBtn);
	}

	@When("enter language {string}")
	public void enter_language(String langName) {
		sendText(addLang.langName, langName);
	}

	@When("clicks save button")
	public void clicks_save_button() {
		click(addLang.saveBtn);
		takeScreenshot("addLanguage");
	}

	@Then("{string} language added successfully")
	public void language_added_successfully(String lang) {
		List<WebElement> languages = addLang.languageValidation;
		String acctual = "";
		for (WebElement language : languages) {
			acctual = language.getText();
			if (acctual.equals(lang)) {
				break;
		 	}
		}
		Assert.assertEquals(acctual, lang);

	}
	@When("click on Qualification")
	public void click_on_Qualification() {
	
		click(addLang.qualific2);
	}
 
	@When("click on add languge")
	public void click_on_add_languge() {
		click(addLang.addLang);
	}

	@When("select language {string}")
	public void select_language(String lang) {
		selectDdValue(addLang.selectLanguage, lang);
	}

	@When("select fluency {string}")
	public void select_fluency(String fluency) {
		selectDdValue(addLang.fluency, fluency);

	}

	@When("click on save languge")
	public void click_on_save_languge() {
		click(addLang.langBtnSave);
		takeScreenshot("addLanguage");
	}

	@When("select competency {string}")
	public void select_competency(String compet) {
		selectDdValue(addLang.competency, compet);

	}

	@Then("language saved successfully {string}")
	public void language_saved_successfully(String lang) {
		List<WebElement> languages = addLang.saveLangValid;
		String acctual = "";
		for (WebElement language : languages) {
			acctual = language.getText();
			if (acctual.equals(lang)) {
				break;
			}
		}
		Assert.assertEquals(acctual, lang);

	}
}
