package week3.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.collections.CollectionUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentRedBus {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://m.redbus.in");
// Fetching value from FROM list
		driver.findElement(By.id("src")).sendKeys("c");
		String fromBus=null;
		Thread.sleep(5000);
		WebElement ulist = driver.findElementByXPath("//ul[@class='autoFill']");
		Thread.sleep(2000);
		List<WebElement> list = ulist.findElements(By.tagName("li"));

		fromBus = list.get(1).getText();
			driver.findElementByXPath("//li[text() ='" +fromBus +"']").click();
			driver.findElement(By.id("src")).sendKeys(Keys.TAB);
// FECTCHING VALUE from TO LIST
		Thread.sleep(2000);
		driver.findElement(By.id("dest")).sendKeys("b");
		Thread.sleep(2000);
		ulist = driver.findElementByXPath("//ul[@class='autoFill']");
		Thread.sleep(2000);
		list = ulist.findElements(By.tagName("li"));
		String toBus = list.get(1).getText();

	//	driver.findElement(By.id("dest")).sendKeys((list.get(0).getText()));
			driver.findElementByXPath("//li[text() ='" +toBus +"']").click();
			
//Fetching Date
		driver.findElementById("onward_cal").click();
		driver.findElementByXPath("//button[text()='>']").click();
		driver.findElementByXPath("//td[text()='1']").click();
		;
		Thread.sleep(2000);
// clicking button
		driver.findElementById("search_btn").click();

		WebElement busfound = driver.findElementByXPath("//span[@class='f-bold busFound']");
		System.out.println(" Total No of BUSes from "+ fromBus + " to " + toBus+" : " + busfound.getText());
		Thread.sleep(2000);
		
		//close YOUR SAFTY IS OUR PRIORITY
		driver.findElementByXPath("//div[@class='close']/i").click();
		
		Thread.sleep(5000);
		
	
		
		
		// choose sleeper 
		WebElement sleeper = driver.findElementByXPath("(//input[@id='bt_SLEEPER']/following-sibling::label)[1]");
		sleeper.click();
		
		 busfound = driver.findElementByXPath("//span[@class='f-bold busFound']");
		System.out.println(" Total No of Sleeper BUSes from "+ fromBus + " to " + toBus+" : " + busfound.getText());
		Thread.sleep(5000);
		//choose AC
		driver.findElementByXPath("(//input[@id='bt_AC']/following-sibling::label)[1]").click();
		 busfound = driver.findElementByXPath("//span[@class='f-bold busFound']");
			System.out.println(" Total No of Sleeper BUSes and Ac Buses from "+ fromBus + " to " + toBus+" : " + busfound.getText());
			
			List <WebElement> farelist = driver.findElementsByXPath("//div[@class='seat-fare ']//span");
			ArrayList<Integer> fareInt = new ArrayList<Integer>();
			int count = 0;
			for( WebElement we :farelist)
			{
				count = Integer.parseInt(we.getText());
		//	System.out.println(we.getText()	 + " count "+ count);
			fareInt.add(count);
			}
			System.out.println("  Costlies Bus fare "+ Collections.max(fareInt));
			
	}

}
