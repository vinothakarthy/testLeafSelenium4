package steps;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks  extends driverShare{
	
	@Before
	public void precondition()
	{
		 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://leaftaps.com/opentaps/control/login");
	}
	@After
	public void postcondition()
	{
		driver.close();
		
	}

}
