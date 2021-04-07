package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Launch URL: https://www.amazon.in/
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//	 2. Type "one plus 7 pro mobiles" in Search Box and Enter
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 7 pro mobiles",Keys.ENTER);
		// 3. Print the price of the first resulting mobile
		System.out.println("Price " +driver.findElementByXPath("(//span[@class='a-price-whole'])[1]").getText());
		// 4. Click on the Mobile (First resulting) image
		driver.findElementByXPath("(//img[@class='s-image'])[1]").click();
		// 5. Switch to the new window
		String first = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		List<String> alist = new ArrayList<String>(allwindow);
		driver.switchTo().window(alist.get(1));
		// 6. Print the number of customer ratings
		System.out.println("RATING "+driver.findElementByXPath("//span[@data-hook='rating-out-of-text']").getText());
		//// 7. Click 'Add to Cart'
		driver.findElement(By.id("add-to-cart-button")).click();
		
		Thread.sleep(2000);
		// 8. Confirm "Added to Cart" text message appeared
		System.out.println(driver.findElementByXPath("//div[@id='attachDisplayAddBaseAlert']//h4").getText());
		
		// 9. Click on Proceed to checkout
	//	driver.findElement(By.id("hlb-ptc-btn-native")).click();
		driver.findElement(By.xpath("//*[@id='attach-sidesheet-checkout-button']/span/input")).click();
		// 10. Confirm the title is "Amazon Sign In"
		System.out.println("Title : "+driver.getTitle());
		//// 11. Click Continue (without entering mobile number/email)
		driver.findElement(By.id("continue")).click();
		// 12. Verify the error message: Enter your email or mobile phone number
		System.out.println("error message " + driver.findElementByXPath("(//div[@class='a-alert-content'])[2]").getText());
		// 13. Close both browsers
		driver.close();
	}

}
