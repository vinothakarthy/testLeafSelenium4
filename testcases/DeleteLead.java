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
	
	public void deleteleadtest(String username,String password,String phonenumber) throws InterruptedException
	{
		new LoginPage(driver).enterUsername(username).enterPassword(password)
							.clickLoginButton().clickcrmSfa().clickleadTab().clickFindLead().clickphoneTab()
							.enterphoneNumber(phonenumber).clickPhoneTabfindleadButton().getLeadId().clickleadlist().clickDeleteButton()
							.clickFindLead().enterName().clickNameTabFindLead().verifyName();
						
							
	}
	
	
}
