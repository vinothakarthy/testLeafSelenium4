package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		// Enter UserName and Password Using Id Locator
		  
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		 // 3. Click on Login Button using Class Locator
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElementByClassName("decorativeSubmit").click();
		// Click on CRM/SFA Link
		driver.findElementByLinkText("CRM/SFA").click();
		
		//5. Click on contacts Button
		driver.findElementByXPath("//a[@href='/crmsfa/control/contactsMain']").click();
		
	//	 Click on Create Contact
		driver.findElementByXPath("//a[@href='/crmsfa/control/createContactForm']").click();
		//Enter FirstName Field Using id Locator
		  driver.findElement(By.id("firstNameField")).sendKeys("Sharvesh");
		// * 8. Enter LastName Field Using id Locator
		  driver.findElement(By.id("lastNameField")).sendKeys("Krishna");
		 //* 9. Enter FirstName(Local) Field Using id Locator
		  driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("sharvesh");
		// * 10. Enter LastName(Local) Field Using id Locator
		  driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("kanna");
		 //* 11. Enter Department Field Using any Locator of Your Choice
		  driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Finanace");
		// * 12. Enter Description Field Using any Locator of your choice 
		  driver.findElement(By.id("createContactForm_description")).sendKeys("Creating contact for  for finance department");
		// * 13. Enter your email in the E-mail address Field using the locator of your choice
		  driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("testleaf@gmail.com");
		 // Select State/Province as NewYork Using Visible Text
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
			Select statesel = new Select(state);
			statesel.selectByVisibleText("New York");

			// * 15. Click on Create Contact
		driver.findElementByXPath("//table/tbody[1]/tr[20]/td[2]/input[1]").click();	 
			// * 16. Click on edit button 
			  driver.findElementByXPath("//a[text()='Edit']").click();
			 //* 17. Clear the Description Field using .clear
			 driver.findElement(By.id("updateContactForm_description")).clear();
			 //* 18. Fill ImportantNote Field with Any text
			 	driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("You can fill any important update here");
			 //* 19. Click on update button using Xpath locator
			 driver.findElementByXPath("//table/tbody[1]/tr[8]/td[2]/input[1]").click();
			 //* 20. Get the Title of Resulting Page.
			 System.out.println("Title of the page "+driver.getTitle());
			
	}

}
