package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethod;

public class MyHomePage extends ProjectSpecificMethod{
	public MyHomePage(ChromeDriver driver,Properties prop)
	{
		this.driver=driver;
		this.prop = prop;
		
	}

	public MyLeadPage clickleadTab()
	{
		driver.findElement(By.linkText(prop.getProperty("MyHomePage.LeadsLink.LinkText"))).click();
		return new MyLeadPage(driver,prop);
	}
}
