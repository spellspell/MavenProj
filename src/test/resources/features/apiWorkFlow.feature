#Author:
@apiWorkflow
Feature: Syntax HRMS API Workflow
  Description:This feature file tests Syntax HRMS API WrokFlow

  Background:
    Given a JWT is generated

  Scenario: Creating an Employee
    Given a request is prepared to create an employee
    When a POST call is made to create an Employee
    Then the status code for creating an employee is 201
    And the employee is created contains key "Message" and value "Entry Created"
    And the employeeID "Employee[0].employee" is stored in the global variable to be used for other calls

  @progression
  Scenario: Retrieving the created employee
    Given a request is prepared to retrieve the created employee
    When  a GET call is made to retrieve the created Employee
    Then the status code for retrieving the created employee is 200
    And the retrieved EmployeeID matches the globally stored EmployeeID
    And the retrieved data matched the data used to create the employee
