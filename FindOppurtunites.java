package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindOppurtunites {
public static void main(String[] args) {
	//Pseudo Code

 
	 // * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	WebDriverManager.chromedriver().setup();
	// To remove Option Chrome controlled by external sotware\
	
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	ChromeDriver driver = new ChromeDriver(options);
	
	driver.get("http://leaftaps.com/opentaps/control/login");

	
	//* 2. Enter UserName and Password Using Id Locator
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	
	// * 3. Click on Login Button using Class Locator
	driver.findElementByClassName("decorativeSubmit").click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	 // * 5. Click on Oppurtunites Button
	   driver.findElementByLinkText("Opportunities").click();
	 // * 6. Click on Find Oppurtunites using Xpath Locator
	 driver.findElementByXPath("//a[@href='/crmsfa/control/findOpportunities']").click();
	 // * 7. Get the List of Oppurtunites available in Oppurtunity id usinf Xpath Locator
	  List<WebElement> opportun = driver.findElementsByXPath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]");
	  for (WebElement itr : opportun)
	  {
		  System.out.println(itr.getText());
	  }
	 // * 8. Get the Title of the Page and verify it.
	 System.out.println(" Title " + driver.getTitle());
}
}
