package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMLibrary
{
	
	public static WebDriver driver;
	public String empno;

	@Given("^i open browser with url \"([^\"]*)\"$")
	public static void launchApp(String url)
	{
	    
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
	}

	@Then("^i should see login page$")
	public void i_should_see_login_page() 
	{
	    if(driver.findElement(By.id("btnLogin")).isDisplayed())
	    {
	    	System.out.println("System Displayed Login Page");
	    }
	}

	@When("^i enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String uname)  
	{
	    driver.findElement(By.id("txtUsername")).sendKeys(uname);
	}

	@When("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pword) 
	{
	    driver.findElement(By.id("txtPassword")).sendKeys(pword);
	}

	@When("^i click login$")
	public void i_click_login() 
	{
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("^i should see admin module$")
	public void i_should_see_admin_module() 
	{
	    if(driver.findElement(By.linkText("Admin")).isDisplayed())
	    {
	    	System.out.println("System Displayed Admin Module.");
	    }
	}
	
	
	@When("^i click logout$")
	public void i_click_logout()
	{
	    driver.findElement(By.partialLinkText("Welcome")).click();
	    driver.findElement(By.linkText("Logout")).click();
	}

	@When("^i close browser$")
	public void i_close_browser() 
	{
	    driver.close();
	}
	
	@Then("^i should see error message$")
	public void i_should_see_error_message() 
	{
	    String errmsg;
	    errmsg = driver.findElement(By.id("spanMessage")).getText().toLowerCase();
	    if(errmsg.contains("invalid"))
	    {
	    	System.out.println("System displayed appropriate Error message for invalid data");
	    }		
	}
	
	@When("^i goto addemployee page$")
	public void i_goto_addemployee_page() 
	{
	    driver.findElement(By.linkText("PIM")).click();
	    driver.findElement(By.linkText("Add Employee")).click();
	}

	@When("^i enter firstname as \"([^\"]*)\"$")
	public void i_enter_firstname_as(String fname) 
	{
	    driver.findElement(By.id("firstName")).sendKeys(fname);
	}

	@When("^i enter lastname as \"([^\"]*)\"$")
	public void i_enter_lastname_as(String lname) 
	{
	    driver.findElement(By.id("lastName")).sendKeys(lname);
	}

	@When("^click save$")
	public void click_save() 
	{
		empno = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
	}

	@Then("^i should see new employee registered successfully$")
	public void i_should_see_new_employee_registered_successfully() 
	{
	    driver.findElement(By.linkText("Employee List")).click();
	    driver.findElement(By.id("empsearch_id")).sendKeys(empno);
	    driver.findElement(By.id("searchBtn")).click();
		
	    WebElement emptable = driver.findElement(By.id("resultTable"));
	    List<WebElement> rows = emptable.findElements(By.tagName("tr"));
	    for(int i=1;i<rows.size();i++)
	    {
	    	List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
	    	if(cols.get(1).getText().equals(empno))
	    	{
	    		System.out.println("New Employee Registered Successfully.");
	    	}	    		
	    }
	}
	
}
