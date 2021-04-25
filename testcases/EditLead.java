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
	
	public void editLeadtest(String phonenumber,String companyname) throws InterruptedException
	{
		new LoginPage(driver,prop).enterUsername(prop.getProperty("username"))
						.enterPassword(prop.getProperty("password"))
						.clickLoginButton()
						.clickcrmSfa()
						.clickleadTab()
						.clickFindLead()
						.clickphoneTab()
						.enterphoneNumber(phonenumber)
						.clickFindLeadButton()
						.clickleadlist()
						.clickEditButton()
						.entereditcompanyName(companyname)
						.clickUpdatesubmit()
						.verifyFirstName();
						
					
	}

}
