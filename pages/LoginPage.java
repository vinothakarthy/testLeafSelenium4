package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod {
	
	public LoginPage(ChromeDriver driver,Properties prop)
	{
		this.driver=driver;
		this.prop = prop;
		
	}
	
	public LoginPage enterUsername(String username)
	{
	driver.findElement(By.id(prop.getProperty("LoginPage.Username.Id"))).sendKeys(username);
	return this;
	}
	public LoginPage enterPassword(String password) {
		driver.findElement(By.id(prop.getProperty("LoginPage.Password.Id"))).sendKeys(password);
		return this;
	}
	public HomePage clickLoginButton() 
	{
		driver.findElement(By.className(prop.getProperty("LoginPage.LoginButton.ClassName"))).click();
		return new HomePage(driver,prop);
	}

}
