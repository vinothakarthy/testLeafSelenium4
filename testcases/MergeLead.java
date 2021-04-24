package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;

public class MergeLead extends ProjectSpecificMethod {
	
	@BeforeTest
	public void setFileName()
	{
		excelFileName="MergeLead";
	}
@Test(dataProvider = "fetch")
	public  void runMergeLead(String username,String password,String firstName1,String firstName2) throws InterruptedException 

	{
		new LoginPage(driver).enterUsername(username).enterPassword(password).clickLoginButton()
							.clickcrmSfa()
							.clickleadTab()
							.clickMergelead()
							.clickMergefromLead(firstName1).clickMergetoLead(firstName2).clickmergeButton()
							.clickFindLead().enterName().clickNameTabFindLead().verifyName();
	}
}
		


