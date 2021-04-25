package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class FindByNameAndPhoneAndMailTabPage extends ProjectSpecificMethod {
	
	
	public FindByNameAndPhoneAndMailTabPage(ChromeDriver driver,Properties prop)
	{
		this.driver = driver;
		this.prop =prop;
		
	}
	
	public FindByNameAndPhoneAndMailTabPage clickphoneTab()
	{
		driver.findElement(By.xpath("//span[text()='"+
								prop.getProperty("FindByNameAndPhoneAndMailTabPage.PhoneTab.Xpath")+
								"']")).click();
		return  this;
	}
	
	public FindByNameAndPhoneAndMailTabPage enterName()
	{
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		return this;
	}
	public FindByNameAndPhoneAndMailTabPage clickFindLeadButton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='"+prop.getProperty("FindByNameAndPhoneAndMailTabPage.FindLeadButton.Xpath")+"']")).click();   
		//driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
		return this;
	}
	public ViewLeadPage clickleadlist()
	{
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return new ViewLeadPage(driver,prop);
	}
	
	
	public FindByNameAndPhoneAndMailTabPage enterphoneNumber(String phonenumber)
	{
		driver.findElement(By.xpath("//input[@name='"+
							prop.getProperty("FindByNameAndPhoneAndMailTabPage.PhoneNumber.Xpath")+"']")).sendKeys(phonenumber);
		
		return this;
	}

	
	public FindByNameAndPhoneAndMailTabPage getLeadId()
	{
	leadID =  driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		 return this;
	}
	
	public FindByNameAndPhoneAndMailTabPage verifyName()
	{
		
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals(prop.getProperty("FindByNameAndPhoneAndMailTabPage.verifyName"))) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		return this;
	}
	
}
