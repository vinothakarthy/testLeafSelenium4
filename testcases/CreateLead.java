package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class CreateLead extends ProjectSpecificMethod {
	@BeforeTest
	public void setFileName()
	{
		excelFileName="CreateLead";
	}

   @Test(dataProvider = "fetch")
  
	public void createLead(String username,String password,String companyname,
			String fristname,String lastname,String phonenumber)
	{
		new LoginPage(driver).enterUsername(username)
						.enterPassword(password)
						.clickLoginButton()
						.clickcrmSfa()
						.clickleadTab()
						.clickCreateLead()
						.entercompanyName(companyname)
						.enterfirstName(fristname)
						.enterlastName("karthikeyah")
						.enterphoneNumber(phonenumber)
						.clickCreateSubmit()
						.verifyFirstName();
								
	}
}

