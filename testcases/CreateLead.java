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
  
	public void createLead(String companyname,String fristname,String lastname,String phonenumber)
	{
		new LoginPage(driver,prop).enterUsername(prop.getProperty("username"))
						.enterPassword(prop.getProperty("password"))
						.clickLoginButton()
						.clickcrmSfa()
						.clickleadTab()
						.clickCreateLead()
						.entercompanyName(companyname)
						.enterfirstName(fristname)
						.enterlastName(lastname)
						.enterphoneNumber(phonenumber)
						.clickCreateSubmit()
						.verifyFirstName();
								
	}
}

