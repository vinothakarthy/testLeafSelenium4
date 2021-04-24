package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class DuplicateLead extends ProjectSpecificMethod {
	
	@BeforeTest
	public void setFileName()
	{
		excelFileName="DuplicateLead";
	}
@Test(dataProvider = "fetch")
	public  void runDuplicateLead(String username,String password,String phonenumber) throws InterruptedException	
	{
	new LoginPage(driver).enterUsername(username).enterPassword(password).clickLoginButton()
						.clickcrmSfa().clickleadTab().clickFindLead().clickphoneTab().enterphoneNumber(phonenumber)
						.clickPhoneTabfindleadButton().clickleadlist().clickDuplicateLeadButton().clickCreateSubmit();
	}

}
