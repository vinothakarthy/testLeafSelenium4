package leafground;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.net.URL;

import org.apache.hc.core5.http.HttpConnection;

//import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLink {
public static void main(String[] args) {

	 // * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	WebDriverManager.chromedriver().setup();
	// To remove Option Chrome controlled by external sotware\
	HttpURLConnection huc = null;
	String url = "";
	
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	ChromeDriver driver = new ChromeDriver(options);
	
	driver.get("http://www.leafground.com");
	driver.findElementByXPath("//img[@alt='Link']").click();
 //{driver.findElementByXPath("//input[@disabled='true']").sendKeys(keysToSend);
	 
 driver.findElementByXPath("(//a[@href='../home.html'])[2]").click();
 driver.findElementByXPath("//img[@alt='Link']").click();
//step5: to click where am suppose to go
	WebElement go =driver.findElement(By.linkText("Find where am supposed to go without clicking me?"));
	String href = go.getAttribute("href");
					System.out.println("You supposed to go " +href);
	//step6: to verify am broken
	String text2 = driver.findElement(By.linkText("Verify am I broken?")).getText();
	System.out.println(text2);
	
	//step7: to find how many links are available in this page
List<WebElement> howmany = driver.findElementsByXPath("//a");
int size = howmany.size();
	System.out.println(" Size "+size);
	Iterator<WebElement> itr = howmany.iterator();
	while(itr.hasNext())
	{
		url = itr.next().getAttribute("href");
		if(url.isEmpty() || url.equals(null))
		{ 
			System.out.println("Url is empty");
		}
		try
		{
			huc =(HttpURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			size = huc.getResponseCode();
			if(size >= 400){
				System.out.println(url+" is a broken link");
				}
				else{
				System.out.println(url+" is a valid link");
				}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
}
