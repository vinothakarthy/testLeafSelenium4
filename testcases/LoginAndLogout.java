package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.HomePage;
import pages.LoginPage;

public class LoginAndLogout extends ProjectSpecificMethod {
	
@Test	
public void loginLogout()
{
 new LoginPage(driver).enterUsername("DemoSalesManager").enterPassword("crmsfa").clickLoginButton().clickLogoutButton();
}
}
