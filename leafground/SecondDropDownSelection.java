package leafground;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondDropDownSelection {
public static void main(String[] args) {
	//createLeadForm_generalCountryGeoId
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
	driver.findElementByLinkText("Leads").click();
	driver.findElementByXPath("//a[@href='/crmsfa/control/createLeadForm']").click();;
	
	WebElement dd=driver.findElementById("createLeadForm_generalCountryGeoId");
	dd.sendKeys("e",Keys.ENTER);
	dd.sendKeys(Keys.ENTER);
	
	Select dd1 = new Select(dd);
	List<WebElement> lst = dd1.getOptions();
 ArrayList<String> starts = new  ArrayList<String>();
 int count =0;
 String finalsec=null;
	  for(WebElement d :lst)
		{
		 if((d.getText()).startsWith("E"))
				 {
			 count++;
			starts.add(d.getText());
				 }
		 if(count==2)
		 { finalsec = d.getText();
			 break;
		 }
		}
	  dd1.selectByVisibleText(finalsec);
}
}
