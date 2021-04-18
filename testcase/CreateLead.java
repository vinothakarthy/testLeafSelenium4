package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class  CreateLead extends BaseClass {
	@BeforeTest
	public void setFileName()
	{
		excelFileName="CreateLead";
	}
	
     @Test(dataProvider = "fetch")
     
	public  void runcreateLead(String company,String fname,String lname,String phonenumber) {
		
	
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phonenumber);
		driver.findElement(By.name("submitButton")).click();
		//driver.close();
}
     
    
    	
     
}






