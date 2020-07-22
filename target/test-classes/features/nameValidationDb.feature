Feature: Name validation againts DB
@tryy 
  Scenario: First Name validation against DB
    Given user is logged with valid admin credentials
     And user navigate to employee list page
    When user enters valid employee id "14589"
    And click on search button
    Then user see table is displayed
    And get first name from table
    When get first name from db
    Then verify first name from ui against db 
    

