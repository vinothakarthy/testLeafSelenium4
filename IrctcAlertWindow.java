package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcAlertWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();

ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");
ChromeDriver driver = new ChromeDriver(options);
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		//1. Load https://www.irctc.co.in
driver.get("https://www.irctc.co.in/");
//	2. Click on OK button in the dialog  // Alert
String firstWindow = driver.getWindowHandle();

 driver.findElementByXPath("//button[text()='OK']").click();;
// wait.until(ExpectedConditions.visibilityOf(element);
 //	3. Click on FLIGHTS link             // New window
Thread.sleep(2000);
driver.findElement(By.linkText("FLIGHTS")).click();
//	4. Go to the Flights tab
Set<String> allWindows=driver.getWindowHandles();
List<String> aList = new ArrayList<String>(allWindows);
driver.switchTo().window(aList.get(1));


//	5. Print the customer care email id
System.out.println(driver.findElementByXPath("(//a[@href='mailto:flights@irctc.co.in'])[3]").getText());
//	6. Close the First tab(Train ticket booking) alone
driver.switchTo().window(firstWindow);
driver.close();

}

}
