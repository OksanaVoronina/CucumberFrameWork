package com.hrms.API.steps.practice;

import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.*;
import org.junit.runners.MethodSorters;
//import org.apache.hc.core5.http.ContentType;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

/*
 * this method will execute annotation in ascending alphabetical order
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardcodedExamples {
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUzMzc5ODcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTM4MTE4NywidXNlcklkIjoiNjc1In0.eT2ncZ2VulckNsUkYdzyZKvZvOvTEpvierZn3NrGRUo";
	static String empId;
	static String empName;

	public void sampleTestNotes() {

		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "17596A");

		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");

		getOneEmployeeResponse.prettyPrint();

		// String response = getOneEmployeeResponse.body().asString();
		// System.out.println(response);

		getOneEmployeeResponse.then().assertThat().statusCode(200);
	}

	@Test
	public void aPOSTcreateEmployee() {

		RequestSpecification creatEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token)
				.body("{\n" + "  \"emp_firstname\": \"Alex\",\n" + "  \"emp_lastname\": \"Biliy\",\n"
						+ "  \"emp_middle_name\": \"Mike\",\n" + "  \"emp_gender\": \"M\",\n"
						+ "  \"emp_birthday\": \"1988-07-25\",\n" + "  \"emp_status\": \"Employee\",\n"
						+ "  \"emp_job_title\": \"IT Analyst\"\n" + "}");

		Response creatyEmployeeResponse = creatEmployeeRequest.when().post("/createEmployee.php");

		creatyEmployeeResponse.prettyPrint();

		empId = creatyEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		empName = creatyEmployeeResponse.jsonPath().getString("Employee[0].emp_firstname");
		System.out.println(empId);

		/**
		 * 
		 */
		creatyEmployeeResponse.then().assertThat().statusCode(201);

		creatyEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

		creatyEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Alex"));

		creatyEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

		creatyEmployeeResponse.then().header("X-Powered-By", "PHP/7.2.18");

	}

	@Test
	public void bGETcreatedEmployee() {
		RequestSpecification getEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", empId).log().all();

		Response getEmployeeResponse = getEmployeeRequest.when().get("/getOneEmployee.php");

		String response = getEmployeeResponse.prettyPrint();

		String employeeName = getEmployeeResponse.body().jsonPath().getString("employee[0].emp_firstname");
		boolean equalsName = employeeName.equals(empName);
		Assert.assertTrue(equalsName);

		getEmployeeResponse.then().assertThat().body("employee[0].employee_id", equalTo(empId));

		getEmployeeResponse.then().assertThat().statusCode(200);

		// second way get info from db
		JsonPath js = new JsonPath(response);
		String empID = js.getString("employee[0].employee_id");
		String empMiddleName = js.getString("employee[0].emp_middle_name");
		String lastName = js.getString("employee[0].emp_lastname");
		String empBday = js.getString("employee[0].emp_birthday");
		String gender = js.getString("employee[0].emp_gender");
		String job_title = js.getString("employee[0].emp_job_title");
		String emp_status = js.getString("employee[0].emp_status");

		Assert.assertTrue(empID.contentEquals(empId));
		Assert.assertEquals(empName, employeeName);
		Assert.assertTrue(empMiddleName.contains("Mike"));
		Assert.assertTrue(lastName.contains("Biliy"));
		Assert.assertTrue(empBday.contains("1988-07-25"));
		Assert.assertTrue(gender.contains("Male"));
		Assert.assertTrue(job_title.contains("IT Analyst"));
		Assert.assertTrue(emp_status.contains("Employee"));

	}

	// @Test
	public void gGETemployees() {
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");

		// response.prettyPrint();
		String allEmployees = getAllEmployeesResponse.asString();
		// allEmployees.contains(empId);//will pass but its incorrect
		// allEmployees.matches(empId);

		JsonPath js = new JsonPath(allEmployees);
		int sizeOfList = js.getInt("Employees.size()");
		System.out.println(sizeOfList);

		for (int i = 0; i <= sizeOfList; i++) {
			String allEmpId = js.getString("Employees[" + i + "].employee_id");
			String allEmpName = js.getString("Employees[" + i + "].emp_firstname");
			// System.out.println(allEmpName);
			// System.out.println(allEmpId);

			if (allEmpName.contains("Alex")) {
				System.out.println(allEmpName + " is present in body");
				break;
			}
		}

	}

	@Test
	public void dPUTupdateCreatedEmp() {
		RequestSpecification updateEmpRequest = given().when().header("Content-Type", "application/json")
				.header("Authorization", token)
				.body(HardcodedConstants.updateCreatedEmpBody());
		
		Response updateResponse= updateEmpRequest.when().put("/updateEmployee.php");
		String update=updateResponse.prettyPrint();

	}
}
