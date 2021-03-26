package leafground;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//http://www.leafground.com/pages/radio.html
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/radio.html");
		
		// Clcik radion BUtton
		List<WebElement> radioButtons = driver.findElementsByXPath("//div[@id='first']//input");
		WebElement yes = driver.findElementByXPath("//label[@for='yes']");
		System.out.println("Yes Value " +yes.getText());
		int count = radioButtons.size();
		System.out.println("Total Radio Buttons "+ count);
		 radioButtons.get(0).click();
		 System.out.println(" Are you liking the class "+radioButtons.get(0).getAttribute("value"));
		
		 // to get default selected radio Button
		 radioButtons=driver.findElementsByXPath("//label[text()='Find default selected radio button']/following-sibling::label/input");
		 for(WebElement select:radioButtons)
		 {
			if( select.isSelected())
			{
				System.out.println("selected : "+select.getAttribute("value"));
			}
		 }
		
		// Select ur age 
		 
		 radioButtons = driver.findElementsByXPath("(//div[@class='large-6 small-12 columns'])[3]//input");
		 int selCount = 0;
		 for(WebElement sel :radioButtons)
		 { 
			// System.out.println("VALUE "+sel.getAttribute("value"));
			 if(sel.isSelected())
			 {
				 selCount++;
				 System.out.println(" Age Already selected ");
			 }
			  }
		 if(!(selCount==0))
			 radioButtons.get(0).click();
	}

}
