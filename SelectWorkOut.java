package week4.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectWorkOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get(" http://leafground.com/pages/Dropdown.html");
		WebElement item1 = driver.findElementByXPath("//div[@id='contentblock']/section[1]/div[6]/select[1]/option[2]");
		WebElement item2 = driver.findElementByXPath("//div[@id='contentblock']/section[1]/div[6]/select[1]/option[5]");
		
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(item1).click(item2).keyUp(Keys.CONTROL).perform();
		


}
}