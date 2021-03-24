package week2.day2;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnListBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://www.leafground.com/pages/Dropdown.html");

//select training program using index

WebElement dlist = driver.findElementById("dropdown1");
Select dd1 = new Select(dlist);
dd1.selectByIndex(3);

// Selecting training program using Text
WebElement dlist1 = driver.findElementByName("dropdown2");
dd1 = new Select(dlist1);
dd1.selectByVisibleText("Appium");
	
//Selecting using Value

 WebElement dlist2 = driver.findElement(By.id("dropdown3"));
 dd1= new Select(dlist2);
 dd1.selectByValue("4");
 
 //get the number of dropdown option

 WebElement dlist3=driver.findElementByClassName("dropdown");
	dd1=new Select(dlist3);
	System.out.println("No of item in drop down box :"+dd1.getOptions().size());
	
//using sendkeys to select
 driver.findElementByXPath("//div[@class='example'][5]/select").sendKeys("Appium");;
	//.args. dd1= new Select(dlist4);
	 
WebElement slist = driver.findElementByXPath("//option[text()='Select your programs']/..")	;
 dd1 = new Select(slist);
 dd1.selectByIndex(2);
 
 
 
 
 
 
	}
	
}
