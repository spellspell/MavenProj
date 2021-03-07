package com.hrms.api;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

//given()
//when()
//then()
public class HardCodedExamples {
    String baseURI = RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQzNjAyNzEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDQwMzQ3MSwidXNlcklkIjoiMjQzOSJ9.MAnPishizTUFggcF2NJN56ZCijT1l0px1ER91o3QA4M";
    @Test
    public void sampleTest() {
//        RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
//        String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQxMjY1NDEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDE2OTc0MSwidXNlcklkIjoiMjQ3NyJ9.HF6XbGuiUjAo8xa1r6Ttum7lUO6Ww32NXK4xRJ8vINo";
        //presparing request to get one employee
        RequestSpecification preparingGetOneEmployeeRequest = given().header("Authorization", token)
                .header("Content-Type", "Application/json")
                .queryParam("employee_id", "13001");
        //sending the request to the endpoint
        Response getOneEmployeeResponse = preparingGetOneEmployeeRequest.when().get("/getOneEmployee.php");
        //print the response
        getOneEmployeeResponse.prettyPrint();
        //Assert that status code is 200

        getOneEmployeeResponse.then().assertThat().statusCode(200);

    }


    @Test
    public void aPostCreateEmployee() {
        //Preparing Create an Employee Request
        RequestSpecification createEmployeeRequest = given().header("Authorization", token)
                .header("Content-Type", "Application/json").body("{\n" +
                        "  \"emp_firstname\": \"Kim\",\n" +
                        "  \"emp_lastname\": \"Kimm\",\n" +
                        "  \"emp_middle_name\": null,\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2021-02-11\",\n" +
                        "  \"emp_status\": \"employee\",\n" +
                        "  \"emp_job_title\": \"IT Analyst\"\n" +
                        "}");
        //Making a Post call to Create Employee
        Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
        //Printing the Employee Id
        createEmployeeResponse.prettyPrint();
        //Assert that status code is 201
        createEmployeeResponse.then().assertThat().statusCode(201);
        //Get Employee_id
        String employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
        // Print EmployeeId
        System.out.println(employeeID);
        //Assert that message contains Entry Created
        createEmployeeResponse.then().assertThat().body("Message",equalTo("Entry Created"));
        //Assert that Employee first name
        createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname",equalTo("Kim"));
        //same thing
        JsonPath js = createEmployeeResponse.jsonPath();
        String emp_ID=js.getString("Employee[0].employee_id");
        System.out.println(emp_ID);
        //asert emp ID but emp ID changes all the time
       // assertThat(emp_ID, equalTo("16435A"));

    }
    @Test
    public void getCreatedEmployee(){
        //created string for base URI
        //creating request
        RequestSpecification getCreatedEmployeeRequest= given().header("Authorization", token)
                .header("Content-Type","Application/json").queryParam("employee_id","15916A");
        //creating response
        Response getCreatedEmployeeResponse=getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
        //asserting using then()
        getCreatedEmployeeResponse.then().assertThat().body("employee[0].emp_firstname",equalTo("Nagato"));
        getCreatedEmployeeResponse.prettyPrint();
        String id =getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
        //asserting with boolean
        boolean verifyingID=id.equalsIgnoreCase("15916A");
        Assert.assertTrue(verifyingID);
        System.out.println(verifyingID);
    }

    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification getCreatedEmployee = given().header("Authorization", token)
                .header("Content-Type", "Application/json").queryParam("employee_id","16443A");
        Response getEmployeeResponse = getCreatedEmployee.when().get("/getOneEmployee.php");
//       getEmployeeResponse.prettyPrint();
        String empID=getEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
// we are checking if the empid is eqaul to the one mentioned in string
        System.out.println(empID);
        boolean VerifyEmployeeID=empID.equalsIgnoreCase("16443A");
        System.out.println(VerifyEmployeeID);
       // Assert.assertTrue(VerifyEmployeeID);
      getEmployeeResponse.then().assertThat().body("employee[0].employee_id",equalTo("16443A"));
    }

    @Test
    public void cUpdateEmployee(){
        RequestSpecification updateEmployeeRequest = given().header("Authorization", token)
                .header("Content-Type", "Application/json").body("{\n" +
                        "  \"employee_id\": \"16443A\",\n" +
                        "  \"emp_firstname\": \"KKK\",\n" +
                        "  \"emp_lastname\": \"AAA\",\n" +
                        "  \"emp_middle_name\": null,\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2021-02-11\",\n" +
                        "  \"emp_status\": \"employee\",\n" +
                        "  \"emp_job_title\": \"IT Analyst\"\n" +
                        "}");
        Response UpdateEmployeeReponse = updateEmployeeRequest.when().put("/updateEmployee.php");
        UpdateEmployeeReponse.prettyPrint();

        //assert that updated employee is correct
        JsonPath js = UpdateEmployeeReponse.jsonPath();
        String emp_firstname = js.getString("employee[0].emp_firstname");
        System.out.println(emp_firstname);
        assertThat(emp_firstname, equalTo("KKK"));
        //another way
        UpdateEmployeeReponse.then().assertThat().body("employee[0].emp_firstname", equalTo("KKK"));



        Object Message = js.get("Message");
        System.out.println(Message);
        assertThat(Message,equalTo("Entry updated"));
        //the other method
        UpdateEmployeeReponse.then().body("Message", containsString("Entry updated"));
    }





@Test
    public void dPartiallyUpdateEmployee(){
        RequestSpecification partiallyUpdateRequest = given().header("Authorization", token)
                .header("Content-Type", "Application/json").body("{\n" +
                        "  \"employee_id\": \"16443A\",\n" +
                        "  \"emp_firstname\": \"updatedname\"\n" +
                        "}");
        Response PartiallyUpdatedEmployeeResponse=partiallyUpdateRequest.when()
                .patch("/updatePartialEmplyeesDetails.php");
        PartiallyUpdatedEmployeeResponse.prettyPrint();
        //assert that body contains the Message entry updated
        JsonPath js= PartiallyUpdatedEmployeeResponse.jsonPath();
        Object Message = js.get("Message");
        System.out.println(Message);
        assertThat(Message,equalTo("Entry updated"));
        //the other method
        PartiallyUpdatedEmployeeResponse.then().body("Message", containsString("Entry updated"));
    }

    @Test
    public void getJobTitle(){
        RequestSpecification request = given().header("Authorization", token)
                .header("Content-Type", "Application/json");
        Response response = request.when().get("/jobTitle.php");
        response.prettyPrint();

    }
    @Test
    public void dDeleteEmployeeRequest() {
        RequestSpecification DeleteEmployeeReq = given().header("Authorization", token)
                .header("Content-Type", "Application/json").queryParam("employee_id","16478A");
      Response DeleteReqResponse=  DeleteEmployeeReq.when().delete("/deleteEmployee.php");
      DeleteReqResponse.prettyPrint();

        DeleteReqResponse.then().assertThat().body("message", containsString("Entry deleted"));

    }
    @Test
    public void fdeleteEmployee() {
        given().header("Authorization", token)
                .header("Content-type", "Application/json")
                .queryParam("employee_id", "16077A").
                when().
                delete("/deleteEmployee.php")
                .then().assertThat().
                body("message", containsString("Entry deleted"));
    }

}
