package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class EditLead extends driverShare {

	@Given("Find Lead clicked")
	public void findleadclick()
	{
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	@Given("Phone tab clicked")
	public void phoneTabclick()
	{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@Given("phonenumber {string}")
	public void phoneNumber(String phonenumber)
	{
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonenumber);
	}
	@When("Find Lead Button clicked")
	public void findleadButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
	}
	@When("LeadList clicked")
	public void leadlistclick()
	{
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
	}
	@When("edit button clicked")
	public void editButtonclick()
	{
		driver.findElement(By.linkText("Edit")).click();	
	}
	@Given("Modify company name as {string}")
	public void editcompanyName(String companyname)
	{
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyname);
	}
	@When("edit form submitbutton clicked")
	public void editsubmit()
	{
		driver.findElement(By.name("submitButton")).click();
	}
}
