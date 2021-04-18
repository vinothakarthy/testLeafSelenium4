package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MergeLead extends driverShare {
	
	String leadID;
	
	@When("Merge Lead clicked")
	public void Mergelead()
	{
		driver.findElement(By.linkText("Merge Leads")).click();
		
	}
@Given("From Lead {string}")
public void fromLead(String firstName1) throws InterruptedException
{
	driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	Set<String> allWindows = driver.getWindowHandles();
	List<String> allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(1));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName1);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	 leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles.get(0));	
}

@Given("To Lead {string}")
public void toLead(String firstName2) throws InterruptedException
{
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set<String> allWindows2 = driver.getWindowHandles();
	List<String> allhandles2 = new ArrayList<String>(allWindows2);
	driver.switchTo().window(allhandles2.get(1));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName2);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles2.get(0));	
}
@When("Merge Clicked")
public void mergeButton()
{
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	driver.switchTo().alert().accept();
		
}
@Then("Verify")
public void verify()
{
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	String text = driver.findElement(By.className("x-paging-info")).getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
}
}
