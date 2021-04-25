package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class DeleteLead extends ProjectSpecificMethod {

	@BeforeTest
	public void setFileName()
	{
		excelFileName="DeleteLead";
	}
	
	@Test(dataProvider = "fetch")
	
	public void deleteleadtest(String phonenumber) throws InterruptedException
	{
		new LoginPage(driver,prop).enterUsername(prop.getProperty("username")).enterPassword(prop.getProperty("password"))
							.clickLoginButton().clickcrmSfa().clickleadTab().clickFindLead().clickphoneTab()
							.enterphoneNumber(phonenumber).clickFindLeadButton().getLeadId().clickleadlist().clickDeleteButton()
							.clickFindLead().enterName().clickFindLeadButton().verifyName();
						
							
	}
	
	
}
