package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.When;

public class PhoneTabPage extends ProjectSpecificMethod{
	public PhoneTabPage(ChromeDriver driver)
	{
		this.driver=driver;
	}

	
	public PhoneTabPage enterphoneNumber(String phonenumber)
	{
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonenumber);
		return this;
	}

	public PhoneTabPage clickPhoneTabfindleadButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		return this;
		
	}
	
	public ViewLeadPage clickleadlist()
	{
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return new ViewLeadPage(driver);
	}
	
	public PhoneTabPage getLeadId()
	{
	leadID =  driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		 return this;
	}
	

	

}
