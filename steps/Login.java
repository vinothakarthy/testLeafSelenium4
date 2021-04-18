package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends driverShare {
	//ChromeDriver driver;
/*	@Given("Open the chrome browser")
	public void openBroser()
	{
		 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Given("Load application url")
	public void loadappurl()
	{
		driver.get("http://leaftaps.com/opentaps/control/login");
		
	}	*/
	@Given("Enter user name as {string}")
	public void enterusername(String username)
	{
		driver.findElement(By.id("username")).sendKeys(username);
		
	}	
	@Given("Enter Password as {string}")
	public void enterpassword(String password)
	{
		driver.findElement(By.id("password")).sendKeys(password);
	}	
	
	@When("Login button clicked")
	public void clicklogin()
	{
		driver.findElement(By.className("decorativeSubmit")).click();	
	}
	@Then("HomePage should be displayed")
	public void verifyhomepage()
	{
		System.out.println("Home Page Displayed");
		}
	
	@But("Error message should be displayed")
	public void verifyerrorpage()
	{
		System.out.println("Error Page Displayed");
		}
	
}
