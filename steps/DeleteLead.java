package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteLead extends driverShare {
	String leadID;
/*	
	Then verify text*/
	@Given("phonenumber to delete {string}")
	public void phonenumberDelete(String phonenumber)
	{
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonenumber);
		
	}
	@When("Find Lead Button for delete clicked")
	public void deleteFindLeadButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();	
	Thread.sleep(2000);	
	}
	@When("LeadList for delete clicked")
	public void deleteLeadList()
	{
		 leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();	
	}
	
	@When("delete button clicked")
	public void deletesubmitButton()
	{
		driver.findElement(By.linkText("Delete")).click();
		
	}
	@Given("enter name as LeadID")
	public void enterName()
	{
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		
	}
	@Then("verify text")
	public void verifyText()
	{
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
	}
}

