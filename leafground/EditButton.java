package leafground;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditButton {
public static void main(String[] args) {

	 // * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	WebDriverManager.chromedriver().setup();
	// To remove Option Chrome controlled by external sotware\
	
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	ChromeDriver driver = new ChromeDriver(options);
	
	driver.get("http://www.leafground.com/pages/Edit.html");
	driver.findElement(By.id("email")).sendKeys("testleaf@gmail.com");;
	
	WebElement append = driver.findElementByXPath("//input[@value='Append ']");
	driver.findElementByXPath("//input[@value='Append ']").sendKeys(append.getText()+"test",Keys.TAB);
			
	WebElement text = driver.findElementByXPath("//input[@value='TestLeaf']");
System.out.println(" The text entered : "+text.getAttribute("value"));

 driver.findElementByXPath("//input[@value='Clear me!!']").clear();
 
if( driver.findElementByXPath("//input[@disabled='true']").isEnabled())
{
	System.out.println("Enabled ");
}
else
{
	System.out.println("Disabled");
}
 //{driver.findElementByXPath("//input[@disabled='true']").sendKeys(keysToSend);
	 
 

}
}
