package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends driverShare
{
	//ChromeDriver driver;
	@Given("CRM link clicked")
	public void crmSfaclick()
	{

		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@Given("Lead Tab clicked")
	public void leadTabclick()
	{
		driver.findElement(By.linkText("Leads")).click();
	}
	@Given("CreateLead clicked")
	public void createLeadclick()
	{
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@Given("Enter Company Name as {string}")
	public void entercompanyName(String conpanyName)
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(conpanyName);
	}							
	@Given("Enter First Name as {string}")
	public void enterfirstName(String firstName)
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}
	@Given("Enter Last Name as {string}")
	public void enterlastName(String lastName)
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	
	}
	@Given("Enter phone number as {string}")
	public void enterphoneNumber(String phonenumber)
	{
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phonenumber);
	}
	@When("SubmitButton Clicked")	 
	public void submitClick()
	{
		driver.findElement(By.name("submitButton")).click();	
	}
	
}
