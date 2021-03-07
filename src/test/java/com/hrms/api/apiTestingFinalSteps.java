package com.hrms.api;

import com.hrms.utils.apiConstants;
import io.cucumber.java.en.*;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class apiTestingFinalSteps {
    RequestSpecification request;
    Response response;
    static String employeeID;

    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
        //preparing request to create Employee
        request = given().header(apiConstants.Header_Content_type, apiConstants.Content_type)
                .header(apiConstants.Header_Authorization, generateTokenSteps.token);


        request = request.body("{\"emp_lastname\":\"sadiq\"," +
                "\"emp_middle_name\":\"s\"," +
                "\"emp_job_title\":\"Cloud Architect\"," +
                "\"emp_status\":\"Employee\"," +
                "\"emp_firstname\":\"moazzam\"," +
                "\"emp_gender\":\"M\"," +
                "\"emp_birthday\":\"2021-02-27\"" +
                "}");

    }

    @When("a POST call is made to create an Employee")
    public void a_POST_call_is_made_to_create_an_Employee() {
        //sending the request to create Employee
        response = request.when().post(apiConstants.CREATE_EMPLOYEE_URI);

    }

    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(int status_code) {
        //assert that the status code is 201
        response.then().assertThat().statusCode(status_code);
    }

    @Then("the employee is created")
    public void the_employee_is_created() {
        //assert that the message contains entry created
        response.then().assertThat().body("Message", equalTo("Entry Created"));

    }

    @Then("the employeeID is stored in the global variable to be used for other calls")
    public void the_employeeID_is_stored_in_the_global_variable_to_be_used_for_other_calls() {
        // extract the emploeeID from the json response
        employeeID = response.jsonPath().getString("Employee[0].employee_id");

    }


}