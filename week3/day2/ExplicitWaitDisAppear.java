package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitDisAppear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		// To remove Option Chrome controlled by external sotware\
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get(" http://leafground.com/pages/appear.html");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		List<WebElement> allButton = driver.findElements(By.tagName("button"));
		int  noOfButton = allButton.size();
		System.out.println("Total No Of Button " + noOfButton);
		
		for(WebElement we : allButton)
		{
			if(we.isDisplayed())
			{
				System.out.println(" Button DIsplayed "+ we.getText());
			}
			else
			{
				WebElement diswe = driver.findElementByXPath("//button[@id='btn']");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn")));
				System.out.println("Button Disappared and apperaed "+ diswe.getText());
			}
	
			
		}
		
	;
	}

}
