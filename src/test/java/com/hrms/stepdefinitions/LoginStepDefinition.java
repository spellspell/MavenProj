package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.ConfigsReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition extends CommonMethods{

    @Given("navigate to HRMS login page")
    public void navigate_to_hrms_login_page() {
        setUp();
    }

    @When("enter valid credentials")
    public void enter_valid_credentials() {
        sendText(loginPage.usernameBox, ConfigsReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigsReader.getPropertyValue("password"));
    }

    @When("click on login button")
    public void click_on_login_button() {
        click(loginPage.loginBtn);
    }

    @Then("verify dashboard is displayed")
    public void verify_dashboard_is_displayed() {
        String actualText = dashboardPage.welcomeMessage.getText();
        String expectedText = "Welcome Admin";
        Assert.assertEquals(actualText, expectedText);
    }

    @Then("quit the browser")
    public void quit_the_browser() {
        tearDown();
    }

    @When("enter invalid credentials")
    public void enter_invalid_credentials() {
        sendText(loginPage.usernameBox, ConfigsReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, "wrongPassword");
    }

    @Then("verify invalid credentials message")
    public void verify_invalid_credentials_message() {
        String actualMessage = loginPage.errorMsg.getText();
        String expectedMessage = "Invalid credentials";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @When("enter empty username and valid password")
    public void enter_empty_username_and_valid_password() {
        sendText(loginPage.usernameBox, "");
        sendText(loginPage.passwordBox, ConfigsReader.getPropertyValue("password"));
    }

    @Then("verify empty username message")
    public void verify_empty_username_message() {
        String actualMessage = loginPage.errorMsg.getText();
        String expectedMessage = "Username cannot be empty";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @When("enter valid username and empty password")
    public void enter_valid_username_and_empty_password() {
        sendText(loginPage.usernameBox, ConfigsReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, "");
    }

    @Then("verify empty password message")
    public void verify_empty_password_message() {
        String actualMessage = loginPage.errorMsg.getText();
        String expectedMessage = "Password cannot be empty";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}

