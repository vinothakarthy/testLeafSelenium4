package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CreateLeadPage extends ProjectSpecificMethod {
	
	public CreateLeadPage(ChromeDriver driver,Properties prop)
	{
	this.driver=driver;
	this.prop=prop;
	}
	public CreateLeadPage entercompanyName(String companyname)
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
		return this;
	}							
	
	public CreateLeadPage enterfirstName(String firstname)
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
		return this;
	}
	
	public CreateLeadPage enterlastName(String lastname)
	{
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
		return this;
	
	}
	
	public CreateLeadPage enterphoneNumber(String phonenum)
	{
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phonenum);
		return this;
	}
	
	public ViewLeadPage clickCreateSubmit()
	{
		driver.findElement(By.name(prop.getProperty("SubmitButton.name"))).click();	
		return new ViewLeadPage(driver,prop);
	}
	

}
