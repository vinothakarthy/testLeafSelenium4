package week2.day2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithTable {
public static void main(String[] args) {
	// Driver Initialization
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get(" http://www.leafground.com/pages/table.html");
	
	// Loop thru Table
	
	WebElement tableList = driver.findElementByXPath("//table[@id='table_id']");
// Finding the RowList
	
	List<WebElement>  rowList = tableList.findElements(By.tagName("tr"));
	
	System.out.println(" Total No of Row   " + rowList.size());
	
	//Finding teh Coloumn List
	
	List<WebElement> coloumnList= tableList.findElements(By.tagName("th"));
	System.out.println(" Total Number of Coloumn "+coloumnList.size());
	
	// Learn to interact with next element in progress
	
	String progress = driver.findElementByXPath("//td[text()='Learn to interact with Elements']/following-sibling::td[1]").getText();
	System.out.println(" Learn to interace with elements progress value is "+progress);
	
	// Check the vital task of least completed progress
	
	List<WebElement> prog = driver.findElementsByXPath("//td[2]");
	List<Integer> strList = new ArrayList<Integer>();
	 for (WebElement itr :prog)
	 {
		 String progressValue = itr.getText().replace("%", "");
		System.out.println( " Eleme nt " +progressValue);
		strList.add((Integer.parseInt(progressValue)));
	 }
	 System.out.println(" Array List "+strList);
	 int minValue = Collections.min(strList);
	System.out.println(" Smalest Value " + minValue);
////td[2][text()='30%']//following::input   
	
	String xpath = "//td[text()="+"\""+minValue + "%"+"\""+ "]//following::input";
	System.out.println(xpath);
	driver.findElementByXPath(xpath).click();
	
}
}
