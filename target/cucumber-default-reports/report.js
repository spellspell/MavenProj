$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/apiWorkFlow.feature");
formatter.feature({
  "name": "syntax HRMS api workflow",
  "description": "    Description: This feature file tests syntax HRMS API WorkFlow",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@apiWorkFlow"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateTokenSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating an Employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkFlow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create an employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_request_is_prepared_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a POST call is made to create an Employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.a_POST_call_is_made_to_create_an_Employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for creating an employee is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_status_code_for_creating_an_employee_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is created",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_employee_is_created()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employeeID is stored in the global variable to be used for other calls",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.api.apiTestingFinalSteps.the_employeeID_is_stored_in_the_global_variable_to_be_used_for_other_calls()"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.api.generateTokenSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Retrieving the created employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkFlow"
    },
    {
      "name": "@progression"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to retrieve the created employee",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "a GET call is made to retrieve the created Employee",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the status code for retrieving the created employee is 200",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the retrieved EmployeeID matches the globally stored EmployeeID",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the retrieved data matched the data used to create the employee",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});