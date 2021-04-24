package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MergeLeadPage  extends ProjectSpecificMethod {

	public MergeLeadPage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	;
public MergeLeadPage clickMergefromLead(String firstName1) throws InterruptedException
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
	return this;
}


public MergeLeadPage clickMergetoLead(String firstName2) throws InterruptedException
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
	return this;
}

public MyLeadPage clickmergeButton()
{
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	driver.switchTo().alert().accept();
	return new MyLeadPage(driver);
		
}


}
