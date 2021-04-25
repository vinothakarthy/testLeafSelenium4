package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class MyLeadPage extends ProjectSpecificMethod {
	public MyLeadPage(ChromeDriver driver,Properties prop)
	{
		this.driver=driver;
		this.prop =prop;
	}

	public CreateLeadPage clickCreateLead()
	{
		driver.findElement(By.linkText(prop.getProperty("MyLeadPage.CreateLead.LinkText"))).click();
		return new CreateLeadPage(driver,prop);
	}
	public FindByNameAndPhoneAndMailTabPage clickFindLead()
	{
		driver.findElement(By.linkText(prop.getProperty("MyLeadPage.FindLead.LinkText"))).click();
		return new FindByNameAndPhoneAndMailTabPage(driver,prop);
	
	}

	public MergeLeadPage clickMergelead()
	{
		driver.findElement(By.linkText(prop.getProperty("MyLeadPage.MergeLead.LinkText"))).click();
		return new MergeLeadPage(driver,prop);
		
	}
	
}
