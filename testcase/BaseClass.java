package testcase;

import org.testng.annotations.Test;

import com.google.common.base.Preconditions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseClass {
public	ChromeDriver driver ;
public String excelFileName;
  @Parameters({"url","username","password"})
  @BeforeMethod
  	public void preCondition(String url,String username,String password)
  	{
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Leads")).click();
		
  	}
  @DataProvider(name="fetch")
  public String[][] senddata() throws IOException
  {
 	/* String data[][] = new String[2][3];
 	 data[0][0] = "TestLeaf3";
 	 data[0][1] = "Kashinwi";
 	 data[0][2] = "Karthik";
 	
 	 data[1][0] = "TestLEaf3";
 	 data[1][1] = "sharvesh";
 	 data[1][2] = "karthi";
 	 return data;
  */
 	 ReadExcel re = new ReadExcel();
 	 return re.exceldata(excelFileName);
 	 
 	 }
  @AfterMethod
  public void postCondition() {
	  driver.close();
  }


}
