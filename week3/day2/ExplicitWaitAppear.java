package week3.day2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitAppear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		// To remove Option Chrome controlled by external sotware\
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get(" http://leafground.com/pages/disapper.html");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement we = driver.findElementById("btn");
		wait.until(ExpectedConditions.invisibilityOf(we));
		we.isDisplayed();
		
		we = driver.findElementByXPath("//div[@id='show']/p/strong");
		System.out.println(we.getText());	
		
		
	}

}
