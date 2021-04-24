package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ViewLeadPage extends ProjectSpecificMethod{

	public ViewLeadPage(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public ViewLeadPage verifyFirstName()
	{
		System.out.println(driver.findElement(By.id("viewLead_firstName_sp")).getText());
		return new ViewLeadPage(driver);
	}

	public ViewLeadPage clickEditButton()
	{
		driver.findElement(By.linkText("Edit")).click();	
		return new ViewLeadPage(driver);
	}
	
	public ViewLeadPage entereditcompanyName(String companyname)
	{
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyname);
		return new ViewLeadPage(driver);
	}
	
	public ViewLeadPage clickUpdatesubmit()
	{
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage(driver);
	}

	public  MyLeadPage clickDeleteButton()
	{
		driver.findElement(By.linkText("Delete")).click();
		
		return new MyLeadPage(driver);
		
	}
	public  CreateLeadPage clickDuplicateLeadButton()
	{
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		return new CreateLeadPage(driver);
		
	}
	

	
	
	
	
}
