package week3.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		Set the system property and Launch the URL
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://erail.in/");
		
//		Click the 'sort on date' checkbox
		driver.findElementByXPath("//input[@id='chkSelectDateOnly']").click();
		
		
//		clear and type in the from station text field
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("Delhi",Keys.ENTER);
		
//		clear and type in the to station text field
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("mumbai",Keys.ENTER);
		
//		Add a java sleep for 2 seconds
		Thread.sleep(2000);
		
//		Store all the train names in a list
		List<WebElement> trainName = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//td[2]");
		ArrayList<String> tname = new ArrayList<String>();
		for(WebElement we : trainName)
		{
			tname.add(we.getText());
		}
		
//		Get the size of it
		System.out.println("Total No of Trains " + tname.size());
		
//		Add the list into a new Set
		Set<String> tset = new HashSet<String>();
		tset.addAll(tname);
//		And print the size of it
		System.out.println(" Total No of Train after adding into set "+ tset.size());
	}

}
