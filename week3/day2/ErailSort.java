package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		Launch the URL - https://erail.in/
		driver.get("https://erail.in/");
		
//		Uncheck the check box - sort on date
		driver.findElementByXPath("//input[@id='chkSelectDateOnly']").click();
		
//		clear and type in the source station 
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("Delhi",Keys.ENTER);
//		clear and type in the destination station
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("mumbai",Keys.ENTER);
//		Find all the train names using xpath and store it in a list
		List<WebElement> trainName = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//td[2]");
		ArrayList<String> tname = new ArrayList<String>();
		for(WebElement we : trainName)
		{
			tname.add(we.getText());
		}
		
//		Use Java Collections sort to sort it and then print it
		Collections.sort(tname);
		System.out.println(tname);
		
	}

}
