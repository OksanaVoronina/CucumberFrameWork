package com.hrms.API.steps.practice;

public class HardcodedConstants {

	public static String updateCreatedEmpBody() {
		String updateBody="{\\n\" + \" \\\"employee_id\\\":\\\"\"+empId+\"\\\",\\n\" + \"            \\\"emp_firstname\\\": \\\"oksana\\\",\\n\"\n" + 
				"						+ \"            \\\"emp_middle_name\\\": \\\"Mike\\\",\\n\" + \"            \\\"emp_lastname\\\": \\\"Biliy\\\",\\n\"\n" + 
				"						+ \"            \\\"emp_birthday\\\": \\\"1989-05-18\\\",\\n\" + \"            \\\"emp_gender\\\": \\\"F\\\",\\n\"\n" + 
				"						+ \"            \\\"emp_job_title\\\": \\\"IT Analyst\\\",\\n\"\n" + 
				"						+ \"            \\\"emp_status\\\": \\\"Employee\\\"\\n\" + \"}\"";
	return updateBody;
	}
}
