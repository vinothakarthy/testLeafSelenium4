package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindContact {

	public static void main(String[] args) throws InterruptedException {
		
		// * //Pseudo Code
		 
		// * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
	
		 //* 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// * 3. Click on Login Button using Class Locator
		driver.findElementByClassName("decorativeSubmit").click();
		
	//	 * 4. Click on CRM/SFA Link

		driver.findElementByLinkText("CRM/SFA").click();
		  
	//	 * 5. Click on contacts Button
		driver.findElementByXPath("//a[@href='/crmsfa/control/contactsMain']").click();  
	//	 * 6. Click on Find Contacts
		  driver.findElementByXPath("//a[text()='Find Contacts']").click();
	//	 * 7. Click on the Email Field using Xpath Locator
		 driver.findElementByXPath("//span[text()='Email']").click();
	//	 * 8. Enter the email using any locator
		  driver.findElementByXPath("//label[text()='Email Address:']/following::input[1]").sendKeys("iswaryatl@gmail.com");
	//	 * 9. Click on Find Contacts using Xpath Locator
		  driver.findElementByXPath("//button[text()='Find Contacts']").click();
		  Thread.sleep(5000);
	//	 * 10. Click on the First Resulting Contact
		 driver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[3]/div[1]/a[1]").click();
		//
	//	 * 11. Get the Text of First Name 
		 WebElement firstName = driver.findElement(By.id("viewContact_firstName_sp"));
		 System.out.println("First Name : "+ firstName.getText());
		 //	 * 12. Click on the Edit Button
		  driver.findElementByLinkText("Edit").click();
	//	 * 13. Select New Marketing Campaign as eCommerce Site Internal Campaign by using SelectByValue
		WebElement marketCamp=  driver.findElementById("addMarketingCampaignForm_marketingCampaignId");
		Select dd1 = new Select(marketCamp);
		dd1.selectByValue("9000");
	//	 * 14. Click on the add button
		  driver.findElementByXPath("//input[@value='Add']").click();
		// * 15. Enter Department Value as Selenium Automation Testing
		 driver.findElement(By.id("updateContactForm_departmentName")).sendKeys(" Computer Department");
		 //* 16. Click on the Update Button
		  driver.findElementByXPath("//input[@value='Update']").click();
		 //* 17. Get the text of Marketing campaign and Verify it
		List  <WebElement> camptable = driver.findElementsByXPath("//table[@class='crmsfaListTable']//tr/td/a[@class='linktext']");
		 //List <WebElement> camptr =camptable.findElements(By.id("tr"));
		for(WebElement itr : camptable)
		{
		//	System.out.println(itr.getText());
		if(itr.getText().contains("9000"))
		{
			System.out.println("value added and verified");
		}
		}
	
		  
		 //* 18. verify Title of the Current page
			System.out.println("Title of this page : "+ driver.getTitle());

	}

}