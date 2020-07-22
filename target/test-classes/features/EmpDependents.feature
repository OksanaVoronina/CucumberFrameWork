#Author:oksana8shalal@gmail.com
Feature: Add dependents

  Background: 
    Given user is logged with valid admin credentials
    And user navigate to employee list page

  @smoke
  Scenario Outline: 
    When user enters valid employee id "12345"
    And click on search button
    And click on employee name
    And click on dependents
    And click on add button
    Then User modifing information "<Name>","<Relationship>","<Month of Birth>","<Year of Birth>" and "<Date of Birth>"
    And click on save button
    Then dependents are added successfully

    Examples: 
      | Name | Relationship | Month of Birth | Year of Birth | Date of Birth |
      | Alex | Child        | May            |          2016 |            18 |
      | Luda | Child        | Jul            |          1956 |            27 |
