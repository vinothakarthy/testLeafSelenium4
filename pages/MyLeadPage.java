package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class MyLeadPage extends ProjectSpecificMethod {
	public MyLeadPage(ChromeDriver driver)
	{
		this.driver=driver;
	}

	public CreateLeadPage clickCreateLead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLeadPage(driver);
	}
	public NameAndIDTabPage clickFindLead()
	{
		driver.findElement(By.linkText("Find Leads")).click();
		return new NameAndIDTabPage(driver);
	
	}

	public MergeLeadPage clickMergelead()
	{
		driver.findElement(By.linkText("Merge Leads")).click();
		return new MergeLeadPage(driver);
		
	}
	
}
