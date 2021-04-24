package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class EditLead extends ProjectSpecificMethod {
	@BeforeTest
	public void setFileName()
	{
		excelFileName="EditLead";
	}
	
	@Test(dataProvider = "fetch")
	
	public void editLeadtest(
			String username,String password,String phonenumber,String companyname) throws InterruptedException
	{
		new LoginPage(driver).enterUsername(username)
						.enterPassword(password)
						.clickLoginButton()
						.clickcrmSfa()
						.clickleadTab()
						.clickFindLead()
						.clickphoneTab()
						.enterphoneNumber(phonenumber)
						.clickPhoneTabfindleadButton()
						.clickleadlist()
						.clickEditButton()
						.entereditcompanyName(companyname)
						.clickUpdatesubmit()
						.verifyFirstName();
						
					
	}

}
