Feature: Add employee scenarios

  #all the common steps for all the scenarios will be written in the background section
  #the steps in the background section will be executed before each scenario
  #the steps in the background section will be executed in the order they are written
  #the background is different for every feature file

  Background:
  #  Given user is able to access HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then user is able to login successfully
    When user clicks on PIM option
    And user clicks on add employee option

  @add
  Scenario: Adding employee
    When user enters employee first name and last name
    And user clicks on save button
    Then user is able to see employee added successfully

  @param
  Scenario: Adding employee using parameters
    When user enters employee "roman" and "Ali" values
    And user clicks on save button
    Then user is able to see employee added successfully