@FeatureTag @Login #feature level tag
Feature: Login Functionality

  @validCredentials @smoke #sceranio level tag
  Scenario: Login with valid credentials
#    Given navigate to HRMS login page
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
#    And quit the browser


  @smoke @syntax @invalidCredentials @regression #adding multiple tags
  Scenario: Login with invalid credentials
#    Given navigate to HRMS login page
    When enter invalid credentials
    And click on login button
    Then verify an error message
#    And quit the browser