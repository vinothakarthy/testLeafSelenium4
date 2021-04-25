package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ViewLeadPage extends ProjectSpecificMethod{

	public ViewLeadPage(ChromeDriver driver,Properties prop)
	{
		this.driver=driver;
		this.prop=prop;
	}
	
	public ViewLeadPage verifyFirstName()
	{
		System.out.println(driver.findElement(By.id("viewLead_firstName_sp")).getText());
		return this;
	}

	public ViewLeadPage clickEditButton()
	{
		driver.findElement(By.linkText(prop.getProperty("ViewLeadPage.EditButton.LinkText"))).click();	
		return this;
	}
	
	public ViewLeadPage entereditcompanyName(String companyname)
	{
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyname);
		return this;
	}
	
	public ViewLeadPage clickUpdatesubmit()
	{
		driver.findElement(By.name(prop.getProperty("SubmitButton.name"))).click();
		return this;
	}

	public  MyLeadPage clickDeleteButton()
	{
		driver.findElement(By.linkText(prop.getProperty("ViewLeadPage.DeleteButton.LinkText"))).click();
		
		return new MyLeadPage(driver,prop);
		
	}
	public  CreateLeadPage clickDuplicateLeadButton()
	{
		driver.findElement(By.linkText(prop.getProperty("ViewLeadPage.DuplicateButton.LinkText"))).click();
		
		return new CreateLeadPage(driver,prop);
		
	}
	

	
	
	
	
}
