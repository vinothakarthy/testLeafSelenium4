package leafground;

//import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {
public static void main(String[] args) {

	 // * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	WebDriverManager.chromedriver().setup();
	// To remove Option Chrome controlled by external sotware\
	
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	ChromeDriver driver = new ChromeDriver(options);
	
	driver.get("http://www.leafground.com");
	driver.findElementByXPath("//img[@alt='Buttons']").click();
 //{driver.findElementByXPath("//input[@disabled='true']").sendKeys(keysToSend);
	 
 driver.findElementById("home").click();
 driver.findElementByXPath("//img[@alt='Buttons']").click();
 WebElement position = driver.findElement(By.id("position"));
Point  loc= position.getLocation();
System.out.println("Location "+loc);

WebElement colr=driver.findElementById("color");
String color=colr.getCssValue("background-color");
//String hexacolor = Color.fromString(color).asHex();
System.out.println(" COlor of Button " + color );

 WebElement size = driver.findElementById("size");
 System.out.println("Size " +size.getSize());
		 

}
}
