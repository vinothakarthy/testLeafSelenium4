package base;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

import utils.ReadExcel;
public class ProjectSpecificMethod {
	public  ChromeDriver driver;
	public String excelFileName;
	public static String leadID;
	
	@BeforeMethod
	public void startup()
	{
		 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	 @DataProvider(name="fetch")
	  public String[][] senddata() throws IOException
	  {
	 	
	 	 ReadExcel re = new ReadExcel();
	 	 return re.exceldata(excelFileName);
	 	 
	 	 }
	
	@AfterMethod
	public void postcondition()
	{
		driver.close();
	}
}
