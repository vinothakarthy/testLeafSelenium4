package week3.day2;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// Open https://www.myntra.com/
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Mouse over on woman
		
		WebElement target = driver.findElementByXPath("//a[@data-group='women']");
		Actions mouseOver = new Actions(driver);
		mouseOver.moveToElement(target).perform();
		
		//Clicking on jacket & COats
		driver.findElementByXPath("//a[@href='/women-jackets-coats']").click();
		
		//Finding Total No of Item
		WebElement count = driver.findElementByXPath("//span[@class='title-count']");
		System.out.println("Total Number Of Item "+ count.getText());
		
		// Validating with sum of CATOGORIES
		List<WebElement> counts = driver.findElementsByXPath("//span[@class='categories-num']");
		int sum=0;
		String name;
		int numberAdd;
		for(WebElement we : counts)
		{   name = we.getText().replace("(","");
			name = name.replace(")", "");
			System.out.println(name);
			numberAdd = Integer.parseInt(name);
			sum = numberAdd+sum;
		}
		System.out.println(" TOTAL IN SUB CATOGORIES "+ sum);
		name = count.getText().replace(" items", "");
		name =name.replace(" - ", "");
		//System.out.println(name);
		if(sum == Integer.parseInt(name))
		{
			System.out.println("TOTAL COUNT "+name + " are equal  to SUM of "+ sum);
			
		}
		//Click COats
		driver.findElementByXPath("//label[text()='Coats']").click();
		//Clicking More Itemns Under Brand
		driver.findElementByClassName("brand-more").click();
		
		// //input 'Search brand'
		
		
		WebElement ele = driver.findElementByXPath("//input[@placeholder='Search brand']");
		ele.sendKeys("MANGO");
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		ele = driver.findElementByXPath("//ul[@class='FilterDirectory-list']//label[1]");
		ele.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='FilterDirectory-list']//label[1]")));
		// closing pop up
		driver.findElementByXPath("//div[@class='FilterDirectory-titleBar']//span").click();
		
		//checking wether all product or Mango or not
		List <WebElement> alist = driver.findElementsByXPath("//ul[@class='results-base']//a");
		int  count2 =0;
		for(WebElement we:alist)
		{	String href=we.getAttribute("href");
			if(href.startsWith("https://www.myntra.com/coats/mango/"))
			{
				count2++;
			}
			else
				System.out.println("NOT MANGO");
		}
		if(alist.size() == count2)
		{
			System.out.println(" All "+ count2+ " items are MANGO");
		}
		else
			System.out.println(alist.size() + "ITEMS " + count2 + "are not MANGO");
		
		//sort by better discount
		WebElement classSort = driver.findElementByClassName("sort-sortBy");
		mouseOver.moveToElement(classSort).perform();
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Better Discount']")));
		
		//price of first displayed
		WebElement price = driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]");
		System.out.println(" THe Price Of First Displayed Item is "+price.getText());
		
		// Mouse over on first item
		
		WebElement firstItem = driver.findElementByXPath("(//ul[@class='results-base']//li)[1]");
		mouseOver.moveToElement(firstItem).perform();
		WebElement wish = driver.findElementByXPath("//span[text()='wishlist']");
		wish.click();
		wait.until(ExpectedConditions.invisibilityOf(wish));
		
		//closing browser
		driver.close();
		
	}

}
