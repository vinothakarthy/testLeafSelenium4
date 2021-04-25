package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class HomePage extends ProjectSpecificMethod {

	public HomePage(ChromeDriver driver,Properties prop)
	{
		this.driver=driver;
		this.prop = prop;
	}
	public LoginPage clickLogoutButton()
	{
		driver.findElement(By.className(prop.getProperty("HomePage.logout.ClassName"))).click();
		return new LoginPage(driver,prop);
	
	}
	public MyHomePage clickcrmSfa()
	{

		driver.findElement(By.linkText(prop.getProperty("HomePage.Crmsfa.LinkText"))).click();
		return new MyHomePage(driver,prop);
	}
}
