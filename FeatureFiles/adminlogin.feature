@tag
Feature: Admin Login
  I want to use this template to check Admin Login

  @AdminLogin_Valid
  Scenario: Check Admin Login with valid inputs
    Given i open browser with url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter username as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login
    Then i should see admin module
    When i click logout
    Then i should see login page   
    When i close browser
    
  @AdminLogin_Invalid
  Scenario Outline: Check Admin Login with invalid inputs
    Given i open browser with url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter username as "<username>"
    And i enter password as "<password>"
    And i click login
    Then i should see error message
    When i close browser
    
    Examples:
    |username|password|
    |Admin|xyz|
    |abc|QEdge@123|
    |abc|xyz|   
    