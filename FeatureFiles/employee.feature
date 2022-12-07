@tag
Feature: Employee Registration
	I want to use this Template to validate New Employee Registration.
	
	@EmpReg
	Scenario: Check new Employee Registration with valid inputs
		Given i open browser with url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter username as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login
    Then i should see admin module
    When i goto addemployee page
    And i enter firstname as "Richards"
    And i enter lastname as "Demo"
    And click save
    Then i should see new employee registered successfully
    When i click logout
    Then i should see login page   
    When i close browser
	  	