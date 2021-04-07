package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NYKAAworkout {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//. Launch URL: "https://www.nykaa.com/"
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		//	2. Enter text as Perfumes in Search Bar and press Enter
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
Thread.sleep(2000);
		//driver.findElementByName("search-suggestions-nykaa").sendKeys("Perfumes",Keys.ENTER);
		driver.findElementByXPath("//input[@id='SearchInputBox']").sendKeys("Perfume",Keys.ENTER);
		//	3. Get The Names Of all the Perfumes Displayed 
		//4. Get The Price of all the Perfumes Displayed
		
		//List<WebElement> nameList = driver.findElementsByXPath("//div[@class='m-content__product-list__title']");
		List<WebElement> list = driver.findElementsByXPath("//div[@class='product-list-box card desktop-cart']");
	//	List<String> nameList = new ArrayList<String>();
		TreeMap<Integer,WebElement> productMap = new TreeMap<Integer,WebElement>();
		for  (WebElement eachList : list)
		{
			WebElement title =eachList.findElement(By.tagName("h2"));
			System.out.println(title.getText());
			String price = eachList.findElement(By.className("post-card__content-price-offer")).getText();
			System.out.println(price);
			int priceInt = Integer.parseInt(price.replaceAll("\\D", ""));
	
			productMap.put(priceInt,title);
		}

		//5. Click on the Highest Price Perfume  
		int highestPrice = productMap.descendingKeySet().first();
		System.out.println(" hightest prcie "+ highestPrice);
		productMap.get(highestPrice).click();
		//6. Click on Add To Bag
		String fristWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		List<String> allList = new ArrayList<String>(allWindow);
		driver.switchTo().window(allList.get(1));
		driver.findElementByXPath("//button[contains(@class,'combo-add-to-btn prdt-des-btn')]").click();
		//7. verify Message Product Added To the bag 
		String verifyMsg = driver.findElementByClassName("add-to-bag-message").getText();
		System.out.println("VERIFIED MESSAGE "+ verifyMsg);
		//8. Click on bag Icon
		driver.findElementByClassName("AddBagIcon").click();
		//9. Get the Grand Total Value
		System.out.println("Grand Total Value " +driver.findElementByXPath("//div[@class='first-col']//div").getText());
		Thread.sleep(2000);
		//////10. Click on Proceed
		driver.findElementByXPath("//span[text()='Proceed']").click();
	//	Thread.sleep(2000);
		//	11. Click on Continue as Guest
		driver.findElementByXPath("//button[text()='CONTINUE AS GUEST']").click();
		//12. Fill all the Fields in Address 
		driver.findElementByXPath("(//input[@class='input-element  '])[1]").sendKeys("inotha");
		//driver.findElementByXPath("(//input[@class='input-element  '])[2]").sendKeys("inotha@ddf.com");
		driver.findElementByName("email").sendKeys("vino@gmail.com");	
		driver.findElementByName("phoneNumber").sendKeys("9871276545");
			driver.findElementByXPath("//input[@placeholder='PinCode']").sendKeys("621007");
			driver.findElementByXPath("//legend[text()='Address']/following-sibling::textarea").sendKeys("updtown , sector 55,badshapur ");
			driver.findElementByXPath("//button[@type='submit']").click();
			Thread.sleep(2000);
		//13. Click on Paynow
			driver.findElementByXPath("//button[@type='submit']").click();
		//	14. Get the Error Message displayed in Red Color
		System.out.println(" Error message  Card Number  "+	driver.findElementByXPath("//span[@class='field-error']").getText());
		System.out.println(" Error message card Expiry "+		driver.findElementByXPath("(//span[@class='field-error'])[2]").getText());
		System.out.println(	" Errormessage cvv  "+driver.findElementByXPath("(//span[@class='field-error'])[3]").getText());
			
			//15. close the current browser
driver.close();

	}

}
