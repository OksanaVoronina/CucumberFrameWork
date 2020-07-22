package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElement;

import com.hrms.pages.AddReportPageElement;
import com.hrms.pages.DashboardPageElement;
import com.hrms.pages.EmpDependents;
import com.hrms.pages.LoginPageElement;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.pages.ViewEmployeePageElements;
import com.hrms.pages.empExperience;
import com.hrms.pages.AddLanguage;

public class PageInitializer extends BaseClass{

		public static LoginPageElement login;
		public static AddEmployeePageElement addEmp;
		public static DashboardPageElement dashboard;
		public static PersonalDetailsPageElements pdetails;
		public static AddReportPageElement report;
		public static ViewEmployeePageElements viewEmp;
		public static EmpDependents empDepend;
		public static empExperience empExp;
		public static AddLanguage addLang;
		public static void initialize() {
			
			login=new LoginPageElement();
			dashboard=new DashboardPageElement();
			addEmp=new AddEmployeePageElement();
			pdetails=new PersonalDetailsPageElements();
			report=new AddReportPageElement();
			viewEmp=new ViewEmployeePageElements();
			empDepend=new EmpDependents();
			empExp=new empExperience();
			addLang=new AddLanguage();
		}
	}

