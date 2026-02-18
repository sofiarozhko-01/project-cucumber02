Feature: Employee search

  Background:
  #  Given user is able to access HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then user is able to login successfully
    When user clicks on PIM option
    And user clicks on employee list option

  @regression @smoke
  Scenario: Search employee by Id
    When user enters valid employee id
    And user clicks on search button
    Then user is able to see the employee details

  @regression @arundhati
  Scenario: Search employee by name
    When user enters valid employee name
    And user clicks on search button
    Then user is able to see the employee details
