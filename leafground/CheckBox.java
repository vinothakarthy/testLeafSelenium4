package leafground;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//http://www.leafground.com/pages/radio.html
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/checkbox.html");
		List<WebElement> check = driver.findElementsByXPath("(//div[@class='example'])[1]/div/input");
		int count = 1;
		//String value = null;
		for(WebElement sel : check)
		{
		if(count%2 ==0)
			sel.click();
			//sel.getAttribute(""input)
			//System.out.println(count+ " VALUE "+sel.getAttribute("input"));
			count++;
			
		}
	
	// confirm selenium selected
		if(driver.findElementByXPath("(//div[@class='example'])[2]/div/input").isSelected())
		{
			System.out.println("Selenium Selected ");
		}
		else
		{
			System.out.println("Selenium option not selected");
		}
			
		
		// Deselect the selected one
		check = driver.findElementsByXPath("(//div[@class='example'])[3]/div/input");
		count=0;
		for(WebElement e : check)
		{
			if (e.isSelected())
			{
				e.click();
				System.out.println(" De selecting "+e.getText());
			}
			//	e.
		}
		
		// Select all the box
		check = driver.findElementsByXPath("(//div[@class='example'])[4]/div/input");
		for(WebElement e : check)
		{
			e.click();
		}
	}

}
