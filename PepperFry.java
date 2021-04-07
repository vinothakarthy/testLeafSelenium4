package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.cucumber.messages.internal.com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PepperFry {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//WebDriverManager.chromedriver().setup();
WebDriverManager.chromedriver().setup();

ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");
ChromeDriver driver = new ChromeDriver(options);

		//1. Load https://www.irctc.co.in
driver.get("https://www.pepperfry.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
Thread.sleep(2000);
//close sweet alert
driver.findElement(By.xpath("//div[@id='regPopUp']//a")).click();
//MouseOver on Furniture
Actions build = new Actions(driver);
WebElement furniture = driver.findElementByXPath("//div[@id='menu_wrapper']//a");
build.moveToElement(furniture).perform();
// Clicking Office Chair
//driver.findElementByXPath("//div[@id='meta-furniture']/div[1]/div[3]/div[2]/div[12]/a[1]").click();
driver.findElement(By.xpath("//a[text()='Office Chairs']")).click();

//Click Executive Chair
Thread.sleep(2000);
driver.findElementByXPath("//h5[text()='Executive Chairs']").click();

//driver.findElementByXPath("//input[@type='number']").sendKeys("50",Keys.ENTER);
driver.findElement(By.xpath("(//div[@class='clip__filter-dimension-input-holder']//input)[1]")).clear();
driver.findElement(By.xpath("(//div[@class='clip__filter-dimension-input-holder']//input)[1]")).sendKeys("50",Keys.ENTER);;

//Add "Galician High Back Executive Chair In Black Colour" chair to Wishlist
driver.findElement(By.id("search")).sendKeys("Galician High Back",Keys.ENTER);
driver.findElementByXPath("//div[@class='clip-prd-hrt pf-col xs-2']/a").click();
//6) Mouseover on Bedroom and Click Study tables
WebElement bedroom = driver.findElementByXPath("(//div[@id='menu_wrapper']//a)[3]");
build.moveToElement(bedroom).perform();
driver.findElementByXPath("//div[@id='meta-bedroom']/div[1]/div[4]/div[2]/div[3]/a[1]").click();

//7) Select Spacewood as Brand
driver.findElementByXPath("//label[text()='Spacewood']").click();


driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
driver.findElement(By.xpath("//span[contains(@class,'wewidgeticon we_close')]")).click();
driver.switchTo().defaultContent();
Thread.sleep(2000);
//8) Select Price as 7000 to 8000
//driver.findElementByXPath("//label[@for='price7000-8000']").click();

WebElement price=driver.findElement(By.xpath("//label[@for='price7000-8000']"));
build.click(price).perform();
//9) Add "SOS Carter Study Table In Lorraine Walnut & Silver Grey Finish
//" to Wishlist.
driver.findElementByXPath("//a[@data-productname='SOS Carter Study Table in Lorraine walnut & silver grey Finish']").click();
//10) Verify the number of items in the Wishlist
System.out.println("No of ITEM IN WISH LIST "+driver.findElementByXPath("(//span[@class='header-nav-cnt count_alert'])[1]").getText());
//11) Navigate to Wishlist
driver.findElementByXPath("//span[text()='Wishlist']").click();
//12) Move Table only to Cart from Wishlist
driver.findElementByXPath("//div[@class='action_block']//a").click();
//13) Click Proceed to Pay Securely
driver.findElementByXPath("//a[@class='proceed_cta']").click();
//14) Enter Pincode as 600028 in Delivery & Assembly Details and click Go
driver.findElement(By.id("pin_code")).sendKeys("600028",Keys.ENTER);
//14) Click Place Order
driver.findElementByXPath("//span[@class='ck-proceed-btn-wrap']/a").click();
//15) Capture a screenshot by Clicking on Order Summary
File screenshot=driver.getScreenshotAs(OutputType.FILE);

File pic1=new File("pic1.jpg");
FileUtils.copyFile(screenshot, pic1);
//16) Close the browser 
driver.close();
	}

}
