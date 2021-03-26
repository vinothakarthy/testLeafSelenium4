package leafground;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageWorkOut {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//createLeadForm_generalCountryGeoId
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Clcikcing on Image and going to home Page
		driver.get("http://www.leafground.com/pages/Image.html");
		driver.findElementByXPath("//img[@src='../images/home.png']").click();;
		// coming back to image 
		driver.findElementByXPath("//img[@alt='Images']").click();;
		
		//Broker Image
		
		 WebElement brokenImage = driver.findElementByXPath("//label[text()='Am I Broken Image?']/following-sibling::img");
		// String src = brokenImage.getAttribute("src");
		 String src = null;
		 src = brokenImage.getAttribute("onclick");
		 System.out.println(" LINK SOURCE " +src);
		 try
		 {
		 if(src.equals(null))
		 {
			 System.out.println("Image is broken");
		 }
		 }
		 finally
		 {
			 System.out.println("Image is broken. Doesnot have libk");
			 
		 
		 }
		// URL url = new URL(src);
		 
		 HttpURLConnection huc = null;
		 huc =(HttpURLConnection) (new URL(src).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();  
		 // http.setRequestProperty("User-Agent","Chrome/23.0.1271.95");
            //http.setConnectTimeout(10000);
            //http.setReadTimeout(20000);
            int responseCode = huc.getResponseCode();
            if (responseCode >=400)
            {
            	System.out.println("Image Is Broken");
            }
            else
            {
            	System.out.println(" Image is not Broken Image ");
            }
		 
	// Keyboard clicking in Image
            driver.findElementByXPath("//img[@src='../images/keyboard.png']").click();;
            
	}

}