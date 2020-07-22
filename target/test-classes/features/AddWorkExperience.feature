#Author: oksana8shalal@gmail.com
Feature: Add work experience

  Background: 
    Given user is logged with valid admin credentials
    And user navigate to employee list page

  @smoke
  Scenario Outline: 
    When user enters valid employee id "12345"
    And click on search button
    And click on employee name
    And click on Qualifications
    And click on add buttons
    Then User add experience information "<Company>","<JobTitle>","<From>","<To>" and "<Comment>"
    And click on save buttons
    Then work experience are added successfully

    Examples: 
      | Company | JobTitle | From        | To          | Comment  |
      | Amazon  | tester   | 2016-Jun-12 | 2020-May-10 | good job |
