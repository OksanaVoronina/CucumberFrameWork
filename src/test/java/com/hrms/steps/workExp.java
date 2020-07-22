package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class workExp extends CommonMethods {

	@When("click on Qualifications")
	public void click_on_Qualifications() {
		click(empExp.qul);
	}

	@When("click on add buttons")
	public void click_on_add_buttons() {
		click(empExp.add);
	}

	@Then("User add experience information {string},{string},{string},{string} and {string}")
	public void user_add_experience_information_and(String company, String jobTitle, String from, String to,
			String comment) {
		sendText(empExp.expEmp, company);
		sendText(empExp.jobTitle, jobTitle);
		sendText(empExp.calendarFrom, from);
		sendText(empExp.calendarTo, to);
		sendText(empExp.comments, comment);

	}

	@When("click on save buttons")
	public void click_on_save_buttons() {
		click(empExp.saveBtn);
		takeScreenshot("workExp");
	}

	@Then("work experience are added successfully")
	public void work_experience_are_added_successfully() {
		boolean expected = empExp.nameAdded.isEnabled();
		Assert.assertTrue("didnt add", expected);
	}
}
