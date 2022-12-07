package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles/adminlogin.feature",glue="stepdefinitions",dryRun=false,
tags=("@AdminLogin_Valid,@AdminLogin_Invalid"),plugin= {"com.cucumber.listener.ExtentCucumberFormatter:Reports/loginresult.html"})
public class AdminLoginTest extends AbstractTestNGCucumberTests 
{

}
