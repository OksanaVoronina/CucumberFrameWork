package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmpDependentsSteps extends CommonMethods {
	@When("click on employee name")
	public void click_on_employee_name() {
		click(empDepend.empClick);
	}

	@When("click on dependents")
	public void click_on_dependents() {
		click(empDepend.depend);

	}

	@When("click on add button")
	public void click_on_add_button() {
		click(empDepend.addBtn);

	}

	@Then("User modifing information {string},{string},{string},{string} and {string}")
	public void user_modifing_information_and(String name, String relationship, String month, String year,
			String date) {
		sendText(empDepend.fName, name);
		selectDdValue(empDepend.relat, relationship);
		click(empDepend.calendarClick);
		selectDdValue(empDepend.month, month);
		selectDdValue(empDepend.year, year);
		selectCalendarDate(empDepend.day, date);

	}

	@Then("click on save button")
	public void click_on_save_button() {

		click(empDepend.saveBtn);
		takeScreenshot("addDependents");
	}

	@Then("dependents are added successfully")
	public void dependents_are_added_successfully() {
		boolean expected = empDepend.fName.isEnabled();
		Assert.assertTrue("didnt add", expected);

	}
}
