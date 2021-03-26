package leafground;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LastDropDownSelection {
public static void main(String[] args) {
	//createLeadForm_generalCountryGeoId
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://www.leafground.com/pages/Dropdown.html");
	
	WebElement dd=driver.findElementById("dropdown1");
	Select dd1 = new Select(dd);
	List<WebElement> list = dd1.getOptions();
int size=list.size();
if(!( size==0))
dd1.selectByIndex(size-1);
System.out.println();
}
}
