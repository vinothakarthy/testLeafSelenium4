package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class NameAndIDTabPage extends ProjectSpecificMethod {
	
	public String LeadId;
	public NameAndIDTabPage(ChromeDriver driver)
	{
		this.driver = driver;
		
	}
	
	public PhoneTabPage clickphoneTab()
	{
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		return new PhoneTabPage(driver);
	}
	
	public NameAndIDTabPage enterName()
	{
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		return this;
	}
	public NameAndIDTabPage clickNameTabFindLead()
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}
	
	public NameAndIDTabPage verifyName()
	{
		
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		return this;
	}
	
}
