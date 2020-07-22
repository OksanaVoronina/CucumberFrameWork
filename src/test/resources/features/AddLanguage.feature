Feature: Admin should add Language

  Background: 
    Given user is logged with valid admin credentials

  @try
  Scenario: Add language
    When Admin navigate on Admin
    And clicks on Qaulifications
    And clicks on Language
    And click on add language button
    And enter language "Ukraine"
    And clicks save button
    Then "Ukraine" language added successfully

  @try
  Scenario: Add language to employee
    When user navigate to employee list page
    And user enters valid employee id "12345"
    And click on search button
    And click on employee name
    And click on Qualification
    And click on add languge
    And select language "Ukraine"
    And select fluency "Writing"
    And select competency "Good"
    And click on save languge
    Then language saved successfully "Ukraine"
