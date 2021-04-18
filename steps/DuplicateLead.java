package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;

public class DuplicateLead extends driverShare{

	@When("duplicate button clicked")
	public void duplicateClick()
	{
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	
	@When("duplicateButton clicked")
	public void duplicateSubmit()
	{
		driver.findElement(By.name("submitButton")).click();
	}
}
